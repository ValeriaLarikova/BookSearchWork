package android.example.booksearchwork;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface BookDao {

    @Query("SELECT * FROM TableOfBooks")
    LiveData<List<BookEntity>> getBookList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBookList(List<BookEntity> bookEntities);

    @Query("SELECT * FROM `TableOfBooks` WHERE `isInPreferences`;")
    LiveData<List<BookEntity>> getPreferencesBookList();
}
