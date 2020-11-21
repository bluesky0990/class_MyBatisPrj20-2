package cs.dit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.service.BDeleteService;
import cs.dit.service.BInsertService;
import cs.dit.service.BListService;
import cs.dit.service.BUpdateService;
import cs.dit.service.BViewService;
import cs.dit.service.InterfaceService;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		InterfaceService command = null;
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".do"));
		
		if(com !=null && com.trim().equals("list")) {
			command = new BListService();
			command.execute(request, response);
			viewPage = "bList.jsp";
		}
		if(com !=null && com.trim().equals("view")) {
			command = new BViewService();
			command.execute(request, response);
			viewPage = "bView.jsp";
		}
		if(com !=null && com.trim().equals("insertForm")) {
			viewPage = "bInsertForm.jsp";
		}
		if(com !=null && com.trim().equals("insert")) {
			command = new BInsertService();
			command.execute(request, response);
			viewPage = "list.do";
		}
		if(com !=null && com.trim().equals("delete")) {
			command = new BDeleteService();
			command.execute(request, response);
			viewPage = "chainDelete.rp?bcode=" + request.getParameter("bcode");
		}
		if(com !=null && com.trim().equals("update")) {
			command = new BUpdateService();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


}
