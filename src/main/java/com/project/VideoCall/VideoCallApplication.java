package com.project.VideoCall;

import com.project.VideoCall.user.User;
import com.project.VideoCall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	) {
		return args -> {
            service.registerUser(User.builder()
					.username("Ali")
					.email("ali@example.com")
					.password("aaa")
					.build());

			service.registerUser(User.builder()
					.username("John")
					.email("john@example.com")
					.password("aaa")
					.build());

			service.registerUser(User.builder()
					.username("Anny")
					.email("anny@example.com")
					.password("aaa")
					.build());
        };
	}
}
