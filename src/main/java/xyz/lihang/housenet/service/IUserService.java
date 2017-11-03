package xyz.lihang.housenet.service;

import xyz.lihang.housenet.dao.BaseDao;
import xyz.lihang.housenet.entity.UsersEntity;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface IUserService extends BaseService<UsersEntity> {
    UsersEntity login(UsersEntity usersEntity);
}
