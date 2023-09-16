package kzo.issuetracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kzo.issuetracking.model.IssueModel;
import kzo.issuetracking.util.JDBCDataSource;
import kzo.issuetracking.util.DataUtil;

public class IssueDao {
	
	public static long nextPk() {
		long pk = 0;
		Connection conn;
		String query = "Select Max(id) from issues";

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
			System.out.println("Error in : IssueDao.nextPk()");
			e.printStackTrace();
		}
		return pk + 1;
	}
	
	public static long addIssue(IssueModel issue) {
		int i = 0;
		Connection conn;
		String query = "Insert into issues values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(query);

			prepStmt.setLong(1, nextPk());
			prepStmt.setString(2, issue.getTitle());
			prepStmt.setString(3, issue.getDescription());
			prepStmt.setString(4, issue.getCategory());
			prepStmt.setInt(5, issue.getPriority());
			prepStmt.setString(6, issue.getAssignedTo());
			prepStmt.setTimestamp(7, DataUtil.getCurrentTimestamp());
			prepStmt.setInt(8, issue.getCreatedBy());
			prepStmt.setTimestamp(9, issue.getDateEdited());
			prepStmt.setString(10, issue.getEditedBy());
			prepStmt.setString(11, issue.getStatus());
			//prepStmt.setLong(12, issue.getUserID());
			// storing our new user in our DB into "users" table
			i = prepStmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in : IssueDao.addUser()");
			e.printStackTrace();
		}

		return i;
	}
	
	public static long deleteIssue (IssueModel issue) {
		int i = 0;
		
		return i;
	}
	
	public static long editIssue (IssueModel issue) {
		int i = 0;
		
		return i;
	}
	
		//get data from DB
		public static List list(String q) {
			ArrayList list = new ArrayList();
			Connection conn = null;
			
			try {
				conn = JDBCDataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(q);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					IssueModel issue = new IssueModel();
					issue.setId(rs.getLong("id"));
					issue.setTitle(rs.getString("title"));
					issue.setDescription(rs.getString("description"));
					issue.setCategory(rs.getString("category"));
					issue.setPriority(rs.getInt("priority"));
					issue.setAssignedTo(rs.getString("assignedTo"));
					issue.setDateCreated(rs.getTimestamp("dateCreated"));
					issue.setCreatedBy(rs.getInt("createdBy"));
					issue.setDateEdited(rs.getTimestamp("dateEdited"));
					issue.setEditedBy(rs.getString("editedBy"));
					issue.setStatus(rs.getString("status"));
					//issue.setUserID(rs.getLong("userID"));
					list.add(issue);
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
