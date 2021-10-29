package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class BinarySearchTreeTest {
	
	private BinarySearchTree<Integer>intBinarySearchTreeOne;
	private BinarySearchTree<Integer>intBinarySearchTreeEmpty;
	private BinarySearchTree<Integer>intBinarySearchTree10;
	private BinarySearchTree<Integer>intBinarySearchTreerandom50;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Random rand= new Random();
		
		intBinarySearchTreeEmpty = new BinarySearchTree <Integer>();
		
		
		intBinarySearchTreeOne = new BinarySearchTree <Integer>();
		intBinarySearchTreeOne.add(69);
		
		intBinarySearchTree10 = new BinarySearchTree <Integer>();
		for(int i = 1; i <= 10; i++) 
			intBinarySearchTree10.add(i);
		
       
		intBinarySearchTreerandom50 = new BinarySearchTree <Integer>();
		for(int i = 1; i <= 50; i++)
			intBinarySearchTreerandom50.add(rand.nextInt(100));
		
		
	}
	
	@Test
	public void testaddIntEmpty() {
	intBinarySearchTreeEmpty.add(42069);
		assertEquals(42069, intBinarySearchTreeEmpty.first());
		
	}
	
	@Test
	public void testaddIntOne() {
		intBinarySearchTreeOne.add(42069);
		assertTrue(intBinarySearchTreeOne.contains(42069));
		assertEquals(42069, intBinarySearchTreeOne.last());
	}
	
	
	@Test
	public void testaddInt10() {
		intBinarySearchTree10.add(42069);
		assertTrue(intBinarySearchTree10.contains(42069));
		assertEquals(42069, intBinarySearchTree10.last());
	}
	
	
	@Test
	public void testaddallIntEmpty() {
		
		
		
	}
	
	@Test
	public void testClearInt10() {
	//	System.out.println(intBinarySearchTree10.size());
	//	System.out.println(intBinarySearchTree10.toArrayList());
	//	intBinarySearchTree10.clear();
	//	System.out.println(intBinarySearchTree10.size());
	//	System.out.println(intBinarySearchTree10.toArrayList());
		
		
	}
	@Test
	public void testremoveallIntEmpty() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) 
			output.add(i);
		System.out.println(intBinarySearchTree10.toArrayList());
		System.out.println(intBinarySearchTree10.size());
		intBinarySearchTree10.removeAll(output);
		System.out.println(intBinarySearchTree10.toArrayList());
		System.out.println(intBinarySearchTree10.size());
		
	}
	
	
	
	@Test
	public void testRmoveInt10() {
		//System.out.println(intBinarySearchTree10.size());
		//System.out.println(intBinarySearchTree10.remove(10));
		//System.out.println(intBinarySearchTree10.toArrayList());
		//System.out.println(intBinarySearchTree10.size());
	}
	
	@Test
	public void testRmoveInt1() {
		//System.out.println(intBinarySearchTreeOne.size());
		//System.out.println(intBinarySearchTreeOne.remove(69));
		//System.out.println(intBinarySearchTreeOne.toArrayList());
		//System.out.println(intBinarySearchTreeOne.size());
	}
	
	@Test
	public void testRmoveIntEmpty() {
		System.out.println(intBinarySearchTreeEmpty.size());
		System.out.println(intBinarySearchTreeEmpty.remove(69));
		System.out.println(intBinarySearchTreeEmpty.toArrayList());
		System.out.println(intBinarySearchTreeEmpty.size());
	}
	
	
	//toArray Tests Ints
	@Test
	public void testToArrayIntEmpty() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		assertArrayEquals(output.toArray(), intBinarySearchTreeEmpty.toArrayList().toArray());
	}
	
	@Test
	public void testToArrayIntOne() {
		ArrayList<Integer> output = intBinarySearchTreeOne.toArrayList();
		assertEquals(69, output.get(0));
	}
	
	@Test
	public void testToArrayInt10() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) 
			output.add(i);
		assertArrayEquals(output.toArray(), intBinarySearchTree10.toArrayList().toArray());
	}
	
	@Test
	public void testToArrayIntRandom() {
		ArrayList<Integer> output = intBinarySearchTreerandom50.toArrayList();
		for(int i = 0; i < output.size() - 1; i++)
			assertTrue(output.get(i).compareTo(output.get(i+1)) <= 0);		
	}
	/**
	//toArray Tests String
	@Test
	public void testToArrayStringEmpty() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		assertArrayEquals(output.toArray(), intBinarySearchTreeEmpty.toArrayList().toArray());
	}
	
	@Test
	public void testToArrayStringOne() {
		ArrayList<Integer> output = intBinarySearchTreeOne.toArrayList();
		assertEquals(69, output.get(0));
	}
	
	@Test
	public void testToArrayString10() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) 
			output.add(i);
		assertArrayEquals(output.toArray(), intBinarySearchTree10.toArrayList().toArray());
	}
	
	@Test
	public void testToArrayStringRandom() {
		ArrayList<Integer> output = intBinarySearchTreerandom50.toArrayList();
		for(int i = 0; i < output.size() - 1; i++)
			assertTrue(output.get(i).compareTo(output.get(i+1)) <= 0);		
	}
	
	**/
	
	
	
	
	
	
	
	
	
}
