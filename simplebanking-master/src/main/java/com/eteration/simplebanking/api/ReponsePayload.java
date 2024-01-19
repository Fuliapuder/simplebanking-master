package com.eteration.simplebanking.api;


import com.eteration.simplebanking.enums.ResponseEnum;

public class ReponsePayload {
    public Integer code;
    public String message;
    public Boolean success;
    public ResponseEnum responseEnum;
    public Object data;

    public ReponsePayload(ResponseEnum responseEnum) {
        super();
        this.responseEnum = responseEnum;
        this.code = responseEnum.getHttpStatusCode();
        this.message = responseEnum.getDescription();
        this.success = responseEnum.getIsSuccess();
    }

    public ReponsePayload(Integer code, String message, Boolean success, Object data) {
        this(code, message, success);
        this.data = data;
    }

    public ReponsePayload(ResponseEnum responseEnum, String message) {
        this(responseEnum);
        if (responseEnum.equals(ResponseEnum.BADREQUEST) || responseEnum.equals(ResponseEnum.FORBIDDEN)
                || responseEnum.equals(ResponseEnum.NOTFOUND) || responseEnum.equals(ResponseEnum.UNAUTHORIZED)) {
            this.success = false;
        }
        this.message = message;
    }

    public ReponsePayload(ResponseEnum responseEnum, String message, Object data) {
        this(responseEnum);
        this.message = message;
        this.data = data;
    }

    public ReponsePayload(Integer code, String message, Boolean success) {
        this(code, success);
        this.message = message;
    }

    public ReponsePayload(Integer code, Boolean success) {
        this(success);
        this.code = code;
    }

    public ReponsePayload(Boolean success) {
        super();
        this.success = success;
    }

    public ReponsePayload(ResponseEnum responseEnum, Object data) {
        this(responseEnum);
        this.data = data;
    }

    public ReponsePayload(ResponseEnum responseEnum, String message, Boolean success, Object data) {
        this(responseEnum);
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}