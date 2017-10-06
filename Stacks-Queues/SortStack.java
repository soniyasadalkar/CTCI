public class SortStack{

	public static void sort(MyStack<Integer> s){
		MyStack<Integer> r = new MyStack<Integer>();

		

		while(!s.isEmpty()){
			int tmp = s.pop();
			
			while(!r.isEmpty() && tmp < r.peek())
				s.push(r.pop());
			r.push(tmp);
		}

		while(!r.isEmpty())
			s.push(r.pop());

		System.out.println("\nAfter sort: ");
		while(!s.isEmpty())
			System.out.println("Elem: "+s.pop());
	}

 	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(100);
		stack.push(80);
		stack.push(2);
		stack.push(500);
		stack.push(10);

		sort(stack);

		

	}
}