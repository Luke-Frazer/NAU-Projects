package p5_package;

/**
 * 
 * @author Luke Frazer
 *
 * Description: Class wrapper for a Java stack of generic data (classes)
 * <p>
 * Note: Only works with class that extends Comparable, as shown in class declaration
 * <p>
 * Note: Maintains a capacity value for maximum number of items that can be stored, and a size value for the number of valid or viable data items in the stack
 * 
 */
public class GenericStackClass<GenericData extends Comparable<GenericData>>
   {
      /**
       * constant for default size of queue
       */
      private static final int DEFAULT_CAPACITY = 10;
      
      /**
       * constant use for space
       */
      private static final char SPACE = ' ';
      
      /**
       * array holding stack items
       */
      private Object[] stackArray;
      
      /**
       * stack size and capacity
       */
      private int stackSize;
      
      /**
       * stack size and capacity
       */
      private int stackCapacity;
      
      /**
       * Default constructor, initializes stack to default capacity (10)
       */
      public GenericStackClass()
      {
         // set stackCapacity to the default capacity
         stackCapacity = DEFAULT_CAPACITY;
         
         // set the size value to 0
         stackSize = 0;
         
         // initialize the stack array with the default capacity
         stackArray = new Object[ stackCapacity ];
      }
      
      /**
       * Initializing constructor, initializes stack to specified capacity
       * 
       * @param capacity - maximum capacity specification for the stack
       */
      public GenericStackClass( int capacity )
      {
         // set stackCapacity to the initialized capacity
         stackCapacity = capacity;
         
         // set the size value to 0
         stackSize = 0;
         
         // initialize the stack array with the initialized capacity
         stackArray = new Object[ capacity ];
         
      }
      
      /**
       * Clears stack of all valid values by setting array size to zero, 
       * values remain in array but are not accessible
       */
      public void clear()
      {
         // set the size to zero
         stackSize = 0;
      }
      
      /**
       * Description: shows stack from top to bottom
       * <p>
       * No display if stack is empty
       */
      @SuppressWarnings("unchecked")
      public void displayStack()
      {
         // initialize variables
         GenericData stackTop = peekTop();
         GenericData stackBottom = (GenericData)stackArray[ 0 ];
         GenericData location;
         int index;
         int numSpaces = 13;
         
         // check if the list is not empty
         if( !isEmpty() )
            {
               // print the stack top line
               System.out.print( "Stack Top: " );
               
               if( stackTop != null && stackTop != stackBottom )
                  {
                     // print the top stack value
                     System.out.print( stackTop );
                     
                     // space it out
                     System.out.println();
                     
                     // print the spacing
                     printChars( numSpaces, SPACE );
                     
                     // increment the spacing by 2
                     numSpaces += 2;
               
                  }
         
               // loop through the stack and print out the data
               for( index = stackSize - 2; index > 0; index-- )
                  {
                     
                     // set the current location data
                     location = (GenericData)stackArray[ index ];
                     
                     // print the data at the index location
                     System.out.print( location );

                     // space it out
                     System.out.println();
               
                     // print the spacing
                     printChars( numSpaces, SPACE );
                     
                     // increment the spacing by 2
                     numSpaces += 2;
               
                  }
               // end the loop
        
               // print the bottom line
               System.out.print( "Stack Bottom: " );
         
               // check if the list is empty
               if( stackBottom != null )
                  {
                     // print the top stack value
                     System.out.print( stackBottom );
                  }
         
               // space it out
               System.out.println();
            }
      }
      
      /**
       * Tests for size of stack equal to zero, no valid values stored in array
       * 
       * @return Boolean result of test for empty
       */
      public boolean isEmpty()
      {
         // initialize variables
         boolean flag = false;
         
         // test if the size is equal to zero
         if( stackSize == 0 )
            {
               // set the flag to true as it is empty
               flag = true;
            }
         
         // return the flag
         return flag;
      }
      
      /**
       * returns value at top of stack without popping
       * 
       * @return GenericData front value if successful, null if not
       */
      @SuppressWarnings("unchecked")
      public GenericData peekTop()
      {
         // check if the array is empty
         if( isEmpty() )
            {
               // return null since there is no values
               return null;
            }
         
         // otherwise, return the value at the top of the stack 
         return (GenericData)stackArray[ stackSize - 1 ];
      }
      
      /**
       * pops item from stack 
       * 
       * @return GenericData popped value if successful, null if not
       */
      @SuppressWarnings("unchecked")
      public GenericData pop()
      {
         // initialize variables
         GenericData success = null;
         
         // check if the size is 0
         if( isEmpty() )
            {
               // return success which is null by default as there are no values
               return success;
            }
         
         // otherwise, you can pop the value at the size location
         stackSize--;
         
         // set the success to the popped value
         success = (GenericData)stackArray[ stackSize ];
         
         // return the popped value
         return success;
      }
      
      /**
       * Description: prints specified number of characters recursively
       * 
       * @param numChars - integer value specifying number of characters
       * 
       * @param outChar - character to be output
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
       * Description: pushes item onto array
       * <p>
       * Checks for full stack and resizes as needed prior to data push
       * 
       * @param newValue - GenericData value to be pushed onto stack
       */
      public void push( GenericData newValue )
      {
         
         // resize the stack
         resize();
         
         // push the new value to the stack
         stackArray[ stackSize ] = newValue;
         
         // increment the size
         stackSize++;
      }
      
      /**
       * Description: Resets array capacity to twice the current capacity
       */
      public void resize()
      {
         // initialize variables
         stackCapacity *= 2;
         int index;
         
         // check if the size is full
         if( stackSize == stackCapacity )
            {
         
               // create the new temporary array
               Object[] tempArray = new Object[ stackCapacity ];
         
               // loop through the stack size and copy over each value to the temp 
               // array
               for( index = 0; index < stackSize; index++ )
                  {
                     // set the current temp value to the stack array value
                     tempArray[ index ] = stackArray[ index ];
                  }
               // end the loop
         
               // set the stack array to the temp array
               stackArray = tempArray;
            }
      }
      
   }
