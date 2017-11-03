package xyz.lihang.housenet.service.impl;

import org.springframework.stereotype.Service;
import xyz.lihang.housenet.dao.DistrictDao;
import xyz.lihang.housenet.entity.DistrictEntity;
import xyz.lihang.housenet.service.AbsBaseService;
import xyz.lihang.housenet.service.IDistrictService;

import javax.annotation.Resource;

@Service
public class DistrictService extends AbsBaseService<DistrictEntity> implements IDistrictService {
    private DistrictDao districtDao;
    @Resource
    public void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
        setBaseDao(districtDao);
    }
}
