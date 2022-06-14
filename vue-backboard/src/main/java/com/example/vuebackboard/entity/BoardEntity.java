package com.example.vuebackboard.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="BOARD")
@Entity
public class BoardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	private String title;
	private String contents;
	private String author;
	private LocalDateTime createdAt;
}
