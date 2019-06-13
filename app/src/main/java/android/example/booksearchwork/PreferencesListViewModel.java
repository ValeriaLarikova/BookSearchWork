package android.example.booksearchwork;

import android.content.Context;
import android.util.Log;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class PreferencesListViewModel extends ViewModel {
    private Repository repository;
    LiveData<List<BookEntity>> bookData;

    public void loadData(Context context,String title){
        if (bookData == null) {
            repository = ((BookSearchWork)context.getApplicationContext()).getRepository();
            bookData = repository.getPreferencesList(title);
//            repository.sheduleUpdate();
        }
    }

    public LiveData<List<BookEntity>> getBookData() {
        return bookData;
    }
}

