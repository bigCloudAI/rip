package com.rip.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rip.entity.ProCodeRepo;
import com.rip.model.ReturnT;
import com.rip.repo.ProCodeRepoRepo;

@Service
public class ProCodeRepoBiz {
	@Autowired
	ProCodeRepoRepo proCodeRepoRepo;

	public ReturnT<Object> getProCodeRepoPage(Pageable pageable) {
		Page<ProCodeRepo> page = proCodeRepoRepo.findAll(pageable);
		return ReturnT.ok(page);
	}

	public ReturnT<Object> addProCodeRepo(ProCodeRepo proCodeRepo) {
		try {
			proCodeRepo = proCodeRepoRepo.save(proCodeRepo);
			return ReturnT.ok(proCodeRepo);
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}

	public ReturnT<Object> deleteProCodeRepo(int id) {
		try {
			proCodeRepoRepo.deleteById(id);
			return ReturnT.ok("删除成功");
		} catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
}
