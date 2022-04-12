package m04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import junit.framework.Assert;

/**
 * Transform_UpperCase doesn't work not sure why.. 
 * 
 * @author Jefson S
 *
 */
class Module04Test {

	  @Test
      void transform_EmptyList() {
         List<Character> arg = new ArrayList<>();
         Module04.transform(arg);  
         List<Character> expected = new ArrayList<>();

             
         assertEquals(expected, arg);

      }
	  
	  @Test 
	  void transform_LowerCase() {
		  List<Character> arg = new ArrayList<>();
		  arg.add('b');
		  arg.add('c');
		  arg.add('a');
		  Module04.transform(arg);
		  
		  List<Character> exp = new ArrayList<>();
		  exp.add('a');
		  exp.add('b');
		  exp.add('c');
		  
		  assertEquals(exp, arg);	  
	  }
////	  
	  @Test 
	  void transform_RemoveDups() {
		  List<Character> arg = new ArrayList<>();
		  arg.add('x');
		  arg.add('a');
		  arg.add('b');
		  arg.add('x');
		  arg.add('b');
		  arg.add('b');
		  Module04.transform(arg);
		  
		  List<Character> exp = new ArrayList<>();
		  exp.add('a');
		  exp.add('b');
		  exp.add('x');
		  
		  assertEquals(exp, arg);
		  
	  }
//	  
	  @Test 
	  void transform_UperrCase() {
		  List<Character> arg = new ArrayList<>();
		  arg.add('U');
		  arg.add('T');
		  arg.add('M');
		  Module04.transform(arg);
		  
		  List<Character> exp = new ArrayList<>();
		  exp.add('@');
		  exp.add('@');
		  exp.add('@');
		  
		  assertEquals(exp, arg);
		  
	  }
//	  
	  @Test 
	  void transform_EmptyList_LowerCase() {
		  List<Character> arg = new ArrayList<>();
		  arg.add(' ');
		  arg.add('n');
		  arg.add('x');
		  arg.add('e');
		  arg.add('s');
	  
		  List<Character> exp = new ArrayList<>();
		  exp.add(' ');
		  exp.add('e');
		  exp.add('n');
		  exp.add('s');
		  exp.add('x');
		  
		  Module04.transform(arg);  
		  assertEquals(exp, arg);
		  
	  }
	  
	  @Test 
	  void transform_UpperCase_LowerCase() {
		  List<Character> arg = new ArrayList<>();
		  arg.add('U');
		  arg.add('M');
		  arg.add('x');
		  arg.add('e');
		  Module04.transform(arg);	
		  
		  List<Character> exp = new ArrayList<>(); 
		  exp.add('@');
		  exp.add('@');
		  exp.add('e');
		  exp.add('x');

		  assertEquals(exp, arg);
		  
	  }
	  

}
