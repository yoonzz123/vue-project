package com.example.vuebackboard.entity;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryCustom {
	private final JPAQueryFactory queryFactory;
	
	
//	public Page<BoardEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
//		JPAQuery<BoardEntity> query = queryFactory.selectFrom(boardEntity);
//		
//		
//		
//		
//	}

}
