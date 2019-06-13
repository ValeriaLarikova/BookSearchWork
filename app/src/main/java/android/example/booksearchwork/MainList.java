package android.example.booksearchwork;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainList extends AppCompatActivity implements Observer<List<BookEntity>> {

    private BookAdapter mAdapter;

    private RecyclerView mNumbersList;

    private String title_value;

    private List<BookEntity> bookEntities0;

    private LiveData<List<BookEntity>> bookData;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

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