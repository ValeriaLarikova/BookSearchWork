package android.example.booksearchwork.activities;

import android.example.booksearchwork.adapters.BookAdapter;
import android.example.booksearchwork.data.entities.BookEntity;
import android.example.booksearchwork.viewmodels.MainViewModel;
import android.example.booksearchwork.R;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainListActivity extends AppCompatActivity implements Observer<List<BookEntity>> {

    private BookAdapter mAdapter;

    private RecyclerView mNumbersList;

    private String title_value;

    private List<BookEntity> bookEntities0;

    private LiveData<List<BookEntity>> bookData;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        title_value = getIntent().getStringExtra(getString(R.string.title));

        bookData = new MutableLiveData<>();

        mNumbersList = findViewById(R.id.book_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        mNumbersList.setHasFixedSize(true);
        bookEntities0 = new ArrayList<>();
        mAdapter = new BookAdapter(bookEntities0, this);

        mNumbersList.setAdapter(mAdapter);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.loadData(this,title_value);

        bookData = mainViewModel.getBookData();

        bookData.observe(this,this);
    }

    @Override
    public void onChanged(List<BookEntity> bookEntities) {
        mAdapter.func(bookEntities);
    }
    public void saveToPreferences(BookEntity bookEntity) {
        mainViewModel.updatePreferences(bookEntity);
    }
}