package com.dto;

import java.util.List;

import com.entity.Details;

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
public class CustomerDto {

	private Integer customerid;
	@NotNull(message = "Name should not be empty")
	private String name;
	@NotNull
	private DetailsDto detail;
	@NotNull(message = "Empty Account type")
	private String accountType;
	@NotNull(message = "Atleast enter any one requirment")
	private List<String> businessRequirements;
	@NotNull(message = "contrant type is null")
    @Pattern(regexp = "^(fulltime|parttime)$", message = "Contract type must be 'fulltime' or 'parttime'")
	private String contractType;
}
