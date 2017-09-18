import java.util.NoSuchElementException;

public class MyQueue<T>{
	private class QueueNode<T>{
		private T item;
		private QueueNode<T> next;

		public QueueNode(T item){
			this.item = item;
		}
	}

	
}
