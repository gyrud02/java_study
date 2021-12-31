package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDAO {
	
	// DB 연결할 정보
	private static String dbUrl = "jdbc:mysql://localhost:3306/jspbeginner";
	private static String dbId = "jspid";
	private static String dbPw = "jsppass";

	// 정보를 담아낼 객체
	public Role getRole(int roleId){
		Role role = null;;
		
		// 연결할 DB 객체
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 예외 처리
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver"); 
			
			// 커넥션 객체 얻어옴
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw); 
			
			// sql문 작성
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			
			// 실행 요청문
			rs = ps.executeQuery();
			
			if(rs.next()){
				int id = rs.getInt("role_id");
				String description = rs.getString(2);
				
				role = new Role(id, description);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally { // DB 닫기
			if(rs != null){
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (ps != null){
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();	
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		} // try~ catch
		
		
		return role;
	} // getRole()
	
	// insert DAO
	public int addRole(Role role){
		
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "INSERT INTO role(role_id, description) VALUES(?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			// 실행 결과를 변수에 담는다.
			insertCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally { // DB 닫기
			if (ps != null){
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();	
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return insertCount;
	} // addRole()
	
	// update
	public int updateRole(Role role){

		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "UPDATE role SET description = ? WHERE role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());

			updateCount = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null){
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return updateCount;
	}
	
	
	// delete
	public int deleteRole(Role role){
	
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "DELETE FROM role WHERE role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role.getRoleId());
			
			deleteCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(ps != null){
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return deleteCount;
	}
	
	// select
	public List<Role> getRoles(){
		
		List<Role> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role ORDER BY role_id DESC";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw)){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			try(ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()){
					String description = rs.getString(1);
					int id = rs.getInt(2);
					Role role = new Role(id, description);
					list.add(role); // list에 반복할 때마다 Role 인스턴스를 생성하여 list에 추가한다.
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
	
}
