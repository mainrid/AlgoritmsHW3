import java.util.Stack;

public class DoubleStack {
	private Stack<Double> stack;

   public static void main (String[] argum) {
      // TODO!!! Your tests here!
   }

   DoubleStack() {
	   this.stack= new Stack<Double>();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return this; // TODO!!! Your code here!
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
      // TODO!!!
   }
  
   public double tos() {
      return stack.peek(); // TODO!!! Your code here!
   }

   @Override
   public boolean equals (Object o) {
      return true; // TODO!!! Your code here!
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

