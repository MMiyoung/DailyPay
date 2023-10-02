package com.sev.dao;

import java.sql.Connection;
import java.util.List;

import com.sev.dto.SEVBoardDto;


public interface SEVBoardDao {
	
	String selectAllsql = " SELECT * FROM SEVBOARD ";
	String selectOnesql = " SELECT * FROM SEVBOARD WHERE BD_NO=? ";
	String insertsql = " INSERT INTO SEVBOARD VALUES(0,?,?,?,now()) ";
	String updatesql = " UPDATE SEVBOARD SET BD_TITLE=?, BD_CONTENT=? WHERE BD_NO=? ";
	String deletesql = " DELETE FROM SEVBOARD WHERE BD_NO=? ";

	public List<SEVBoardDto> selectAll(Connection con);
	//게시글 목록
	public SEVBoardDto selectOne(Connection con, int bd_no);
	//게시글 상세보기(한 게시글만 출력)
	public boolean insert(Connection con, SEVBoardDto dto);
	//글쓰기
	public boolean update(Connection con, SEVBoardDto dto);
	//글수정
	public boolean delete(Connection con, int bd_no);
	//글삭제	

}
