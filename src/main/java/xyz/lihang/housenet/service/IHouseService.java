package xyz.lihang.housenet.service;

import xyz.lihang.housenet.entity.HouseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface IHouseService extends BaseService<HouseEntity> {
    List<HouseEntity> loadData (List<HouseEntity> houseEntityList);

    HouseEntity loadData (HouseEntity houseEntity);
}
