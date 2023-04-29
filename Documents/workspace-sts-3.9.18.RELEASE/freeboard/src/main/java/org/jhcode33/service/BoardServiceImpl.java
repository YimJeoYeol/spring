package org.jhcode33.service;

import java.util.List;

import org.jhcode33.domain.BoardDTO;
import org.jhcode33.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	
	@Override
	public void register(BoardDTO dto) {
		mapper.insertSelectKey(dto);
		log.info("****** register : " + dto);

	}

	@Override
	public BoardDTO get(long dno) {
		log.info("******get.......");
		return mapper.getOne(dno);
	}

	@Override
	public boolean modify(BoardDTO dto) {
		log.info("**********modifi :");
		
		return mapper.update(dto) == 1;
	}

	@Override
	public boolean remove(long bno) {
		log.info("**********remove : ");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardDTO> getList() {
		log.info("******** getList...........");
		return mapper.getList();
	}

}
