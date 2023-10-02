package com.sev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sev.biz.SEVBoardBiz;
import com.sev.biz.SEVBoardBizImpl;
import com.sev.dto.SEVBoardDto;

/**
 * @author 누나
 *
 */
@WebServlet("/SEVBoardServlet")
public class SEVBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SEVBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");

		String command = request.getParameter("command");

		SEVBoardBiz biz = new SEVBoardBizImpl();

		// 만약 요청이 main이라면?
		if (command.equals("main")) {
			// biz의 selectAll 메소드 리턴값 받을 변수 선언
			List<SEVBoardDto> list = biz.selectAll();
			request.setAttribute("list", list);

			// forward방식으로 main.jsp 이동
			dispatch("main.jsp", request, response);

			// 만약 요청이 one 이라면?
		} else if (command.equals("one")) {
			// 같이 넘겨준 bd_no도 가져옴
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			SEVBoardDto dto = biz.selectOne(bd_no);

			request.setAttribute("dto", dto);
			dispatch("selectone.jsp", request, response);

			// 만약 요청이 insert 이라면?
		} else if (command.equals("insert")) {
			response.sendRedirect("insert.jsp");
			
			// 만약 요청이 bdinsert 이라면?
		} else if (command.equals("bdinsert")) {
			String name = request.getParameter("sevname");
			String title = request.getParameter("sevtitle");
			String content = request.getParameter("sevcontent");

			SEVBoardDto dto = new SEVBoardDto(name, title, content);
			boolean res = biz.insert(dto);
			if (res) {
				jsResponse("글 작성 성공", "controller.do?command=main", response);
			} else {
				dispatch("controller.do?command=insert", request, response);
			}
			
			// 만약 요청이 update 라면?
		} else if (command.equals("update")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			
			SEVBoardDto dto = biz.selectOne(bd_no); 

			request.setAttribute("dto", dto);
			dispatch("update.jsp", request, response); // 게시글의 원래 데이터 값대로 update.jsp로 보내줌
			
			// 만약 요청이 bdupdate 라면?
		} else if (command.equals("bdupdate")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			String title = request.getParameter("sevtitle");
			String content = request.getParameter("sevcontent");
			
			SEVBoardDto dto = new SEVBoardDto(bd_no, title, content);
			boolean res = biz.update(dto);
			if (res) {
				jsResponse("글 수정 성공", "controller.do?command=one&bd_no="+bd_no, response);
			} else {
				dispatch("controller.do?command=update&bd_no="+bd_no, request, response);
			}
			
			// 만약 요청이 delete 라면?
		} else if (command.equals("delete")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			
			boolean res = biz.delete(bd_no);
			if (res) {
				jsResponse("글 삭제 성공", "controller.do?command=main", response);
			} else {
				dispatch("controller.do?command=one&bd_no="+bd_no, request, response);
			}
		}

	}
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);

	}

	
	// 성공알림 메서드
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String alert = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url + "';"
				+ "</script>";
		PrintWriter out = response.getWriter();
		out.print(alert);
	}

}
