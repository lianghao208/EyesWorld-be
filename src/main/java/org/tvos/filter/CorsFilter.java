package org.tvos.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域请求过滤器
 */
public class CorsFilter extends OncePerRequestFilter {
    static final String ORIGIN = "Origin";
    private String originUrl=null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //System.out.println("aa "+request.getHeader(ORIGIN));
        //System.out.println(request.getMethod());
      /* if (request.getHeader(ORIGIN) == null ) {*/
            //System.out.println("okokoko111");
            String origin = request.getHeader(ORIGIN);
            response.setHeader("Access-Control-Allow-Origin", originUrl);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers",
                    request.getHeader("Access-Control-Request-Headers"));
            response.setHeader("Access-Control-Expose-Headers","Date,Set-Cookie,Access-Control-Allow-Headers");
      /*  }else {
            //System.out.println("okokoko2222");
            String origin = request.getHeader(ORIGIN);
            response.setHeader("Access-Control-Allow-Origin", originUrl);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers",
                    request.getHeader("Access-Control-Request-Headers"));
            response.setHeader("Access-Control-Expose-Headers","Date,Set-Cookie,Access-Control-Allow-Headers");

        }*/
        if (request.getMethod().equals("OPTIONS")) {
            try {
                originUrl = request.getHeader(ORIGIN);
                response.getWriter().print("OK");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

            filterChain.doFilter(request, response);

        }
    }
}