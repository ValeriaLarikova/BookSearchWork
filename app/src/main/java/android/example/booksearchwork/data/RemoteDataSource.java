package android.example.booksearchwork.data;

import android.example.booksearchwork.data.BookService;
import android.example.booksearchwork.data.entities.Root;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    // для работы с ретрофитом

    private BookService bookService;

    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://openlibrary.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bookService = retrofit.create(BookService.class);
    }


    public Root getBookList(String title){
        Call<Root> call = bookService.getBookList(title);
        try {
            Response<Root> response = call.execute();
            Log.e("lll", "" + response.raw().toString());
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException ioex) {
            Log.e("Remote","IOEX" + ioex);
        }

        return null;
    }

}
