package xyz.lihang.housenet.service;

import xyz.lihang.housenet.entity.StreetEntity;

import java.util.List;

public interface IStreetService extends BaseService<StreetEntity> {
    List<StreetEntity> getListByDistrictId(Integer id);
}
