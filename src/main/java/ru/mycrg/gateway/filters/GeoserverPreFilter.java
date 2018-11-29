package ru.mycrg.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

public class GeoserverPreFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(GeoserverPreFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
//        return RequestContext
//                .getCurrentContext()
//                .getRequest()
//                .getServletPath()
//                .contains("geoserver");
    }

    @Override
    public Object run() {
        log.info("GeoserverPreFilter run");

//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        request.setAttribute("fizAttribute", "fizAttribute");

        return null;
    }
}
