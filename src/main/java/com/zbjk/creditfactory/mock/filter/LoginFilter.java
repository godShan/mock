package com.zbjk.creditfactory.mock.filter;

import com.google.gson.Gson;
import com.zbjk.creditfactory.mock.common.constant.ResponseCode;
import com.zbjk.creditfactory.mock.dto.MockDto;
import com.zbjk.creditfactory.mock.dto.PageModel;
import com.zbjk.creditfactory.mock.dto.ResponseVo;
import com.zbjk.creditfactory.mock.service.IMockService;
import com.zbjk.creditfactory.mock.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/3/13/013.
 * @author wys
 */
@Component
public class LoginFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

    @Autowired
    private IMockService iMockService;

    static {
        patterns.add(Pattern.compile(".*/mock/.*"));
        patterns.add(Pattern.compile(".*/plugins/.*"));
        patterns.add(Pattern.compile(".*/js/.*"));
        patterns.add(Pattern.compile(".*/favicon.ico"));
        patterns.add(Pattern.compile("/"));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("==>LoginFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求转换成HttpServletRequest 请求
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI().substring(req.getContextPath().length());

        if (isInclude(url)){
            filterChain.doFilter(req, resp);
            return;
        } else {
            MockDto mockDto = new MockDto();
            mockDto.setUrl(url);
            Gson gson = new Gson();
            PageModel<MockDto> pageModel = iMockService.selectMockByUrl(mockDto);
            if (pageModel.getDataList().size() < 1) {
                ResponseVo vo = ResponseUtil.buildVo(false, ResponseCode.CODE_ERROR.getCode(), ResponseCode.CODE_ERROR.getMsg(), "nihao");
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("application/json;charset=utf-8");
                resp.getWriter().write(gson.toJson(vo));
                return;
            }
            MockDto mockDto1 = pageModel.getDataList().get(0);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(mockDto1.getData());
            return;
        }
    }

    @Override
    public void destroy() {
        System.out.println("测试devhaha");
    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

}
