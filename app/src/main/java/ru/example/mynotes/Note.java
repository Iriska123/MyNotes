package ru.example.mynotes;

import java.time.LocalDateTime;

public class Note {

    private static Note[] notes;
    private String description;
    private String noteName;
    private LocalDateTime date;

    public Note(String description, String noteName, LocalDateTime date) {
        this.description = description;
        this.noteName = noteName;
        this.date = date;
    }

    public static Note[] getNotes() {
        return notes;
    }

    public String getDescription() {
        return description;
    }

    public String getNoteName() {
        return noteName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static void setNotes(Note[] notes) {
        Note.notes = notes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
