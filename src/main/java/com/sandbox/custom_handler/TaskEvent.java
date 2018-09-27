package com.sandbox.custom_handler;

import java.util.Date;

class TaskEvent {
    private Long id;
    private Date date;
    private String action;
    private String userId;

    TaskEvent(Date date, Long id, String userId, String action) {
        this.id = id;
        this.date = date;
        this.action = action;
        this.userId = userId;
    }

    String getAction() {
        return action;
    }

    Long getId() {
        return id;
    }

    String getUserId() {
        return userId;
    }

    Date getDate() {
        return date;
    }

    String getEntityName() {
        return "task";
    }
}
