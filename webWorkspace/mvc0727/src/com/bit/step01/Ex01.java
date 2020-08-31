package com.bit.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex01 implements Servlet {
	ServletConfig config;
	
	// ��û�� ���� ������ ��ü�� �����ϰ� ����ϴ� ���� �ƴ϶� �������� �ٲٰ� �������� ������ �ϴ��� ������ �ؽ��ڵ� ���� ������.

	@Override
	// ���� �������� �����Ҷ� ����
	// ��ü�� ���� ��ÿ� �̶� �������� �ǰ� �� ���Ŀ� web.xml�� ���� �Ǿ� �ִ� url pattern���� ���ӵǾ��� �� ���ʿ� ������ ��ü�� ������ ����Ѵ�.
	// ���ʿ� ���ӿ����� �ٸ� �� ���ؼ� �ӵ��� ������. ������ ���ʿ� ���� ��ü�� ������ ���Ŀ� �����ϴٺ��� �������� �Ź� ���ص� �Ǳ� ������ ���� �ӵ��� ������.
	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;
		System.out.println("init..."+this.hashCode());
	}

	@Override
	// ���񽺰� �����Ҷ� ���� ���ΰ�ħ�� ��� ����
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service..."+this.hashCode());
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>hello world</h1>");
	}

	@Override
	// ���� ����
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("config..");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("info...");
		return "�� �������� ���� ���� �������...";
	}

}