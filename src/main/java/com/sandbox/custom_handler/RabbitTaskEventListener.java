package com.sandbox.custom_handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitTaskEventListener extends AbstractTaskEventListener {
    void processEvent(TaskEvent event) {
        Gson gson = new Gson();
        try {
            RabbitClient.getInstance().sendMessage(gson.toJson(event));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
