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
@Table(name = "pro_software", schema = "rip")
public class ProSoftware {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32)
	int id; 
	@Column(name = "dev_pro_id")
	int devProId;
	@Column(name = "zhname")
	String zhname;
	@Column(name = "codeRepoName")
	String codeRepoName;
    @Column(name = "buildTool")
    String buildTool;
    @Column(name = "buildCmd")
    String buildCmd;
    @Column(name = "buildTargetPath")
    String buildTargetPath;
    @Column(name = "softwareName")
    String softwareName;
    @Column(name = "targetType")
    String targetType;
	
    @Transient
	Link link = new Link(zhname,codeRepoName,zhname,softwareName);
    
	public Link getLink() {
		link = new Link(zhname,codeRepoName,zhname,softwareName);
		return this.link;
	}
    
}
