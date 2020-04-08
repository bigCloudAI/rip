package com.rip.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rip.biz.ProReleaseBiz;
import com.rip.entity.ProRelease;
import com.rip.model.ReturnT;

@RestController
@RequestMapping("/proRelease")
public class ProReleaseController {
	
	@Autowired
	ProReleaseBiz proReleaseBiz;
	
	@PostMapping("/proReleasePage")
	public ReturnT<Object> getProReleasePage(Pageable pageable){
	    return proReleaseBiz.getProReleasePage(pageable);
	}
	
	@PostMapping("/addProRelease")
	public ReturnT<Object> addProRelease(ProRelease proRelease){
	    return proReleaseBiz.addProRelease(proRelease);
	}
	
	@PostMapping("/deleteProRelease")
	public ReturnT<Object> deleteProRelease(int id){
	    return proReleaseBiz.deleteProRelease(id);
	}

}
