package com.hlj.ExtendsThread;


//这个就是一个多线程的操作类 ，下面就该启动线程了
public class MyThred  extends Thread{

	String name;
	public MyThred(String name) {
		super();
		this.name = name;
	}
	//重写 run 方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<10;i++) //表示循环 10 次
		{
			System.out.println("name:"+name+i);
		}
	}
 
}
