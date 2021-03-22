package com.example.notemaker.model;

public class notes {
    private String id;
    private String UserId;
    private String title;
    private String note;

    public notes()
    {}

    public notes(String id, String userId, String title, String note) {
        this.id = id;
        UserId = userId;
        this.title = title;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
