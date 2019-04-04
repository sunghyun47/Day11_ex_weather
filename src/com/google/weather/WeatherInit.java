package com.google.weather;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WeatherInit {

	private String info;
	private Scanner sc; //여러번쓸거니깐 

	public WeatherInit() {
		info="seoul ,맑음 ,10 ,20 , 0.3 ,daejon, 비,22 ,50,0.1,"
				+ "incheon-태풍 -56 -90 -22.2 -jeju ,흐림,15,10,1.2";
		sc = new Scanner(System.in); //래퍼런스타입
	}

	public ArrayList<Weather> getWeather() {
		ArrayList<Weather> ar = new ArrayList<Weather>();
		info = info.replace("-", ","); // 빼기를 쉼표로
		
		StringTokenizer st = new StringTokenizer(info,","); //아래 주석한거랑 똑같음
		while(st.hasMoreTokens()) {
			Weather weather = new Weather();
			weather.setCity(st.nextToken().trim());
			weather.setState(st.nextToken().trim());
			weather.setGion(Integer.parseInt(st.nextToken().trim()));
			weather.setHum(Integer.parseInt(st.nextToken()));
			weather.setMise(Double.parseDouble(st.nextToken().trim()));
			ar.add(weather);
		}

		/*
		String [] infos = info.split(","); //문자열로 이루어진 배열

		for(int i=0; i<infos.length; i++) { //배열크기의 변수만큼 반복
			Weather weather = new Weather(); //새로운변수 선언

			weather.setCity(infos[i].trim()); //0번째(seoul)
			weather.setState(infos[++i].trim()); //1번째(맑음)
			weather.setGion(Integer.parseInt(infos[++i].trim())); //2번째(10)
			weather.setHum(Integer.parseInt(infos[++i].trim())); //3번째(20)
			weather.setMise(Double.parseDouble(infos[++i].trim())); //4번째(0.3)
			ar.add(weather);
		}
		System.out.println(ar.size());
	}
		 */
		
		return ar;
	}

	public Weather setWeather() { //직접입력해서 만드는부분 보내줌
		Weather weather = new Weather(); //래퍼런스타입

		System.out.println("도시명 입력");
		String city = sc.next();
		weather.setCity(city); //weather.city = city

		System.out.println("날씨 입력");
		weather.setState(sc.next());

		System.out.println("기온 입력");
		weather.setGion(sc.nextInt());

		System.out.println("습도입력");
		weather.setHum(sc.nextInt());

		System.out.println("미세먼지 입력");
		weather.setMise(sc.nextDouble());

		return null;
	}

	public Weather findWeather(ArrayList<Weather> ar) {
		System.out.println("도시명 입력");
		String city = sc.next();
		Weather w = null;
		for(int i=0;i<ar.size();i++) {
			//Weather w = ar.get(i);//꺼냄 
			//if(w.getCity().equals(city)) { //비교
			if(ar.get(i).getCity().equals(city)) { //city랑 같는지 비교
				w = ar.get(i); //꺼내서넣기
				break;
			}

		}

		return w;
	}

	public String deleteWeather(ArrayList<Weather> ar) {
		System.out.println("삭제할 도시 입력");
		String city = sc.next();
		String result = "없는도시";
		for(int i=0;i<ar.size();i++) {
			//Weather w = ar.get(i);//꺼냄 
			//if(w.getCity().equals(city)) { //비교
			if(ar.get(i).getCity().equals(city)) { //city랑 같는지 비교
				//Weather w = ar.get(i);
				//ar.remove(w);
				ar.remove(i); //위에2줄대신 쓸수있음
				result = "삭제 완료";
				break;
			}

		}

		return result;

	}

}
