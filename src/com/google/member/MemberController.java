package com.google.member;

import java.util.HashMap;
import java.util.Scanner;

public class MemberController {
	// - mi : MemberInit
	// - mv : MemberView
	// - sc : Scanner
	// - map : HashMap<String, Member>

	// + start() : void
	// 1. 회원가입
	// 2. 로그인
	// 3. 회원탈퇴
	// 4. 회원전체 정보보기
	// 5. 종료

	private MemberInit mi;
	private MemberView mv;
	private Scanner sc;
	private HashMap<String, Member> map;
	
	public MemberController() {
		mi = new MemberInit();
		mv = new MemberView();
		sc = new Scanner(System.in);
	}
	
	public void start() {
		map = mi.setMember();
		
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원탈퇴");
			System.out.println("4. 회원전체정보");
			System.out.println("5. 종료");
			int select = sc.nextInt();
			
			if(select==1) {
				Member member = mi.memberJoin();
				map.put(member.getId(), member);
			}else if(select==2) {
				Member member = mi.memberLogin(map);
				if(member != null) {
					mv.view("로그인 성공");
				}else {
					mv.view("로그인 실패");
				}
			}else if(select==3) {
				String str = mi.memberDelete(map);
				mv.view(str);
			}else if(select==4) {
				mv.view(map);
			}else {
				mv.view("종료 합니다.");
				break;
			}
			
		}
		
	}

}