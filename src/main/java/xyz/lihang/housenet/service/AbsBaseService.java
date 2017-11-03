package xyz.lihang.housenet.service;

import xyz.lihang.housenet.dao.BaseDao;
import xyz.lihang.housenet.utils.GeneralQueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public abstract class AbsBaseService<T> implements BaseService<T> {
    private BaseDao<T> baseDao;

    @Override
    public void save(T t) {
        baseDao.save(t);
    }
    @Override
    public void delete(T t) {
        baseDao.delete(t);

    }
    @Override
    public void update(T t) {
        baseDao.update(t);
    }
    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }

    @Override
    public T findById (Serializable id) {
        return baseDao.findById(id);
    }
    @Override
    public void execute(String hql) {
        baseDao.execute(hql);
    }

    @Override
    public List<T> findByCondition(String hql) {
        return baseDao.findByCondition(hql);
    }

    @Override
    public int getAllCount() {
        return baseDao.getAllCount();
    }

    @Override
    public int getConditionCount(String hql) {
        return baseDao.getConditionCount(hql);
    }

    @Override
    public GeneralQueryHelper<T> getByQueryHelper(GeneralQueryHelper<T> generalQueryHelper) {
        return baseDao.getByQueryHelper(generalQueryHelper);
    }

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

}
