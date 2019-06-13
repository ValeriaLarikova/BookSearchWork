package android.example.booksearchwork.data.entities;

import android.example.booksearchwork.data.entities.Docs;

import java.util.List;
public class Root
{
    private int start;

    private int num_found;

    private List<Docs> docs;

    public void setStart(int start){
        this.start = start;
    }
    public int getStart(){
        return this.start;
    }
    public void setNum_found(int num_found){
        this.num_found = num_found;
    }
    public int getNum_found(){
        return this.num_found;
    }
    public void setDocs(List<Docs> docs){
        this.docs = docs;
    }
    public List<Docs> getDocs(){
        return this.docs;
    }
}

