package com.alexd.app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    void main() {
        ArrayList<Course> courses = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection();
                Statement statement = connection.createStatement()) {

            statement.setQueryTimeout(30);
            String query = "SELECT * FROM courses";

            try (ResultSet results = statement.executeQuery(query)) {
                while (results.next()) {
                    Course course = new Course(results.getInt("id"), results.getInt("education_id"),
                            results.getString("course_name"), results.getString("course_code"),
                            results.getString("completion_date"));
                    courses.add(course);
                }
            }

            for (Course course : courses) {
                IO.println(course.getId() + " | " + course.getEducationId() + " | " + course.getCourseName() + " | "
                        + course.getCourseCode() + " | " + course.getCompletionDate());
            }

        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
    }
}
