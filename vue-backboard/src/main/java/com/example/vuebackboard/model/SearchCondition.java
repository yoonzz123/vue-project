package com.example.vuebackboard.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCondition {
	
	private String sk; //search key
	private String sv; // search value
	
}
