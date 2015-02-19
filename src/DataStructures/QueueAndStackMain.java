package DataStructures;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class QueueAndStackMain<T> {

	public static void main(String[] args) {

		/*
		 * 3 / \ / \ 1 4 / 2
		 */
		BinaryTreeNode root = new BinaryTreeNode(3);
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(4);
		BinaryTreeNode n3 = new BinaryTreeNode(2);
		BinaryTreeNode n4 = new BinaryTreeNode(5);

		// Build the damn tree

		root.left = n1;
		root.right = n2;
		root.right.left = n3;
		System.out.println("Inorder");
		inOrderTraversal(root);
		System.out.println("Preorder");
		preOrderTraversal(root);
		System.out.println("PostOrder");
		postOrderTraversal(root);
		System.out.println("LevelOrder");
		LevelOrderTraversal(root);
		System.out.println("ZigZagOrder");
		ZigZagOrderTraversal(root);
		System.out.println("Full b tree?");
		boolean b = isFullBTree(root);

		if (b)
			System.out.println("Yes");
		else
			System.out.println("No");

		int height = heightOfTree(root);
		System.out.println("Height of tree: " + height);
		System.out.println("Diameter of tree: " + diameterOfTree(root));
		BinaryTreeNode x = findLCA(root, 4,2);
		System.out.println("LCA: "+x.data);
		

		// int[][] array = new int[][]{{0,1,1},{0,0,1},{1,1,1}};
		// int rowCount = array.length;
		// int colCount = array[0].length;
		// int minRowIndex = 0;
		// int farthestOne = find(array[0]);
		// if(farthestOne==-1)
		// farthestOne = colCount - 1;
		// for(int i =1;i<rowCount; i++)
		// {
		// while(farthestOne!=-1 && array[i][farthestOne]==1 )
		// {
		// farthestOne=farthestOne-1;
		// minRowIndex = i-1;
		// }
		// }
		// System.out.println(minRowIndex);
		//
		// }
		//
		// public static int find(int[] arr)
		// {
		// for(int i=0;i<arr.length;i++)
		// if(arr[i]==1)
		// return i;
		// return -1;
		// }
		
		int[] a = new int[]{1,4,5,6,7,8};
		int find = BinaryRecursive(a,8,0,a.length-1);
		System.out.println("BT ITERATIVE: "+find);
		
		int[] a1= new int[]{1,2,3,4,5};
		int[] a2 = new int[]{6,7,8,9};
		
		mergeArray(a1,a2);
		
		System.out.println("WAYS"+ makeChange(25,100));
		
		int[] array1 = new int[]{1,2,3,5,7};
		int minElem = array1[0];
		int maxSum = 0;
		
		for(int i =1; i<array1.length ; i++)
		{
			if(array1[i]<minElem)
				minElem = array1[i];
			if(array1[i]-minElem>maxSum)
				maxSum = array1[i]-minElem;
		}
		System.out.println(maxSum+" MAMAMAMA");
		
		
		boolean golf = isStringAPalindrome("Hello olleH");
		boolean notgolf = isStringAPalindromeLetterComparison("Hello olleH");
		System.out.println("IS: "+golf+notgolf);
	}
	
	public static int makeChange(int denom,int n)
	{
		int next_denom=0;
		switch(denom)
		{
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
		case 5:
			next_denom = 1;
		case 1:
			return 1;
		}
		
		int ways=0;
		for(int i =0; i*denom<=n; i++)
		{
			ways+= makeChange(next_denom,n-i*denom);
			
		}
	return ways;
	
	}
	
	
	
	public static int[] mergeArray(int[] a, int [] b)
	{
		int[] c = new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length)
		{
			if(a[i]<b[j])
				c[k++]=a[i++];
			else
				c[k++] = b[j++];
		}
		while(i<a.length)
			c[k++] = a[i++];
		while(j<b.length)
			c[k++] = b[j++];
		
		return c;
		
	}
	public static int BinaryIterative(int[] a, int key)
	{
		int low = 0;
		int high = a.length-1;
		int mid;
		while(low<=high)
		{
			 mid = low + (high-low)/2;
			 if(a[mid]==key)
				 return mid+1;
			 else if(a[mid]>key)
				 high = mid-1;
			 else if (a[mid]<key)
				 low = mid + 1;
		}
		return -1;
	}
	
	public static int BinaryRecursive(int a[], int key, int low, int high)
	{
		if(low>high)
			return -1;
		int mid = low+(high-low)/2;
		if(a[mid]==key)
			return mid;
		else if(a[mid]>key)
			return BinaryRecursive(a,key,low,mid-1);
		else
			return  BinaryRecursive(a,key,mid+1,high);
	}
	public static void inOrderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}

	public static void preOrderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void postOrderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		System.out.println(root.data);
	}

	public static void LevelOrderTraversal(BinaryTreeNode root) {
		QUEUES<BinaryTreeNode> forManip = new QUEUES<BinaryTreeNode>();
		BinaryTreeNode tempNode = root;
		while (tempNode != null) {
			System.out.println(tempNode.data);
			if (tempNode.left != null)
				forManip.enQueue(tempNode.left);
			if (tempNode.right != null)
				forManip.enQueue(tempNode.right);
			tempNode = forManip.deQueue();
		}

	}
	public static boolean isStringAPalindrome(String input)
	{

	    boolean isPalindrome = input.replaceAll("[^A-Za-z]","").toLowerCase().equals(new StringBuilder(input.replaceAll("[^A-Za-z]","").toLowerCase()).reverse().toString());
	    return isPalindrome;


	}

	public static boolean isStringAPalindromeLetterComparison(String input)
	{
	       // String sanitizedInput = input.replaceAll("[^A-Za-z]","").toLowerCase();
	        
	        int length = input.length();
	        
	        char[] inputCharArray = input.toCharArray();
	        
	        for(int i=0; i<length; i++)
	        {
	                if(((inputCharArray[i]>=65 && inputCharArray[i]<=90) || (inputCharArray[i]>=97 && inputCharArray[i]<=122)) && inputCharArray[i]!=inputCharArray[length-i-1])
	                    return false;
	        }
	        return true;
	 }

	public static void ZigZagOrderTraversal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
		int ltor = 1;
		s1.push(root);
		while (!s1.isEmpty()) {
			BinaryTreeNode x = s1.pop();
			if (x != null) {
				System.out.println(x.data);
				if (ltor == 1) {
					if (x.left != null)
						s2.push(x.left);
					if (x.right != null)
						s2.push(x.right);
				} else {
					if (x.right != null)
						s2.push(x.right);
					if (x.left != null)
						s2.push(x.left);
				}
			}
			if (s1.isEmpty()) {
				ltor = 1 - ltor;
				Stack s = s1;
				s1 = s2;
				s2 = s;
			}
		}

	}

	public static boolean isFullBTree(BinaryTreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (isFullBTree(root.left) && isFullBTree(root.right))
			return true;
		return false;
	}

	public static int heightOfTree(BinaryTreeNode root) {
		if (root == null)
			return 0;
		else
			return (1 + Math.max(heightOfTree(root.left),
					heightOfTree(root.right)));
	}

	public static int diameterOfTree(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);
		return (Math
				.max(lheight+rheight+1, Math.max(diameterOfTree(root.left),
						diameterOfTree(root.right))));
	}

	public static BinaryTreeNode findLCA(BinaryTreeNode root, int n1, int n2) {

				if(root==null)
					return  null;
				if(root.data==n1||root.data==n2)
					return root;
				BinaryTreeNode lefter = findLCA(root.left,n1,n2);
				BinaryTreeNode righter = findLCA(root.right,n1,n2);
				
				if(lefter!=null && righter!=null)
					return root;
				
				return lefter!=null?lefter:righter;
				

	}
	
	
}