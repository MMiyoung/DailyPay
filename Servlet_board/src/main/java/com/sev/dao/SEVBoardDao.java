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
	//�Խñ� ���
	public SEVBoardDto selectOne(Connection con, int bd_no);
	//�Խñ� �󼼺���(�� �Խñ۸� ���)
	public boolean insert(Connection con, SEVBoardDto dto);
	//�۾���
	public boolean update(Connection con, SEVBoardDto dto);
	//�ۼ���
	public boolean delete(Connection con, int bd_no);
	//�ۻ���	

}
