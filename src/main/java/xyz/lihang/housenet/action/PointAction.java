package xyz.lihang.housenet.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import xyz.lihang.housenet.aop.JSONInvok;
import xyz.lihang.housenet.entity.DistrictEntity;
import xyz.lihang.housenet.entity.HouseEntity;
import xyz.lihang.housenet.entity.StreetEntity;
import xyz.lihang.housenet.entity.TypeEntity;
import xyz.lihang.housenet.service.IDistrictService;
import xyz.lihang.housenet.service.IStreetService;
import xyz.lihang.housenet.service.ITypeService;
import xyz.lihang.housenet.service.IUserService;
import xyz.lihang.housenet.utils.Page;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Namespace("/admin/point")
@ParentPackage("default")
@Scope("prototype")
@Controller
public class PointAction extends BaseAction {

    private Integer districtId;

    @Resource
    private IDistrictService districtService;

    @Resource
    private IStreetService streetService;

    @Resource
    private ITypeService typeService;

    @JSONInvok
    @Action(value="districtList")
    public List<DistrictEntity> districtList (){
        return  districtService.getAll();
    }

    @JSONInvok
    @Action(value="streetByDistrictId")
    public List<StreetEntity> streetByDistrictId (){
        return  streetService.getListByDistrictId(districtId);
    }


    @JSONInvok
    @Action(value="typeList")
    public List<TypeEntity> typeList (){
        return typeService.getAll();
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
}
