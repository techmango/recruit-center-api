package com.recruitcenter.api.entity.output;

import java.util.ArrayList;

public class KeyValueTree {
	private String id;
	
	private String name;
	
	private ArrayList<KeyValueTree> next;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<KeyValueTree> getNext() {
		return next;
	}

	public void setNext(ArrayList<KeyValueTree> next) {
		this.next = next;
	}
}
