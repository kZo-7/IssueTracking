package kzo.issuetracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kzo.issuetracking.model.IssueModel;
import kzo.issuetracking.model.UserModel;
import kzo.issuetracking.util.JDBCDataSource;

public class UserDao {

	public static long nextPk() {
		long pk = 0;
		Connection conn;
		String query = "Select Max(idUsers) from users";

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(query);
			// store data from our DB after query execution
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				pk = rs.getLong(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in : UserDao.nextPk()");
			e.printStackTrace();
		}
		return pk + 1;
	}

	public static long addUser(UserModel user) {
		int i = 0;
		Connection conn;
		String query = "Insert into users values (?, ?, ?, ?, ?, ?)";

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(query);

			prepStmt.setLong(1, nextPk());
			prepStmt.setString(2, user.getName());
			prepStmt.setString(3, user.getSurname());
			prepStmt.setString(4, user.getPosition());
			prepStmt.setString(5, user.getEmail());
			prepStmt.setString(6, user.getPsw());
			// storing our new user in our DB into "users" table
			i = prepStmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in : UserDao.addUser()");
			e.printStackTrace();
		}

		return i;
	}

	public static UserModel UserLogin(String login, String password) {
		UserModel user = null;
		Connection conn;
		String query = "Select * from users where usEmail=? and usPsw=?";

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, login);
			prepStmt.setString(2, password);
			// we store in rs the whole table row that matches
			ResultSet rs = prepStmt.executeQuery();

			if (rs.next()) {
				user = new UserModel();

				user.setId(rs.getLong("idUsers"));
				user.setName(rs.getString("usName"));
				user.setSurname(rs.getString("usSurname"));
				user.setPosition(rs.getString("usPosition"));
				user.setEmail(rs.getString("usEmail"));
				user.setPsw(rs.getString("usPsw"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in : UserDao.UserModel.UserLogin(login, password)");
			e.printStackTrace();
		}

		return user;
	}
	
	//get data from DB
			public static List userlist() {
				ArrayList list = new ArrayList();
				Connection conn = null;
				
				try {
					conn = JDBCDataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement("select * from users");
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						UserModel user = new UserModel();
						user.setId(rs.getLong("idUsers"));
						user.setName(rs.getString("usName"));
						user.setSurname(rs.getString("usSurname"));
						user.setPosition(rs.getString("usPosition"));
						user.setEmail(rs.getString("usEmail"));
						list.add(list);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error in : IssueDao.List list()");
					e.printStackTrace();
				} finally {
					JDBCDataSource.closeConnection(conn);
				}
				return list;
			}

}