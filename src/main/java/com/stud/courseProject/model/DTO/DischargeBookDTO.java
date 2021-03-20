package com.stud.courseProject.model.DTO;

public class DischargeBookDTO {
    private int id;
    private String name;
    private String author;
    private String publish_house;
    private String publish_date;

    public DischargeBookDTO(int id ,String name, String author, String publish_house, String publish_date) {
        this.id=id;
        this.name = name;
        this.author = author;
        this.publish_house = publish_house;
        this.publish_date = publish_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
