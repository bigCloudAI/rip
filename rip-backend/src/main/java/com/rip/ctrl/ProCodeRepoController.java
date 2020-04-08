package com.rip.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rip.biz.ProCodeRepoBiz;
import com.rip.entity.ProCodeRepo;
import com.rip.model.ReturnT;

@RestController
@RequestMapping("/proCR")
public class ProCodeRepoController {
	 
	@Autowired
	ProCodeRepoBiz proCodeRepoBiz;
	
	@PostMapping("/proCRPage")
	public ReturnT<Object> getProCRPage(Pageable pageable){
	    return proCodeRepoBiz.getProCodeRepoPage(pageable);
	}
	
	@PostMapping("/addProCR")
	public ReturnT<Object> addProCR(ProCodeRepo proCodeRepo){
		System.out.println(proCodeRepo);
	    return proCodeRepoBiz.addProCodeRepo(proCodeRepo);
	}
	
	@PostMapping("/deleteProCR")
	public ReturnT<Object> deleteProCR(int id){
	    return proCodeRepoBiz.deleteProCodeRepo(id);
	}

}
