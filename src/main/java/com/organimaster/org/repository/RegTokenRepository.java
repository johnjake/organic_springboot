package com.organimaster.org.repository;

import com.organimaster.org.model.token.RegToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegTokenRepository extends JpaRepository<RegToken, Integer> {

}
