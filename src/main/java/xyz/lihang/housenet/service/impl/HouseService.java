package xyz.lihang.housenet.service.impl;

import org.springframework.stereotype.Service;
import xyz.lihang.housenet.dao.HouseDao;
import xyz.lihang.housenet.dao.StreetDao;
import xyz.lihang.housenet.dao.TypeDao;
import xyz.lihang.housenet.dao.UsersDao;
import xyz.lihang.housenet.entity.HouseEntity;
import xyz.lihang.housenet.service.AbsBaseService;
import xyz.lihang.housenet.service.IHouseService;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class HouseService extends AbsBaseService<HouseEntity> implements IHouseService {

    private HouseDao houseDao;

    @Resource
    public void setHouseDao(HouseDao houseDao) {
        this.houseDao = houseDao;
        setBaseDao(houseDao);
    }

    @Override
    public void save(HouseEntity houseEntity) {
        houseEntity.setPubdate(new Date());
        super.save(houseEntity);
    }

    @Override
    public List<HouseEntity> loadData (List<HouseEntity> houseEntityList){
        for(int i=0;i<houseEntityList.size();i++){
            HouseEntity houseEntity = houseEntityList.get(i);
            loadData(houseEntity);
        }
        return  houseEntityList;
    }

    @Override
    public HouseEntity loadData(HouseEntity houseEntity) {
        houseEntity.getUsersByUserId();
        houseEntity.getStreetByStreetId().getDistrictByDistrictId();
        houseEntity.getTypeByTypeId();
        return houseEntity;
    }
}
