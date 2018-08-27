package com.oaclient.entity.common;

/**
 * 通用返回信息
 */
public class ReturnCode {
    private String message=MessageType.SUCCESS;
    private String status=StatusType.SUCCESS;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReturnCode() {
    }

    public ReturnCode(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
