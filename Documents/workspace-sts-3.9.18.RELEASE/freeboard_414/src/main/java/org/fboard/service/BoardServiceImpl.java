package org.fboard.service; //23년 04월17일 수업

import java.util.List;

import org.fboard.domain.BoardDTO;
import org.fboard.domain.Criteria;
import org.fboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper; //객체생성을 해줘야 요청가능 @Setter(onMethod_ = {@Autowired})없으면 초기화만 된다.(무쓸모)
	
	@Override
	public void register(BoardDTO dto) {
		//mapper.insert(dto);
		mapper.insertSelectKey(dto);
		log.info("#$%register: "+dto);

	}

	@Override
	public BoardDTO get(long bno) {
		log.info("###get: ");
		
		//BoardDTO one = mapper.getOne(bno);
		//return one; (1단계)
		return mapper.getOne(bno);
	}

	@Override
	public boolean modify(BoardDTO dto) {
		log.info("!@#$modify: "+dto);
		return mapper.update(dto) == 1;
	}

	@Override
	public boolean remove(long bno) {
		log.info("!@#$remove: ");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		log.info("###getlist...");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public long getTotal(Criteria cri) {
		log.info("********* get total count");
		
		
		return mapper.getTotalCount(cri);
	}

}
