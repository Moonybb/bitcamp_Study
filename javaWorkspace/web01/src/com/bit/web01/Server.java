package com.bit.web01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server extends Thread{
	Socket socket;
	
	public Server(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null;
		FileInputStream fileInputStream = null;
		File file = null;
		try {
			SocketAddress socketAddress = socket.getRemoteSocketAddress();
//			System.out.println(socketAddress.toString());
			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			String request = bufferedReader.readLine();
//			System.out.println(request);
			String[] arr = request.split(" ");
			if(arr[1].equals("/")){
				arr[1]="/index.html";
			}
			file = new File("www"+arr[1]);
			outputStream = socket.getOutputStream();
			////////////////
			outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
			outputStream.write("Content-type: text/html; charset=utf-8 \r\n".getBytes());
			outputStream.write("\r\n".getBytes());//본문과 해더 정보의 구분 개행을 하면 하나의 정보로 인식을 하게 된다.
			
//			outputStream.write("<h1>Hello World</h1>".getBytes());
			fileInputStream = new FileInputStream(file);
			int su=-1;
			while((su=fileInputStream.read())!=-1){
				outputStream.write(su);
			}
			
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(bufferedReader!=null)bufferedReader.close();
				if(inputStreamReader!=null)inputStreamReader.close();
				if(inputStream!=null)inputStream.close();
				if(fileInputStream!=null)fileInputStream.close();
				if(outputStream!=null)outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int port = 8080;
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(port);
			while(true){
				Socket socket = serverSocket.accept();
				Server server = new Server(socket);
				server.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket!=null)serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
