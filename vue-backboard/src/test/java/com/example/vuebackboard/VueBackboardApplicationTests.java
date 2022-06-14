package com.example.vuebackboard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.vuebackboard.entity.BoardEntity;
import com.example.vuebackboard.entity.BoardRepository;
import com.example.vuebackboard.service.BoardService;
import com.example.vuebackboard.web.dtos.BoardDto;

@SpringBootTest
class VueBackboardApplicationTests {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardService boardService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void createImportSql2() {
		// String sql = "INSERT INTO BOARD (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (1, '게시글 제목1', '게시글 내용1', '작성자1', '2022-02-18 23:24:00');";
		
		List<BoardEntity> eList = new ArrayList<>();
		
	    for (int i = 1; i <= 100; i++) {
	    	
	        String sql2 = "게시글 제목" + i;
	        String sql3 = "게시글 내용1432134" + i;
	        String sql4 = "작성자" + i;
	        
	    	BoardEntity entity = BoardEntity.builder()
	    			.title(sql2)
	    			.contents(sql3)
	    			.author(sql4)
	    			.createdAt(LocalDateTime.now())
	    			.build();
	    	System.out.println(entity);
	    	eList.add(entity);
	    	boardRepository.save(entity);
	    	
	    }
	}
	
//	@Test
//	public void boardInsert1() {
//		BoardDto dto = BoardDto.builder()
//				.author("12341234")
//				.contents("12341234")
//				.title("123412341")
//				.build();
//		
//		System.out.println(dto);
//		
//		boardService.create(dto);
//	}
//	
	
	
	
}
