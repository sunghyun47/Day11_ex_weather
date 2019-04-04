package com.google.weather;

import java.util.ArrayList;

public class WeatherView {

	public void view(String str) {
		System.out.println(str);
		
	}

	public void view(ArrayList<Weather> ar) { //리스트에 있는거 다찍어줌 
		for(int i=0; i<ar.size(); i++) {
			Weather weather = ar.get(i);
			this.view(weather);
		}
	}
	
	
	public void view(Weather weather) {
		System.out.println("city : " + weather.getCity());
		System.out.println("state : " + weather.getState());
		System.out.println("gion : " + weather.getGion());
		System.out.println("hum : " + weather.getHum());
		System.out.println("mise : " + weather.getMise());
		System.out.println("=============================");

		
		
		
	}
}
