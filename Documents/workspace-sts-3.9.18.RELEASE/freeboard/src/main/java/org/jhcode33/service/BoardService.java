package org.jhcode33.service;

import java.util.List;

import org.jhcode33.domain.BoardDTO;

public interface BoardService {
	public void register(BoardDTO dto);
	public BoardDTO get(long dno);
	public boolean modify(BoardDTO dto);
	public boolean remove(long bno);
	public List<BoardDTO> getList();
}
