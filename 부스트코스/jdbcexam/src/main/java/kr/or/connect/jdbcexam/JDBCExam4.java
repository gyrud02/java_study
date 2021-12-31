package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDAO;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam4 {

	public static void main(String[] args) {

		// delete 실행
		
		int roleId = 3;
		String description = "수정";

		Role role = new Role(roleId, description);
		RoleDAO dao = new RoleDAO();
		
		int deleteCount = dao.deleteRole(role);
		
		System.out.println(deleteCount);
		
	}

}
