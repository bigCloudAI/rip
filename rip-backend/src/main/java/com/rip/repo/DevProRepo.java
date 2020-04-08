package com.rip.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rip.entity.DevPro;

@Repository
public interface  DevProRepo extends JpaRepository<DevPro,Integer>,JpaSpecificationExecutor<DevPro>{
}
