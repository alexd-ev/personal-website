package com.alexd.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectSkill {
    public static ArrayList<Project> loadAllProjects(Statement statement) throws SQLException {
        LinkedHashMap<Integer, Project> projectMap = new LinkedHashMap<>();
        String projectSkillsQuery = """
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
        try (ResultSet projectSkillsResults = statement.executeQuery(projectSkillsQuery)) {
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
