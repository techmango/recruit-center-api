package com.recruitcenter.api.entity.output;

import java.util.ArrayList;

import com.recruitcenter.api.utils.Common;

public class GlobalBaseGenericArray<T> extends GlobalBaseInfo {
	
	private ArrayList<T> data = new ArrayList<T>();
	
	public ArrayList<T> getData() {
		return data;
	}

	public void setData(ArrayList<T> data) {
		this.data = data;
	}
}
