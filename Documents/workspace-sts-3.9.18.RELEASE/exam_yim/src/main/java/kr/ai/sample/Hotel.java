package kr.ai.sample;

import org.springframework.stereotype.Component;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Component
@Data
@Getter

public class Hotel {
	@NonNull
	private Chef chef;
	private String name;
	private int age;
	
	public Hotel(Chef chef) { 
		this.chef = chef; 
		}
	 
}
