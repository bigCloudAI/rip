package com.rip.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rip.biz.DevProBiz;
import com.rip.entity.DevPro;
import com.rip.model.ReturnT;

@RestController
@RequestMapping("/devPro")
public class DevProController {
 
	@Autowired
	DevProBiz devProBiz;
	
	@PostMapping("/devProPage")
	public ReturnT<Object> getDevProPage(Pageable pageable){
	    return devProBiz.getDevProPage(pageable);
	}
	
	@PostMapping("/addDevPro")
	public ReturnT<Object> addDevPro(DevPro devPro){
	    return devProBiz.addDevPro(devPro);
	}
	
	@PostMapping("/deleteDevPro")
	public ReturnT<Object> deleteDevPro(int id){
	    return devProBiz.deleteDevPro(id);
	}
	
	@PostMapping("/devProInfo")
	public ReturnT<Object> devProInfo(DevPro devPro){
		System.out.println(devPro);
	    return devProBiz.devProInfo(devPro.getId());
	}

}
