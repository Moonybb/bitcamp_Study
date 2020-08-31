package com.bit.day22;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PictureTest {

	public static void main(String[] args) {
		String jpg = "C:\\Users\\bitcamp\\Desktop\\thumb-1920-764193.jpg";
		File file = new File(jpg);
		FileInputStream fis = null;
		
		if(file.exists()){
		try {
			fis = new FileInputStream(file);
			int read = fis.read();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();	
				
			} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						if(fis!=null){
						fis.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
				}	
			}
		}
	}
}


