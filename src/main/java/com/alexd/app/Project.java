package com.alexd.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

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

    public ArrayList<String> getSkills() {
        return skillNames;
    }

    public static ArrayList<Project> loadAllProjects(Statement statement) throws SQLException {
        LinkedHashMap<Integer, Project> projectMap = new LinkedHashMap<>();
        String projectsQuery = """
                SELECT p.id,
                       p.title,
                       p.description,
                       p.github_url,
                       p.experience_id,
                       p.education_id,
                       exp.company,
                       edu.institution,
                       s.name
                  FROM projects p
                       LEFT JOIN
                       experience exp ON p.experience_id = exp.id
                       LEFT JOIN
                       education edu ON p.education_id = edu.id
                       LEFT JOIN
                       project_skills ps ON p.id = ps.project_id
                       LEFT JOIN
                       skills s ON ps.skill_id = s.id
                 ORDER BY p.id;
                """;
        try (ResultSet projectSkillsResults = statement.executeQuery(projectsQuery)) {
            while (projectSkillsResults.next()) {
                int projectId = projectSkillsResults.getInt("id");
                if (!projectMap.containsKey(projectId)) {
                    Project project = new Project(projectId, projectSkillsResults.getString("title"),
                            projectSkillsResults.getString("description"), projectSkillsResults.getString("github_url"),
                            projectSkillsResults.getString("company"), projectSkillsResults.getString("institution"));
                    projectMap.put(projectId, project);
                }
                String skillName = projectSkillsResults.getString("name");
                projectMap.get(projectId).getSkills().add(skillName);
            }
        }
        return new ArrayList<>(projectMap.values());
    }
}
