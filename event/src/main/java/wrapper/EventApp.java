package wrapper;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.findsportmates.dao.EventDAO;
import com.findsportmates.dao.EventDAOImpl;
import com.findsportmates.service.EventService;
import com.findsportmates.service.EventServiceImpl;

@Configuration
@EnableAutoConfiguration
@ComponentScan("wrapper,com.findsportmates.service,com.findsportmates.dao")
@EntityScan(basePackages = "com.findsportmates.model")
//@ImportResource("classpath:applicationContext.xml")
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
//@EnableWebMvc
public class EventApp  {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EventApp.class, args);
	}
	
	@Bean
	public EventDAO eventDAO() {
		return new EventDAOImpl();
	}

}