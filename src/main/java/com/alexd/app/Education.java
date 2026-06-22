package com.alexd.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Education {
    private int id;
    private String institution;
    private String degree;
    private String major;
    private String startDate;
    private String endDate;
    private ArrayList<String> courseNames = new ArrayList<>();

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

    public ArrayList<String> getCourseNames() {
        return courseNames;
    }

    public static ArrayList<Education> loadAllEducations(Statement statement) throws SQLException {
        LinkedHashMap<Integer, Education> educationMap = new LinkedHashMap<>();
        String educationsQuery = """
                SELECT e.id,
                       e.institution,
                       e.degree,
                       e.major,
                       e.start_date,
                       e.end_date,
                       c.course_name
                  FROM education e
                       LEFT JOIN
                       courses c ON e.id = c.education_id
                 ORDER BY e.start_date DESC,
                          c.completion_date DESC;
                """;
        try (ResultSet educationsResults = statement.executeQuery(educationsQuery)) {
            while (educationsResults.next()) {
                int educationId = educationsResults.getInt("id");
                if (!educationMap.containsKey(educationId)) {
                    Education education = new Education(educationId, educationsResults.getString("institution"),
                            educationsResults.getString("degree"), educationsResults.getString("major"),
                            educationsResults.getString("start_date"), educationsResults.getString("end_date"));
                    educationMap.put(educationId, education);
                }
                String courseName = educationsResults.getString("course_name");
                if (courseName != null) {
                    educationMap.get(educationId).getCourseNames().add(courseName);
                }
            }
        }
        return new ArrayList<>(educationMap.values());
    }
}
