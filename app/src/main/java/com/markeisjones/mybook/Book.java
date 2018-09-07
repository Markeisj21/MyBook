package com.markeisjones.mybook;

public class Book {
    public String title;
    public String imageURL;
    public String author;

    public Book() {
    }

    public Book(String title, String imageURL, String author) {
        this.title = title;
        this.imageURL = imageURL;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

