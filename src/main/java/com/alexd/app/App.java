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
            IO.println();

            ArrayList<Education> educations = Education.loadAllEducations(statement);
            for (Education education : educations) {
                IO.println(education.getId() + " | " + education.getInstitution() + " | " + education.getDegree()
                        + " | " + education.getMajor() + " | " + education.getStartDate() + " | "
                        + education.getEndDate() + " | ");
                for (String courseName : education.getCourseNames()) {
                    IO.println("  - " + courseName);
                }
            }
            IO.println();

            ArrayList<Experience> experiences = Experience.loadAllExperiences(statement);
            for (Experience experience : experiences) {
                IO.println(experience.getId() + " | " + experience.getCompany() + " | " + experience.getRole() + " | "
                        + experience.getStartDate() + " | " + experience.getEndDate() + " | "
                        + experience.getDescription());
            }
            IO.println();

            ArrayList<Project> projectSkills = ProjectSkill.loadAllProjectSkills(statement);
            for (Project projectSkill : projectSkills) {
                IO.println(projectSkill.getId() + " | " + projectSkill.getTitle() + " | "
                        + projectSkill.getDescription() + " | " + projectSkill.getGithubUrl() + " | "
                        + projectSkill.getCompany() + " | " + projectSkill.getInstitution());
                for (String skill : projectSkill.getProjectSkills()) {
                    IO.println("  - " + skill);
                }
            }
            IO.println();

            ArrayList<Skill> skills = Skill.loadAllSkills(statement);
            for (Skill skill : skills) {
                IO.println(skill.getId() + " | " + skill.getName() + " | " + skill.getCategory());
            }
            IO.println();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
