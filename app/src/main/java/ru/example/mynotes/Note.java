package ru.example.mynotes;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Random;


public class Note implements Parcelable {
    private static final Random random = new Random();

    private static Note[] notes;

    private String title;
    private String description;
    private LocalDateTime date;

    public Note(String description, String title, LocalDateTime date) {
        this.description = description;
        this.title = title;
        this.date = date;
    }

    public static Note[] getNotes() {
        return notes;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    static {
        notes = new Note[10];                             // инициализатор
        for (int i = 0; i < notes.length; i++) {
            notes[i] = Note.getNote(i);
        }
    }
    public static Note getNote(int index) {               //фабричный метод, создает объект
        String title = String.format("Заметка %d", index);
        String description = String.format("Описание заметки %d", index);
        LocalDateTime date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date = LocalDateTime.now().plusDays(-random.nextInt(5));
        }
        return new Note(title,description,date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(getTitle());
        parcel.writeString(getDescription());
        parcel.writeSerializable(getDate());
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel parcel) {
            return new Note(parcel);
        }
        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    protected Note(Parcel parcel){
        title = parcel.readString();
        description = parcel.readString();
        date = (LocalDateTime)parcel.readSerializable();
    }
}
