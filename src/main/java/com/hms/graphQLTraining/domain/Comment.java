package com.hms.graphQLTraining.domain;

import java.time.LocalDateTime;

public class Comment {
    private final Long id;
    private final String title;
    private final LocalDateTime createdAt;

    public Comment(long id, String title, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
