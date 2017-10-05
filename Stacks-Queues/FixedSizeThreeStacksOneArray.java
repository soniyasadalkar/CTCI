import java.util.EmptyStackException;


class FixedSizeThreeStacksOneArray{
	private int numOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public FixedSizeThreeStacksOneArray(int stackSize){
		stackCapacity = stackSize;
		values = new int[numOfStacks * stackCapacity];
		sizes = new int[numOfStacks];
	}

	public void push(int stackNum, int val) throws Exception{
		if(isFull(stackNum))
			throw new Exception("Stack is full\n");

		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = val;
	}

	public boolean isFull(int stackNum){
		return stackCapacity == sizes[stackNum];
	}

	public int indexOfTop(int stackNum){
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	public int pop(int stackNum){
		if(isEmpty(stackNum))
			throw new EmptyStackException();

		int topIndex = indexOfTop(stackNum);
		int val = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return val;
	}

	public int peek(int stackNum){
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		return values[indexOfTop(stackNum)];
	}

	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}

	public static void main(String[] args){
		FixedSizeThreeStacksOneArray mystack = new FixedSizeThreeStacksOneArray(3);

		try{
			//System.out.println(mystack.peek(0));
			mystack.push(0, 10);
			mystack.push(0, 20);
			mystack.push(0, 30);
			//mystack.push(0, 40);
			System.out.println(mystack.peek(0));
			System.out.println(mystack.pop(0));
			mystack.push(1, 100);
			System.out.println(mystack.peek(1));
			mystack.push(2, 1000);
			System.out.println(mystack.peek(2));
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		

	}
}