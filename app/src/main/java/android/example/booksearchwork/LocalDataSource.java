package android.example.booksearchwork;


import android.content.Context;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

public class LocalDataSource {
    //для работы с базой
    final BookDB dataBase1;

    public  LocalDataSource (Context context) {
        dataBase1 = Room.databaseBuilder(context,BookDB.class,"book_list").build();

    }

    public  void  storeBookList(List<BookEntity> root) {
        dataBase1.bookDao().insertBookList(root);
    }


    public LiveData<List<BookEntity>> getBookList() {
        return dataBase1.bookDao().getBookList();
    }
    public LiveData<List<BookEntity>> getPreferencesList() {
        return dataBase1.bookDao().getPreferencesBookList();
    }
}
