import java.util.NoSuchElementException;

public class MyQueue<T>{
	private class QueueNode<T>{
		private T item;
		private QueueNode<T> next;

		public QueueNode(T item){
			this.item = item;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item){
		QueueNode<T> t = new QueueNode<T>(item);
		if( last != null)
			last.next = t;
	       last = t;
       		if( first == null)
	 		first = last;		
	}

	public T remove(){
		if(first == null)
			throw new NoSuchElementException();
		T item = first.item;
		first = first.next;
		if( first == null)
			last = null;
		return item;
	}
	
	public T peek(){
		if( first == null)
			throw new NoSuchElementException();
		return first.item;	
	}

	public boolean isEmpty(){
		return first == null;
	}

	public static void main(String args[]){
		MyQueue<Integer> q = new MyQueue<Integer>();
		System.out.println(q.remove());
		q.add(10);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());

	}
}
