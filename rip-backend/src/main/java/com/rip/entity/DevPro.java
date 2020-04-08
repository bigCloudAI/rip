package com.rip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dev_pro", schema = "rip")
public class DevPro {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32)
	int id; 
	
	@Column(name = "proName", length = 32)
	String proName;
	@Column(name = "proDesc", length = 32)
	String proDesc;
	
}
