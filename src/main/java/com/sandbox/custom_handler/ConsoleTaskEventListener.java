package com.sandbox.custom_handler;

public class ConsoleTaskEventListener extends AbstractTaskEventListener {
    void processEvent(TaskEvent event) {
        StringBuilder sb = new StringBuilder();

        sb
            .append("[")
            .append(event.getEntityName())
            .append("-")
            .append(event.getId())
            .append("] ")
            .append(event.getAction())
            .append(" by user ")
            .append(event.getUserId());

        System.out.println(sb);
    }
}
