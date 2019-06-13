package android.example.booksearchwork;


import android.app.Application;

public class BookApp extends Application {
    private Repository repository;
    // нужно для того, чтобы вызвать репозиторий, тогда когда контекст не возможно дать, поэтому контекстом береться приложение
    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(this);
    }

    public Repository getRepository() {
        return repository;
    }

}
