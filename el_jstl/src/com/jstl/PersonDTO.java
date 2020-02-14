package com.jstl;

import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class PersonDTO {
	private String name;
	private int age;
}
