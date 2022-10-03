// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
class StackX {
    private int maxSize;        // size of stack array
    private Objeto[] stackArray;
    private int top;            // top of stack

    //--------------------------------------------------------------
    public StackX(int s)         // constructor
    {
        maxSize = s;             // set array size
        stackArray = new Objeto[maxSize];  // create array
        top = -1;                // no items yet
    }

    //--------------------------------------------------------------
    public boolean push(Objeto j)    // put item on top of stack
    {
        if (isEmpty()) {
            stackArray[++top] = j;
            return true;
        } else if (stackArray[top].getPeso() > j.getPeso()) {
            stackArray[++top] = j;     // increment top, insert item
            return true;
        } else {
            return false;
        }
    }

    //--------------------------------------------------------------
    public Objeto pop()           // take item from top of stack
    {
        return stackArray[top--];  // access item, decrement top
    }

    //--------------------------------------------------------------
    public Objeto peek()          // peek at top of stack
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty()    // true if stack is empty
    {
        return (top == -1);
    }

    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return (top == maxSize - 1);
    }

    //--------------------------------------------------------------
    public void showStack() {
        for (Objeto objeto : stackArray) {
            System.out.println(objeto);
        }
    }

//--------------------------------------------------------------
}  // end class StackX
////////////////////////////////////////////////////////////////
/*class StackApp
   {
   public static void main(String[] args)
      {
      StackX theStack = new StackX(10);  // make new stack
      theStack.push(20);               // push items onto stack
      theStack.push(40);
      theStack.push(60);
      theStack.push(80);

      while( !theStack.isEmpty() )     // until it's empty,
         {                             // delete item from stack
         long value = theStack.pop();
         System.out.print(value);      // display it
         System.out.print(" ");
         }  // end while
      System.out.println("");
      }  // end main()
   }  // end class StackApp
////////////////////////////////////////////////////////////////*/
