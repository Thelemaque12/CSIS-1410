package m04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Module04 {

	public static void main(String[] args) {
		System.out.println("Testing toString List Method:");
		List<Integer> empty = new ArrayList<>();
		System.out.println(toStringList(empty));
		
		List<Integer> nullValue = new ArrayList<>();
		nullValue.add(null);
		System.out.println(toStringList(nullValue));
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(0);
		list2.add(-3);
		list2.add(-6);

		System.out.println(toStringList(list2));
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(15);
		System.out.println(toStringList(list3));
		
		List<Integer> list = new ArrayList<>();
		list.add(44);
		list.add(666);
		list.add(7777);
		list.add(88888);
		//list.add(null);

		System.out.println(toStringList(list));
		
		List<Integer> list4 = new ArrayList<>();
		list4.add(44);
		list4.add(-666);
		list4.add(4);
		list4.add(0);
		list4.add(-6);
		list.add(null);

		System.out.println(toStringList(list4));
		
		System.out.println("\nTesting Transform Mehtod:");
		List<Character> arg1 = new ArrayList<>();
		transform(arg1);
		
		List<Character> arg2 = new ArrayList<>();
		arg2.add('b');
		arg2.add('c');
		arg2.add('a');
		transform(arg2);
		
		List<Character> arg3 = new ArrayList<>();
		arg3.add('U');
		arg3.add('T');
		transform(arg3);
		
		List<Character> arg4 = new ArrayList<>();
		arg4.add('x');
		arg4.add('a');
		arg4.add('b');
		arg4.add('x');
		arg4.add('b');
		arg4.add('b');
		transform(arg4);
		
		List<Character> arg = new ArrayList<>();
		arg.add('C');
		arg.add('S');
		arg.add('I');
		arg.add('S');
		transform(arg);
		
		List<Character> arg5 = new ArrayList<>();
		arg5.add('M');
		arg5.add('o');
		arg5.add('d');
		arg5.add('e');
		arg5.add('l');
		arg5.add(' ');
		arg5.add('S');
		transform(arg5);

	}


	/**
	 * This method receives a list of numbers as an argument. 
	 * Based on the numbers in that list, 
	 * it creates and returns a list of strings.
	 * @param numberList
	 * @return 
	 */
	public static List<String> toStringList(List<Integer> numberList){
		
		List<String> sb = new ArrayList<>();
		
		if(numberList.isEmpty()) {
			return sb;
		}
	
		if(numberList.get(0) == null) {
			return null;
		}
		numberList.removeIf(n -> n <= 0);	

		sb.add("#"+numberList.size());
    
		for(Integer i: numberList) {	
			sb.add(Integer.toHexString(i));
		}
		
		if(sb.size() >= 2) {
			Collections.swap(sb, sb.size() - 1, sb.size() - 2);
			//return sb;
			
		}
		return sb;

	}
	
	/**
	 * The following method should modify/change the list
	 *  that is passed as an argument as described below.
	 *  Exchange all the upper-case letters with the at sign '@'. 
	 * @param list
	 */
	public static void transform(List<Character> list) {
	
		Set<Character> set = new HashSet<>(list);
		list.clear();
		list.addAll(set);
		Collections.sort(list);
		List<Character> cha = new ArrayList<>();
		
//		if(list.isEmpty()) {
//			cha.add(list.get(0));
//		}

		for(int i = 0; i < list.size(); i++) {
			if(list.isEmpty()) {
				cha.add(list.get(i));
			}
			if (Character.isUpperCase(list.get(i))) {
				cha.add('@');
			}
			else {
				cha.add(list.get(i));

			}
		}
		System.out.println(cha);
	}
}
