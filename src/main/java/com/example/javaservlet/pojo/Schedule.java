package com.example.javaservlet.pojo;

public class Schedule {
    private int id;
    private int userId;
    private String eventDate;
    private String eventTime;
    private String description;

    // 默认构造函数
    public Schedule() {
    }

    // 带参数的构造函数
    public Schedule(int id, int userId, String eventDate, String eventTime, String description) {
        this.id = id;
        this.userId = userId;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.description = description;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString 方法
    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", userId=" + userId +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

