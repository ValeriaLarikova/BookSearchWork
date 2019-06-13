package android.example.booksearchwork.adapters;

import android.content.Context;
import android.example.booksearchwork.data.entities.BookEntity;
import android.example.booksearchwork.R;
import android.example.booksearchwork.activities.MainListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.NumberViewHolder>{
    private  static  int viewHolderCount;
    private int numberItems;
    private Context context;

    private List<BookEntity> bookEntities;
    public BookAdapter(List<BookEntity> bookEntities1, Context context) {
        this.context = context;
        if (bookEntities1.isEmpty()) {
            numberItems = 0;
        }
        else {
            numberItems = bookEntities1.size();
        }
        bookEntities = bookEntities1;
        viewHolderCount = 0;
    }

    public void func (List<BookEntity> bookEntities1) {
        bookEntities = bookEntities1;
        notifyDataSetChanged();

    }

    // создаем новые вьюхолдеры
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.book_item;

        // perevodim xml v java
        LayoutInflater inflater = LayoutInflater.from(context);

        // dolzhen znat iz kakogo xml delaem/ znay roditelya / neobhodimo li pomeshat sozdanniu component vnytr roditelya, no ono i tak bydet sdelano
        View view = inflater.inflate(layoutIdForListItem,parent,false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);
        //  viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);

        viewHolderCount++;

        return viewHolder;
    }


    // у созданных холдеров меняем их значения, во время прокрутки списка
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainListActivity)context).saveToPreferences(bookEntities.get(position));
            }
        });
        holder.bind(bookEntities,position);
    }

    // вернуть общее кол-во елементов в списке
    @Override
    public int getItemCount() {
        return bookEntities.size();
    }

    //обертка для элемента списка
    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView author;
        TextView year;
        TextView edition;

        public NumberViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            year = itemView.findViewById(R.id.year);
            edition = itemView.findViewById(R.id.edition_count);

        }

        void bind(List<BookEntity> bookEntities, int listIndex) {
            title.setText(bookEntities.get(listIndex).title);
            author.setText(bookEntities.get(listIndex).author);
            year.setText("" + bookEntities.get(listIndex).year);

            int ed = bookEntities.get(listIndex).edition;
            String edTxt = "";
            if (ed == 1) {
                edTxt += "First";
            } else if (ed == 2) {
                edTxt += "Second";
            } else if (ed == 3) {
                edTxt += "Third";
            } else {
                edTxt += ed + "th";
            }
            edTxt += " edition";
            edition.setText(edTxt);
        }
    }
}
