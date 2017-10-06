import java.lang.*;

public class StackMin extends MyStack<NodeWithMin>{

	public void push(int val){
		int NewMin = Math.min(val, min());
		int newMax = Math.max(val, max());
		super.push(new NodeWithMin(val, NewMin, newMax));
	}

	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else
			return peek().min;
	}

	public int max(){
		if(this.isEmpty())
			return Integer.MIN_VALUE;
		else
			return peek().max;
	}

	public static void main(String[] args){
		StackMin stack = new StackMin();
		stack.push(10);
		stack.push(5);
		System.out.println("Min: "+stack.min()+" Max: "+stack.max());
		stack.push(100);
		System.out.println("Min: "+stack.min()+" Max: "+stack.max());
		stack.push(1);
		System.out.println("Min: "+stack.min()+" Max: "+stack.max());
	}
}

class NodeWithMin{
	public int min;
	public int value;
	public int max;

	public NodeWithMin(int v, int min, int max){
		this.min = min;
		this.max = max;
		value = v;
	}
}