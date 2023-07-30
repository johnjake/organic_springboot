package com.organimaster.org;

import com.organimaster.org.component.DefaultUser;
import com.organimaster.org.playload.request.RegTokenRequest;
import com.organimaster.org.playload.request.RegisterRequest;
import com.organimaster.org.services.AuthenticationService;
import com.organimaster.org.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import static com.organimaster.org.model.user.Role.ADMIN;

@SpringBootApplication
public class OrganiMasterGroupApplication {
	@Autowired
	private DefaultUser defaultUser;
	public static void main(String[] args) {
		SpringApplication.run(OrganiMasterGroupApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service,
			RegistrationService regService
	) {
		return args -> {
			var responseAdmin = service.userExistsByEmail(defaultUser.getEmail());
			var responseManager = service.userExistsByEmail(defaultUser.getManagerEmail());

			if (responseAdmin > 0) {
				System.out.println("ADMIN: " + defaultUser.getEmail());
			} else {
				var admin = RegisterRequest.builder()
						.firstname("John")
						.lastname("Doe")
						.email(defaultUser.getEmail())
						.password(defaultUser.getPassword())
						.role(ADMIN)
						.build();
				var token = service.register(admin).getAccessToken();
				var tokenized = RegTokenRequest.builder()
								.token(token)
								.userId(1)
						.build();
				var resultToken = regService.registerToken(tokenized).getSuccess();
				System.out.println("RESULT TOKEN: " + resultToken);
				System.out.println("ADMIN TOKEN: " + token);
			}

			if (responseManager == 0) {
				var admin = RegisterRequest.builder()
						.firstname("William")
						.lastname("Smith")
						.email(defaultUser.getManagerEmail())
						.password(defaultUser.getManagerPassword())
						.role(ADMIN)
						.build();
				System.out.println("MANAGER TOKEN: " + service.register(admin).getAccessToken());

			} else {
				System.out.println("MANAGER: " + defaultUser.getManagerEmail());
			}
		};
	}
}
