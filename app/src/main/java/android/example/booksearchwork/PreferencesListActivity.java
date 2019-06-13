package android.example.booksearchwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PreferencesListActivity extends AppCompatActivity implements Observer<List<BookEntity>> {
    private BookAdapter mAdapter;

    private RecyclerView mNumbersList;

    private String title_value;

    private List<BookEntity> bookEntities0;

    private LiveData<List<BookEntity>> bookData;
    private PreferencesListViewModel preferencesListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_list);

        bookData = new MutableLiveData<>();

        mNumbersList = findViewById(R.id.book_preferences_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        mNumbersList.setHasFixedSize(true);
        bookEntities0 = new ArrayList<>();
        mAdapter = new BookAdapter(bookEntities0, this);

        mNumbersList.setAdapter(mAdapter);

        preferencesListViewModel =
                ViewModelProviders.of(this).get(PreferencesListViewModel.class);

        preferencesListViewModel.loadData(this,title_value);

        bookData = preferencesListViewModel.getBookData();

        bookData.observe(this,this);

    }

    @Override
    public void onChanged(List<BookEntity> bookEntities) {
        mAdapter.func(bookEntities);
    }
}
