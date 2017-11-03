package xyz.lihang.housenet.service.impl;

import org.springframework.stereotype.Service;
import xyz.lihang.housenet.dao.StreetDao;
import xyz.lihang.housenet.entity.DistrictEntity;
import xyz.lihang.housenet.entity.StreetEntity;
import xyz.lihang.housenet.service.AbsBaseService;
import xyz.lihang.housenet.service.IStreetService;
import xyz.lihang.housenet.utils.MyException;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class StreetService extends AbsBaseService<StreetEntity> implements IStreetService {
    private StreetDao streetDao;

    @Resource
    public void setStreetDao(StreetDao streetDao) {
        this.streetDao = streetDao;
        setBaseDao(streetDao);
    }

    @Override
    public List<StreetEntity> getListByDistrictId(Integer id) {
        if(id == null)
            throw new MyException("参数错误");
        List<StreetEntity> streetList = streetDao.findByCondition(" from StreetEntity se where district_id = ? ", id);
        return streetList ;
    }

}
