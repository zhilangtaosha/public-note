package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		Set<Integer> sets = new HashSet<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	
		((LinkedList<Integer>)list).clone();
	}

}
