package xyz.lihang.housenet.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import xyz.lihang.housenet.utils.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * action基类
 * 封装部分方法
 */
public abstract class BaseAction extends ActionSupport {

    protected final Logger logger = Logger.getLogger(this.getClass().getName());
    /**
     * 当前页码
     */
    protected Page page = new Page();
    /**
     * 搜索
     */
    protected String keywords;

    /**
     * 获取session
     * @return HttpSession
     */
    public HttpSession getSession (){
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 获取request
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest (){
        return ServletActionContext.getRequest();
    }

    /**
     * HttpServletResponse
     * @return
     */
    public HttpServletResponse getResponse (){
        return  ServletActionContext.getResponse();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
