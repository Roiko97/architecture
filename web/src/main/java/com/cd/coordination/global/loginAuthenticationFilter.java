package com.cd.coordination.global;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/loginAuthenticationFilter")
public class loginAuthenticationFilter implements Filter {
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession(true);
        String student_id = (String) session.getAttribute("student_id");
        String path=request.getRequestURI();

        if(path.endsWith("on.jsp")|| path.endsWith("js") || path.endsWith("css")|| path.endsWith("gif")|| path.endsWith("jpg")){
            chain.doFilter(request, response);
            return;
        }
        if(path.indexOf("/on.jsp")>-1){//登录页面不过滤
            chain.doFilter(request, response);//递交给下一个过滤器
            return;
        }
        //if(path.indexOf("/register.jsp")>-1){//注册页面不过滤
        //	chain.doFilter(request, response);
        //    return;
        // }

        if(student_id!=null)
        {
            //代表已经登录成功。不进行拦截。
            chain.doFilter(request, response);
            return;
            //response.sendRedirect(request.getContextPath()+"/on.jsp");
        }else {
            response.sendRedirect("on.jsp");
            chain.doFilter(request, response);
            return;
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
