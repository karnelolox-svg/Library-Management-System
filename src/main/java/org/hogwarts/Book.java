package org.hogwarts;

public class Book {
    private String Author;
    private String Title;
    private String isbn;


    public Book(String Author,String Title, String isbn){
        this.Author = Author;
        this.Title = Title;
        this.isbn = isbn;

    }

    public String toString(){
        return Author + "," + Title +  "," + isbn;
    }

    public String getISBN(){

        return this.isbn;
    }

//    public String getAuthor(){
//
//        return this.Author;
//    }
//
//    public String getTitle(){
//
//        return this.Title;
//    }
//
//    public String toFileString(){
//
//        return getAuthor() +
//    }
}
