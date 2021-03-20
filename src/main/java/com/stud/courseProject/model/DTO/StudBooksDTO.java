package com.stud.courseProject.model.DTO;

public class StudBooksDTO {
    private String author;
    private String name_book;
    private String issue_date;
    private String return_period;
    private String publish_house;
    private String publish_date;

    public StudBooksDTO(String author, String name_book, String publish_house,
                        String publish_date, String issue_date, String return_period) {
        this.publish_house=publish_house;
        this.publish_date=publish_date;
        this.author=author;
        this.name_book = name_book;
        this.issue_date = issue_date;
        this.return_period = return_period;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturn_period() {
        return return_period;
    }

    public void setReturn_period(String return_period) {
        this.return_period = return_period;
    }
}
