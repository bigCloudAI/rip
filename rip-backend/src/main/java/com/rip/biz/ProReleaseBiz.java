package com.rip.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rip.entity.ProRelease;
import com.rip.model.ReturnT;
import com.rip.repo.ProReleaseRepo;

@Service
public class ProReleaseBiz {
	@Autowired
	ProReleaseRepo proReleaseRepo;

	public ReturnT<Object> getProReleasePage(Pageable pageable) {
		Page<ProRelease> page = proReleaseRepo.findAll(pageable);
		return ReturnT.ok(page);
	}

	public ReturnT<Object> addProRelease(ProRelease proRelease) {
		try {
			proRelease = proReleaseRepo.save(proRelease);
			return ReturnT.ok(proRelease);
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}

	public ReturnT<Object> deleteProRelease(int id) {
		try {
			proReleaseRepo.deleteById(id);
			return ReturnT.ok("删除成功");
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
}
