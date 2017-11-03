package xyz.lihang.housenet.utils;

import java.util.List;


/**
 * Json约定
 * @author LiHang
 */
public class RenderJson {
	private String status ;
	private String message;
	private List list;
	private Object obj;
	private boolean renderJsonFlag = true;


	public String getStatus() {
		return status;
	}

	public RenderJson setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public RenderJson setMessage(String message) {
		this.message = message;
		return this;
	}

	public List getList() {
		return list;
	}

	public RenderJson setList(List list) {
		this.list = list;
		return this;
	}

	public Object getObj() {
		return obj;
	}

	public RenderJson setObj(Object obj) {
		this.obj = obj;
		return this;
	}

	public boolean isRenderJsonFlag() {
		return renderJsonFlag;
	}

	public void setRenderJsonFlag(boolean renderJsonFlag) {
		this.renderJsonFlag = renderJsonFlag;
	}

	public RenderJson SUCCESS(){
		this.status = "success";
		return this;
	}
	
	public RenderJson ERROR(){
		this.status = "error";
		return this;
	}
	
	public RenderJson defaultSuccessMessage(){
		this.message = "成功";
		return this;
	}
	
	public RenderJson defaultErrorMessage(){
		this.message = "出现未知错误,请检查请求参数";
		return this;
	}
	
	public static  RenderJson Instance (){
		return new RenderJson();
	}

	public static RenderJson defaultSuccess(){
		return new RenderJson().SUCCESS().defaultSuccessMessage();
	}

}
