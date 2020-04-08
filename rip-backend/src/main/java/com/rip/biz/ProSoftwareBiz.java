package com.rip.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rip.entity.ProSoftware;
import com.rip.model.ReturnT;
import com.rip.repo.ProSoftwareRepo;

@Service
public class ProSoftwareBiz {
	@Autowired
	ProSoftwareRepo proSoftwareRepo;

	public ReturnT<Object> getProSoftwarePage(Pageable pageable) {
		Page<ProSoftware> page = proSoftwareRepo.findAll(pageable);
		return ReturnT.ok(page);
	}

	public ReturnT<Object> addProSoftware(ProSoftware proSoftware) {
		try {
			proSoftware = proSoftwareRepo.save(proSoftware);
			return ReturnT.ok(proSoftware);
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}

	public ReturnT<Object> deleteProSoftware(int id) {
		try {
			proSoftwareRepo.deleteById(id);
			return ReturnT.ok("删除成功");
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
}
