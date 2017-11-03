package xyz.lihang.housenet.service.impl;

import org.springframework.stereotype.Service;
import xyz.lihang.housenet.dao.TypeDao;
import xyz.lihang.housenet.entity.TypeEntity;
import xyz.lihang.housenet.service.AbsBaseService;
import xyz.lihang.housenet.service.ITypeService;

import javax.annotation.Resource;

@Service
public class TypeService extends AbsBaseService<TypeEntity> implements ITypeService {
    private TypeDao typeDao;

    @Resource
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
        setBaseDao(typeDao);
    }
}
