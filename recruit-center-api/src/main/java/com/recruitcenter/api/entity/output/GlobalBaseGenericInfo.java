package com.recruitcenter.api.entity.output;

import java.util.ArrayList;

import com.recruitcenter.api.utils.Common;

public class GlobalBaseGenericInfo<T> {
	private String result = Common.FAILURE_TAG;
	
	private String error = null;
	
	private ArrayList<T> data = new ArrayList<T>();

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

	public ArrayList<T> getData() {
		return data;
	}

	public void setData(ArrayList<T> data) {
		this.data = data;
	}
	
}
