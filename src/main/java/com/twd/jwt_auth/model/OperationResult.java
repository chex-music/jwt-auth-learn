package com.twd.jwt_auth.model;

public class OperationResult {

    private boolean success;
    private String message;

    public OperationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public OperationResult() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
