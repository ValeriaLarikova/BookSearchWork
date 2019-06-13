package android.example.booksearchwork.data;

import android.example.booksearchwork.data.BookDao;
import android.example.booksearchwork.data.entities.BookEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BookEntity.class},version = 1,exportSchema = false)
public abstract class BookDB extends RoomDatabase {
    public abstract BookDao bookDao();
}
