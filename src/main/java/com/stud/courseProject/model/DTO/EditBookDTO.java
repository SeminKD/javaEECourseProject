package com.stud.courseProject.model.DTO;

public class EditBookDTO {
    private int id_book;
    private String name_book;
    private String author;
    private String publish_house;
    private String publish_date;
    private int quantity;

    public EditBookDTO(int id_book, String name_book, String author, String publish_house,
                       String publish_date, int quantity, int id_library, String address) {
        this.id_book = id_book;
        this.name_book = name_book;
        this.author = author;
        this.publish_house = publish_house;
        this.publish_date = publish_date;
        this.quantity = quantity;
    }

    public EditBookDTO() {
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish_house() {
        return publish_house;
    }

    public void setPublish_house(String publish_house) {
        this.publish_house = publish_house;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
