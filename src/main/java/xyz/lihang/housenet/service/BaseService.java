package xyz.lihang.housenet.service;

import xyz.lihang.housenet.utils.GeneralQueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface BaseService<T> {
    void save (T t);

    void delete(T t);

    void update(T t);

    List<T> getAll();

    T findById (Serializable id);

    void execute(String hql);

    List<T> findByCondition(String hql);

    int getAllCount();

    int getConditionCount(String hql);

    GeneralQueryHelper<T> getByQueryHelper(GeneralQueryHelper<T> generalQueryHelper);
}