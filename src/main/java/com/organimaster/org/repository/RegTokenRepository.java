package com.organimaster.org.repository;

import com.organimaster.org.model.token.RegToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegTokenRepository extends JpaRepository<RegToken, Integer> {
    @Query(value = """
     select rt.regKey from RegToken rt
     JOIN User u ON rt.user_id = u.id
     WHERE u.email = :email_add AND u.role = 'ADMIN'
      """)
    String getTokenByEmail(String email_add);
}
