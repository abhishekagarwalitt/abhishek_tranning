package com.collections;

import java.util.*;

public class ListTest {

	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Ravi");// Adding object in arraylist
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
		System.out.println("ArrayList" + list);
		list.remove(2);
		System.out.println("ArrayList" + list);

		LinkedList linkedList = new LinkedList();
		linkedList.add("Ravi");
		linkedList.add(10);
		linkedList.add("Ravi");
		linkedList.set(0, "Ajay");
		linkedList.addFirst("Ram");
		System.out.println("LinkedList" + linkedList);
		
		Vector vector = new Vector();
		System.out.println("Capacity" + vector.capacity());
		for (int i = 0; i < 10; i++) {
			vector.addElement(i);
		}
		System.out.println("Capacity" + vector.capacity());
		vector.addElement("A");
		System.out.println("Capacity" + vector.capacity());
		System.out.println("Vector" + vector);
		
		Stack stack=new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println("Stack" + stack);
		System.out.println(stack.search("A"));
		System.out.println(stack.search("D"));

	}
}