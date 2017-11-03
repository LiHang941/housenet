package xyz.lihang.housenet.utils;

import com.alibaba.fastjson.JSON;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/11/2.
 *
 * 将指定对象转换成json 通过struts2 输出到客户端
 */
public class JsonWriterUtil {
    /**
     * 将JSON 字串  输出到用户
     * @param jsonObj  待输出的JSON
     */
    public static void writerJson (Object jsonObj){
        PrintWriter pw = null;
        try{
            String jsonStr = JSON.toJSONString(jsonObj,SimplePropertyFilter.getInstance());
            HttpServletResponse res = ServletActionContext.getResponse();
            SetContentType.setWriterTextType(res);
            pw = ServletActionContext.getResponse().getWriter();
            pw.write(jsonStr);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pw != null)
                pw.close();
        }
    }
}
