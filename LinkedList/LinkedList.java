class LinkedList{
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

	public static void main(String args[]){
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
	}
}
