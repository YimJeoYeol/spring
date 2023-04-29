package org.test03.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	private List<SampleDto> list;
	
	public SampleDTOList() {
		list = new ArrayList<SampleDto>();
	}
}
