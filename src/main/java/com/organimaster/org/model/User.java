package com.organimaster.org.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.organimaster.org.model.bases.DateAudit;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User extends DateAudit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "first_name")
	@Size(max = 50)
	private String firstName;

	@NotBlank
	@Column(name = "last_name")
	@Size(max = 50)
	private String lastName;

	@NotBlank
	@Column(name = "username")
	@Size(max = 50)
	private String username;

	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Size(max = 100)
	@Column(name = "password")
	private String password;

	@NotBlank
	@NaturalId
	@Size(max = 100)
	@Column(name = "email")
	@Email
	private String email;

	@NotBlank
	@NaturalId
	@Column(name = "created_at")
	@Timestamp
	private Instant createdAt;

	@NotBlank
	@NaturalId
	@Column(name = "updated_at")
	@Timestamp
	private Instant updatedAt;

	public User(String firstName, String lastName, String username, String password, String email, Instant createdAt, Instant updatedAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
}
