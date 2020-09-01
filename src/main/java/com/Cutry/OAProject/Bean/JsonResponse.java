package com.Cutry.OAProject.Bean;

import java.util.HashMap;

public class JsonResponse {

    private Object data;

    private boolean success;

    private String message;

    public JsonResponse () {
        this.data = new HashMap<String, Object>();
        this.success = true;
        this.message = "";
    }

    public JsonResponse (Object data) {
        this.data = data;
        this.success = true;
        this.message = "";
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFalseAndMessage (String message) {
        this.success = false;
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "data=" + data +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
