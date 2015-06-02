public class Calculator
{
	private Stack<Float> stack;
	
	public Calculator()
	{
		stack = new Stack<Float>();
	}

	public Float getX()
	{
		return stack.peek();
	}
	
	public void enter(Float x)
	{
		stack.push(x);
	}
	
	public void operation(Character o)
	{
		float x = stack.pop();
		float y = stack.pop();
		
		switch(o)
		{
			case '+': 
				stack.push(x+y); 	
			break;
			
			case'-':
				stack.push(y-x);
			break;
			
			case'*':
				stack.push(x*y);
			break;
			
			case'/':
				stack.push(y/x);
			break;
			case'^':
				stack.push((float)Math.pow(y, x));
				break;
		}
	}	
}
