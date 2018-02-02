package com.wgg.essay;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.web.servlet.config.annotation.InterceptorRegistry;import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;import com.wgg.essay.config.TokenInterceptor;@SpringBootApplicationpublic class EssayApplication extends WebMvcConfigurerAdapter{	public static void main(String[] args) {		SpringApplication.run(EssayApplication.class, args);	}		/**	 * 配置拦截器	 */	public void addInterceptors(InterceptorRegistry registry) {        registry.addInterceptor(new TokenInterceptor())        .addPathPatterns("/**")        .excludePathPatterns("/**/login");    }	}