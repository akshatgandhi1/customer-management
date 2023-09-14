package com.entity;

import java.util.List;


import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerid;
	@NotNull(message = "Name should not be empty")
	private String name;
	@NotNull
	private Details detail;
	@NotNull(message = "Empty Account type")
	private String accountType;
	@NotNull(message = "Atleast enter any one requirment")
	private List<String> businessRequirements;
	@NotNull(message = "contrant type is null")
    @Pattern(regexp = "^(fulltime|parttime)$", message = "Contract type must be 'fulltime' or 'parttime'")
	private String contractType;
}
