package xyz.lihang.housenet.action;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import xyz.lihang.housenet.entity.HouseEntity;
import xyz.lihang.housenet.entity.TypeEntity;
import xyz.lihang.housenet.entity.UsersEntity;
import xyz.lihang.housenet.service.IHouseService;
import xyz.lihang.housenet.service.ITypeService;
import xyz.lihang.housenet.service.IUserService;
import xyz.lihang.housenet.Constant;
import xyz.lihang.housenet.utils.GeneralQueryHelper;
import xyz.lihang.housenet.utils.MyException;
import xyz.lihang.housenet.utils.Range;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/11/1.
 */
@Namespace("/")
@ParentPackage("default")
@Scope("prototype")
@Controller
public class IndexAction extends BaseAction {
    @Resource
    private IUserService userService;
    @Resource
    private ITypeService typeService;
    @Resource
    private IHouseService houseService;


    private UsersEntity user;
    private Range range;
    private String msg;
    private HouseEntity house;

    @Action(value="index",results={
            @Result(name="success", location="/WEB-INF/jsp/page/index.jsp")
    })
    @Override
    public String execute() throws Exception {
        GeneralQueryHelper<HouseEntity> generalQueryHelper = new GeneralQueryHelper<HouseEntity>(
                HouseEntity.class, "houseEntity");
        generalQueryHelper.setPageProperty(page.getP(),Constant.INDEX_LIST_LENGTH);
        if(StringUtils.isNotBlank(keywords)){
            generalQueryHelper.addAndCondition("houseEntity.title like ?","%" + keywords + "%");
        }
        if(range!=null){
            if(null != range.getStartFloorage()){
                    generalQueryHelper.addAndCondition("houseEntity.floorage >= ?",range.getStartFloorage());
            }
            if(null !=range.getEndFloorage()){
                    generalQueryHelper.addAndCondition("houseEntity.floorage <= ?",range.getEndFloorage());
            }

            if(null != range.getStartPrice()){
                generalQueryHelper.addAndCondition("houseEntity.price >= ?",range.getStartPrice());
            }
            if(null !=range.getEndPrice()){
                generalQueryHelper.addAndCondition("houseEntity.price <= ?",range.getEndPrice());
            }

            if(range.getTypeId()!= null){
                generalQueryHelper.addAndCondition("houseEntity.typeId = ?",range.getTypeId());
            }
        }
        generalQueryHelper.addOrderByProperty("houseEntity.id ",GeneralQueryHelper.ORDER_BY_DESC);
        GeneralQueryHelper<HouseEntity> queryHelper = houseService.getByQueryHelper(generalQueryHelper);
        page = generalQueryHelper.getPage();
        HttpServletRequest request = getRequest();
        List<TypeEntity> typeList = typeService.getAll();
        List<HouseEntity> houseList = houseService.loadData(queryHelper.getList());
        request.setAttribute("typeList",typeList);
        request.setAttribute("houseList",houseList);
        List<Integer> pageList = new ArrayList<>();
        for(int i=1;i<=page.getTotalPage();i++){
            pageList.add(i);
        }
        request.setAttribute("pageList",pageList);

        return SUCCESS;
    }

    @Action(value="showUI",results={
            @Result(name="success", location="/WEB-INF/jsp/page/show.jsp")
    })
    public String showUI (){
        house = houseService.loadData(houseService.findById(house.getId()));
        return SUCCESS;
    }


    /**
     * 登陆界面
     * @return
     */
    @Action(value="loginUI",results={
            @Result(name="success", location="/WEB-INF/jsp/page/login.jsp")
    })
    public String loginUI (){
        return SUCCESS;
    }
    /**
     * 登陆
     */
    @Action(value="login",results={
            @Result(name="error", location="/WEB-INF/jsp/page/login.jsp"),
            @Result(name="success", type = "redirect" ,location = "/admin/managerUI.do")
    })
    public String login (){
        try {
            UsersEntity login = userService.login(user);
            getSession().setAttribute(Constant.USER_TOKEN,login);
            return SUCCESS;
        }catch (MyException e){
            logger.info(e.getErrorMsg());
            msg = "信息错误,请重新登陆填写内容";
            return ERROR;
        }
    }

    /**
     * 退出
     * @return
     */
    @Action(value="layout",results={
            @Result(name="success", type = "redirect" ,location = "/loginUI.do")
    })
    public String layout(){
        getSession().invalidate();
        return SUCCESS;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
