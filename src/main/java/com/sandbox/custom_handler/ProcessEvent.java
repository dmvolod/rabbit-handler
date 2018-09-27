package com.sandbox.custom_handler;

import java.util.Date;

class ProcessEvent {
    private Long processInstanceId;
    private Date date;
    private String action;
    private String processName;
    private String nodeName;


    ProcessEvent(Date date, String processName, Long processId, String action, String nodeName) {
        this.processName = processName;
        this.processInstanceId = processId;
        this.date = date;
        this.action = action;
        this.nodeName = nodeName;
    }

    String getAction() {
        return action;
    }

    Long getProcessInstanceId() {
        return processInstanceId;
    }

    Date getDate() {
        return date;
    }

    String getEntityName() {
        return "process";
    }

    public String getProcessName() {
        return processName;
    }

    public String getNodeName() {
        return nodeName;
    }
}
