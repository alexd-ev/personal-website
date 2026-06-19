package com.alexd.app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class App {
    void main() {
        try (Connection connection = JDBCConnection.getConnection();
                Statement statement = JDBCConnection.getStatement(connection)) {

            ArrayList<Course> courses = Course.loadAllCourses(statement);
            for (Course course : courses) {
                IO.println(course.getId() + " | " + course.getEducationId() + " | " + course.getCourseName() + " | "
                        + course.getCourseCode() + " | " + course.getCompletionDate());
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
