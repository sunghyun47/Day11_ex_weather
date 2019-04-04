package com.google.weather;

import java.util.ArrayList;
import java.util.Scanner;

public class WeatherController {

	private WeatherInit wi;
	private WeatherView wv;
	private Scanner sc;
	private ArrayList<Weather> ar;
	
	public WeatherController() { //변수선언
		wi = new WeatherInit();
		wv = new WeatherView();
		sc = new Scanner(System.in);
	
	}
	
	public void start() {
		ar = wi.getWeather();
		boolean check = true;
		
		while(check) {
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 삭제");
			System.out.println("4. 출력");
			System.out.println("5. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: //setWeather
				Weather weather = wi.setWeather();
				ar.add(weather);
				break;
				
			case 2: //findWeather
				Weather weather2 = wi.findWeather(ar);
				if(weather2 != null) {
					wv.view(weather2);
				}
				else {
					wv.view("찾는 도시 없음");
				}
				break;
				
			case 3: //deleteWeather
				String str = wi.deleteWeather(ar);
				wv.view(str);
				break;
				
			case 4:
				wv.view(ar);
				break;
				default:
					System.out.println("종료합니다");
					check=!check;
			}
			
			
		}
		
	}
	
}

