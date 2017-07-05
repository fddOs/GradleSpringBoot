package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Controller
public class SampleController {
	private Logger logger = LoggerFactory.getLogger(SampleController.class);
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		logger.info("访问hello");
		//System.out.println(testDao.insert("url", "dsb"));
		return "Hello World!";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam String name,@RequestParam String sex) {
		return name+" "+sex;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(SampleController.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		//SpringApplication.run(SampleController.class, args);
	}
}