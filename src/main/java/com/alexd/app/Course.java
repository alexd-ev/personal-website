package com.alexd.app;

import java.util.ArrayList;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Course {
    private int id;
    private int educationId;
    private String courseName;
    private String courseCode;
    private String completionDate;

    public Course() {
    }

    public Course(int id, int educationId, String course_name, String course_code, String completion_date) {
        this.id = id;
        this.educationId = educationId;
        this.courseName = course_name;
        this.courseCode = course_code;
        this.completionDate = DateUtils.formatYearMonth(completion_date);
    }

    public int getId() {
        return id;
    }

    public int getEducationId() {
        return educationId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public static ArrayList<Course> loadAllCourses(Statement statement) throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        String coursesQuery = """
                SELECT *
                  FROM courses;
                 ORDER BY completion_date DESC;
                """;
        try (ResultSet courseResults = statement.executeQuery(coursesQuery)) {
            while (courseResults.next()) {
                Course course = new Course(courseResults.getInt("id"), courseResults.getInt("education_id"),
                        courseResults.getString("course_name"), courseResults.getString("course_code"),
                        courseResults.getString("completion_date"));
                courses.add(course);
            }
        }
        return courses;
    }
}
