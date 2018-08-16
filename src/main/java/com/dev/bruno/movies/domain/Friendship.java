package com.dev.bruno.movies.domain;

import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;

@RelationshipEntity(type = "IS_FRIEND")
public class Friendship {

    @Id
    @GeneratedValue
    private Long relationshipId;

    @StartNode
    private User requestedBy;

    @EndNode
    private User acceptedBy;

    private LocalDateTime friendshipStartedAt;

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

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