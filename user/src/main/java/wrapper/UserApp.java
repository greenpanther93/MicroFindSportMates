package wrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.findsportmates.dao.UserDAO;
import com.findsportmates.dao.UserDAOImpl;

@Configuration
@EnableAutoConfiguration
@ComponentScan("wrapper,com.findsportmates.service,com.findsportmates.dao")
@EntityScan(basePackages = "com.findsportmates.model")
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
public class UserApp {
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(UserApp.class, args);
    }
    
    @Bean
	public UserDAO userDAO() {
		return new UserDAOImpl();
	}
}