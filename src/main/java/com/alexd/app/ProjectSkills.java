package com.alexd.app;

public class ProjectSkills {
    private int project_id;
    private int skill_id;

    public ProjectSkills() {
    }

    public ProjectSkills(int project_id, int skill_id) {
        this.project_id = project_id;
        this.skill_id = skill_id;
    }

    public int getProjectId() {
        return project_id;
    }

    public int getSkillId() {
        return skill_id;
    }
}
