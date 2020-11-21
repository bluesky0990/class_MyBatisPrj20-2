package cs.dit.service;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.BoardDAO2;
import cs.dit.dto.BoardDTO;

public class BDeleteService implements InterfaceService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		BoardDAO2 dao = new BoardDAO2();

		dao.delete(Integer.parseInt(request.getParameter("bcode")));
	}
}
