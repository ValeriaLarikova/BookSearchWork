package android.example.booksearchwork.data;

import android.example.booksearchwork.data.entities.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {
    @GET("search.json")
    Call<Root> getBookList(@Query("q")String title);
}