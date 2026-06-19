package com.alexd.app;

import java.util.ArrayList;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Experience {
    private int id;
    private String company;
    private String role;
    private String start_date;
    private String end_date;
    private String description;

    public Experience() {
    }

    public Experience(int id, String company, String role, String start_date, String end_date, String description) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.start_date = DateUtils.formatYearMonth(start_date);
        this.end_date = DateUtils.formatYearMonth(end_date);
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public String getStartDate() {
        return start_date;
    }

    public String getEndDate() {
        return end_date;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Experience> loadAllExperiences(Statement statement) throws SQLException {
        ArrayList<Experience> experiences = new ArrayList<>();
        String experiencesQuery = """
                SELECT *
                  FROM experience;
                """;
        try (ResultSet experiencesResults = statement.executeQuery(experiencesQuery)) {
            while (experiencesResults.next()) {
                Experience experience = new Experience(experiencesResults.getInt("id"),
                        experiencesResults.getString("company"), experiencesResults.getString("role"),
                        experiencesResults.getString("start_date"), experiencesResults.getString("end_date"),
                        experiencesResults.getString("description"));
                experiences.add(experience);
            }
        }
        return experiences;
    }
}
