package p5_package;

/**
 * 
 * @author Luke Frazer
 *
 * Description: Java Queue class of generic data (classes)
 * <p>
 * Note: Only works with class that extends Comparable, as shown in class declaration
 * <p>
 * Note: Queue automatically resizes as needed
 * <p>
 * Note: Queue is maintained within array with front and rear indices rotated as needed to manage queue; array capacity is only increased when the queue array is full
 */

public class GenericQueueClass<GenericData extends Comparable<GenericData>>
   {
      
      /**
       *  constant for default size of queue
       */
      private static final int DEFAULT_CAPACITY = 10;
      
      /**
       *  constant use for space
       */
      private static final char SPACE = ' ';
      
      /**
       *  array holding queued items
       */
      private Object[] queueArray;
      
      /**
       *  queue size and capacity
       */
      private int queueSize;
      
      /**
       *  queue size and capacity
       */
      private int queueCapacity;

      /**
       * index of front and rear of queue
       */
      private int frontIndex;
      
      /**
       * index of front and rear of queue
       */
      private int rearIndex;
      
      /**
       * Default constructor, initializes queue to default capacity (10)
       */
      public GenericQueueClass()
      {
         // initialize front and rear index
         frontIndex = 0;
         rearIndex = -1;
         
         // initialize and instantiate the capacity
         queueCapacity = DEFAULT_CAPACITY;
         queueArray = new Object[ queueCapacity ];
         
         // set the queue size to zero
         queueSize = 0;
      }
      
      /**
       * Initializing constructor, initializes queue to specified capacity
       * 
       * @param capacity - maximum capacity specification for the queue
       */
      public GenericQueueClass( int capacity )
      {
         // initialize front and rear index
         frontIndex = 0;
         rearIndex = -1;
         
         // initialize and instantiate the capacity
         queueCapacity = capacity;
         queueArray = new Object[ queueCapacity ];
         
         // set the queue size to zero
         queueSize = 0;
         
      }
      
      /**
       * Clears queue of all valid values by setting array size to zero, 
       * values remain in array but are not accessible
       */
      public void clear()
      {
         // set the queue size to zero
         queueSize = 0;
      }
      
      /**
       * dequeues item from queue
       * 
       * @return dequeued value if successful, null if not
       */
      @SuppressWarnings("unchecked")
      public GenericData dequeue()
      {
         // get the front value
         GenericData frontVal = (GenericData)queueArray[ frontIndex ];
        
         // increment the rear index 
         frontIndex++;
         
         // mod rear by capacity
         frontIndex %= queueCapacity;
         
         // increase the size
         queueSize--;
         
         // return the front value that was dequeued
         return frontVal;
      }
      
      /**
       * Description: shows stack from front to rear
       * <p>
       * No display if stack is empty
       */
      @SuppressWarnings("unchecked")
      public void displayQueue()
      {
         // initialize variables
         GenericData queueFront = peekFront();
         GenericData queueRear = (GenericData)queueArray[ rearIndex ];
         GenericData location;
         int index;
         int numSpaces = 15;
         
         // check if the list is not empty
         if( !isEmpty() )
            {
               // print the stack top line
               System.out.print( "Queue Front: " );
               
               if( queueFront != null && queueFront != queueRear )
                  {
                     // print the top stack value
                     System.out.print( queueFront );
                     
                     // space it out
                     System.out.println();
                     
                     // print the spacing
                     printChars( numSpaces, SPACE );
                     
                     // increment the spacing by 2
                     numSpaces += 2;
               
                  }
         
               // loop through the stack and print out the data
               for( index = frontIndex; index != rearIndex; index++ )
                  {
                     // check to make sure you don't print the rear index twice
                     if( (GenericData)queueArray[ index + 1 ] != 
                                          (GenericData)queueArray[ rearIndex ])
                        {
                           // set the +current location data
                           location = (GenericData)queueArray[ index + 1 ];
                     
                           // print the data at the index location
                           System.out.print( location );

                           // space it out
                           System.out.println();
               
                           // print the spacing
                           printChars( numSpaces, SPACE );
                     
                           // increment the spacing by 2
                           numSpaces += 2;
                        }
               
                  }
               // end the loop
        
               // print the bottom line
               System.out.print( "Queue Rear: " );
         
               // check if the list is empty
               if( queueRear != null )
                  {
                     // print the top stack value
                     System.out.print( queueRear );
                  }
         
               // space it out
               System.out.println();
            }
      }
      
      /**
       * Description: Enqueues item into array
       * <p>
       * Checks for full queue and resizes as needed prior to data enqueue
       * 
       * @param newValue - GenericData value to be inserted into queue
       */
      public void enqueue( GenericData newValue )
      {
         
         if( isEmpty() )
            {
               // increment the rear index 
               rearIndex++;
               
               // mod rear by capacity
               rearIndex %= queueCapacity;
               
               // set the rear index location to the new value
               queueArray[ rearIndex ] = newValue;
               
               // increase the size
               queueSize++;
            }
         else 
            {
         
               // increment the rear index 
               rearIndex++;
               
               // mod rear by capacity
               rearIndex %= queueCapacity;
               
               // set the value at the rear index 
               queueArray[ rearIndex ] = newValue;
         
               // increase the size
               queueSize++;

               // resize if necessary
               resize();
            }
         
      }
      
      /**
       * Tests for size of queue equal to zero, no valid values stored in array
       * 
       * @return Boolean result of test for empty
       */
      public boolean isEmpty()
      {
         // initialize variables
         boolean flag = false;
         
         // test if the size is equal to zero
         if( queueSize == 0 )
            {
               // set the flag to true as it is empty
               flag = true;
            }
         
         // return the flag
         return flag;
      }
      
      /**
       * returns value at front of queue without dequeuing
       * 
       * @return GenericData front value if successful, null if not
       */
      @SuppressWarnings("unchecked")
      public GenericData peekFront()
      {
         // check if the array is empty
         if( isEmpty() )
            {
               // return null if it is empty
               return null;
            }
         
         // otherwise, return the value at the front
         return (GenericData)queueArray[ frontIndex ];
      }
      
      /**
       * Description: prints specified number of characters recursively
       * 
       * @param numChars - Integer value specifying number of characters
       * 
       * @param outChar - characters to be output
       */
      public void printChars( int numChars, char outChar )
      {
         // check if the requested number is greater than 0
         if( numChars > 0 )
            {
               // call again, reducing number by one 
               printChars( numChars - 1, outChar );
               
               // print a character
               System.out.print( outChar );
            }
         
         // if not greater than zero, do nothing
        
      }
      
      /**
       * Description: Resets array capacity to twice the current capacity
       */
      public void resize()
      {
         // initialize variables
         Object[] tempArray;
         queueCapacity *= 2;
         int locIndex = frontIndex;
         int index = 0;
         
         // check if the size is equal to the capacity
         if( queueSize == queueCapacity )
            {
         
               // create temp array with doubled capacity
               tempArray = new Object[ queueCapacity ];
               
               // loop from front to rear
               while( locIndex != rearIndex )
                  {
                     // set the temp array value to queue array value
                     tempArray[ index ] = queueArray[ index ];
               
                     // incrememnt the index
                     index++;
                     
                     // incrememnt the location index
                     locIndex++;
               
                     // modulo location index by the capacity in case it needs
                     // to wrap around
                     locIndex %= queueCapacity;
               
                  }
         
               // set the queue array to the temp array
               queueArray = tempArray;
         
               // set the front to zero
               frontIndex = 0;
         
               // set the rear to size - 1
               rearIndex = queueSize - 1;
      
            }
      }
   }
