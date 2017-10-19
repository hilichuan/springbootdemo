package b2c.example;

import b2c.example.dao.CityMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@MapperScan("b2c.example.dao")
@SpringBootApplication
public class SpringbootDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
