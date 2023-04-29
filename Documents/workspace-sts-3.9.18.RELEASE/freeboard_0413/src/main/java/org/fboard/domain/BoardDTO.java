package org.fboard.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardDTO {
	
	private long bno;
	private String title;
	private String content;
	private String writer;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date regdate;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date updatedate;

}
