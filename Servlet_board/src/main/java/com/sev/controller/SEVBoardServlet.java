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
 * @author ����
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

		// ���� ��û�� main�̶��?
		if (command.equals("main")) {
			// biz�� selectAll �޼ҵ� ���ϰ� ���� ���� ����
			List<SEVBoardDto> list = biz.selectAll();
			request.setAttribute("list", list);

			// forward������� main.jsp �̵�
			dispatch("main.jsp", request, response);

			// ���� ��û�� one �̶��?
		} else if (command.equals("one")) {
			// ���� �Ѱ��� bd_no�� ������
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			SEVBoardDto dto = biz.selectOne(bd_no);

			request.setAttribute("dto", dto);
			dispatch("selectone.jsp", request, response);

			// ���� ��û�� insert �̶��?
		} else if (command.equals("insert")) {
			response.sendRedirect("insert.jsp");
			
			// ���� ��û�� bdinsert �̶��?
		} else if (command.equals("bdinsert")) {
			String name = request.getParameter("sevname");
			String title = request.getParameter("sevtitle");
			String content = request.getParameter("sevcontent");

			SEVBoardDto dto = new SEVBoardDto(name, title, content);
			boolean res = biz.insert(dto);
			if (res) {
				jsResponse("�� �ۼ� ����", "controller.do?command=main", response);
			} else {
				dispatch("controller.do?command=insert", request, response);
			}
			
			// ���� ��û�� update ���?
		} else if (command.equals("update")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			
			SEVBoardDto dto = biz.selectOne(bd_no); 

			request.setAttribute("dto", dto);
			dispatch("update.jsp", request, response); // �Խñ��� ���� ������ ����� update.jsp�� ������
			
			// ���� ��û�� bdupdate ���?
		} else if (command.equals("bdupdate")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			String title = request.getParameter("sevtitle");
			String content = request.getParameter("sevcontent");
			
			SEVBoardDto dto = new SEVBoardDto(bd_no, title, content);
			boolean res = biz.update(dto);
			if (res) {
				jsResponse("�� ���� ����", "controller.do?command=one&bd_no="+bd_no, response);
			} else {
				dispatch("controller.do?command=update&bd_no="+bd_no, request, response);
			}
			
			// ���� ��û�� delete ���?
		} else if (command.equals("delete")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			
			boolean res = biz.delete(bd_no);
			if (res) {
				jsResponse("�� ���� ����", "controller.do?command=main", response);
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

	
	// �����˸� �޼���
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String alert = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url + "';"
				+ "</script>";
		PrintWriter out = response.getWriter();
		out.print(alert);
	}

}
