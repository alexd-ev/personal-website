package com.alexd.app;

import java.util.ArrayList;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    private int id;
    private int education_id;
    private String course_name;
    private String course_code;
    private String completion_date;

    public Course() {
    }

    public Course(int id, int education_id, String course_name, String course_code, String completion_date) {
        this.id = id;
        this.education_id = education_id;
        this.course_name = course_name;
        this.course_code = course_code;
        this.completion_date = DateUtils.formatYearMonth(completion_date);
    }

    public int getId() {
        return id;
    }

    public int getEducationId() {
        return education_id;
    }

    public String getCourseName() {
        return course_name;
    }

    public String getCourseCode() {
        return course_code;
    }

    public String getCompletionDate() {
        return completion_date;
    }

    public static ArrayList<Course> loadAllCourses(Statement statement) throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        String coursesQuery = """
                SELECT *
                  FROM courses;
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
