package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDAO;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam5 {

	public static void main(String[] args) {

		// select 테스트 실행
		
		RoleDAO dao = new RoleDAO();
		
		List<Role> list = dao.getRoles();
		
		for(Role role : list){
			System.out.println(role);
		}
	}

}
