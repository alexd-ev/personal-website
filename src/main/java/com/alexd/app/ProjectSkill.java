package com.alexd.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectSkill {
    private int project_id;
    private int skill_id;

    public ProjectSkill() {
    }

    public ProjectSkill(int project_id, int skill_id) {
        this.project_id = project_id;
        this.skill_id = skill_id;
    }

    public int getProjectId() {
        return project_id;
    }

    public int getSkillId() {
        return skill_id;
    }

    public static ArrayList<Project> loadAllProjectSkills(Statement statement) throws SQLException {
        LinkedHashMap<Integer, Project> projectMap = new LinkedHashMap<>();
        String projectSkillsQuery = """
                SELECT p.id,
                       p.title,
                       p.description,
                       p.github_url,
                       p.experience_id,
                       p.education_id,
                       s.name
                  FROM projects p
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
                            projectSkillsResults.getInt("experience_id"), projectSkillsResults.getInt("education_id"));
                    projectMap.put(projectId, project);
                }
                String skillName = projectSkillsResults.getString("name");
                projectMap.get(projectId).getProjectSkills().add(skillName);
            }
        }
        return new ArrayList<>(projectMap.values());
    }
}
