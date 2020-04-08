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
@Table(name = "pro_image", schema = "rip")
public class ProImage {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32)
	int id; 
	@Column(name = "dev_pro_id")
	int devProId;
	@Column(name = "zhname", length = 32)
	String zhname;
	@Column(name = "imageName")
	String imageName;
	@Column(name = "softwareName")
	String softwareName;
	@Column(name = "dockerfile",  columnDefinition="text", nullable=true)
	String dockerfile;
	@Column(name = "versionManageWay")
	String versionManageWay;
	
	@Transient
	Link link = new Link(zhname+"","",zhname,imageName);
	
	public Link getLink() {
		link = new Link(this.zhname+"",this.softwareName,this.zhname,this.imageName);
		return this.link;
	}
	
}
