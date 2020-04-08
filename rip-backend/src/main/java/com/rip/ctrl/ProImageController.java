package com.rip.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rip.biz.ProImageBiz;
import com.rip.entity.ProImage;
import com.rip.model.ReturnT;

@RestController
@RequestMapping("/proImage")
public class ProImageController {
	@Autowired
	ProImageBiz proImageBiz;
	
	@PostMapping("/proImagePage")
	public ReturnT<Object> getProImagePage(Pageable pageable){
	    return proImageBiz.getProImagePage(pageable);
	}
	
	@PostMapping("/addProImage")
	public ReturnT<Object> addProImage(ProImage proImage){
	    return proImageBiz.addProImage(proImage);
	}
	
	@PostMapping("/deleteProImage")
	public ReturnT<Object> deleteProImage(int id){
	    return proImageBiz.deleteProImage(id);
	}

}
