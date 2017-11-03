package xyz.lihang.housenet.service.impl;

import org.springframework.stereotype.Service;
import xyz.lihang.housenet.dao.UsersDao;
import xyz.lihang.housenet.entity.UsersEntity;
import xyz.lihang.housenet.service.AbsBaseService;
import xyz.lihang.housenet.service.IUserService;
import xyz.lihang.housenet.utils.MyException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class UserService extends AbsBaseService<UsersEntity> implements IUserService {

    private UsersDao usersDao;

    @Resource
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
        setBaseDao(usersDao);
    }

    @Override
    public void save(UsersEntity usersEntity) {
        if(usersEntity == null)
            usersEntity = new UsersEntity();
        usersEntity.setIsadmin("3");
        usersEntity.setName("hello");
        super.save(usersEntity);
    }

    @Override
    public UsersEntity login(UsersEntity user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new MyException("登陆信息错误");
        }else{
            List<UsersEntity> userList = usersDao.getAll();
            for (UsersEntity usersEntity : userList){
                if(user.getUsername().equals(usersEntity.getUsername()) && user.getPassword().equals(usersEntity.getPassword())){
                    return usersEntity;
                }
            }
        }
        throw new MyException("登陆信息错误");
    }
}
