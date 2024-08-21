package p10_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class OpCodeHeapClass
   {

      /**
       * Initial array capacity
       */
      public final int DEFAULT_ARRAY_CAPACITY = 10;
      
      /**
       * Array for heap
       */
      private OpCodeClass[] heapArray;
      
      /**
       * Management data for array
       */
      private int arraySize;
      
      /**
       * Management data for array
       */
      private int arrayCapacity;
      
      /**
       * Display flag can be set to observe bubble up 
       * and trickle down operations
       */
      private boolean displayFlag;
      
      /**
       * Default constructor sets up array management 
       * conditions and default display flag setting
       */
      public OpCodeHeapClass()
      {
         // initialize the array capacity
         arrayCapacity = DEFAULT_ARRAY_CAPACITY;
         
         // set array size to 0
         arraySize = 0;
         
         // initialize array
         heapArray = new OpCodeClass[ arrayCapacity ];
         
         // set default display flag
         displayFlag = false;
      }
      
      /**
       * Copy constructor copies array and array 
       * management conditions and default display flag setting
       * 
       * @param copied object
       */
      public OpCodeHeapClass( OpCodeHeapClass copied )
      {
         // initialize variables
         int index; 
         
         // set array capacity
         arrayCapacity = copied.arrayCapacity;
         
         // set the size
         arraySize = copied.arraySize;
         
         // initialize array
         heapArray = new OpCodeClass[ arrayCapacity ];
         
         // set copied display flag
         displayFlag = copied.displayFlag;
         
         // loop through the array
         for( index = 0; index < arrayCapacity; index++ )
            {
               // copy the element at the current index
               heapArray[ index ] = new OpCodeClass(copied.heapArray[ index ]);
            }
      }
      
      /**
       * Accepts OpCodeData item and adds it to heap
       * <p>
       * Note: uses bubbleUpArrayHeap to resolve 
       * unbalanced heap after data addition
       * <p>
       * Note: must check for resize before attempting to add an item
       * 
       * @param newItem - OpCodeClass data item to be added 
       */
      public void addItem( OpCodeClass newItem )
      {
         // check for resize
         checkForResize();
         
         // print line for adding data
         System.out.println();
         System.out.println();
         System.out.print( "Adding new Process: " + newItem );
         
         // add the item to the end of the array
         heapArray[ arraySize ] = newItem;
         
         // call the bubbleUpArrayHeap method to resolve unbalanced heap
         bubbleUpArrayHeap( arraySize );
         
         // increment arraySize
         arraySize++;
      }
      
      /**
       * Note: must check for resize before attempting to add an item
       * 
       * @param currentIndex - index of current item being assessed, 
       * and moved up as needed
       */
      private void bubbleUpArrayHeap( int currentIndex )
      {
         // initialize variables
         int parentIndex = ( currentIndex - 1 ) / 2;
         OpCodeClass placeholder;
         OpCodeClass printParent = null, printChild = null;
         
         // check if not at the root
         if( currentIndex != 0 )
            {
               // check if less than parent
               if( heapArray[ currentIndex ].compareTo(
                                              heapArray[ parentIndex ] ) < 0 )
                  {
                     // save printParent and printChild
                     printParent = heapArray[ parentIndex ];
                     printChild = heapArray[ currentIndex ];
                     
                     // save placeholder for swapping
                     placeholder = heapArray[ parentIndex ];
                     
                     // swap with parent using the placeholder
                     heapArray[ parentIndex ] = heapArray[ currentIndex ];
                     heapArray[ currentIndex ] = placeholder;
                  
                     // check for displayFlag
                     if( displayFlag )
                        {
                           // print bubble up title
                           System.out.println();
                           System.out.println( "   - Bubble up:" );
                     
                           // print swapping data
                           System.out.print( "     - Swapping parent: " + 
                                 printParent + " with child: " + printChild );
                        }
                  }
               // call recursion on the parent
               bubbleUpArrayHeap( parentIndex );
            }
         
         // end recursion
      }
      
      /**
       * Automatic resize operation used prior to 
       * any new data addition in the heap
       * <p>
       * Tests for full heap array, and resizes to 
       * twice the current capacity as required
       */
      private void checkForResize()
      {
         // initialize variables
         OpCodeClass[] tempArray;
         int index;
         
         // check if the size is equal to capacity
         if( arraySize == arrayCapacity )
            {
               // set capacity to twice it's size
               arrayCapacity *= 2;
               
               // set a temp array with the new capacity
               tempArray = new OpCodeClass[ arrayCapacity ];
               
               // loop through the array and copy the data to the new temp
               for( index = 0; index < arraySize; index++ )
                  {
                     // copy the data in the main array to the temp array
                     tempArray[index] = heapArray[ index ];
                  }
               
               // set the heap array to the copied array
               heapArray = tempArray;
            }
      }
      
      /**
       * Tests for empty heap
       * 
       * @return boolean result of test
       */
       public boolean isEmpty()
       {
          // return if size is 0
          return ( arraySize == 0 );
       }
       
       /**
        * Removes OpCodeClass data item from top of min heap, 
        * thus being the operation with the lowest priority value
        * <p>
        * Note: Uses trickleDownArrayHeap to resolve 
        * unbalanced heap after data removal
        * 
        * @return OpCodeClass item removed
        */
       public OpCodeClass removeItem()
       {
          // initialize variables
          OpCodeClass removedVal;
          int root = 0;
          
          // save the value at root
          removedVal = heapArray[ 0 ];
          
          // print line for adding data
          System.out.println();
          System.out.print( "RemovingProcess: " + removedVal);
          
          // swap removed val with the val at end of array
          heapArray[ root ] = heapArray[ arraySize - 1 ];
          heapArray[ arraySize - 1] = removedVal;
          
          // call trickle down method on the root
          trickleDownArrayHeap( root );
          
          // decrease size
          arraySize--;
          
          // print endline
          System.out.println();
          
          // return the removed val
          return removedVal;
       }
       
       /**
        * Utility method to set the display flag for displaying 
        * internal operations of the heap bubble and trickle operations
        * 
        * @param setState - flag used to set the state to display, or not
        */
       public void setDisplayFlag( boolean setState )
       {
          // set the display flag to the setState variable
          displayFlag = setState;
       }
       
       /**
        * Dumps array to screen as is, no filtering or management
        */
       public void showArray()
       {
          // initialize variables
          int index;
          String separator = " | ";
          
          // print endline
          System.out.println();
          
          // loop through the array
          for( index = 0; index < arraySize; index++ ) 
             {
                // print the data at the current location
                System.out.print( heapArray[ index ] + separator );
             }
          
          // print an endline
          System.out.println();
       }
       
       /**
        * Recursive operation to reset data in the correct 
        * order for the min heap after data removal
        * 
        * @param currentIndex - index of current item being assessed, 
        * and moved down as required
        */
       private void trickleDownArrayHeap( int currentIndex )
       {
          // initialize variables
          int leftIndex, rightIndex;
          OpCodeClass placeholder;
          OpCodeClass printChild = null, printParent = null;
          
          // set left and right child
          leftIndex = ( currentIndex * 2 ) + 1;
          rightIndex = ( currentIndex * 2 ) + 2;
             
          
          // now, check if left is less than array size
          if( leftIndex < arraySize )
             {
                // check if right child is within bounds
                if( rightIndex < arraySize - 1 )
                   {
                      // check if left child is smaller than current and right
                      if( heapArray[ leftIndex ].compareTo( 
                      heapArray[ currentIndex ] ) < 0 && heapArray[ 
                      leftIndex ].compareTo( heapArray[ rightIndex ] ) < 0 )
                         {
                            // set printChild and printParent
                            printChild = heapArray[ leftIndex ];
                            printParent = heapArray[ currentIndex ];
                                  
                            // swap parent with smaller child
                            placeholder = heapArray[ currentIndex ];
                            heapArray[ currentIndex ] = heapArray[ leftIndex ];
                            heapArray[ leftIndex ] = placeholder;
                                  
                            // check for displayFlag
                            if( displayFlag )
                               {
                                  // print trickle down title
                                  System.out.println();
                                  System.out.println( "   - Trickle down:" );
                                        
                                  // print swapping data
                                  System.out.print( "     - Swapping parent: " + 
                                  printParent + " with child: " + printChild );
                               }
                                  
                            // call recursion on the next index
                            trickleDownArrayHeap( leftIndex );
                         }
                      
                      // otherwise, check if right is less than current and left
                      else if(heapArray[ rightIndex ].compareTo( heapArray[ 
                              currentIndex ] ) < 0 && heapArray[ rightIndex
                               ].compareTo( heapArray[ leftIndex ] ) < 0 )
                         {
                            // set printChild and printParent
                            printChild = heapArray[ rightIndex ];
                            printParent = heapArray[ currentIndex ];
                                    
                            // swap parent with smaller child
                            placeholder = heapArray[ currentIndex ];
                            heapArray[currentIndex] = heapArray[rightIndex];
                            heapArray[ rightIndex ] = placeholder;
                                    
                            // check for displayFlag
                            if( displayFlag )
                               {
                                  // print trickle down title
                                  System.out.println();
                                  System.out.println( "   - Trickle down:" );
                                  
                                  // print swapping data
                                  System.out.print( "     - Swapping parent: " + 
                                  printParent + " with child: " + printChild );
                               }
                                    
                            // call recursion on the next index
                            trickleDownArrayHeap( rightIndex );
                         } 
                   }
             }
       }
   }
