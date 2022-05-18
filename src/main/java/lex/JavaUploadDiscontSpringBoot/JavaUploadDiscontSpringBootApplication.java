package lex.JavaUploadDiscontSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class JavaUploadDiscontSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaUploadDiscontSpringBootApplication.class, args);
	}

}
