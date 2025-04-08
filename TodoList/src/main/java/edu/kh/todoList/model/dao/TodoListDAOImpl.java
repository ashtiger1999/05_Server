package edu.kh.todoList.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.todoList.common.JDBCTemplate.*;
import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {
	
	// JDBC 객체 잠조 변수 선언 + Properties 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop; //  sql.xml 파일에서 쿼리문을 읽어오기 위해 필요
	
	// ToodListDAOImpl 생성자 /xml/sql.xml 경로 읽어어기
	public TodoListDAOImpl() {
		// TodoListDAOImpl 객체가 생성될 때(Service 단에서 new 연산자를 통해 객체화 될 때)
		// sql.xml 파일의 내용을 읽어와 Properties prop 객체에서 K:V 세팅
		
		try {
			String filePath = TodoListDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			System.out.println("sql.xml 로드 중 예외 발생");
			e.printStackTrace();
		}
	}

	@Override
	public List<Todo> todoListFullView(Connection conn) throws Exception {
		// interface에서 implements를 받은 클래스가 상속받은 메서드에 예외를 던질때,
		// interface 객체도 동일한 방식의 예외 처리가 필요하다.

		// 결과 저장용 변수 선언
		List<Todo> todoList = new ArrayList<>();
		
		try {
			
			// SQL 작성
			String sql = prop.getProperty("todoListFullView");
			
			stmt = conn.createStatement();
			
			// executeQuery() - SELECT 수행 후 ResultSet 반환
			// excuteUpdate()
			// - DML(INSERT/UPDATE/UPDATE) 수행 후 결과 행의 갯수 반환
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				boolean complete = rs.getInt("todo_complete") == 1;
				
				Todo todo = Todo.builder()
						.todoNo(rs.getInt("todo_no"))
						.todoTitle(rs.getString("todo_title"))
						.todoComplete(complete)
						.regDate(rs.getString("reg_date"))
						.build();
				
				todoList.add(todo);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return todoList;
	}

	@Override
	public int getCompleteCount(Connection conn) throws Exception {

		// 결과 저장용 변수 선언
		int completeCount = 0;
		
		try {
			
			// SQL 작성
			String sql = prop.getProperty("getCompleteCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				completeCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
			
		return completeCount;
	}

	@Override
	public int todoAdd(Connection conn, String title, String detail) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("todoAdd");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, detail);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	@Override
	public Todo todoDetail(Connection conn, int todoNo) throws Exception {
		
		Todo todo = null;
		
		try {
			
			String sql = prop.getProperty("todoDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boolean complete = rs.getInt("todo_complete") == 1;
				
				todo = Todo.builder()
						.todoNo(todoNo)
						.todoTitle(rs.getString("todo_title"))
						.todoDetail(rs.getString("todo_detail"))
						.todoComplete(complete)
						.regDate(rs.getString("reg_date"))
						.build();
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return todo;
	}

	@Override
	public int todoComplete(Connection conn, int todoNo) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("todoComplete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
