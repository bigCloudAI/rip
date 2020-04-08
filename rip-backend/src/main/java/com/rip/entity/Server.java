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
@Table(name = "server", schema = "rip")
public class Server {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32)
	int id; 
	@Column(name = "ipAddress", length = 32)
	String ipAddress;
	@Column(name = "stype", length = 32)
    String stype;
	@Column(name = "userName", length = 32)
    String userName;
	@Column(name = "password", length = 32)
    String password;
	@Column(name = "hostName", length = 32)
    String hostName;
	@Column(name = "status", length = 1)
    int status;
	
}
