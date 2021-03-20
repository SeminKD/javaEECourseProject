package com.stud.courseProject.model.DTO;

public class DischargeDTO {
    private int id_discharge;
    private String info_student;
    private DischargeBookDTO book;
    private String name_librarian;
    private String issue_date;
    private String return_period;

    public DischargeDTO() {
    }

    public DischargeDTO(int id_discharge, String info_student, DischargeBookDTO book,  String name_librarian,
                        String issue_date, String return_period) {
        this.id_discharge = id_discharge;
        this.book = book;
        this.info_student = info_student;
        this.name_librarian = name_librarian;
        this.issue_date = issue_date;
        this.return_period = return_period;
    }

    public int getId_discharge() {
        return id_discharge;
    }

    public void setId_discharge(int id_discharge) {
        this.id_discharge = id_discharge;
    }

    public DischargeBookDTO getInfo_book() {
        return book;
    }

    public void setInfo_book(DischargeBookDTO info_book) {
        this.book = info_book;
    }

    public String getInfo_student() {
        return info_student;
    }

    public void setInfo_student(String info_student) {
        this.info_student = info_student;
    }

    public String getName_librarian() {
        return name_librarian;
    }

    public void setName_librarian(String name_librarian) {
        this.name_librarian = name_librarian;
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
