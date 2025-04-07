package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	// 필드
	private String title; // 제목
	private String author; // 작성자
	private int price; // 가격
	
	// 메서드
}
