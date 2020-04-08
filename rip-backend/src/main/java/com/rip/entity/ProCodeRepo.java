package com.rip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "pro_code_repo", schema = "rip")
public class ProCodeRepo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32)
	int id; 
	
	@Column(name = "dev_pro_id")
	int devProId;
	
	@Column(name = "name", length = 32)
	String name;
	@Column(name = "repourl")
	String repourl;
	@Column(name = "type")
	String type;
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	
	
	
	@Transient
	Link link = new Link(name+"","",name,repourl);
	
	public Link getLink() {
		link = new Link(this.name+"","",this.name,this.repourl);
		return this.link;
	}
}
