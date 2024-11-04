package com.pet_groomer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.model.EmpJDBCDAO;
import com.emp.model.EmpVO;

public class PetGroomerJDBCDAO implements PetGroomerDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia103_g3?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "EVA817";
	
	private static final String INSERT_STMT = 
			"INSERT INTO PET_GROOMER (PG_NAME,PG_AREA,SCH_DATE,SCH_TIME,PG_STATUS,PG_BIO,PG_PW,PG_EMAIL) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";	
	private static final String GET_ALL_STMT = 
			"SELECT * FROM PET_GROOMER ORDER BY PG_ID";
	private static final String GET_ONE_STMT = 
			"SELECT * FROM PET_GROOMER WHERE PG_ID = ?";
	private static final String DELETE = 
			"DELETE FROM PET_GROOMER WHERE PG_ID = ?";
	private static final String UPDATE = 
			"UPDATE PET_GROOMER SET PG_NAME=?,PG_AREA=?,SCH_DATE=?,SCH_TIME=?,PG_STATUS=?,PG_BIO=?,PG_PW=?,PG_EMAIL=?,TOTAL_STARS=?,RATING_TIMES=?,REPORT_TIMES=? WHERE PG_ID=?";

		
		
		@Override
		public void insert(PetGroomerVO petGroomerVO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setString(1, petGroomerVO.getPgName());
				pstmt.setString(2, petGroomerVO.getPgArea());
				pstmt.setString(3, petGroomerVO.getSchDate());
				pstmt.setString(4, petGroomerVO.getSchTime());
				pstmt.setString(5, petGroomerVO.getPgStatus());
				pstmt.setString(6, petGroomerVO.getPgBio());
				pstmt.setString(7, petGroomerVO.getPgPw());
				pstmt.setString(8, petGroomerVO.getPgEmail());
		

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}

		}
		
			
			
		@Override
		public PetGroomerVO findByPrimaryKey(Integer pgId) {
			PetGroomerVO petGroomerVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, pgId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
				
					petGroomerVO = new PetGroomerVO();
					petGroomerVO.setPgId(rs.getInt("PG_ID"));
					petGroomerVO.setPgName(rs.getString("PG_NAME"));
					petGroomerVO.setPgLicenses(rs.getBytes("PG_LICENSES"));
					petGroomerVO.setPgPic(rs.getBytes("PG_PIC"));
					petGroomerVO.setPgArea(rs.getString("PG_AREA"));
					petGroomerVO.setSchDate(rs.getString("SCH_DATE"));
					petGroomerVO.setSchTime(rs.getString("SCH_TIME"));					
					petGroomerVO.setPgStatus(rs.getString("PG_STATUS"));
					petGroomerVO.setPgBio(rs.getString("PG_BIO"));
					petGroomerVO.setPgPw(rs.getString("PG_PW"));
					petGroomerVO.setPgEmail(rs.getString("PG_EMAIL"));
					petGroomerVO.setTotalStars(rs.getInt("TOTAL_STARS"));
					petGroomerVO.setRatingTimes(rs.getInt("RATING_TIMES"));
					petGroomerVO.setReportTimes(rs.getInt("REPORT_TIMES"));
					
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return petGroomerVO;
		
		}
		
		
		
		@Override
		public List<PetGroomerVO> getAll() {
			List<PetGroomerVO> list = new ArrayList<PetGroomerVO>();
			PetGroomerVO petGroomerVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					petGroomerVO = new PetGroomerVO();
					petGroomerVO.setPgId(rs.getInt("PG_ID"));
					petGroomerVO.setPgName(rs.getString("PG_NAME"));
					petGroomerVO.setPgLicenses(rs.getBytes("PG_LICENSES"));
					petGroomerVO.setPgPic(rs.getBytes("PG_PIC"));
					petGroomerVO.setPgArea(rs.getString("PG_AREA"));
					petGroomerVO.setSchDate(rs.getString("SCH_DATE"));
					petGroomerVO.setSchTime(rs.getString("SCH_TIME"));					
					petGroomerVO.setPgStatus(rs.getString("PG_STATUS"));
					petGroomerVO.setPgBio(rs.getString("PG_BIO"));
					petGroomerVO.setPgPw(rs.getString("PG_PW"));
					petGroomerVO.setPgEmail(rs.getString("PG_EMAIL"));
					petGroomerVO.setTotalStars(rs.getInt("TOTAL_STARS"));
					petGroomerVO.setRatingTimes(rs.getInt("RATING_TIMES"));
					petGroomerVO.setReportTimes(rs.getInt("REPORT_TIMES"));
					list.add(petGroomerVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return list;
	
		}
		


		@Override
		public void update(PetGroomerVO petGroomerVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);
				
				pstmt.setString(1, petGroomerVO.getPgName());
				pstmt.setString(2, petGroomerVO.getPgArea());
				pstmt.setString(3, petGroomerVO.getSchDate());
				pstmt.setString(4, petGroomerVO.getSchTime());
				pstmt.setString(5, petGroomerVO.getPgStatus());
				pstmt.setString(6, petGroomerVO.getPgBio());
				pstmt.setString(7, petGroomerVO.getPgPw());
				pstmt.setString(8, petGroomerVO.getPgEmail());
				pstmt.setInt(9, petGroomerVO.getTotalStars());
				pstmt.setInt(10, petGroomerVO.getRatingTimes());
				pstmt.setInt(11, petGroomerVO.getReportTimes());
				pstmt.setInt(12, petGroomerVO.getPgId());

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}

			
		}



		@Override
		public void delete(Integer pgId) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, pgId);

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			
			
		}

		
		public static void main(String[] args) {

			PetGroomerJDBCDAO dao = new PetGroomerJDBCDAO();
			
			
			// 查詢
			PetGroomerVO petGroomerVO1 = dao.findByPrimaryKey(4002);
			System.out.print(petGroomerVO1.getPgId() + ",");
			System.out.print(petGroomerVO1.getPgName() + ",");
			System.out.print(petGroomerVO1.getPgLicenses() + ",");
			System.out.print(petGroomerVO1.getPgPic() + ",");
			System.out.print(petGroomerVO1.getPgArea() + ",");
			System.out.print(petGroomerVO1.getSchDate() + ",");
			System.out.print(petGroomerVO1.getSchTime() + ",");
			System.out.print(petGroomerVO1.getPgStatus() + ",");
			System.out.print(petGroomerVO1.getPgBio() + ",");
			System.out.print(petGroomerVO1.getPgPw() + ",");
			System.out.print(petGroomerVO1.getPgEmail() + ",");
			System.out.print(petGroomerVO1.getTotalStars() + ",");
			System.out.print(petGroomerVO1.getRatingTimes() + ",");
			System.out.println(petGroomerVO1.getReportTimes() + ",");
			
			System.out.println("---------------------");

			// 查詢
			List<PetGroomerVO> list = dao.getAll();
			for (PetGroomerVO aPg : list) {
				System.out.print(aPg.getPgId() + ",");
				System.out.print(aPg.getPgName() + ",");
				System.out.print(aPg.getPgLicenses() + ",");
				System.out.print(aPg.getPgPic() + ",");
				System.out.print(aPg.getPgArea() + ",");
				System.out.print(aPg.getSchDate() + ",");
				System.out.print(aPg.getSchTime() + ",");
				System.out.print(aPg.getPgStatus() + ",");
				System.out.print(aPg.getPgBio() + ",");
				System.out.print(aPg.getPgPw() + ",");
				System.out.print(aPg.getPgEmail() + ",");
				System.out.print(aPg.getTotalStars() + ",");
				System.out.print(aPg.getRatingTimes() + ",");
				System.out.println(aPg.getReportTimes() + ",");
				
				System.out.println();
			}
			
				// 新增
				PetGroomerVO petGroomerVO2 = new PetGroomerVO();
				petGroomerVO2.setPgName("吳永志1");
				petGroomerVO2.setPgArea("中壢市");
				petGroomerVO2.setSchDate("1111100");
				petGroomerVO2.setSchTime("110");
				petGroomerVO2.setPgStatus("1");
				petGroomerVO2.setPgBio("紙上得來終覺淺，絕知此事要躬行");
				petGroomerVO2.setPgPw("password");
				petGroomerVO2.setPgEmail("no1@gmail.com");
				dao.insert(petGroomerVO2);
				System.out.println("已新增完成!");
						
				//修改
				PetGroomerVO petGroomerVO3 = new PetGroomerVO();
				
				petGroomerVO3.setPgName("徐聰明");
				petGroomerVO3.setPgArea("台中市");
				petGroomerVO3.setSchDate("0000000");
				petGroomerVO3.setSchTime("000");
				petGroomerVO3.setPgStatus("0");
				petGroomerVO3.setPgBio("修改測試abc123");
				petGroomerVO3.setPgPw("FIX55555");
				petGroomerVO3.setPgEmail("fix55555@gmail.com");
				petGroomerVO3.setTotalStars(100);
				petGroomerVO3.setRatingTimes(50);
				petGroomerVO3.setReportTimes(5);
				petGroomerVO3.setPgId(2);
				dao.update(petGroomerVO3);
				System.out.println("已修改完成!");

				// 刪除
				dao.delete(4001);
				System.out.println("已刪除完成!");
			
	
		}

		
}
