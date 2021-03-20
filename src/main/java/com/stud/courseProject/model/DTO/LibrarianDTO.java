package com.stud.courseProject.model.DTO;

public class LibrarianDTO {
    private int id_librarian;
    private String name_librarian;
    private String address;

    public LibrarianDTO(int id_librarian, String name_librarian, String address) {
        this.id_librarian = id_librarian;
        this.name_librarian = name_librarian;
        this.address = address;
    }

    public int getId_librarian() {
        return id_librarian;
    }

    public void setId_librarian(int id_librarian) {
        this.id_librarian = id_librarian;
    }

    public String getName_librarian() {
        return name_librarian;
    }

    public void setName_librarian(String name_librarian) {
        this.name_librarian = name_librarian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
