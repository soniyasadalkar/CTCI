public class StackWithMinExtraStack extends MyStack<Integer>{
	MyStack<Integer> sMin;
	MyStack<Integer> sMax;

	public StackWithMinExtraStack(){
		sMin = new MyStack<Integer>();
		sMax = new MyStack<Integer>();
	}

	public void push(int val){
		if(val < min())
			sMin.push(val);
		if(val > max())
			sMax.push(val);

		super.push(val);
	}

	public Integer pop(){
		int val = super.pop();
		if( val == min())
			sMin.pop();
		if( val == max())
			sMax.pop();

		return val;
	}

	public int min(){
		if(this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return sMin.peek();
	}

	public int max(){
		if(this.isEmpty())
			return Integer.MIN_VALUE;
		else
			return sMax.peek();
	}

	public static void main(String[] args){
		StackWithMinExtraStack
		 stack = new StackWithMinExtraStack();
		stack.push(10);
		stack.push(5);
		System.out.println("Min: "+stack.min()+" Max: "+stack.max());
		stack.push(100);
		System.out.println("Min: "+stack.min()+" Max: "+stack.max());
		stack.push(1);
		System.out.println("Min: "+stack.min()+" Max: "+stack.max());
	}
}