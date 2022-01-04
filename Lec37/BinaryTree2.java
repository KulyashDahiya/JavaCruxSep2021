package Lec37;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BinaryTree2 {
	
Scanner sc = new Scanner(System.in);
	
	private class Node{
		
		int data;
		Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
		
		public Node()
		{
			this(0);
		}
		
	}
	
	private Node root;
	
	public void createTree(int[] pre,int[] in)
	{
		root = createTreeUsingPreAndIn(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	
	private Node createTreeUsingPreAndIn(int[] pre,int[] in,int plo,int phi, int inlo, int inhi)
	{
		if(inlo>inhi)
		{
			return null;
		}
		else
		{
			Node r = new Node(pre[plo]);
			int idx = searchIn(in, inlo, inhi, pre[plo]);
			r.left = createTreeUsingPreAndIn(pre, in, plo+1, plo+idx-inlo , inlo, idx-1);
			r.right = createTreeUsingPreAndIn(pre, in, plo+idx-inlo+1, phi, idx+1, inhi);
			return r;
		}
	}
	
	private int searchIn(int[] arr,int si,int ei,int ele)
	{
		for(int i = si; i <= ei; i++)
		{
			if(ele == arr[i])
				return i;
		}
		return -1;
	}
	
	
	public void createTreeUsingLevelOrder()
	{
		root = new Node(sc.nextInt());
		Queue<Node> qt = new LinkedList<>();
		qt.add(root);
		
		while(!qt.isEmpty())
		{
			Node n = qt.remove();
			int l = sc.nextInt();
			int r = sc.nextInt();
			
			if(l != -1)
			{
				Node ln = new Node(l);
				n.left = ln;
				qt.add(ln);
			}
			
			if(r != -1)
			{
				Node rn = new Node(r);
				n.right = rn;
				qt.add(rn);
			}
		}
	}
	
	public int ht()
	{
		return ht(root);
	}
	
	private int ht(Node n)
	{
		if(n == null)
		{
			return -1;
		}
		else
		{
			int l = ht(n.left);
			int r = ht(n.right);
			return Math.max(l, r) + 1;
		}
	}
	
	public int dia()
	{
		return dia(root);
	}
	
	private int dia(Node n)
	{
		if(n == null)
			return 0;
		else
		{
			int ldia = dia(n.left);
			int rdia = dia(n.right);
			int d = ht(n.left) + ht(n.right) + 3;
			return Math.max(rdia, Math.max(ldia, d));
		}
	}
	
	
	private class DiaPair{
		int dia = 0;
		int ht = -1;
	}
	
	public int dia2()
	{
		return dia2(root).dia;
	}
	
	private DiaPair dia2(Node n)
	{
		if(n == null)
			return new DiaPair();
		else
		{
			DiaPair l = dia2(n.left);
			DiaPair r = dia2(n.right);
			DiaPair c = new DiaPair();
			
			c.dia = Math.max(l.dia, Math.max(r.dia, l.ht+r.ht+3));
			c.ht = Math.max(l.ht, r.ht) + 1;
			return c;
		}
	}
	
	
	
	public void leftTreeView()
	{
//		maxlvl = -1;
//		ltv1(root,0);
		ltv2(root,0,-1);
	}
	
	private static int maxlvl = -1;
	
	private static void ltv1(Node n,int lvl)
	{
		if(n == null)
			return;
		else
		{
			if(lvl > maxlvl)
			{
				System.out.println(n.data);
				maxlvl = lvl;
			}
			ltv1(n.left,lvl+1);
			ltv1(n.right,lvl+1);
		}
	}
	
	
	private static int ltv2(Node n,int lvl,int maxlvl)
	{
		if(n == null)
			return maxlvl;
		else
		{
			if(lvl > maxlvl)
			{
				System.out.println(n.data);
				maxlvl = lvl;

			}
			maxlvl = ltv2(n.left,lvl+1,maxlvl);
			
			return ltv2(n.right,lvl+1,maxlvl);
		}
	}
	
	public void display()
	{
		display(root);
	}
	
	private void display(Node n)
	{
		if(n == null)
		{
			return;
		}
		else
		{
			String s = "";
			if(n.left != null)
			{
				s = s + n.left.data;
			}
			s = s + " --> " + n.data +" <-- ";
			if(n.right != null)
			{
				s = s + n.right.data;
			}
			
			System.out.println(s);
			display(n.left);
			display(n.right);
		}
	}

}
