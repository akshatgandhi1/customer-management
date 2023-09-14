package com.dto;

import java.time.LocalDate;

import com.customeValidation.PastDate;

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
public class DetailsDto {
	
    @Pattern(regexp = "^(M|F)$", message = "Sex must be 'M' or 'F'")
	private String sex;
   
    @PastDate
	private LocalDate dob;
	
	//here native is key word so used nativ
	@NotNull(message = "nativ can't be empty")
    private String nativ;

}
