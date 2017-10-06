public class QueueViaStacks<T>{
	MyStack<T> stackNewest, stackOldest;

	public QueueViaStacks(){
		stackOldest = new MyStack<T>();
		stackNewest = new MyStack<T>();
	}

	public void add(T val){
		// stackNewest always has the newest elements.
		stackNewest.push(val);
	}

	public void shiftStacks(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
		}
	}
	public T peek(){
		shiftStacks();
		return stackOldest.peek();
	}
	public T remove(){
		shiftStacks();
		return stackOldest.pop();
	}

	 public static void main(String[] args) {
		QueueViaStacks<Integer> queue = new QueueViaStacks<Integer>();
		queue.add(100);
		System.out.println(queue.peek());
		queue.add(200);
		System.out.println(queue.peek());
		queue.add(300);
		System.out.println(queue.peek());
		queue.remove();
		System.out.println(queue.peek());	
	}
}