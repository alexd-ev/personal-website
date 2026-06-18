package com.alexd.app;

public class Education {
    private int id;
    private String institution;
    private String degree;
    private String major;
    private String start_date;
    private String end_date;

    public Education() {
    }

    public Education(int id, String institution, String degree, String major, String start_date, String end_date) {
        this.id = id;
        this.institution = institution;
        this.degree = degree;
        this.major = major;
        this.start_date = DateUtils.formatYearMonth(start_date);
        this.end_date = DateUtils.formatYearMonth(end_date);
    }

    public int getId() {
        return id;
    }

    public String getInstitution() {
        return institution;
    }

    public String getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public String getStartDate() {
        return start_date;
    }

    public String getEndDate() {
        return end_date;
    }
}
