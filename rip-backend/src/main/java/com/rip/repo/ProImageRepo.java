package com.rip.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rip.entity.ProImage;

@Repository
public interface  ProImageRepo extends JpaRepository<ProImage,Integer>,JpaSpecificationExecutor<ProImage>{
	public List<ProImage> findByDevProId(int devProId);
}
