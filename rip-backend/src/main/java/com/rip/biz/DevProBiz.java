package com.rip.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rip.entity.DevPro;
import com.rip.entity.ProCodeRepo;
import com.rip.entity.ProImage;
import com.rip.entity.ProRelease;
import com.rip.entity.ProSoftware;
import com.rip.model.ReturnT;
import com.rip.repo.DevProRepo;
import com.rip.repo.ProCodeRepoRepo;
import com.rip.repo.ProImageRepo;
import com.rip.repo.ProReleaseRepo;
import com.rip.repo.ProSoftwareRepo;

@Service
public class DevProBiz {
	@Autowired
	DevProRepo devProRepo;
	
	@Autowired
	ProCodeRepoRepo proCodeRepoRepo;
	@Autowired
	ProImageRepo proImageRepo;
	@Autowired
	ProReleaseRepo proReleaseRepo;
	@Autowired
	ProSoftwareRepo proSoftwareRepo;
	
	 public ReturnT<Object> getDevProPage(Pageable pageable){
		 Page<DevPro> serverPage = devProRepo.findAll(pageable);
	        return ReturnT.ok(serverPage);
	    }
	
	public ReturnT<Object> addDevPro(DevPro devPro){
		try {
			devPro = devProRepo.save(devPro);
			return ReturnT.ok(devPro);
		}catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
	
	public ReturnT<Object> deleteDevPro(int id){
		try {
			devProRepo.deleteById(id);
			return ReturnT.ok("删除成功");
		}catch (Exception e) {
			return ReturnT.error(e.getMessage());
		}
	}
	
	public ReturnT<Object> devProInfo(int id){
		try {
			List<ProCodeRepo> codeRepos = proCodeRepoRepo.findByDevProId(id);
			List<ProSoftware> softwares = proSoftwareRepo.findByDevProId(id);
			List<ProImage> images = proImageRepo.findByDevProId(id);
			List<ProRelease> releases = proReleaseRepo.findByDevProId(id);
			List<Object> devsteps = new ArrayList<Object>();
			
			Map<String,Object> proCodeRepos = new HashMap<String,Object>();
			Map<String,Object> proSoftwares = new HashMap<String,Object>();
			Map<String,Object> proImages = new HashMap<String,Object>();
			Map<String,Object> proReleases = new HashMap<String,Object>();
			proCodeRepos.put("name", "代码仓库");
			proCodeRepos.put("index", 0);
			proCodeRepos.put("items", codeRepos);
			devsteps.add(proCodeRepos);

			proSoftwares.put("name", "镜像包");
			proSoftwares.put("index", 1);
			proSoftwares.put("items", softwares);
			devsteps.add(proSoftwares);
			
			proImages.put("name", "软件包");
			proImages.put("index", 2);
			proImages.put("items", images);
			devsteps.add(proImages);
			
			proReleases.put("name", "运行环境");
			proReleases.put("index", 3);
			proReleases.put("items", releases);
			devsteps.add(proReleases);
			
			
			return ReturnT.ok(devsteps);
		}catch (Exception e) {
			e.printStackTrace();
			return ReturnT.error(e.getMessage());
		}
	}
	
}
