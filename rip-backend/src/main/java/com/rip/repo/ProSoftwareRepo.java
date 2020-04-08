package com.rip.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rip.entity.ProSoftware;

@Repository
public interface  ProSoftwareRepo extends JpaRepository<ProSoftware,Integer>,JpaSpecificationExecutor<ProSoftware>{
	public List<ProSoftware> findByDevProId(int devProId);
}
