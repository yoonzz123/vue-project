package com.example.vuebackboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.vuebackboard.entity.BoardEntity;
import com.example.vuebackboard.web.dtos.BoardDto;

@SpringBootApplication
public class VueBackboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueBackboardApplication.class, args);
		
		BoardDto b = new BoardDto();
		
		
		
	}

}
