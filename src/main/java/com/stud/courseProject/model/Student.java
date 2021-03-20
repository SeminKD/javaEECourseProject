package com.stud.courseProject.model;

public class Student {

    private int id_student;
    private String name_student;
    private String stud_group;

    public Student() {
    }

    public Student(int id_student, String name_student, String stud_group) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.stud_group = stud_group;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getStud_group() {
        return stud_group;
    }

    public void setStud_group(String stud_group) {
        this.stud_group = stud_group;
    }
}
