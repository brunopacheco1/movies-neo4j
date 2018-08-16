package com.dev.bruno.movies.dto;

import java.time.LocalDateTime;

public class FriendshipDTO {

    private Long requestedBy;

    private Long acceptedBy;

    private LocalDateTime friendshipStartedAt;

    public Long getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Long requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Long getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(Long acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public LocalDateTime getFriendshipStartedAt() {
        return friendshipStartedAt;
    }

    public void setFriendshipStartedAt(LocalDateTime friendshipStartedAt) {
        this.friendshipStartedAt = friendshipStartedAt;
    }
}