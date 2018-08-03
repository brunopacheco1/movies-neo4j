package com.dev.bruno.movies.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.time.LocalDateTime;

@RelationshipEntity(type = "IS_FRIEND")
public class Friendship {

    @StartNode
    private User requestedBy;

    @EndNode
    private User acceptedBy;

    private LocalDateTime friendshipStartedAt;

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(User acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public LocalDateTime getFriendshipStartedAt() {
        return friendshipStartedAt;
    }

    public void setFriendshipStartedAt(LocalDateTime friendshipStartedAt) {
        this.friendshipStartedAt = friendshipStartedAt;
    }
}