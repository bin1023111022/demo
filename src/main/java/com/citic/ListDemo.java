package com.citic;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>(),l2 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l2.add(5);
		l2.add(6);
		l2.add(3);
		l2.add(4);
		l1.retainAll(l2);
		System.out.println("l1----"+l1);
		System.out.println("l2----"+l2);
	}
}
