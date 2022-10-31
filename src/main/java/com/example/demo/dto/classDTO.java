package com.example.demo.dto;

public class classDTO {
    private String field;
    private String className;
    private int credits;
    private int english;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    private int years;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
}
