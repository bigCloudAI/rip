package com.rip.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rip.entity.ProRelease;

@Repository
public interface ProReleaseRepo extends JpaRepository<ProRelease,Integer>,JpaSpecificationExecutor<ProRelease>{
	public List<ProRelease> findByDevProId(int devProId);
}
