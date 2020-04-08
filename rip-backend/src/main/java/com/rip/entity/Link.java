package com.rip.entity;

import lombok.Data;

@Data
public class Link {
	public Link() {}
	public Link(String self, String head) {
		super();
		this.self = self;
		this.head = head;
	}
	
	public Link(String self, String head, String name, String value) {
		super();
		this.self = self;
		this.head = head;
		this.name = name;
		this.value = value;
	}

	String self;//
	String head;
	String name;
	String value;
	boolean select = false;
}
