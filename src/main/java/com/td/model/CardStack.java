package com.td.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.td.auth.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stacks")
public class CardStack {
    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public String name;

    public String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }
    @JsonIgnore
    @ManyToOne(optional = false)
    public User user;

    public void setFlashcards( List<Flashcard> flashcards ) {
        this.flashcards = flashcards;
    }

    @OneToMany(mappedBy = "stack", fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.MERGE })
    public List<Flashcard> flashcards;

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }


    public User getUser() {
        return user;
    }

}
