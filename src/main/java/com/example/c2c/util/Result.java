package com.example.c2c.util;

public class Result {
    private boolean success;
    private String message;
    private Object data;

    public static Result success(String message, Object data) {
        Result result = new Result();
        result.success = true;
        result.message = message;
        result.data = data;
        return result;
    }

    public static Result fail(String message) {
        Result result = new Result();
        result.success = false;
        result.message = message;
        return result;
    }


    public Result() {
    }

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
