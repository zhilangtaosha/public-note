package com.lsj.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void test1(){
		Collection c = new ArrayList();
		c.add(1);				//自动装箱
		c.add(3.14);
		c.add(new Object());
		c.add(new Customer("JACK", 20));
		System.out.println(c.size());
		
		//loop1
		for(Object e : c.toArray()){
			System.out.println(e);
		}
		
		//loop2
		for(Iterator itr = c.iterator(); itr.hasNext(); ){
			Object o = itr.next();
			System.out.println(o);
		}
		c.clear();
		System.out.println(c.size());
	}
	
	public static void test2(){
		List list = new ArrayList();
		
		list.add(100);
		list.add(99);
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	public static void test3(){
		Set s = new HashSet();
		
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		Iterator it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	public static void test4(){
		Set es = new HashSet();
		
		Employee e1 = new Employee("1000", "JACK");
		Employee e2 = new Employee("1001", "KING");
		Employee e3 = new Employee("2000", "SCOTT");
		Employee e4 = new Employee("2001", "SUN");
		Employee e5 = new Employee("3000", "JIM");
		Employee e6 = new Employee("3001", "COOK");
		
		es.add(e1);
		es.add(e2);
		es.add(e3);
		es.add(e4);
		es.add(e5);
		es.add(e6);
		
		System.out.println(es.size());
	}
	
	public static void test5(){
		Set es = new TreeSet();
		
		es.add(new User(40));
		es.add(new User(32));
		es.add(new User(22));
		es.add(new User(33));
		es.add(new User(30));
		es.add(new User(41));
		es.add(new User(29));
		es.add(new User(39));
		
		for(Object o : es)
		{
			System.out.println(o);
		}
	}
	
	public static void test6(){
		Set es = new TreeSet(new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				double v1 = ((Product)o1).price;
				double v2 = ((Product)o2).price;
				
				if(v1 == v2){
					return 0;
				}else if(v1 > v2){
					return 1;
				}else if(v1 < v2){
					return -1;
				}
				return 0;
			}
		});
	
		
		es.add(new Product(4.0));
		es.add(new Product(3.2));
		es.add(new Product(2.2));
		es.add(new Product(3.3));
		es.add(new Product(2.8));
		
		for(Object o : es)
		{
			System.out.println(o);
		}
	}
	
	public static void test7(){
		Map persons = new HashMap();
		
		persons.put("1000", "JACK");
		persons.put("1011", "JACK");
		persons.put("1002", "SUN");
		persons.put("1003", "COOK");
		persons.put("1004", "KING");
		persons.put("1000", "LUCY"); 
		
		System.out.println(persons.size());
		
		Iterator it = persons.values().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("=================================");
		
		Iterator it2 = persons.keySet().iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
		Set entrySet = persons.entrySet();
		Iterator it3 = entrySet.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}
	}
	
	public static void test8(){
		List l = new ArrayList();
		
		l.add(10);
		l.add(5);
		l.add(9);
		l.add(20);
		l.add(30);
		
		Iterator itr = l.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println("=========================");
		Collections.sort(l);
		itr = l.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test6();
//		test7();
		test8();
		System.out.println("Done!");
	}

}


class Customer{
	String name;
	int age;
	
	public Customer(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "Customer[name="+name+",age="+age+"]";
	}
}

class Employee{
	
	String no;
	String name;
	
	public Employee(String no, String name){
		this.no = no;
		this.name = name;
	}
	
	public int hashCode(){	//以员工编号分组 
		return no.hashCode();
	}
}

class User implements Comparable{

	int age;
	
	public User(int age){
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "User[age="+age+"]";
	}
	
	@Override
	public int compareTo(Object o) {
		return this.age - ((User)o).age;
	}
}

class Product{
	
	double price;
	
	public Product(double price){
		this.price = price;
	}
	
	@Override
	public String toString(){
		return this.price + "";
	}
}