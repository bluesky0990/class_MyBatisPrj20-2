package cs.dit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.service.InterfaceService;
import cs.dit.service.RDeleteService;
import cs.dit.service.RInsertService;
import cs.dit.service.RViewService;


@WebServlet("*.rp")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		InterfaceService command = null;

		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".rp"));

		if(com !=null && com.trim().equals("replyLoad")) { // bView 페이지의 댓글목록 ajax로 반환
			command = new RViewService();
			command.execute(request, response);
			viewPage = "output.jsp";
		}
		
		if(com !=null && com.trim().equals("replyInsert")) { // bView 페이지의 댓글추가 ajax로 반환
			command = new RInsertService();
			command.execute(request, response);
			viewPage = "output.jsp";
		}

		if(com !=null && com.trim().equals("replyDelete")) { // 댓글 삭제요청시 실행됨
			command = new RDeleteService();
			command.execute(request, response);
			viewPage = "output.jsp";
		}
		
		if(com !=null && com.trim().equals("chainDelete")) { // 게시글 삭제요청시 댓글전체 삭제 실행됨
			command = new RDeleteService();
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
