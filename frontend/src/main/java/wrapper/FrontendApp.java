package wrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableAutoConfiguration
@ComponentScan("wrapper,com.findsportmates.controller")
@EnableDiscoveryClient
@EnableFeignClients
@EnableWebMvc
public class FrontendApp implements WebMvcConfigurer{
	
	public static void main(String[] args) {
		SpringApplication.run(FrontendApp.class, args);
	}

	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean  
	public InternalResourceViewResolver viewResolver() {  
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
		resolver.setPrefix("/WEB-INF/views/");  
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;  
	}	
	
	@Bean
    public IEventServiceImpl eventService() {
        return new IEventServiceImplImpl();
    }
	
	@Bean
    public IUserServiceImpl userService() {
        return new IUserServiceImplImpl();
    }
}