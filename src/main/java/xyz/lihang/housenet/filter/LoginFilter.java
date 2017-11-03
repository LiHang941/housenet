package xyz.lihang.housenet.filter;

import xyz.lihang.housenet.Constant;
import xyz.lihang.housenet.entity.UsersEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpservletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpservletResponse = (HttpServletResponse) servletResponse;
        UsersEntity user = (UsersEntity) httpservletRequest.getSession().getAttribute(Constant.USER_TOKEN);
        if(user == null){
            String path = httpservletRequest.getContextPath();
            String basePath = servletRequest.getScheme()+"://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+path+"/";
            String url = basePath + "loginUI.do";
            httpservletResponse.sendRedirect(url);
        }
    }

    @Override
    public void destroy() {

    }
}
