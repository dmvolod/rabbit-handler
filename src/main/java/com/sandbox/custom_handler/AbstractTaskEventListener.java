package com.sandbox.custom_handler;

import org.kie.api.task.TaskEvent;
import org.kie.api.task.TaskLifeCycleEventListener;

abstract public class AbstractTaskEventListener implements TaskLifeCycleEventListener {
    public void beforeTaskActivatedEvent(TaskEvent event) {
        processTaskEvent(event, "activated");
    }

    public void beforeTaskClaimedEvent(TaskEvent event) {
        processTaskEvent(event, "claimed");
    }

    public void beforeTaskSkippedEvent(TaskEvent event) {
        processTaskEvent(event, "skipped");
    }

    public void beforeTaskStartedEvent(TaskEvent event) {
        processTaskEvent(event, "started");
    }

    public void beforeTaskStoppedEvent(TaskEvent event) {
        processTaskEvent(event, "stopped");
    }

    public void beforeTaskCompletedEvent(TaskEvent event) {
        processTaskEvent(event, "completed");
    }

    public void beforeTaskFailedEvent(TaskEvent event) {
        processTaskEvent(event, "failed");
    }

    public void beforeTaskAddedEvent(TaskEvent event) {
        processTaskEvent(event, "added");
    }

    public void beforeTaskExitedEvent(TaskEvent event) {
        processTaskEvent(event, "exited");
    }

    public void beforeTaskReleasedEvent(TaskEvent event) {
        processTaskEvent(event, "released");
    }

    public void beforeTaskResumedEvent(TaskEvent event) {
        processTaskEvent(event, "resumed");
    }

    public void beforeTaskSuspendedEvent(TaskEvent event) {
        processTaskEvent(event, "suspended");
    }

    public void beforeTaskForwardedEvent(TaskEvent event) {
        processTaskEvent(event, "forwarded");
    }

    public void beforeTaskDelegatedEvent(TaskEvent event) {
        processTaskEvent(event, "delegated");
    }

    public void beforeTaskNominatedEvent(TaskEvent event) {
        processTaskEvent(event, "nominated");
    }

    public void afterTaskActivatedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskClaimedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskSkippedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskStartedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskStoppedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskCompletedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskFailedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskAddedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskExitedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskReleasedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskResumedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskSuspendedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskForwardedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskDelegatedEvent(TaskEvent event) {
        // do nothing
    }

    public void afterTaskNominatedEvent(TaskEvent event) {
        // do nothing
    }

    private void processTaskEvent(TaskEvent event, String action) {
        com.sandbox.custom_handler.TaskEvent taskEvent = new com.sandbox.custom_handler.TaskEvent(
                event.getEventDate(),
                event.getTask().getId(),
                event.getTaskContext().getUserId(),
                action
        );
        processEvent(taskEvent);
    }

    abstract void processEvent(com.sandbox.custom_handler.TaskEvent event);
}
