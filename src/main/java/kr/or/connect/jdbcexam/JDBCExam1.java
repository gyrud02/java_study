package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDAO;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {

		// DB 연동 실행 테스트
		RoleDAO dao = new RoleDAO();
		Role role = dao.getRole(1);
		
		System.out.println(role);
	}

}
