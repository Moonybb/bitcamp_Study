package com.bit.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Score {
	
	
	public static void main(String[] args) {
		
		Map<Integer,Student> list = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int num=0;
		System.out.println("학생 성적 입력기");
		
		System.out.println("\n-------------------------------------------");
		
		while(true){
			
			System.out.print("\n원하시는 번호를 입력해주세요\n1.전체보기 2.성적입력 3.성적수정 4.성적삭제 0.종료>>");
			int input = sc.nextInt();
			sc.nextLine();
			if(input==0){
				
				//종료
				
				
				break;
			}else if(input==1){
				//전체보기
				String msg ="\n학번||\t이름||\t국어||\t영어||\t수학||\t총점||\t평균||";
				System.out.println(msg);
				Set<Integer> stu = list.keySet();
				Iterator<Integer> iter = stu.iterator();
				while(iter.hasNext()){
					int key = iter.next();
					System.out.println(list.get(key).toString());
					
				}

				
			}else if(input==2){
				//성적입력
				num++;
				System.out.println("학번은 자동 입력 됩니다.");
				Student student = new Student(num);
				System.out.print("이름>>");
				student.setName(sc.nextLine());
				System.out.print("국어성적>>");
				student.setKorean(sc.nextInt());
				System.out.print("영어성적>>");
				student.setEnglish(sc.nextInt());
				System.out.print("수학성적>>");
				student.setMath(sc.nextInt());
				
				list.put(num,student);
				
			}else if(input==3){
				//성적수정
				System.out.print("수정할 학번을 입력해주세요>>");
				Set<Integer> stu = list.keySet();
				Iterator<Integer> iterator = stu.iterator();
				int reset = sc.nextInt();
				sc.nextLine();
				while(iterator.hasNext()){
					int key =iterator.next();
					if(key==reset){
						System.out.print("이름>>");
						list.get(key).setName(sc.nextLine());
						System.out.print("국어성적>>");
						list.get(key).setKorean(sc.nextInt());
						System.out.print("영어성적>>");
						list.get(key).setEnglish(sc.nextInt());
						System.out.print("수학성적>>");
						list.get(key).setMath(sc.nextInt());
						break;
					}
					
				}
			}else if(input==4){
				//성적삭제
				System.out.print("삭제할 학번을 입력해주세요>>");
				Set<Integer> stu = list.keySet();
				Iterator<Integer> iterator = stu.iterator();
				int reset = sc.nextInt();
				sc.nextLine();
				while(iterator.hasNext()){
					int key =iterator.next();
					if(key==reset){
						list.remove(key);
						break;
					}
					
				}
			}
				
		}
		
		
		
	}
}
