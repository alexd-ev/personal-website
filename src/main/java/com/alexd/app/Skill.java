package com.alexd.app;

import java.util.ArrayList;

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

    public static ArrayList<Skill> loadAllSkills(Statement statement) throws SQLException {
        ArrayList<Skill> skills = new ArrayList<>();
        String skillsQuery = """
                SELECT *
                  FROM skills
                """;
        try (ResultSet skillsResults = statement.executeQuery(skillsQuery)) {
            while (skillsResults.next()) {
                Skill skill = new Skill(skillsResults.getInt("id"), skillsResults.getString("name"),
                        skillsResults.getString("category"));
                skills.add(skill);
            }
        }
        return skills;
    }
}
