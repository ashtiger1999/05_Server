package edu.kh.todoList.model.service;

import java.util.Map;

// 유지보수성과 확장성, 테스트 용이성 때문
// -> Controller는 ServiceImpl을 직접 쓰지 않고, Service 인터페이스를 의존하므로,
//	  나중에 구현체가 바뀌어도 Controller는 영향을 받지 않음
// => 추후에 새로운 로직을 작성하여 ServiceImpl을 대체하고 싶을 떄,
//	  보다 수비게 교체가 가능하다
public interface TodoListService {

	/** 할 일 목록 반환 서비스
	 * @return TodoList + 완료된 개수 Map
	 */
	Map<String, Object> todoListFullView();
	
}
