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
@Table(name = "pro_release", schema = "rip")
public class ProRelease {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32)
	int id;
	@Column(name = "dev_pro_id")
	int devProId;
	@Column(name = "name")
	String name;
	@Column(name = "image")
	String image;
	@Column(name = "deployWay")
	String deployWay;
	@Column(name = "env")
	String env;
	@Column(name = "envType")
	String envType;
	@Column(name = "diyTag")
	String diyTag;
	
	
	@Transient
	Link link ;
	
	public Link getLink() {
		link = new Link(this.name,this.image,this.name,this.env);
		return this.link;
	}
	
}
