package com.rip.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rip.entity.Server;

@Repository
public interface  ServerRepo extends JpaRepository<Server,Integer>,JpaSpecificationExecutor<Server>{
}
