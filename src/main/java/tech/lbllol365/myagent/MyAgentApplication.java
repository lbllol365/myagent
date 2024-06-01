package tech.lbllol365.myagent;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ForestScan(basePackages = "tech.lbllol365.myagent.client")
public class MyAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAgentApplication.class, args);
	}

}

