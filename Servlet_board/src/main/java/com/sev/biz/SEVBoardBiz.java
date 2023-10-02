package com.sev.biz;

import java.util.List;

import com.sev.dto.SEVBoardDto;

public interface SEVBoardBiz {

	public List<SEVBoardDto> selectAll();
	//게시글 목록
	public SEVBoardDto selectOne(int bd_no);
	//게시글 상세보기(한 게시글만 출력)
	public boolean insert(SEVBoardDto dto);
	//글쓰기
	public boolean update(SEVBoardDto dto);
	//글수정
	public boolean delete(int bd_no);
	//글삭제	

}
