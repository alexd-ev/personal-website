package com.alexd.app;

import java.util.ArrayList;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Education {
    private int id;
    private String institution;
    private String degree;
    private String major;
    private String startDate;
    private String endDate;

    public Education() {
    }

    public Education(int id, String institution, String degree, String major, String start_date, String end_date) {
        this.id = id;
        this.institution = institution;
        this.degree = degree;
        this.major = major;
        this.startDate = DateUtils.formatYearMonth(start_date);
        this.endDate = DateUtils.formatYearMonth(end_date);
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
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public static ArrayList<Education> loadAllEducations(Statement statement) throws SQLException {
        ArrayList<Education> educations = new ArrayList<>();
        String educationsQuery = """
                SELECT *
                  FROM education;
                """;
        try (ResultSet educationsResults = statement.executeQuery(educationsQuery)) {
            while (educationsResults.next()) {
                Education education = new Education(educationsResults.getInt("id"),
                        educationsResults.getString("institution"), educationsResults.getString("degree"),
                        educationsResults.getString("major"), educationsResults.getString("start_date"),
                        educationsResults.getString("end_date"));
                educations.add(education);
            }
        }
        return educations;
    }
}
