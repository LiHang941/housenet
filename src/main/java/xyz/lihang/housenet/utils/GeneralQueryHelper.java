package xyz.lihang.housenet.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 * Hql查询帮助类
 *
 //===================用例=============================
 //设置from xxx
 GeneralQueryHelper<HouseEntity> generalQueryHelper = new GeneralQueryHelper<HouseEntity>(HouseEntity.class, "houseEntity");
 //设置分页
 generalQueryHelper.setPageProperty(page.getP(),Constant.MANAGER_LIST_LENGTH);
 //添加一个查询限定条件
 generalQueryHelper.addAndCondition("houseEntity.title like ?","%" + keywords + "%");
 //添加orderBy 语句
 generalQueryHelper.addOrderByProperty("houseEntity.pubdate ",GeneralQueryHelper.ORDER_BY_DESC);
 //查询
 GeneralQueryHelper<HouseEntity> queryHelper = houseService.getByQueryHelper(generalQueryHelper);
 *
 */
public class GeneralQueryHelper<T> {
    //查询返回的分页
    private Page page;
    //查询返回的集合
    private List<T> list;

    private int indexPage = 0;
    private int pageLenght  = 0;

    //from子句
    private String fromClause = "";
    //where子句
    private String whereClause = "";
    //order by子句
    private String orderByClause = "";

    //查询条件
    private List<Object> parameters;

    //排序顺序
    public static String ORDER_BY_DESC = "DESC";//降序
    public static String ORDER_BY_ASC = "ASC";//升序



    /**
     * 指定那个查询的那个对象
     * 自动生成FROM clazz.getSimpleName();
     * @param clazz 实体
     */
    public GeneralQueryHelper(Class clazz) {
        fromClause = "FROM " + clazz.getSimpleName();
    }
    /**
     * 指定那个查询的那个对象
     * 自动生成FROM clazz.getSimpleName()  alias
     * @param clazz 实体
     * @param alias 别名
     */
    public GeneralQueryHelper(Class clazz,String alias) {
        fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
    }
    /**
     * 添加一个AND条件的    HQL语句
     * @param condition 语句
     * @param params 参数
     */
    public void addAndCondition(String condition, Object... params){
        if (whereClause.length() > 1) {//非第一个查询条件
            whereClause += " AND " + condition;
        } else {//第一个查询条件
            whereClause += " WHERE " + condition;
        }

        //设置查询条件值到查询条件值集合中
        if(parameters == null){
            parameters = new ArrayList<Object>();
        }
        if(params != null){
            for(Object param: params){
                parameters.add(param);
            }
        }
    }
    /**
     * 添加一个OR
     * @param condition 条件
     * @param params
     */
    public void addOrCondition(String condition, Object... params){
        if (whereClause.length() > 1) {//非第一个查询条件
            whereClause += " OR " + condition;
        } else {//第一个查询条件
            whereClause += " WHERE " + condition;
        }

        //设置查询条件值到查询条件值集合中
        if(parameters == null){
            parameters = new ArrayList<Object>();
        }
        if(params != null){
            for(Object param: params){
                parameters.add(param);
            }
        }
    }
    /**
     * 构造order by子句
     * @param property 排序属性，如：i.createTime
     * @param order 排序顺序，如：DESC 或者 ASC
     */
    public void addOrderByProperty(String property, String order){
        if (orderByClause.length() > 1) {//非第一个排序属性
            orderByClause += "," + property + " " + order;
        } else {//第一个排序属性
            orderByClause = " ORDER BY " + property + " " + order;
        }
    }

    //查询hql语句
    /**
     * 获取查询List的hql语句
     * @return
     */
    public String getQueryListHql(){
        return fromClause + whereClause + orderByClause;
    }

    //查询统计数的hql语句
    /**
     * 获取统计查询的HQL语句
     * @return
     */
    public String getQueryCountHql(){
        return "SELECT COUNT(*) " + fromClause + whereClause;
    }

    /**
     * 获取 查询hql语句中?对应的查询条件值集合
     * @return
     */
    public List<Object> getParameters(){
        if(parameters == null)
            parameters = new ArrayList<Object>();
        return parameters;
    }
    /**
     * 获取分页对象
     * @return
     */
    public Page getPage() {
        return page;
    }
    /**
     * 设置分页对象
     * @param page
     */
    public void setPage(Page page) {
        this.page = page;
    }
    /**
     * 获取查询返回的内容
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置查询返回的内容
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }
    /**
     * 设置页面属性
     * @param indexPage 当前页码
     * @param pageLenght 页码长度
     */
    public void setPageProperty(int indexPage,int pageLenght){
        this.indexPage = indexPage;
        this.pageLenght = pageLenght;
    }
    /**
     * 判断是否分页
     * @return
     */
    public boolean isPage(){
        if(indexPage < 0 || pageLenght<=0){
            return false;
        }
        return true;
    }

    /**
     * 获取当前页码
     * @return
     */
    public int getIndexPage() {
        return indexPage;
    }

    /**
     * 获取页面长度
     * @return
     */
    public int getPageLenght() {
        return pageLenght;
    }
}