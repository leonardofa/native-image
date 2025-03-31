package br.com.leonardo.estudos.springbootgraalvm;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExecutionTimeFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    long startTime = System.currentTimeMillis();
    chain.doFilter(request, response);
    long elapsedTime = System.currentTimeMillis() - startTime;
    String path = httpServletRequest.getRequestURI();
    System.out.printf("Request [%s] spent %s ms.", path, elapsedTime);
  }
}