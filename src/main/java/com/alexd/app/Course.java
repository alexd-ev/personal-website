package com.alexd.app;

public class Course {
    private int id;
    private int education_id;
    private String course_name;
    private String course_code;
    private String completion_date;

    public Course() {
    }

    public Course(int id, int education_id, String course_name, String course_code, String completion_date) {
        this.id = id;
        this.education_id = education_id;
        this.course_name = course_name;
        this.course_code = course_code;
        this.completion_date = DateUtils.formatYearMonth(completion_date);
    }

    public int getId() {
        return id;
    }

    public int getEducationId() {
        return education_id;
    }

    public String getCourseName() {
        return course_name;
    }

    public String getCourseCode() {
        return course_code;
    }

    public String getCompletionDate() {
        return completion_date;
    }
}
