package com.springstudy.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springstudy.biz.common.JDBCUtil;
import com.springstudy.biz.user.UserDAO;
import com.springstudy.biz.user.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// SQL 명령어들
	private final String USER_GET = "SELECT * FROM users WHERE id=? AND password=?";

	// 회원 존재 여부
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		UserVO user = null;

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
			;
		}

		return user;
	}

}
