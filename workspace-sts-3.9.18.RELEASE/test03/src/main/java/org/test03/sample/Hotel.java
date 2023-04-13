package org.test03.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@Getter
/* @AllArgsConstructor */
/* @RequiredArgsConstructor */
public class Hotel {
	@NonNull
	private Chef chef;
	private String name;
	
	 public Hotel(Chef chef) { this.chef = chef; }
	 
}
