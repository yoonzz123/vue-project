package com.example.vuebackboard.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.vuebackboard.entity.BoardEntity;
import com.example.vuebackboard.entity.BoardRepository;
import com.example.vuebackboard.model.Header;
import com.example.vuebackboard.model.Pagination;
import com.example.vuebackboard.web.dtos.BoardDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public Header<List<BoardDto>> getBoardList(Pageable pageable){
		List<BoardDto> dtos = new ArrayList<>();
		
		Page<BoardEntity> boardEntities = boardRepository.findAllByOrderByIdxDesc(pageable);
		
		for (BoardEntity entity : boardEntities) {
			BoardDto dto = BoardDto.builder()
					.idx(entity.getIdx())
					.author(entity.getAuthor())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
			
			dtos.add(dto);
		}
		
		Pagination pagination = new Pagination(
				(int) boardEntities.getTotalElements()
				, pageable.getPageNumber() + 1
				, pageable.getPageSize()
				, 10
				);
		return Header.OK(dtos, pagination);
	}
	
	// 게시글 가져오기
	public BoardDto getBoard(Long id) {
		BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		return BoardDto.builder()
				.idx(entity.getIdx())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .author(entity.getAuthor())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
	}		
	
	// 게시글 등록
	public BoardEntity create(BoardDto boardDto) {
		BoardEntity entity = BoardEntity.builder()
				.title(boardDto.getTitle())
				.contents(boardDto.getContents())
				.author(boardDto.getAuthor())
				.createdAt(LocalDateTime.now())
				.build();
		
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		System.out.println(entity.getIdx());
		return boardRepository.save(entity);
	}
	
	// 게시글 수정
	public BoardEntity update(BoardDto boardDto) {
		
		BoardEntity entity = boardRepository.findById(
				boardDto.getIdx()).orElseThrow(() -> 
					new RuntimeException("게시글을 찾을 수 없습니다."));
		entity.setTitle(boardDto.getTitle());
		entity.setContents(boardDto.getContents());
		return boardRepository.save(entity);
	}
	
	// 게시글 삭제
	public void delete(Long id) {
		BoardEntity entity = boardRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		boardRepository.delete(entity);
	}
	
}
