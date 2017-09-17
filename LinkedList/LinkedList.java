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

	public static Node PartitionList(Node node, int x){
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		while( node != null){
			Node next = node.next;
			node.next = null;
			if( node.data < x){
				if(beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else{
				if(afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				}else{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if( beforeStart == null)
			return afterStart;
		beforeEnd.next = afterStart;
		
		return beforeStart;
	}

	public static Node PartitionListUnstable(Node node, int x){
		Node head = node;
		Node tail = node;

		while(node != null){
			Node next = node.next;
			if( node.data < x){
				node.next = head;
				head = node;
			}
			else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}

	/* makes use of additional space & digits of the number are represented in reverse order*/
	public Node SumLists(Node first, Node second){
		Node res = null;
		Node prev = null;
		Node temp = null;
		int carry = 0, sum = 0;
		while( first != null || second != null){
			sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;
			carry = ( sum >= 10 ) ? 1 : 0;
			sum = (sum % 10);
			temp = new Node(sum);

			if( res == null)
				res = temp;
			else
				prev.next = temp;
			prev = temp;

			if( first != null)
				first = first.next;
			if (second != null )
				second = second.next;
		}
		if ( carry > 0 )
			temp.next = new Node(carry);
		return res;	
	}

	/* Without using extra space and digits are in same order as the number */
	class PartialSum{
		public Node sum = null;
		int carry = 0;
	}

	public static int length(Node node){
		int length = 0;
		while (node != null){
			++length;
			node = node.next;
		}
		return length;
	}
	public Node SumListsRec(Node first, Node second){
		int len1 = length(first);
		int len2 = length(second);
		if( len1 < len2 )
			first = padList(first, len2 - len1);
		else
			second = padList(second, len1 - len2);

		PartialSum sum = this.addLists(first, second);

		if( sum.carry == 0)
			return sum.sum;
		else{
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	public  Node padList(Node node, int padding){
		Node head = node;
		for( int i = 0; i < padding; ++i)
			head = insertBefore(head, 0);
		return head;
	}

	public  PartialSum addLists(Node first, Node second){
		if( first == null && second == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addLists(first.next, second.next);
		int val = sum.carry + first.data + second.data;

		Node res = insertBefore(sum.sum, val % 10);
		sum.sum = res;
		sum.carry = val / 10;
		return sum;
	}

	public  Node insertBefore(Node node, int val){
		Node new_node = new Node(val);
		if( node != null)
			new_node.next = node;
		return new_node;
	}

	public boolean isPalindrome(Node head)
	{
		Node reversed = reverseList(head);
		LinkedList l = new LinkedList();
		l.head = reversed;
		System.out.println("reversed list");
		l.print();
		return isEqual(head, reversed);
	}

	public Node reverseList(Node node){
		Node reverse_head = null;
		while(node != null){
			Node n = new Node(node.data);
			n.next = reverse_head;
			reverse_head = n;
			node = node.next;
		}
		return reverse_head;
	}

	public boolean isEqual(Node first, Node second){
		while( first != null && second != null){
			if( first.data != second.data)
				return false;
			first = first.next;
			second = second.next;
		}
		return (first == null) && (second == null);
	}

	/*is palindrome using stack */
	public boolean isPalindromeStack(Node head){
		Stack<Integer> st = new Stack<Integer>();
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			st.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null)
			slow = slow.next;

		while(slow != null){
			int top = st.pop().intValue();
			if( top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
	/* Recursive approach */
	class Result{
		public Node node;
		public boolean result;
		public Result(Node n, boolean r){
			node = n;
			result = r;
		}
	}
	public boolean isPalindromeRec(Node node){
		int len = length(head);
		Result res = isPalindromeHelper(node, len);
		return res.result;
	}	

	public Result isPalindromeHelper(Node node, int len){
		if( node == null || len <= 0)
			return new Result(node, true);
		else if ( len == 1)
			return new Result(node.next, true);
		
		Result res = isPalindromeHelper(node.next, len - 2);
		if( !res.result || res.node == null)
			return res;
		res.result = (node.data == res.node.data);
		
		res.node = res.node.next;

		return res;
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
		
		/* Partition a list around 'x' */
		LinkedList list3 = new LinkedList();
		int[] elements2 = new int[]{3,5,8,5,10,2,1};
		createList(list3, elements2);
		list3.print();
		//list3.head = PartitionList(list3.head, 5);
		list3.head = PartitionListUnstable(list3.head, 5);
		list3.print();

		/* Sum of two numbers reperesented by linked list */
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		int[] e1 = new int[]{7,5,9,4,6};
		int[] e2 = new int[]{8,4};
		createList(l1, e1);
		createList(l2, e2);
		LinkedList res_list = new LinkedList();
		res_list.head = res_list.SumLists(l1.head, l2.head);
		res_list.print();

		/* Sum of two numbers  - recursion */

		LinkedList l3 = new LinkedList();
		LinkedList l4 = new LinkedList();
		int[] e3 = new int[]{ 5,6,3,1};
		int[] e4 = new int[]{8,4,2};
		createList(l3, e3);
		createList(l4, e4);
		LinkedList res_list1 = new LinkedList();
		res_list1.head = res_list1.SumListsRec(l3.head, l4.head);
		res_list1.print();

		/* Check if a list is palindrome */
		LinkedList l5 = new LinkedList();
		int[] e5 = new int[]{0,1,1,0};
		createList(l5, e5);
		if(l5.isPalindrome(l5.head))
			System.out.println("list is palindrome");
		else
			System.out.println("list is not a palindrome");

		/*Approach using Stack */
		if(l5.isPalindromeStack(l5.head))
			System.out.println("list is palindrome");
		else
			System.out.println("list is not a palindrome");

		/* Recursive approach */
		if(l5.isPalindromeRec(l5.head))
			System.out.println("list is palindrome");
		else
			System.out.println("list is not a palindrome");

	}
}
