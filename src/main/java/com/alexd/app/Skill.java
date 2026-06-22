package com.alexd.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Skill {
    private int id;
    private String name;
    private String category;

    public Skill() {
    }

    public Skill(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static LinkedHashMap<String, ArrayList<Skill>> loadAllSkillsByCategory(Statement statement)
            throws SQLException {
        LinkedHashMap<String, ArrayList<Skill>> groupedSkills = new LinkedHashMap<>();
        String skillsQuery = """
                SELECT id,
                       name,
                       category
                  FROM skills
                 ORDER BY category,
                          name COLLATE NOCASE;
                """;
        try (ResultSet skillsResults = statement.executeQuery(skillsQuery)) {
            while (skillsResults.next()) {
                String category = skillsResults.getString("category");
                Skill skill = new Skill(skillsResults.getInt("id"), skillsResults.getString("name"), category);
                groupedSkills.putIfAbsent(category, new ArrayList<>());
                groupedSkills.get(category).add(skill);
            }
        }
        return groupedSkills;
    }
}
