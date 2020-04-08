package com.rip.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rip.biz.ProSoftwareBiz;
import com.rip.entity.ProSoftware;
import com.rip.model.ReturnT;

@RestController
@RequestMapping("/proSoftware")
public class ProSoftwareController {
	 
	@Autowired
	ProSoftwareBiz proSoftwareBiz;
	
	@PostMapping("/proSoftwarePage")
	public ReturnT<Object> getProSoftwarePage(Pageable pageable){
	    return proSoftwareBiz.getProSoftwarePage(pageable);
	}
	
	@PostMapping("/addProSoftware")
	public ReturnT<Object> addProSoftware(ProSoftware proSoftware){
	    return proSoftwareBiz.addProSoftware(proSoftware);
	}
	
	@PostMapping("/deleteProSoftware")
	public ReturnT<Object> deleteProSoftware(int id){
	    return proSoftwareBiz.deleteProSoftware(id);
	}

}
