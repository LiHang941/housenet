package xyz.lihang.housenet.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Namespace("/")
@ParentPackage("default")
@Scope("prototype")
@Controller
public class ErrorAction extends ActionSupport {

    /**
     * error页面
     * @return
     */
    @Action(value="error",results={
            @Result(name="success", location="/WEB-INF/jsp/error/404.jsp")
    })
    public String index (){
        return SUCCESS;
    }
}
