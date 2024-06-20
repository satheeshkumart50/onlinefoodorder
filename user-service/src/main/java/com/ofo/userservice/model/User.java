package com.ofo.userservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id","firstName","lastName","speciality","dob","mobile","emailId","createdDate"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false,name="id")
	private Long id;

	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(name="first_name")
	private String firstName;

	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(name="last_name")
	private String lastName;

	@Column(name="dob")
	@NotNull(message = "dob is required")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date dob;

	@NotBlank
	@Pattern(regexp = "^\\d{10,10}$")
	@Column(unique = true, length = 10, name="mobile")
	private String mobile;

	@NotEmpty
	@Email(flags = { Flag.CASE_INSENSITIVE })
	@Column(name="email_id")
	private String emailId;

/*	@Column
	@NotEmpty
	@Temporal(TemporalType.DATE)
	private Date createdDate; */
}