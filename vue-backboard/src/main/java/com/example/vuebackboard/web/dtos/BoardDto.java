package com.example.vuebackboard.web.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
	
	private Long idx;
	private String title;
	private String contents;
	private String author;
	private String createdAt;
}
