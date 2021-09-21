package ru.netology;

public class Magazine extends Product {
    private String author;

    public Magazine() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Magazine(int id, int price, String name, String author) {
        super(id, price, name);
        this.author = author;
    }

}