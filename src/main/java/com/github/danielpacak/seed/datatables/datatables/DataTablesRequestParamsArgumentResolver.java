package com.github.danielpacak.seed.datatables.datatables;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class DataTablesRequestParamsArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(final MethodParameter parameter) {
    return parameter.getParameterAnnotation(DataTablesRequestParams.class) != null;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    HttpServletRequest httpRequest = (HttpServletRequest) webRequest.getNativeRequest();
    DataTablesRequest tablesRequest = new DataTablesRequest();

    tablesRequest.setDraw(Integer.valueOf(httpRequest.getParameter("draw")));
    tablesRequest.setStart(Integer.valueOf(httpRequest.getParameter("start")));
    tablesRequest.setLength(Integer.valueOf(httpRequest.getParameter("length")));

    return tablesRequest;
  }

}
