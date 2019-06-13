package android.example.booksearchwork;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "TableOfBooks")
public class BookEntity {

    @PrimaryKey
    public int id;
    public String title;
    public int year ;
    public String author;
    public int edition;
    public boolean isInPreferences;
}

