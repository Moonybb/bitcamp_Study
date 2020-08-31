package com.bit.student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import oracle.jdbc.driver.OracleDriver;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.sql.*;
import java.util.Properties;

import javax.swing.JTextField;


public class Ex01 extends JFrame {
	JLabel[] table = new JLabel[50];
	
	private JPanel contentPane;
	private JTextField addNumtf;
	private JTextField addNametf;
	private JTextField addKoreantf;
	private JTextField addEnglishtf;
	private JTextField addMathtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex01 frame = new Ex01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ex01() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("학생성적관리프로그램(ver 0.4.0)");
		label.setFont(new Font("궁서", Font.BOLD, 24));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btn1 = new JButton("전체 보기");
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 0);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 1;
		panel_1.add(btn1, gbc_btn1);
		
		
		
		
		JButton btn2 = new JButton("입력");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2.insets = new Insets(0, 0, 5, 0);
		gbc_btn2.gridx = 0;
		gbc_btn2.gridy = 3;
		panel_1.add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton("수정");
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3.insets = new Insets(0, 0, 5, 0);
		gbc_btn3.gridx = 0;
		gbc_btn3.gridy = 6;
		panel_1.add(btn3, gbc_btn3);
		
		JButton btn5 = new JButton("종료");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btn4 = new JButton("삭제");
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn4.insets = new Insets(0, 0, 5, 0);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 9;
		panel_1.add(btn4, gbc_btn4);
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn5.insets = new Insets(0, 0, 5, 0);
		gbc_btn5.gridx = 0;
		gbc_btn5.gridy = 11;
		panel_1.add(btn5, gbc_btn5);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(11, 5, 0, 0));
		
		
		
		JLabel lblNewLabel = new JLabel("학번");
		center.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		center.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("국어");
		center.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("영어");
		center.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("수학");
		center.add(lblNewLabel_4);
		
		for(int i=0;i<table.length;i++){
			table[i] = new JLabel();
			center.add(table[i]);
		}

		JPanel center2 = new JPanel();
		contentPane.add(center2,BorderLayout.CENTER);
//		center2.setVisible(false);
		GridBagLayout gbl_center2 = new GridBagLayout();
		gbl_center2.columnWidths = new int[] {100, 0, 0};
		gbl_center2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_center2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_center2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		center2.setLayout(gbl_center2);
		
		JLabel label_1 = new JLabel("입력페이지");
		label_1.setFont(new Font("굴림", Font.BOLD, 20));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		center2.add(label_1, gbc_label_1);
		
		JLabel lblNewLabel_5 = new JLabel("학번");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		center2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		addNumtf = new JTextField();
		GridBagConstraints gbc_addNumtf = new GridBagConstraints();
		gbc_addNumtf.insets = new Insets(0, 0, 5, 0);
		gbc_addNumtf.fill = GridBagConstraints.HORIZONTAL;
		gbc_addNumtf.gridx = 1;
		gbc_addNumtf.gridy = 1;
		center2.add(addNumtf, gbc_addNumtf);
		addNumtf.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("이름");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 2;
		center2.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		addNametf = new JTextField();
		GridBagConstraints gbc_addNametf = new GridBagConstraints();
		gbc_addNametf.insets = new Insets(0, 0, 5, 0);
		gbc_addNametf.fill = GridBagConstraints.HORIZONTAL;
		gbc_addNametf.gridx = 1;
		gbc_addNametf.gridy = 2;
		center2.add(addNametf, gbc_addNametf);
		addNametf.setColumns(10);
		
		JLabel label_2 = new JLabel("국어");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		center2.add(label_2, gbc_label_2);
		
		addKoreantf = new JTextField();
		GridBagConstraints gbc_addKoreantf = new GridBagConstraints();
		gbc_addKoreantf.insets = new Insets(0, 0, 5, 0);
		gbc_addKoreantf.fill = GridBagConstraints.HORIZONTAL;
		gbc_addKoreantf.gridx = 1;
		gbc_addKoreantf.gridy = 3;
		center2.add(addKoreantf, gbc_addKoreantf);
		addKoreantf.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("영어");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		center2.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		addEnglishtf = new JTextField();
		GridBagConstraints gbc_addEnglishtf = new GridBagConstraints();
		gbc_addEnglishtf.insets = new Insets(0, 0, 5, 0);
		gbc_addEnglishtf.fill = GridBagConstraints.HORIZONTAL;
		gbc_addEnglishtf.gridx = 1;
		gbc_addEnglishtf.gridy = 4;
		center2.add(addEnglishtf, gbc_addEnglishtf);
		addEnglishtf.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("수학");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		center2.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		addMathtf = new JTextField();
		GridBagConstraints gbc_addMathtf = new GridBagConstraints();
		gbc_addMathtf.insets = new Insets(0, 0, 5, 0);
		gbc_addMathtf.fill = GridBagConstraints.HORIZONTAL;
		gbc_addMathtf.gridx = 1;
		gbc_addMathtf.gridy = 5;
		center2.add(addMathtf, gbc_addMathtf);
		addMathtf.setColumns(10);
		
		JButton addBtn = new JButton("입력");
		GridBagConstraints gbc_addBtn = new GridBagConstraints();
		gbc_addBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addBtn.gridx = 1;
		gbc_addBtn.gridy = 6;
		center2.add(addBtn, gbc_addBtn);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				center.setVisible(true);
				center2.setVisible(false);
				contentPane.add(center,BorderLayout.CENTER);
				String sql="select * from student01";
				new OracleDriver();
				
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				Properties properties = new Properties();
				properties.setProperty("user", "scott");
				properties.setProperty("password", "tiger");
				
				Connection connection= null;
				Statement statement= null;
				ResultSet resultSet = null;
				try {
					connection = DriverManager.getConnection(url,properties);
					statement = connection.createStatement();
					resultSet=statement.executeQuery(sql);
					int cnt=0;
					while(resultSet.next()){
						for(int i=1;i<6;i++){
							table[cnt++].setText(resultSet.getString(i));
						}
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(resultSet!=null)resultSet.close();
						if(statement!=null)statement.close();
						if(connection!=null)connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				center.setVisible(false);
				center2.setVisible(true);
				contentPane.add(center2,BorderLayout.CENTER);
			}
		});	
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String param1 = addNumtf.getText();
				String param2 = addNametf.getText();
				String param3 = addKoreantf.getText();
				String param4 = addEnglishtf.getText();
				String param5 = addMathtf.getText();
				addNumtf.setText("");
				addNametf.setText("");
				addKoreantf.setText("");
				addEnglishtf.setText("");
				addMathtf.setText("");
				
				String sql = "insert into student01 values (";
				sql+=param1+",'"+param2+"',"+param3+","+param4+","+param5+")";
//				System.out.println(sql);
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				Properties properties = new Properties();
				properties.setProperty("user", "scott");
				properties.setProperty("password", "tiger");
				new oracle.jdbc.OracleDriver();
				Connection connection = null;
				Statement statement = null;
				try {
					connection = DriverManager.getConnection(url,properties);
					statement = connection.createStatement();
					statement.executeUpdate(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(statement!=null)statement.close();
						if(connection!=null)connection.close();
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			
				
				
			}
		});
		
	}

}
