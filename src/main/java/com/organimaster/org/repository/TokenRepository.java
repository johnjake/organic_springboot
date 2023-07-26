package com.organimaster.org.repository;

import com.organimaster.org.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = "CALL sp_getTokensById(:userId)", nativeQuery = true)
    List<Token> findAllValidTokenByUser(@Param("userId") Long id);

    Optional<Token> findByToken(String token);
}
