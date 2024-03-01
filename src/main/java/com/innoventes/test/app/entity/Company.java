package com.innoventes.test.app.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name")
	@NotNull
	@Size(min = 5, message = "The name should be atleast 5 letters in length")
	private String companyName;

	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "strength")
	@Min(value = 0, message = "The value must be positive")
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;


	@Column(name = "company_code")
	@UniqueElements
	@Size(min = 5, message = "size should be minimum of 5 letters")
	@Pattern(regexp = "[a-zA-Z]{2}\\d{2}[EN]", message = "Enter a valid company code")
	private String companyCode;
}
