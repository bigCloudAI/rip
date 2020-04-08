package com.rip.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rip.entity.Server;
import com.rip.model.ReturnT;
import com.rip.repo.ServerRepo;

@Service
public class ServerBiz {

	@Autowired
	ServerRepo serverRepo;
	
	
	 public ReturnT<Object> getServerPage(Pageable pageable){
		 Page<Server> serverPage = serverRepo.findAll(pageable);
	        return ReturnT.ok(serverPage);
	    }
	
	public ReturnT<Object> addServer(Server server){
		try {
			server = serverRepo.save(server);
			return ReturnT.ok(server);
		}catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
	
	public ReturnT<Object> deleteServer(int id){
		try {
			serverRepo.deleteById(id);
			return ReturnT.ok("删除成功");
		}catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
	
	
	
}
