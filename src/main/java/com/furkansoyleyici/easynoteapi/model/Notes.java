package com.furkansoyleyici.easynoteapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "content")
    private String content;

    @Column(name = "priority")
    private int priority;

    @Column(name = "is_favorite")
    private boolean isFavorite;

    @Column(name = "notes_date")
    private String notesDate;

    public Notes() {}

    public Notes(String title, String subtitle, String content, int priority, boolean isFavorite, String notesDate) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.priority = priority;
        this.isFavorite = isFavorite;
        this.notesDate = notesDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @JsonProperty("isFavorite")
    public boolean getIsFavorite() {
        return isFavorite;
    }

    @JsonProperty("isFavorite")
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getNotesDate() {
        return notesDate;
    }

    public void setNotesDate(String notesDate) {
        this.notesDate = notesDate;
    }
}
