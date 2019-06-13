package android.example.booksearchwork;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class Repository {

    private  LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;

    public Repository(Context context) {
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }

    public LiveData<List<BookEntity>> getMainList(final String title) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run()  {
                Root docs = remoteDataSource.getBookList(title);
                if (docs != null) {
                    final List<BookEntity> bookList = new ArrayList<>();
                    for (int i = 0; i < docs.getDocs().size(); i++) {
                        BookEntity bookEntity = new BookEntity();
                        bookEntity.id = i;
                        bookEntity.title = docs.getDocs().get(i).getTitle();
                        bookEntity.year = docs.getDocs().get(i).getFirst_publish_year();
                        bookEntity.author = docs.getDocs().get(i).getAuthor_name().get(0);
                        bookEntity.edition = docs.getDocs().get(i).getEdition_count();
                        bookEntity.isInPreferences = false;
                        bookList.add(bookEntity);
                    }
                    localDataSource.storeBookList(bookList);
                }
            }
        });
        return localDataSource.getBookList();
    }
    public LiveData<List<BookEntity>> getPreferencesList(final String title) {
        return localDataSource.getPreferencesList();
    }
    public void updatePreferences(BookEntity bookEntity) {
        final List<BookEntity> bookList = new ArrayList<>();
        bookEntity.isInPreferences = true;
        bookList.add(bookEntity);
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.storeBookList(bookList);
            }
        });
    }


    public void sheduleUpdate() {
//        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(SyncWorker.class).build();
//        WorkManager.getInstance().enqueue(request);
//        WorkManager.getInstance().getWorkInfoByIdLiveData(); // чтобы следить за статусом нашей задачи
    }

}
