package p6_package;

/**
 *  
 * Description: Simple iterator class that manages integers
 * <p>
 * Note: Automatically resizes as needed
 * 
 * @author Luke Frazer
 *
 */
public class IteratorClass
   {

      /**
       *  constant for default size of iterator
       */
      private static final int DEFAULT_CAPACITY = 10;
      
      /**
       *  constant use for not found
       */
      private static final int NOT_FOUND = -1;
      
      /**
       *  constant use for left bracket
       */
      private static final char LEFT_BRACKET = '[';
      
      /**
       *  constant use for right bracket
       */
      private static final char RIGHT_BRACKET = ']';
      
      /**
       *  constant use for space
       */
      private static final char SPACE = ' ';
      
      /**
       *  array holding items
       */
      private int[] iteratorArray;
      
      /**
       *  iterator size and capacity
       */
      private int iteratorSize;
      
      /**
       *  iterator size and capacity
       */
      private int iteratorCapacity;
      
      /**
       *  index of current index of iterator
       */
      private int currentIndex;
      
      /**
       *  Default constructor, initializes iterator to default capacity (10)
       */
      public IteratorClass()
      {
         // set the capacity
         iteratorCapacity = DEFAULT_CAPACITY;
         
         // set the size
         iteratorSize = 0;
         
         // set the current index
         currentIndex = 0;
         
         // initialize the array
         iteratorArray = new int[ iteratorCapacity ];
      }
      
      /**
       *  Initializing constructor, initializes iterator to specified capacity
       * @param capacity - initial capacity specification for the iterator
       */
      public IteratorClass( int capacity )
      {
         // set the capacity
         iteratorCapacity = capacity;
         
         // set the size
         iteratorSize = 0;
         
         // set the current index
         currentIndex = 0;
         
         // initialize the array
         iteratorArray = new int[ iteratorCapacity ];
      }
      
      /**
       *  Clears iterator of all valid values by setting array size and 
       *  current index to zero, values remain in array but are not accessible
       */
      public void clear()
      {
         // set array size to zero
         iteratorSize = 0;
         
         // set current index to zero
         currentIndex = 0;
      }
      
      /**
       *  Description: shows iterator from beginning to end with brackets
       *  around current index
       *  <p>
       *  Displays "Empty" if iterator is empty
       */
      public void displayIterator()
      {
         // initialize variables
         int index;
         
         // check if the array is not empty
         if( !isEmpty() )
            {
               // print the title line
               System.out.print( "Iterator: " );
               
               // loop from beginning to end
               for( index = 0; index < iteratorSize; index++ )
                  {
                     // check if the index is equal to current index 
                     if( index == currentIndex )
                        {
                           // print this index with brackets around it
                           System.out.print( "" + LEFT_BRACKET + 
                               iteratorArray[ index ] + RIGHT_BRACKET + SPACE );
                        }
                     
                     // otherwise, pring the value at the current location
                     else
                        {
                           System.out.print( "" + iteratorArray[ index ] + 
                                                                        SPACE );
                        }
                  }
               
               // print the endline
               System.out.println();
            }
         
         // otherwise, the array is empty
         else
            {
               // print empty
               System.out.println( "Empty" );
            }
            
      }
      
      /**
       * returns value at current index
       * 
       * @return integer value at current index
       */
      public int getValueAtCurrent()
      {
         // return the integer value at current index
         return iteratorArray[ currentIndex ];
      }
      
      /**
       * checks for next element available in iterator
       * <p>
       * Note: Use one line of code
       * 
       * @return Boolean result of test
       */
      public boolean hasNext()
      {
         
         // TODO check if this works when iterator is at the end
         // return state of if the next value is not zero
         return ( !isEmpty() && currentIndex + 1 < iteratorSize );
      }
      
      /**
       * checks for previous element available in iterator
       * <p>
       * Note: Uses one line of code
       * 
       * @return Boolean result of test
       * 
       */
      public boolean hasPrev()
      {
         // return state of if the previous value is not zero
         return ( !isEmpty() && currentIndex - 1 != NOT_FOUND );
      }
      
      /**
       * inserts item into iterator at current index
       * <p>
       * Note: Must check for resize after operation
       * 
       * @param newVal - integer value to be inserted
       */
      public void insertAtCurrent( int newVal )
      {
         // initialize variables
         int index;
         
         // loop from end to the beginning of the array
         for( index = iteratorSize; index > currentIndex; index-- )
            {
               // set the previous value to the current value
               iteratorArray[ index ] = iteratorArray[ index - 1 ];
            }
         
         // set the beginning value to the new value
         iteratorArray[ currentIndex ] = newVal;
         
         // increment the size
         iteratorSize += 1;
         
         // check for resize
         resize();
      }
      
      /**
       * inserts item into iterator at end of iterator
       * <p>
       * Note: Does not affect current index
       * <p>
       * Note: Must check for resize after operation
       * 
       * @param newVal - integer value to be inserted
       */
      public void insertAtEnd( int newVal )
      {
         // set the new value to the end size location of the array
         iteratorArray[ iteratorSize ] = newVal;
         
         // increment the array size
         iteratorSize += 1;
         
         // check for resize
         resize();
         
      }
      
      /**
       * inserts item into iterator at beginning of iterator
       * <p>
       * Note: Does not affect current index
       * <p>
       * Note: Must check for resize after operation
       * 
       * @param newVal - integer value to be inserted
       */
      public void insertAtFront( int newVal )
      {
         // initialize variables
         int index;
         int beginning = 0;
         
         // loop from end to the beginning of the array
         for( index = iteratorSize; index > beginning; index-- )
            {
               // set the previous value to the current value
               iteratorArray[ index ] = iteratorArray[ index - 1 ];
            }
         
         // set the beginning value to the new value
         iteratorArray[ beginning ] = newVal;
         
         // increment the size
         iteratorSize += 1;
         
         // check for resize
         resize();
      }
      
      /**
       * moves current index to the right, if not at end
       * 
       * @return Boolean result of action
       */
      public boolean moveNext()
      {
         // check if the array has a next value to iterate to 
         if( hasNext() )
            {
               // set the current index to the next value
               currentIndex += 1;
               
               // return true since it was successful
               return true;
            }
         
         // otherwise, it is at the end and returns false
         return false;
      }
      
      /**
       * moves current index to the left, if not at beginning
       * 
       * @return Boolean result of action
       */
      public boolean movePrev()
      {
         // check if the array has a previous value to iterate to 
         if( hasPrev() )
            {
               // set the current index to the next value
               currentIndex -= 1;
               
               // return true since it was successful
               return true;
            }
         
         // otherwise, it is at the end and returns false
         return false;
      }
      
      /**
       * Tests for size of array equal to zero, no valid values stored in array
       * 
       * @return Boolean result of test for empty
       */
      public boolean isEmpty()
      {
         // return if the size is zero
         return ( iteratorSize == 0 );
      }
      
      /**
       * removes item from iterator at current index
       * <p>
       * Must resolve condition if last item removed
       * 
       * @return integer value if successful, NOT_FOUND if not
       */
      public int removeAtCurrent()
      {
         // initialize variables
         int index;
         int removedVal;
         
         // check if the array is not empty
         if( !isEmpty() )
            {
               // set the value to be removed
               removedVal = iteratorArray[ currentIndex ];
               
               // loop from end to the beginning of the array
               for( index = currentIndex; index < iteratorSize; index++ )
                  {
                     // set the previous value to the current value
                     iteratorArray[ index ] = iteratorArray[ index + 1 ];
                  }
               
               // decrement the size
               iteratorSize -= 1;
               
               // check if the current index is out of bounds
               if( iteratorArray[ currentIndex ] == 0 )
                  {
                     // set the current index to the size value
                     setToLast();
                  }
               
               // return the value that was removed
               return removedVal;
               
            }
         
         // otherwise, the array was empty and the value was not found
         return NOT_FOUND;
      }
      
      /**
       * Description: Resets array capacity to twice the current 
       * capacity only as needed
       */
      public void resize()
      {
         // initialize variables
         int doubleCapacity = 2;
         int index;
         int[] tempArray;
         
         // check if the size is equal to the capacity
         if( iteratorSize == iteratorCapacity )
            {
               // double size
               iteratorCapacity *= doubleCapacity;
               
               // create temporary array
               tempArray = new int[ iteratorCapacity ];
               
               // loop through array and copy values over to temp array
               for( index = 0; index < iteratorSize; index++ )
                  {
                     // set the temp location to array's value
                     tempArray[ index ] = iteratorArray[ index ];
                  }
               
               // set the iterator Array to the temp array
               iteratorArray = tempArray;
            }
         
         // otherwise, there is no need to resize
      }
      
      /**
       * sets current index to beginning
       * 
       * @return Boolean result of action
       */
      public boolean setToFirst()
      {
         // check if the array is not empty
         if( !isEmpty() )
            {
               // set the current index to zero
               currentIndex = 0;
               
               // return true since it was successful
               return true;
            }
         
         // otherwise, the array was empty and return false since it failed
         return false;
      }
      
      /**
       * sets current index to end
       * 
       * @return Boolean result of action
       */
      public boolean setToLast()
      {
         // check if the array is not empty
         if( !isEmpty() )
            {
               // set the current index to the last value
               currentIndex = iteratorSize - 1;
               
               // return true since it was successful
               return true;
            }
         
         // otherwise, the array was empty and return false since it failed
         return false;
      }
      
   }
