package cs.dit.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cs.dit.dto.BoardDTO;

public class BoardDAO2 {
	private static SqlSessionFactory sqlMapper = null;  //static 변수로 sqlMapper객체변수 선언
	//한번 만든뒤 SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야만 함
	//SqlSessionFactory 의 가장 좋은 스코프는 애플리케이션임으로 static으로 선언
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			try {
				InputStream stream = Resources.getResourceAsStream("cs/dit/config/mybatis-config.xml");
				sqlMapper = new SqlSessionFactoryBuilder().build(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<BoardDTO> list(){
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			return session.selectList("cs.dit.config.selectAll");
		} finally {
			session.close();
		}
	}

	//멤버 상세 보기	
	public BoardDTO view(int bcode) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			return session.selectOne("cs.dit.config.selectOne", bcode);
		} finally {
			session.close();
		}
	}
	
	public int insert(BoardDTO dto) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			return session.insert("cs.dit.config.boardInsert", dto);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public int update(BoardDTO dto) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			return session.update("cs.dit.config.boardUpdate", dto);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public int delete(int bcode) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			return session.delete("cs.dit.config.boardDelete", bcode);
		} finally {
			session.commit();
			session.close();
		}
	}
}
