package com.example.contentprovidertest.Ui.CustomContentProvider;

import android.net.Uri;

/**
 * Created by user on 24/4/17.
 */
public class BookInformation {

    private String bookTitle;
    private String isbn;

    public BookInformation(String bookTitle, String isbn) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }


    public String getIsbn() {
        return isbn;
    }


}
