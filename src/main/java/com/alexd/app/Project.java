package com.alexd.app;

import java.util.ArrayList;

public class Project {
    private int id;
    private String title;
    private String description;
    private String githubUrl;
    private String company;
    private String institution;
    private ArrayList<String> skillNames = new ArrayList<>();

    public Project() {
    }

    public Project(int id, String title, String description, String github_url, String company, String institution) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.githubUrl = github_url;
        this.company = company;
        this.institution = institution;
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
        return githubUrl;
    }

    public String getCompany() {
        return company;
    }

    public String getInstitution() {
        return institution;
    }

    public ArrayList<String> getProjectSkills() {
        return skillNames;
    }
}
