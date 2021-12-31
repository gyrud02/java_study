package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDAO;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam3 {

	public static void main(String[] args) {

		// update 테스트 실행
		
		int roleId = 3;
		String description = "수정";
		
		Role role = new Role(roleId, description);
		RoleDAO dao = new RoleDAO();
		
		int updateCount = dao.updateRole(role);
		
		System.out.println(updateCount);
	}

}
