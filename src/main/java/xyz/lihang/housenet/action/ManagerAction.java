package xyz.lihang.housenet.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import xyz.lihang.housenet.Constant;
import xyz.lihang.housenet.aop.JSONInvok;
import xyz.lihang.housenet.entity.HouseEntity;
import xyz.lihang.housenet.entity.UsersEntity;
import xyz.lihang.housenet.service.IHouseService;
import xyz.lihang.housenet.service.IUserService;
import xyz.lihang.housenet.service.impl.HouseService;
import xyz.lihang.housenet.utils.GeneralQueryHelper;
import xyz.lihang.housenet.utils.Page;
import xyz.lihang.housenet.utils.RenderJson;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Namespace("/admin")
@ParentPackage("default")
@Scope("prototype")
@Controller
public class ManagerAction extends BaseAction {

    @Resource
    private IHouseService houseService;

    private HouseEntity house;

    private List<HouseEntity> houseList;


    @Action(value="addUI",results={
            @Result(name="success", location="/WEB-INF/jsp/house/add.jsp")
    })
    public String addUI (){
        return SUCCESS;
    }

    @Action(value="updateUI",results={
            @Result(name="success", location="/WEB-INF/jsp/house/update.jsp")
    })
    public String updateUI (){
        house = houseService.findById(house.getId());
        return SUCCESS;
    }

    @JSONInvok
    @Action(value="updateHouse")
    public RenderJson updateHouse(){
        house.setPubdate(new Date());
        houseService.update(house);
        return RenderJson.defaultSuccess();
    }


    @JSONInvok
    @Action(value="addHouse")
    public RenderJson addHouse(){
        UsersEntity users = (UsersEntity) getSession().getAttribute(Constant.USER_TOKEN);
        house.setUserId(users.getId());
        houseService.save(house);
        return RenderJson.defaultSuccess();
    }

    @JSONInvok
    @Action(value="deleteHouse")
    public RenderJson deleteHouse(){
        houseService.delete(house);
        return RenderJson.defaultSuccess();
    }


    @Action(value="mainUI",results={
            @Result(name="success", location="/WEB-INF/jsp/house/main.jsp")
    })
    public String mainUI (){
        return SUCCESS;
    }





    @Action(value="managerUI",results={
            @Result(name="success", location="/WEB-INF/jsp/house/manager.jsp")
    })
    public String managerUI (){
        GeneralQueryHelper<HouseEntity> generalQueryHelper = new GeneralQueryHelper<HouseEntity>(
                HouseEntity.class, "houseEntity");
        generalQueryHelper.setPageProperty(page.getP(),
                Constant.MANAGER_LIST_LENGTH);
        if(StringUtils.isNotBlank(keywords)){
            generalQueryHelper.addAndCondition("houseEntity.title like ?","%" + keywords + "%");
        }
        generalQueryHelper.addOrderByProperty("houseEntity.pubdate ",GeneralQueryHelper.ORDER_BY_DESC);
        generalQueryHelper.addOrderByProperty("houseEntity.id ",GeneralQueryHelper.ORDER_BY_DESC);
        GeneralQueryHelper<HouseEntity> queryHelper = houseService.getByQueryHelper(generalQueryHelper);
        houseList = houseService.loadData(queryHelper.getList());
        page = generalQueryHelper.getPage();
        HttpServletRequest request = getRequest();
        request.setAttribute("houseList",houseList);
        return SUCCESS;
    }

    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    public List<HouseEntity> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<HouseEntity> houseList) {
        this.houseList = houseList;
    }
}
