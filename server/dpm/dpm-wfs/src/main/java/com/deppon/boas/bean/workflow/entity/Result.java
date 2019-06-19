package com.deppon.boas.bean.workflow.entity;

import java.io.Serializable;

/**
 * @author offves
 * @since 2019/1/14 17:35
 */
public class Result<T> implements Serializable {
    private static final long    serialVersionUID = 6718375200758695447L;
    private              boolean success          = true;
    private              T       data;
    private              int     errorCode;
    private              String  errorName;
    private              String  errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
