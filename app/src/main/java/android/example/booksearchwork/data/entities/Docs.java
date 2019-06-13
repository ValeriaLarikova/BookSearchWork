package android.example.booksearchwork.data.entities;

import java.util.ArrayList;
import java.util.List;
public class Docs
{
    private int cover_i;

    private boolean has_fulltext;

    private int edition_count;

    private String title;

    private List<String> author_name;

    private int first_publish_year;

    private String key;

    private List<String> ia;

    private List<String> author_key;

    private boolean public_scan_b;

    public void setCover_i(int cover_i){
        this.cover_i = cover_i;
    }
    public int getCover_i(){
        return this.cover_i;
    }
    public void setHas_fulltext(boolean has_fulltext){
        this.has_fulltext = has_fulltext;
    }
    public boolean getHas_fulltext(){
        return this.has_fulltext;
    }
    public void setEdition_count(int edition_count){
        this.edition_count = edition_count;
    }
    public int getEdition_count(){
        return this.edition_count;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthor_name(List<String> author_name){
        this.author_name = author_name;
    }
    public List<String> getAuthor_name(){
        return this.author_name;
    }
    public void setFirst_publish_year(int first_publish_year){
        this.first_publish_year = first_publish_year;
    }
    public int getFirst_publish_year(){
        return this.first_publish_year;
    }
    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }
    public void setIa(List<String> ia){
        this.ia = ia;
    }
    public List<String> getIa(){
        return this.ia;
    }
    public void setAuthor_key(List<String> author_key){
        this.author_key = author_key;
    }
    public List<String> getAuthor_key(){
        return this.author_key;
    }
    public void setPublic_scan_b(boolean public_scan_b){
        this.public_scan_b = public_scan_b;
    }
    public boolean getPublic_scan_b(){
        return this.public_scan_b;
    }
}

