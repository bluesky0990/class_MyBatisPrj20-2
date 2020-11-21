package cs.dit.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.ReplyDAO;

public class RDeleteService implements InterfaceService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bcode = null;
		String rcode = null;

		ReplyDAO dao = new ReplyDAO();
		try {
			bcode = request.getParameter("bcode");
			System.out.println("찹찹이b" + bcode);
		} catch (Exception e) {
			System.out.println("게시글코드에러");
		}
		
		try {
			rcode = request.getParameter("rcode");
			System.out.println("찹찹이r" + rcode);
		} catch (Exception e) {
			System.out.println("댓글코드에러");
		}
		
		if(rcode != null) {
			dao.replyDelete(Integer.parseInt(rcode));
		} else if(bcode != null) {
			dao.chainDelete(Integer.parseInt(bcode));
		}
	}
}
