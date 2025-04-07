package edu.kh.todoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
	
	private int todoNO;				// todo 번호
	private String todoTitle;		// todo 제목
	private String todoDetail;		// todo 상세내용
	private boolean todoComplete;	// todo 완료 여부
	private String regDate;			// todo 등록일

}
