package org.fboard.mapper;

import java.util.List;

import org.fboard.domain.BoardDTO;
import org.fboard.domain.Criteria;

public interface BoardMapper {

	//@Select("select * from tbl_board")
	public List<BoardDTO> getList();
	//페이징 처리를 위한 메소드
	public List<BoardDTO> getListWithPaging(Criteria cri);
	public void insert(BoardDTO dto);
	public void insertSelectKey(BoardDTO dto);
	
	public BoardDTO getOne(long bno);
	public int delete(long bno);
	public int update(BoardDTO dto);
	public List<BoardDTO> searchTitle(String svalue);
	public long getTotalCount(Criteria cri);
}
