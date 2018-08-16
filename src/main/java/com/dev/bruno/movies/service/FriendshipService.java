package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Friendship;
import com.dev.bruno.movies.domain.User;
import com.dev.bruno.movies.dto.FriendshipDTO;
import com.dev.bruno.movies.exceptions.EntityNotFound;
import com.dev.bruno.movies.repository.FriendshipRepository;
import com.dev.bruno.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {

    private FriendshipRepository friendshipRepository;
    private UserRepository userRepository;

    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository, UserRepository userRepository) {
        this.friendshipRepository = friendshipRepository;
        this.userRepository = userRepository;
    }

    public void insert(FriendshipDTO friendshipDTO) {
        Friendship friendship = new Friendship();
        convertToEntity(friendship, friendshipDTO);
        friendshipRepository.save(friendship);
    }

    public void update(Long id, FriendshipDTO friendshipDTO) {
        Friendship friendship = findOne(id);
        convertToEntity(friendship, friendshipDTO);
        friendshipRepository.save(friendship);
    }

    public void delete(Long id) {
        Friendship friendship = findOne(id);
        friendshipRepository.delete(friendship);
    }

    private Friendship findOne(Long id) {
        return friendshipRepository.findById(id).orElse(null);
    }

    private void convertToEntity(Friendship entity, FriendshipDTO dto) {
        User acceptedBy = userRepository.findById(dto.getAcceptedBy()).orElseThrow(EntityNotFound::new);
        User requestedBy = userRepository.findById(dto.getRequestedBy()).orElseThrow(EntityNotFound::new);

        entity.setAcceptedBy(acceptedBy);
        entity.setFriendshipStartedAt(dto.getFriendshipStartedAt());
        entity.setRequestedBy(requestedBy);
    }
}