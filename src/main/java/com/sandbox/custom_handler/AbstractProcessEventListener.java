package com.sandbox.custom_handler;

import org.kie.api.event.process.*;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.api.runtime.process.ProcessInstance;

abstract public class AbstractProcessEventListener implements org.kie.api.event.process.ProcessEventListener {
    public void beforeProcessStarted(ProcessStartedEvent event) {
        processProcessEvent(event, "started");
    }

    public void afterProcessStarted(ProcessStartedEvent event) {
        // do nothing
    }

    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        processProcessEvent(event, "completed");
    }

    public void afterProcessCompleted(ProcessCompletedEvent event) {
        // do nothing
    }

    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        processNodeEvent(event, "entered");
    }

    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        // do nothing
    }

    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        processNodeEvent(event, "left");
    }

    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        // do nothing
    }

    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        // do nothing
    }

    public void afterVariableChanged(ProcessVariableChangedEvent event) {
        // do nothing
    }

    public void beforeSLAViolated(SLAViolatedEvent event) {
        // do nothing
    }

    public void afterSLAViolated(SLAViolatedEvent event) {
        // do nothing
    }

    private void processNodeEvent(ProcessNodeEvent event, String action) {
        NodeInstance node = event.getNodeInstance();
        ProcessInstance processInstance = event.getProcessInstance();

        ProcessEvent processEvent = new ProcessEvent(
                event.getEventDate(),
                processInstance.getProcessId(),
                processInstance.getParentProcessInstanceId(),
                action,
                node.getNodeName()
        );

        processEvent(processEvent);
    }

    private void processProcessEvent(org.kie.api.event.process.ProcessEvent event, String action) {
        ProcessInstance processInstance = event.getProcessInstance();

        ProcessEvent processEvent = new ProcessEvent(
                event.getEventDate(),
                processInstance.getProcessId(),
                processInstance.getParentProcessInstanceId(),
                action,
                null
        );

        processEvent(processEvent);
    }

    abstract void processEvent(ProcessEvent event);
}
