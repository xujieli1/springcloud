/*
 * Copyright 2017 bianxianmao.com All right reserved. This software is the confidential and proprietary information of
 * bianxianmao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with bianxianmao.com.
 */
package com.jerry.eurekarabhychild.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author:jieli.xu
 * @Created: 2019/3/5
 * @Modifier:jieli.xu
 * @Updated:2019/3/5
 * @Description:
 * @Version:BUILD1001
 */
@Component
public class MyFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        /**
         * 4种不同生命周期的类型
         * pre：路由之前
         *  routing：路由之时
         *  post： 路由之后
         *  error：发送错误调用
         */
        return "pre";
    }
    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        /**
         * 过滤的顺序
         */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
         */
        if (true){
            logger.error("shouldFilter>>>>>>true");
        }else{
            logger.error("shouldFilter>>>>>>false");
        }
        return true;
    }
    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        /**
         * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
         */
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        logger.info(String.format("%s >>>>>>> %s",httpServletRequest.getMethod(),httpServletRequest.getRequestURL().toString()));
        Object accessToken = httpServletRequest.getParameter("token");
        if(null == accessToken){
            logger.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);

            try {
                requestContext.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return new String("token is pass");
    }
}
