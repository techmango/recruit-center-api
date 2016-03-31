package com.recruitcenter.api.entity.output;

import com.recruitcenter.api.utils.Common;

public class GlobalBaseInfo {
private String result = Common.FAILURE_TAG;
	
	private String error = null;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
