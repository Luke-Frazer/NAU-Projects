package p7_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class LL_StackClass
   {
      /**
       * IteratorClass object used as data for class
       */
      LL_IteratorClass stackData;
      
      /**
       * Default constructor
       */
      public LL_StackClass()
      {
         stackData = new LL_IteratorClass();
      }
      
      /**
       * Copy Constructor
       * 
       * @param copied - LL_StackClass object to be copied
       */
      public LL_StackClass( LL_StackClass copied )
      {
         stackData = new LL_IteratorClass( copied.stackData );
      }
      
      /**
       * Clears all data
       */
      public void clear()
      {
         stackData.clear();
      }
      
      /**
       * checks for empty stack
       * 
       * @return Boolean result of test
       */
      public boolean isEmpty()
      {
         return stackData.isEmpty(); 
      }
      
      /**
       * Returns data from top of stack without removing
       * 
       * @return integer value at top of stack
       */
      public int peekTop()
      {
         // initialize variables
         int value;
         
         // check if the stack is empty
         if( isEmpty() )
            {
               // get the value at current which is not found
               value = stackData.getValueAtCurrent();
            }
         
         // otherwise, it is not empty
         else
            {
               // set to the end value
               stackData.setToLast();
               
               // get the current value
               value = stackData.getValueAtCurrent();
            }
         
         // return the final value
         return value;
      }
      
      /**
       * Removes data from top of stack
       * 
       * @return integer value at top of stack
       */
      public int pop()
      {
         // initialize variables
         int value;
         
         // check if empty
         if( isEmpty() )
            {
               // set value to current which will be not found
               value = stackData.getValueAtCurrent();
            }
         
         // otherwise, it is not empty
         else
            {
               // set to last value
               stackData.setToLast();
               
               // set the current value
               value = stackData.getValueAtCurrent();
               
               // remove the current value
               stackData.removeAtCurrent();
            }
         
         // return the final value
         return value;
      }
      
      /**
       * Places data at top of stack
       * 
       * @param value - integer value to be pushed onto stack
       */
      public void push( int value )
      {
         // append value to the end
         stackData.insertAtEnd( value );
      }
      
   }
