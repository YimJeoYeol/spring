package org.jhcode33.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	//DTO 변수가 중간에 대문자가 되면 바인딩할 때 오류가 날수도 있어서 그냥 소문자로 하는게 좋음.
	private long 	bno;
	private String  title;
	private String  content;
	private String  writer;
	private Date    regdate;
	private Date    updatedate;

}
