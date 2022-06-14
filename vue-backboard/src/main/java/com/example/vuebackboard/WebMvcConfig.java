package com.example.vuebackboard;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	public void addArgumentReslvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		SortHandlerMethodArgumentResolver sortArgumuntResolver = new SortHandlerMethodArgumentResolver();
		sortArgumuntResolver.setSortParameter("sortBy");
		sortArgumuntResolver.setPropertyDelimiter("-");
		
		PageableHandlerMethodArgumentResolver pageableArgumentResolver = new PageableHandlerMethodArgumentResolver(sortArgumuntResolver);
		pageableArgumentResolver.setOneIndexedParameters(true);
		pageableArgumentResolver.setMaxPageSize(500);
		pageableArgumentResolver.setFallbackPageable(PageRequest.of(0, 10));
		argumentResolvers.add(pageableArgumentResolver); 
	}
}
