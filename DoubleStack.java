import java.util.Stack;

public class DoubleStack {
	private Stack<Double> stack;

   public static void main (String[] argum) {
      DoubleStack first= new DoubleStack();
      first.push(3.5);
      first.push(4.5);
      
      try {
		DoubleStack firstClone= (DoubleStack)first.clone();
		System.out.println(first.equals(firstClone));
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
            
   }

   DoubleStack() {
	   this.stack= new Stack<Double>();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
	   DoubleStack temporary = new DoubleStack();
	   DoubleStack clone = new DoubleStack();
	   
	   int stackSize= this.stack.size();
	   for (int i = 0; i < stackSize; i++) {
		   double temp = this.stack.pop();
		   temporary.push(temp);
	   }
	   for (int i = 0; i < stackSize; i++) {
		   double temp = temporary.pop();
		   clone.push(temp);	
		   this.stack.push(temp);
		   	
	   }
	   
	   return clone;
	   
   }

   public boolean stEmpty() {
	  if(this.stack.isEmpty()){
		  return true;
	  } 
      return false; 
   }

   public void push (double a) {
      this.stack.push(a);
	   
   }

   public double pop() {
      return this.stack.pop();
   } // pop

   public void op (String s) {
      double first = pop();
      double second = pop();
      
      if(s.equals("+")){
    	  push(second+first);
      }else if(s.equals("-")){
    	  push(second-first);
      }else if(s.equals("*")){
    	  push(second*first);
      }else if(s.equals("/")){
    	  push(second/first);
      }
   }
  
   public double tos() {
      return stack.peek(); 
   }

   @Override
   public boolean equals (Object o) {
	  if(o==null)
		  return false;
	  if(!(o instanceof DoubleStack)) 
		  return false;
	  
	  DoubleStack other = (DoubleStack)o;
	  if(this.stack.equals(other.stack))
		  return true;
	  
      return false;
   }

   @Override
   public String toString() {
	   if (stEmpty()){
		   return "Stack is empty";
	   }
	   
      StringBuffer stackData = new StringBuffer();
      
      for (int i = 0; i < stack.size(); i++) {
    	  stackData.append(stack.get(i).toString() + " ");
      }
      return stackData.toString();
      
	   
   }

   public static double interpret (String pol) {
      return 0.; // TODO!!! Your code here!
   }

}

