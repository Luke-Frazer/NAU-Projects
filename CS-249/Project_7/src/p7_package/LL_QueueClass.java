package p7_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class LL_QueueClass extends LL_IteratorClass
   {
      /**
       * Default constructor
       */
      public LL_QueueClass()
      {
         super();
      }
   
      /**
       * Copy Constructor
       * 
       * @param copied - LL_QueueClass object to be copied
       */
      public LL_QueueClass( LL_QueueClass copied )
      {
         super( copied );
      }
      
      /**
       * Clears queue
       */
      public void clear()
      {
         super.clear();
      }
   
      /**
       * Dequeues data, returns 
       * 
       * @return integer value from queue
       */
      public int dequeue()
      {
         // initialize variables/method
         int value;
         
         // check if the list is empty
         if( isEmpty() )
            {
               // get the value at current which is not found
               value = super.getValueAtCurrent();
            }
         
         // otherwise, it is not empty
         else
            {
               // set to the first value i.e. headRef
               super.setToFirst();
               
               // save the value at headRef
               value = super.getValueAtCurrent();
               
               // remove the current value
               super.removeAtCurrent();
            }
         
         // return the final value
         return value;
      }
      
      /**
       * Enqueues data
       * 
       * @param value - integer value to be enqueued
       */
      public void enqueue( int value )
      {
         // set value at the last node
         super.insertAtEnd( value );
         
         // set the current to the end
         super.setToLast();
      }
      
      /**
       * checks for empty
       * 
       * @return Boolean result of test
       */
      public boolean isEmpty()
      {
         // check if the list is empty
         return super.isEmpty();
      }
      
      /**
       * Views value at front of queue
       * 
       * @return integer value at front of queue
       */
      public int peekFront()
      {
         // initialize variables
         int value;
         
         // check if empty
         if( isEmpty() )
            {
               // set the value to current which is not found
               value = super.getValueAtCurrent();
            }
         
         // otherwise, it is not empty
         else
            {
               // set to the first value
               super.setToFirst();
         
               // save the current value
               value = super.getValueAtCurrent();
               
               // return the value
               return value;
            }
         
         // otherwise, return negative value to indicate not found
         return value;
      }
      
      
      
   }
