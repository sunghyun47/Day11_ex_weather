package com.google.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberView {
	// + view(String) : void
	// + view(Member) : void
	// + view(HashMap<String, Member>) : void
	
	public void view(HashMap<String, Member> map) {
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Member member = map.get(key);
			this.view(member);
		}
		
	}
	
	public void view(Member member) {
		System.out.println("name : " + member.getName());
		System.out.println("id : " + member.getId());
		System.out.println("pw : " + member.getPw());
		System.out.println("age : " + member.getAge());
		System.out.println("level : " + member.getLevel());
		
	}
	
	
	public void view(String str) {
		System.out.println(str);
		
		
	}
	
	
}
