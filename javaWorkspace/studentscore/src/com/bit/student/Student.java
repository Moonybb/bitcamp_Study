package com.bit.student;

public class Student {
	
	private int korean,english,math,num,sum;
	private String name;
	private double average;
	
	Student(int num){
		this.num=num;
	}
	
	public int getNum(){
		return num;
	}
	
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAverage(){
		return (korean+english+math)*100/3/100.0;
	}
	
	public int getSum(){
		return (korean+english+math);
	}
	@Override
	public String toString(){
		
		return getNum()+"\t"+getName()+"\t"+getKorean()+"\t"+getEnglish()+"\t"+getMath()+"\t"+getSum()+"\t"+getAverage();
	}
	
	
	
}
