package com.example.vuebackboard.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vuebackboard.entity.BoardEntity;
import com.example.vuebackboard.service.BoardService;
import com.example.vuebackboard.web.dtos.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardController {
	
	private final BoardService boardService;
	
	
	@GetMapping("/board/list")
	public List<BoardDto> boardList(){
		System.out.println("asdfjlkasdjfljaskldfjlaksd");
		return boardService.getBoardList();}
	
	@GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }
	
	@PostMapping("/board")
	public BoardEntity create(@RequestBody BoardDto boardDto) {
		return boardService.create(boardDto);
	}
	
	@PatchMapping("/board")
	public BoardEntity update(@RequestBody BoardDto boardDto) {
		return boardService.update(boardDto);		
	}
	
	@DeleteMapping("/board/{id}")
	public void delte(@PathVariable Long id) {
		boardService.delete(id);
	}
}
