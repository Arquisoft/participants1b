package asw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
      SpringApplication.run(Application.class, args);
      
	}
}
