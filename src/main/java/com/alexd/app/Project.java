package com.alexd.app;

import java.util.ArrayList;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Project {
    private int id;
    private String title;
    private String description;
    private String github_url;
    private int experience_id;
    private int education_id;

    public Project() {
    }

    public Project(int id, String title, String description, String github_url, int experience_id, int education_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.github_url = github_url;
        this.experience_id = experience_id;
        this.education_id = education_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGithubUrl() {
        return github_url;
    }

    public int getExperienceId() {
        return experience_id;
    }

    public int getEducationId() {
        return education_id;
    }

    public static ArrayList<Project> loadAllProjects(Statement statement) throws SQLException {
        ArrayList<Project> projects = new ArrayList<>();
        String projectsQuery = "SELECT * FROM projects";
        try (ResultSet projectsResults = statement.executeQuery(projectsQuery)) {
            while (projectsResults.next()) {
                Project project = new Project(projectsResults.getInt("id"), projectsResults.getString("title"),
                        projectsResults.getString("description"), projectsResults.getString("github_url"),
                        projectsResults.getInt("experience_id"), projectsResults.getInt("education_id"));
                projects.add(project);
            }
        }
        return projects;
    }
}
