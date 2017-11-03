var isIE = !!document.all;
//Selector
function bindSelector()
{
	for(var i=0; i<arguments.length; i++) {
		document.getElementById(arguments[i]).onmouseover = function(){
			this.getElementsByTagName("ul")[0].style.display = "block";
		}
		document.getElementById(arguments[i]).onmouseout = function(){
			this.getElementsByTagName("ul")[0].style.display = "none";
		}
	}
}

function getStyle(el, name)
{
	return isIE ? el.currentStyle[name] : window.getComputedStyle(el, null)[name];
}

/**
 * 默认返回处理renderJson
 * @param obj
 */
function baseAjax(obj) {
    $.ajax({
    	type: "POST",
        url: obj.url,
        data: obj.data,
        dataType:'json',
        success: function (data) {
    		if(data.renderJsonFlag == true ){
    			alert(data.message);
				//renderJson处理
    			if(data.status == 'success'){
                    if(obj.success != null){
                        obj.success(data);
                    }
				}else{
                    if(obj.error != null ){
                        obj.error();
                    }
				}
			}else{
                if(obj.success != null){
                    obj.success(data);
                }else {
                    //..默认处理
                }
			}
        },
        error:function () {
			if(obj.error != null ){
				obj.error();
			} else {
				alert("请求失败")
			}
    	}
});
}