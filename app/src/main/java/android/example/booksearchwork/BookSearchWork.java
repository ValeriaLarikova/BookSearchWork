package android.example.booksearchwork;

import android.app.Application;
import android.example.booksearchwork.data.Repository;

public class BookSearchWork extends Application {

    private Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(this);
    }

    public Repository getRepository() {
        return repository;
    }
}
