package com.pet_groomer.controller;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.pet_groomer.model.PetGroomerService;
import com.pet_groomer.model.PetGroomerVO;

@WebServlet("/backend/pg/pg.do")

public class PetGroomerServlet extends HttpServlet{


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("pgId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入美容師編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/backend/pg/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer pgId = null;
				try {
					pgId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("美容師編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/backend/pg/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				
				
				/***************************2.開始查詢資料*****************************************/
				PetGroomerService pgSvc = new PetGroomerService();
				PetGroomerVO petGroomerVO = pgSvc.getOnePg(pgId);
				if (petGroomerVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/backend/pg/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petGroomerVO", petGroomerVO); // 資料庫取出的PetGroomerVO物件,存入req
				String url = "/backend/pg/listOnePg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllPg.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer pgId = Integer.valueOf(req.getParameter("pgId"));
				
				/***************************2.開始查詢資料****************************************/
				PetGroomerService pgSvc = new PetGroomerService();
				PetGroomerVO petGroomerVO = pgSvc.getOnePg(pgId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("petGroomerVO", petGroomerVO);         // 資料庫取出的PetGroomerVO物件,存入req
				String url = "/backend/pg/update_pg_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		if ("update".equals(action)) { // 來自update_pg_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer pgId = Integer.valueOf(req.getParameter("pgId").trim());
				
				String pgName = req.getParameter("pgName");
				String pgNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (pgName == null || pgName.trim().length() == 0) {
					errorMsgs.add("美容師姓名: 請勿空白");
				} else if(!pgName.trim().matches(pgNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("美容師姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String pgArea = req.getParameter("pgArea").trim();
				if (pgArea == null || pgArea.trim().length() == 0) {
					errorMsgs.add("服務區域請勿空白");
				}	
				
				String schDate = req.getParameter("schDate").trim();
				if (schDate == null || schDate.trim().length() == 0) {
					errorMsgs.add("每周服務日請勿空白");
				}	
				
				String schTime = req.getParameter("schTime").trim();
				if (schTime == null || schTime.trim().length() == 0) {
					errorMsgs.add("每日服務時段請勿空白");
				}	
				
				String pgStatus = req.getParameter("pgStatus").trim();
				if (pgStatus == null || pgStatus.trim().length() == 0) {
					errorMsgs.add("營業狀態請勿空白");
				}	
				
				String pgBio = req.getParameter("pgBio").trim();
				if (pgBio == null || pgBio.trim().length() == 0) {
					errorMsgs.add("簡介請勿空白");
				}	
				
				String pgPw = req.getParameter("pgPw").trim();
				if (pgPw == null || pgPw.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}
				
				String pgEmail = req.getParameter("pgEmail").trim();
				if (pgEmail == null || pgEmail.trim().length() == 0) {
					errorMsgs.add("信箱請勿空白");
				}	
				
				Integer totalStars = Integer.valueOf(req.getParameter("totalStars").trim());
				
				Integer ratingTimes = Integer.valueOf(req.getParameter("ratingTimes").trim());
				
				Integer reportTimes = Integer.valueOf(req.getParameter("reportTimes").trim());
				
//				Integer totalStars = req.getParameter("totalStars").trim();
//				if (totalStars == null || totalStars.trim().length() == 0) {
//					errorMsgs.add("評價總星數請勿空白");
//				}	
//				
//				Integer ratingTimes = req.getParameter("ratingTimes").trim();
//				if (ratingTimes == null || ratingTimes.trim().length() == 0) {
//					errorMsgs.add("評價總次數請勿空白");
//				}
//				
//				Integer reportTimes = req.getParameter("reportTimes").trim();
//				if (reportTimes == null || reportTimes.trim().length() == 0) {
//					errorMsgs.add("違規記點次數請勿空白");
//				}



				PetGroomerVO petGroomerVO = new PetGroomerVO();
				petGroomerVO.setPgName(pgName);
				petGroomerVO.setPgArea(pgArea);
				petGroomerVO.setSchDate(schDate);
				petGroomerVO.setSchTime(schTime);
				petGroomerVO.setPgStatus(pgStatus);
				petGroomerVO.setPgBio(pgBio);
				petGroomerVO.setPgPw(pgPw);
				petGroomerVO.setPgEmail(pgEmail);
				petGroomerVO.setTotalStars(totalStars);
				petGroomerVO.setRatingTimes(ratingTimes);
				petGroomerVO.setReportTimes(reportTimes);
				petGroomerVO.setPgId(pgId);
				
				
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("petGroomerVO", petGroomerVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/backend/pg/update_pg_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				PetGroomerService pgSvc = new PetGroomerService();
				petGroomerVO = pgSvc.updatePetGroomer(pgName, pgArea, schDate, schTime, pgStatus, pgBio, pgPw, pgEmail,totalStars,ratingTimes,reportTimes,pgId);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("petGroomerVO", petGroomerVO); // 資料庫update成功後,正確的的petGroomerVO物件,存入req
				String url = "/backend/pg/listOnePg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		
		if ("insert".equals(action)) { // 來自addPg.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String pgName = req.getParameter("pgName");
				String pgNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z)]{2,10}$";
				if (pgName == null || pgName.trim().length() == 0) {
					errorMsgs.add("美容師姓名: 請勿空白");
				} else if(!pgName.trim().matches(pgNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("美容師姓名: 只能是中、英文字母, 且長度必需在2到10之間");
	            }
				
				String pgArea = req.getParameter("pgArea").trim();
				if (pgArea == null || pgArea.trim().length() == 0) {
					errorMsgs.add("服務地區請勿空白");
				}
				
				String schDate = req.getParameter("schDate").trim();
				if (schDate == null || schDate.trim().length() == 0) {
					errorMsgs.add("請勿空白");
				}
				
				String schTime = req.getParameter("schTime").trim();
				if (schTime == null || schTime.trim().length() == 0) {
					errorMsgs.add("請勿空白");
				}
				
				String pgStatus = req.getParameter("pgStatus").trim();
				if (pgStatus == null || pgStatus.trim().length() == 0) {
					errorMsgs.add("請勿空白");
				}
				
				String pgBio = req.getParameter("pgBio").trim();
				if (pgBio == null || pgBio.trim().length() <= 10) {
					errorMsgs.add("請勿空白或小於10個字");
					
				}
				
				String pgPw = req.getParameter("pgPw");
				String pgPwReg = "^[(a-zA-Z0-9)]{8,16}$";
				if (pgPw == null || pgPw.trim().length() == 0) {
					errorMsgs.add("密碼: 請勿空白");
				} else if(!pgPw.trim().matches(pgPwReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("美容師密碼: 只能是英文字母及數字, 且長度必需在8到16之間");
	            }
				
				
				String pgEmail = req.getParameter("pgEmail");
				String pgEmailReg = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
				if (pgEmail == null || pgEmail.trim().length() == 0) {
					errorMsgs.add("美容師信箱: 請勿空白");
				} else if(!pgEmail.trim().matches(pgEmailReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("美容師信箱: 只能是英文字母");
	            }
				

				PetGroomerVO petGroomerVO = new PetGroomerVO();
				petGroomerVO.setPgName(pgName);
				petGroomerVO.setPgArea(pgArea);
				petGroomerVO.setSchDate(schDate);
				petGroomerVO.setSchTime(schTime);
				petGroomerVO.setPgStatus(pgStatus);
				petGroomerVO.setPgBio(pgBio);
				petGroomerVO.setPgPw(pgPw);
				petGroomerVO.setPgEmail(pgEmail);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("petGroomerVO", petGroomerVO); // 含有輸入格式錯誤的petGroomerVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/backend/pg/addPg.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				PetGroomerService pgSvc = new PetGroomerService();
				petGroomerVO = pgSvc.addPetGroomer(pgName,  pgArea, schDate, schTime, pgStatus,
						pgBio, pgPw, pgEmail) ;
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/backend/pg/listAllPg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPg.jsp
				successView.forward(req, res);	
		}
				

		
		if ("delete".equals(action)) { // 來自listAllPg.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer pgId = Integer.valueOf(req.getParameter("pgId"));
				
				/***************************2.開始刪除資料***************************************/
				PetGroomerService pgSvc = new PetGroomerService();
				pgSvc.deletePetGroomer(pgId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/backend/pg/listAllPg.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}


