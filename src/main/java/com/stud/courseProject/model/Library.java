package com.stud.courseProject.model;

public class Library {

    private int id_library;
    private String address;

    public Library(){
    }

    public Library(int id_library, String address) {
        this.id_library = id_library;
        this.address = address;
    }

    public int getId_library() {
        return id_library;
    }

    public void setId_library(int id_library) {
        this.id_library = id_library;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
