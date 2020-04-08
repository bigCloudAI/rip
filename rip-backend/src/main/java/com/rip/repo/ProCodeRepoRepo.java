package com.rip.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rip.entity.ProCodeRepo;

@Repository
public interface ProCodeRepoRepo extends JpaRepository<ProCodeRepo,Integer>,JpaSpecificationExecutor<ProCodeRepo>{
	public List<ProCodeRepo> findByDevProId(int devProId);
}
