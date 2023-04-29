package org.jhcode33.mapper;

import java.util.List;

import org.jhcode33.domain.BoardDTO;

public interface BoardMapper {
	//@Select("SELECT * FROM tbl_board")
	//목록 조회
	public List<BoardDTO> getList();
	
	//추가
	public void insert(BoardDTO dto);
	
	//시퀀스를 사용하지 않고 번호를 증가시키는 방법
	public void insertSelectKey(BoardDTO dto);
	
	//하나만 가져오기
	public BoardDTO getOne(long bno);
	
	//수정
	public int update(BoardDTO dto);
	
	//삭제
	public int delete(long bno);
	
	//검색기능
	public List<BoardDTO> searchTitle(String svalue);
	
	
}
