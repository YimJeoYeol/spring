package org.fboard.service; //23년 04월17일 수업

import java.util.List;

import org.fboard.domain.BoardDTO;
import org.fboard.domain.Criteria;

public interface BoardService {
	public void register(BoardDTO dto);
	public BoardDTO get(long bno);
	public boolean modify(BoardDTO dto);
	public boolean remove(long bno);
	//public List<BoardDTO> getList();
	public List<BoardDTO> getList(Criteria cri);
	public long getTotal(Criteria cri);
	
}
