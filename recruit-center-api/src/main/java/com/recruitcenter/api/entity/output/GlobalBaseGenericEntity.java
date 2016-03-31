package com.recruitcenter.api.entity.output;

public class GlobalBaseGenericEntity<T> extends GlobalBaseInfo {
	private T data = null;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
