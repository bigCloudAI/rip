package com.rip.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rip.entity.ProImage;
import com.rip.model.ReturnT;
import com.rip.repo.ProImageRepo;

@Service
public class ProImageBiz {
	@Autowired
	ProImageRepo proImageRepo;

	public ReturnT<Object> getProImagePage(Pageable pageable) {
		Page<ProImage> page = proImageRepo.findAll(pageable);
		return ReturnT.ok(page);
	}

	public ReturnT<Object> addProImage(ProImage proImage) {
		try {
			proImage = proImageRepo.save(proImage);
			return ReturnT.ok(proImage);
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}

	public ReturnT<Object> deleteProImage(int id) {
		try {
			proImageRepo.deleteById(id);
			return ReturnT.ok("删除成功");
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
}
