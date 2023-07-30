package com.organimaster.org.model.token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegToken {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String regKey;

    @Column(unique = true)
    public int user_id;
}
