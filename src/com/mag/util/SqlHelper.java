/*SqlHelper 封装了 JDBC 操作，提供了统一的数据库访问接口，
使 Java 程序能够与数据库建立连接并进行数据操作，
同时屏蔽了底层 JDBC 的复杂性，简化了 Service 层的代码*/

package com.mag.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class SqlHelper {

	//把 SqlHelper里的数据库工具拿出来，给外边（service）用
	public static Connection getCt() {
		return ct;
	}
	public static PreparedStatement getPs() {
		return ps;
	}
	public static ResultSet getRs() {
		return rs;
	}


	//数据库连接
	private static Connection ct=null;
	//sql语句对象
	private static PreparedStatement ps=null;
	//查询结果集
	private static ResultSet rs=null;
	//JDBC驱动
	private static String driver="";
	//数据库地址
	private static String url="";
	//用户名
	private static String username="";
	//密码
	private static String password="";
	//装配置文件里的键值对
	private static Properties pp=null;
	//读 dbinfo.properties文件
	private static InputStream fis=null;


	//静态块，只做一次，加载数据库配置、注册驱动
	static{

		try {
			//创建箱子pp。Properties是java自带类
			pp=new Properties();
			//把dbinfo.properties变成字节流
			fis=SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			//fis文件里的东西，传到pp
			pp.load(fis);
			//把箱子pp里的drive拿出来，赋值给全局变量drive
			driver=pp.getProperty("driver");
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			password=pp.getProperty("password");
			//连接MySQL，注册JDBC
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			if(fis!=null)
			{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			fis=null;
		}
	}


	//连接MySQL，并把那条‘通话线路’（Connection）给ct
	public static Connection getConnection()
	{
		try {
			ct=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}


	//关闭资源函数
	public static void close(Connection ct,PreparedStatement ps,ResultSet rs)
		{
			try {
				//为了程序健壮、
				if(rs!=null)
				{
					rs.close();
				}
				rs=null;
				if(ps!=null)
				{
					ps.close();
				}
				ps=null;
				if(ct!=null)
				{
					ct.close();
				}
				ct=null;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	//Update函数，增删改
	public static int executeUpdate(String sql, String[] parameters) {
		int rows = 0;
		try {
			//连数据库
			ct = getConnection();
			//把sql发给数据库，预编译
			ps = ct.prepareStatement(sql);
			//填上ps的？
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setObject(i + 1, parameters[i]);
				}
			}
			//改了几行，通知数据库开始动
			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, ps, rs);
		}
		return rows; // 返回行数
	}

	//查，返回查询结果集
	public static ResultSet executeQuery(String sql,String []parameters)
	{
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null&&!parameters.equals(""))
			{
			  for(int i=0;i<parameters.length;i++)
			  {
				  ps.setObject(i+1, parameters[i]);
			  }
			}
			//通知数据库可以查了
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			
            //因为要返回结果集rs，所以要手动关闭资源。
		}
	}


}
