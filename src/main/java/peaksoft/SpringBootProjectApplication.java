package peaksoft;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import peaksoft.model.User;
import peaksoft.service.UserService;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
//	@Bean
//	CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.saveAdmin(new User("uulkan", "uulkan@gmail.com", "2003"));
//		};
//   }

}
