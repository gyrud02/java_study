package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDAO;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) {
		// insert 실행 테스트

		int roleId = 3;
		String description = "CTO";
		
		Role role = new Role(roleId, description);
		RoleDAO dao = new RoleDAO();
		
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);
		
	}

}
