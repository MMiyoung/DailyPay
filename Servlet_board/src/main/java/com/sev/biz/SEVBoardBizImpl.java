package com.sev.biz;

import java.util.List;
import java.sql.Connection;
import com.jdbc.JDBCTemplate;
import com.sev.dao.SEVBoardDao;
import com.sev.dao.SEVBoardDaoImpl;
import com.sev.dto.SEVBoardDto;

public class SEVBoardBizImpl implements SEVBoardBiz {
	private SEVBoardDao dao = new SEVBoardDaoImpl();

	@Override
	public List<SEVBoardDto> selectAll() {
		Connection con = JDBCTemplate.getConnection();
		List<SEVBoardDto> res = dao.selectAll(con);
		JDBCTemplate.close(con);

		return res;
	}

	@Override
	public SEVBoardDto selectOne(int bd_no) {
		Connection con = JDBCTemplate.getConnection();
		SEVBoardDto dto = dao.selectOne(con, bd_no);
		JDBCTemplate.close(con);

		return dto;
	}

	@Override
	public boolean insert(SEVBoardDto dto) {
		Connection con = JDBCTemplate.getConnection();
		boolean res = dao.insert(con, dto);
		if (res) {
			JDBCTemplate.commit(con);
		}
		JDBCTemplate.close(con);
		return res;
	}

	@Override
	public boolean update(SEVBoardDto dto) {
		Connection con = JDBCTemplate.getConnection();
		boolean res = dao.update(con, dto);
		if (res) {
			JDBCTemplate.commit(con);
		}
		JDBCTemplate.close(con);
		return res;
	}

	@Override
	public boolean delete(int bd_no) {
		Connection con = JDBCTemplate.getConnection();
		boolean res = dao.delete(con, bd_no);
		if (res) {
			JDBCTemplate.commit(con);
		}
		JDBCTemplate.close(con);
		return res;
	}

}
