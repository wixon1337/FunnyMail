package hu.flowacademy.FunnyMail.Models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private UUID id;
    private User from;
    private User to;
    private String content;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Message(UUID id, User from, User to, String content) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
