package com.bit.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class ObjectStream1 {
	
	public static void main(String[] args) {
		String path = "data4.bin";
		File file = new File(path);
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis=new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			
			String msg = (String)ois.readObject();
			
			ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
			System.out.println(msg);
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
			}
			
			Vector v = (Vector) ois.readObject();
			Enumeration em = v.elements();
			while(em.hasMoreElements()){
				System.out.println(em.nextElement());
			}
			
			int[] sus= (int[]) ois.readObject();
			System.out.println(Arrays.toString(sus));
			
			Vector v2 = (Vector) ois.readObject();
			int[] ele1=(int[]) v2.get(0);
			System.out.println(Arrays.toString(ele1));
			Vector v3= (Vector) v2.get(1);
			em=v3.elements();
			while(em.hasMoreElements()){
				System.out.println(em.nextElement());
			}
			Student1 stu = (Student1) ois.readObject();
			System.out.println(stu.num);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fis!=null)fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
