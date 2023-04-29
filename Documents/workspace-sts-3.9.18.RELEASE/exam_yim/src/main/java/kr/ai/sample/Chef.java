package kr.ai.sample;

import org.springframework.stereotype.Component;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Data
public class Chef {
	private String name;
	private int age;
}
