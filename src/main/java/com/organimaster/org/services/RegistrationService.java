package com.organimaster.org.services;

import com.organimaster.org.model.token.RegToken;
import com.organimaster.org.playload.request.AccessTokenRequest;
import com.organimaster.org.playload.request.RegTokenRequest;
import com.organimaster.org.playload.response.AccessTokenResponse;
import com.organimaster.org.playload.response.TokenValidationResponse;
import com.organimaster.org.repository.RegTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegTokenRepository repository;

    public RegistrationService(RegTokenRepository repository) {
        this.repository = repository;
    }

    public TokenValidationResponse registerToken(RegTokenRequest param) {
        var tokenized = RegToken.builder()
                .regKey(param.getToken())
                .user_id(param.getUserId())
                .build();
        var response = repository.save(tokenized);
        return TokenValidationResponse
                .builder()
                .success(response.getRegKey())
                .build();
    }

    public AccessTokenResponse getTokenRegister(AccessTokenRequest request) {
        var tokenized = repository.getTokenByEmail(request.getEmail());
        return AccessTokenResponse.builder().accessToken(tokenized).build();
    }

}
