package com.sandbox.custom_handler;

public class ConsoleProcessEventListener extends AbstractProcessEventListener {
    void processEvent(ProcessEvent event) {

        StringBuilder sb = new StringBuilder();
        sb
            .append("[")
            .append(event.getEntityName())
            .append("-")
            .append(event.getProcessName())
            .append("-")
            .append(event.getProcessInstanceId())
            .append("] ")
            .append(event.getAction());

        if (event.getNodeName() != null) {
            sb
                .append(" ")
                .append(event.getNodeName());
        }

        System.out.println(sb);
    }
}
