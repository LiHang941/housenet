package xyz.lihang.housenet.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import xyz.lihang.housenet.utils.GeneralQueryHelper;
import xyz.lihang.housenet.utils.Page;
import xyz.lihang.housenet.utils.PageUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 *
 * dao操作基类
 */
public abstract class BaseDao<T> extends HibernateDaoSupport {
    //
    private String className;
    // 当前操作的实际的bean类型
    private Class<T> clazz;

    public BaseDao() {
        Type type = this.getClass().getGenericSuperclass();
        // 转换为参数化类型
        ParameterizedType pt = (ParameterizedType) type; // BaseDao<Employee>
        // 得到实际类型
        Type types[] = pt.getActualTypeArguments();
        // 获取实际类型
        clazz = (Class<T>) types[0];
        className = clazz.getSimpleName();// 例如：Employee
    }

    @Resource(name="sessionFactory")
    public void setBaseDaoSessionFactory(SessionFactory  sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    /**
     * 保存
     * @param t
     */
    public void save(T t) {
        currentSession().save(t);
    }

    /**
     * 更新
     * @param t
     */
    public void update(T t) {
        currentSession().update(t);
    }

    /**
     * 删除
     * @param t
     */
    public void delete(T t) {
        currentSession().delete(t);
    }

    /**
     * 用于执行无返回值的操作
     * delete update insert
     * @param hql
     */
    public void execute(String hql) {
        currentSession().createQuery(hql)
                .executeUpdate();
    }

    /**
     * 获取所有
     * @return List<T>
     */
    public List<T> getAll() {
        return currentSession()
                .createQuery("from " + className).list();
    }

    /**
     * 查询指定条件的hql
     * @param hql
     * @param parameter
     * @return
     */
    public List<T> findByCondition(String hql,Object ... parameter) {
        Query query = currentSession().createQuery(hql);
        for(int i=0 ;i<parameter.length;i++){
            query.setParameter(i, parameter[i]);
        }
        return query.list();
    }

    /**
     * 根据指定id查对象
     * @param id
     * @return
     */
    public T findById(Serializable id) {
        return (T) currentSession().get(clazz, id);
    }

    /**
     * 获取总记录数
     * @return
     */
    public int getAllCount() {
        return Integer.parseInt(currentSession()
                .createQuery("select count(*) from " + className)
                .uniqueResult().toString());
    }
    /**
     * 通过指定的条件获取记录数
     * @param hql
     * @return
     */
    public int getConditionCount(String hql,Object ... parameter) {
        Query query = currentSession().createQuery(hql);
        for(int i=0 ;i<parameter.length;i++){
            query.setParameter(i, parameter[i]);
        }
        return Integer.parseInt(query.uniqueResult().toString());
    }
    /**
     * 通过QueryHelper类获取内容
     * @param generalQueryHelper
     * @return
     */
    public GeneralQueryHelper<T> getByQueryHelper(
            GeneralQueryHelper<T> generalQueryHelper) {
        Query query = currentSession().createQuery(generalQueryHelper.getQueryListHql());
        List<Object> parameter = generalQueryHelper.getParameters();
        for(int i=0 ;i<parameter.size();i++){
            query.setParameter(i, parameter.get(i));
        }
        //判断是否分页
        if(generalQueryHelper.isPage()){
            Query pageQuery = currentSession().createQuery(generalQueryHelper.getQueryCountHql());
            List<Object> pageParameter = generalQueryHelper.getParameters();
            for(int i=0 ;i<pageParameter.size();i++){
                pageQuery.setParameter(i, pageParameter.get(i));
            }
            int totalCount = Integer.parseInt(pageQuery.uniqueResult().toString());  //记录数
            Page page = PageUtils.createPage(generalQueryHelper.getPageLenght(), totalCount, generalQueryHelper.getIndexPage());
            //分页的情况
            generalQueryHelper.setPage(page);
            query.setMaxResults(page.getEveryPage()).setFirstResult(page.getBeginIndex());
            generalQueryHelper.setList(query.list());
        }else{
            //不分页的情况
            generalQueryHelper.setList(query.list());
        }

        return generalQueryHelper;
    }


}
