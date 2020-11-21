package cs.dit.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.BoardDAO2;
import cs.dit.dto.BoardDTO;

public class BInsertService implements InterfaceService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		BoardDTO dto = new BoardDTO();
		BoardDAO2 dao = new BoardDAO2();

		dto.setSubject(request.getParameter("subject"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		
		dao.insert(dto);
	}
}
