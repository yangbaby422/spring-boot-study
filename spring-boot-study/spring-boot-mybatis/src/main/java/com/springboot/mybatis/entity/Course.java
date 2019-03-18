package com.springboot.mybatis.entity;

import lombok.Data;

@Data
public class Course {
    private Long courseId;
    private String courseName;
    private Long userId;
    private String courseClass;
    private String cover;
    private String courseCode;
    private Short finished;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Short getFinished() {
        return finished;
    }

    public void setFinished(Short finished) {
        this.finished = finished;
    }
}