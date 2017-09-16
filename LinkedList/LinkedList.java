import java.util.*;

public class LinkedList{
	Node head;

	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void addAtBeginning(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;	
	}

	public void addAtEnd(int new_data){
		Node new_node = new Node(new_data);
		Node temp = head;
		if( temp == null)
		{
			head = new_node;
			return;
		}
		while( temp.next != null){
			temp = temp.next;
		}
		temp.next = new_node;
	}

	public void insertAfter(Node prev_node, int new_data){
		if( prev_node == null){
			System.out.println("Prev node cannot be empty\n");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	public void print(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+"\t");
			temp = temp.next;
		}
		System.out.println();
	}

	public void delete(int key){
		Node temp = head;
		if( temp != null && temp.data == key ){
			head = temp.next;
			return;
		}
		Node prev = null; 
		while( temp != null ){
			if( temp.data == key){
				prev.next = temp.next;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	public static void createList(LinkedList list, int[] arr){
		
		for( int element : arr){
			list.addAtEnd(element);
		}
	}

	public static void removeDuplicates(LinkedList list){
		Node prev = null;
		HashSet<Integer> set = new HashSet<Integer>();
		Node temp = list.head;
		while( temp != null){
			if( set.contains(temp.data)){
				prev.next = temp.next;
			}else{
				set.add(temp.data);
				prev = temp;
			}
			temp = temp.next;
		}	
	}

	public static void removeDuplicatesWithoutExtraSpace(LinkedList list){
		Node current = list.head;
		while( current != null){
			Node runner = current;
			while( runner.next != null){
				if( runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}

	class Index{
		public int value = 0;
	}
	public static Node kthNodetoLast_R(Node head, int k, Index idx){
		if(head == null)
			return null;
		Node node = kthNodetoLast_R(head.next, k, idx);
		idx.value = idx.value + 1;
		if( idx.value == k)
			return head;
		return node;
	}	
	public Node kthNodetoLast_R(LinkedList list, int k){
		Index idx = new Index();
		Node node = kthNodetoLast_R(this.head, k, idx);
		return node;
	}
	public static Node kthNodetoLast_I(LinkedList list, int k){
		Node p1 = list.head;
		Node p2 = list.head;
		for(int i = 0; i < k; ++i){
			if( p1 == null)
				return null;
			p1 = p1.next;
		}
		while( p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;	
	}

	public static void main(String args[]){
		/*
		LinkedList list = new LinkedList();
		list.addAtBeginning(1);
		list.addAtBeginning(2);
		list.addAtEnd(800);
		list.addAtBeginning(3);
		list.addAtEnd(400);
		list.insertAfter(list.head.next, 1000);
		list.insertAfter(list.head, -22);
		list.print();
		list.delete(3);
		list.print();
		list.delete(1);
		list.print();
		list.delete(400);
		list.print();
		list.delete(93);
		list.print();
		*/

		LinkedList list2 = new LinkedList();
		int[] elements = new int[]{11, 22, 33, 11, 44, 22, 11, 33, 55};
		createList(list2, elements);
		list2.print();
		/*	
		removeDuplicates(list2);
		list2.print();
		*/
		removeDuplicatesWithoutExtraSpace(list2);
		list2.print();

		//kth Node to last
		int k = 5;
		Node node = kthNodetoLast_I(list2, k);
		if( node != null)
			System.out.println(k+"th node to last is "+node.data);
		else
			System.out.println("Out of bounds");
		Node node_r = list2.kthNodetoLast_R(list2, k);
		if( node_r != null)
			System.out.println(k+"th node to last is "+node_r.data);
		else
			System.out.println("Out of bounds");
	}
}
