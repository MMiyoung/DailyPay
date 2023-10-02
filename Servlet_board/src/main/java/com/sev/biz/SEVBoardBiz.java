package com.sev.biz;

import java.util.List;

import com.sev.dto.SEVBoardDto;

public interface SEVBoardBiz {

	public List<SEVBoardDto> selectAll();
	//�Խñ� ���
	public SEVBoardDto selectOne(int bd_no);
	//�Խñ� �󼼺���(�� �Խñ۸� ���)
	public boolean insert(SEVBoardDto dto);
	//�۾���
	public boolean update(SEVBoardDto dto);
	//�ۼ���
	public boolean delete(int bd_no);
	//�ۻ���	

}
