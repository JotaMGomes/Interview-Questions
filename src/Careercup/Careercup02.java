package Careercup;

import java.util.ArrayList;

// https://www.careercup.com/question?id=22191662
// Jose Luiz Mattos Gomes

public class Careercup02 {

	public static void main(String[] args) {

		Tree vTree = new Tree(1);
		
		Tree vAux = new Tree(2);
		vTree.left= vAux;

		vAux = new Tree(3);
		vTree.right= vAux;

		Tree vAux1 = new Tree(4);
		vAux= vTree.left; // 2
		vAux.left = vAux1;
		
		vAux1 = new Tree(5);
		vAux.right = vAux1;
		vAux= vTree.right; // 3
		vAux.left = vAux1;
		
		vAux1 = new Tree(6);
		vAux.right = vAux1;
		
		vAux1 = new Tree(7);
		vAux= vTree.left.left; // 4
		vAux.left = vAux1;
		
		vAux1 = new Tree(8);
		vAux.right = vAux1;
		
		vAux= vTree.left.right; // 5
		vAux.left = vAux1;
		
		vAux1 = new Tree(9);
		vAux.right = vAux1;
		
		vAux= vTree.right.right; // 6
		vAux.left = vAux1;
		
		vAux1 = new Tree(10);
		vAux.right = vAux1;
		
		Solution02 vSolution = new Solution02();
		Solution02.printControl = new ArrayList<Integer>();
		vSolution.printTree(vTree);
		
		System.out.println("=====");
		vSolution.emptyVolume(vTree);
		vSolution.distributeVolume(2, vTree);
		Solution02.printControl = new ArrayList<Integer>();
		vSolution.printTree(vTree);
		
		System.out.println("=====");
		vSolution.emptyVolume(vTree);
		vSolution.distributeVolume(5, vTree);
		Solution02.printControl = new ArrayList<Integer>();
		vSolution.printTree(vTree);	
		
		System.out.println("=====");
		vSolution.emptyVolume(vTree);
		vSolution.distributeVolume(6, vTree);
		Solution02.printControl = new ArrayList<Integer>();
		vSolution.printTree(vTree);

	}

}


class Tree{
	int value;
	double volume;
	Tree left, right;
	final double capacity = 1;
	
	Tree(int val){
		this.value = val;
		this.volume = 0;
	}
}

class Solution02 {
	
	public static ArrayList<Integer> printControl;
	
	public void distributeVolume(double totalVolume, Tree vTree){
		if (vTree == null)
			return;
		vTree.volume += totalVolume;
		double surplus = vTree.volume-vTree.capacity;
		if (surplus > 0) {
			vTree.volume = vTree.capacity;
			distributeVolume(surplus/2, vTree.left);
			distributeVolume(surplus/2, vTree.right);
		}
	}
	
	public void printTree(Tree vTree) {
		if (vTree == null || printControl.contains(vTree.value))
			return;
		printControl.add(vTree.value);
		System.out.print(vTree.value + " volume: " + vTree.volume);
		System.out.print(" left: " + (vTree.left == null ? "-" : vTree.left.value));
		System.out.println(" right: " + (vTree.right == null ? "-" : vTree.right.value));
		printTree(vTree.left);
		printTree(vTree.right);
	}
	
	public void emptyVolume(Tree vTree) {
		if (vTree == null)
			return;
		vTree.volume = 0;
		emptyVolume(vTree.left);
		emptyVolume(vTree.right);
	}
	
}