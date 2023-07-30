package com.organimaster.org.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "com.organimaster.org.default-user")
public class DefaultUser {
    private String email;
    private String password;
    private String managerEmail;
    private String managerPassword;
}
