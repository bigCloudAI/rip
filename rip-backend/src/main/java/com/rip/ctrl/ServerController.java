package com.rip.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rip.biz.ServerBiz;
import com.rip.entity.Server;
import com.rip.model.ReturnT;


@RestController
@RequestMapping("/server")
public class ServerController {

	@Autowired
	ServerBiz serverBiz;
    @PostMapping("/serverPage")
    public ReturnT<Object> getServerPage(Pageable pageable){
    	System.out.println(pageable);
        return serverBiz.getServerPage(pageable);
    }
    
    @PostMapping("/addServer")
    public ReturnT<Object> addServer(Server server){
        return serverBiz.addServer(server);
    }
    
    @PostMapping("/deleteServer")
    public ReturnT<Object> deleteServer(int id){
    	
        return serverBiz.deleteServer(id);
    }
	
}
