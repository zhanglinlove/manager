package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DB {

	private static String url = "jdbc:mysql://localhost:3306/db_shop";
	private static String user = "admin";
	private static String password = "admin";
	private static String driverName = "com.mysql.jdbc.Driver";
	private Connection conn;
	private PreparedStatement pre;
	private ResultSet set;
	
	public void connect(){
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public List<Object> select(String sql, Object[] params){
		connect();
		try {
			pre = conn.prepareStatement(sql);
			if (params != null){
				for (int i = 0; i < params.length; i++) {
					pre.setObject(i+1, params[i]);
				}
			}

			set = pre.executeQuery();
			List<Object> parent = new ArrayList<Object>();
			List<Object> sub = new ArrayList<Object>();
			ResultSetMetaData data = set.getMetaData();
			for(int i =1; i < data.getColumnCount(); i++){
				String name = data.getColumnName(i);
				sub.add(name);
			}
			parent.add(sub);
			while (set.next()){
				sub = new ArrayList<Object>();
				for (int i = 0; i < data.getColumnCount(); i++) {
					Object obj = set.getObject(i+1);
					sub.add(obj);
				}
				parent.add(sub);
			}
			return parent;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close(){
		try {
			if (pre != null)
				pre.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
