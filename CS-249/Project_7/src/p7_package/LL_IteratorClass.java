package p7_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class LL_IteratorClass
   {
      /**
       * constant used for not found
       */
      private static final int NOT_FOUND = -1;
      
      /**
       * constant use for left bracket
       */
      private static final char LEFT_BRACKET = '[';
      
      /**
       * constant use for right bracket
       */
      private static final char RIGHT_BRACKET = ']';
      
      /**
       * constant use for space
       */
      private static final char SPACE = ' ';
      
      /**
       * Internal/Nested Node class for storing integers
       */
      private class NodeClass
      {
         /**
          * NodeClass data
          */
         int data;
         
         /**
          * NodeClass next reference
          */
         NodeClass nextRef;
         
         /**
          * NodeClass default constructor
          */
         @SuppressWarnings("unused")
         public NodeClass()
         {
            // set the next reference to null
            nextRef = null;
            
            // set the data to nothing
            data = 0;
         }
         
         /**
          * NodeClass initialization constructor
          * 
          * @param value - integer value for initialization
          */
         public NodeClass( int value )
         {
            // set the next reference to null
            nextRef = null;
            
            // set the data to nothing
            data = value;
         }
         
         /**
          * NodeClass copy constructor
          * 
          * @param copied - NodeClass object to be copied
          */
         public NodeClass( NodeClass copied )
         {
            // set nextRef to null
            nextRef = null;
            
            // copy data
            data = copied.data;
         }
         
      }
      
      /**
       * head node for linked list
       */
      private NodeClass headRef;
      
      /**
       * reference to current node
       */
      private NodeClass currentRef;
      
      /**
       * Default constructor, initializes references to null
       */
      public LL_IteratorClass()
      {
         // set references to null
         currentRef = null;
         headRef = null;
      }
      
      /**
       * Copy constructor
       * 
       * @param copied - LL_IteratorClass object to be copied
       */
      public LL_IteratorClass( LL_IteratorClass copied )
      {
      // set the head reference to null
         headRef = null;
         
         // initialize references
         NodeClass cpdWkgRef;
         NodeClass localWkgRef;
         
         // check if the copied headRef not null
         if( copied.headRef != null )
            {
               // create a new nodeclass from the copied headRef
               headRef = new NodeClass( copied.headRef );
               
               // set the copied working ref to the node after copied headRef
               cpdWkgRef = copied.headRef.nextRef;
               
               // set the local working ref to the node after the headRef
               localWkgRef = headRef.nextRef;
               
               // increment the copied working ref to be one after local
               cpdWkgRef = cpdWkgRef.nextRef;
               
               // loop until the copied working ref is at the end
               while( cpdWkgRef != null )
                  {
                     // create a new nodeClass object with copied working ref
                     localWkgRef.nextRef = new NodeClass( cpdWkgRef );
                     
                     // increment the local working ref
                     localWkgRef = localWkgRef.nextRef;
                     
                     // increment the copied working ref
                     cpdWkgRef = cpdWkgRef.nextRef;
                  }
            }
         
      }
      
      /**
       * Clears iterator of all valid values by setting head reference to null
       */
      public void clear()
      {
         // set the head reference and current reference to null
         headRef = null;
         currentRef = headRef;
      }
      
      /**
       * Description: shows iterator from beginning to end with brackets around
       *  current index
       * <p>
       * Displays "Empty" if list is empty
       */
      public void displayIterator()
      {
         // initialize variables
         NodeClass wkgRef = headRef;
         int value;
         
         // check if the list is empty
         if( isEmpty() )
            {
               System.out.println( "Empty" );
            }
         
         // otherwise, assume not empty
         else
            {
               // print iterator line
               System.out.print( "Iterator: " );
               
               // loop through the linked list and print the data
               while( wkgRef != null )
                  {
                     // set the data value
                     value = wkgRef.data;
                     
                     if( wkgRef == currentRef )
                        {
                           // print the line with brackets
                           System.out.format( "%c%d%c%c", LEFT_BRACKET, 
                                             value, RIGHT_BRACKET, SPACE );
                        }
                     
                     // otherwise, working ref is not the current ref
                     else
                        {
                           System.out.format( "%d%c", value, SPACE );
                        }
                     
                     // increment the working ref
                     wkgRef = wkgRef.nextRef;
                  }
            }
         
         // print an endline
         System.out.println();
      }
      
      /**
       * returns reference prior to current reference
       * <p>
       * Note: Returns null if current reference is at head
       * <p>
       * @return NodeClass object found at current
       */
      public NodeClass getCurrentPriorRef()
      {
         // initialize variables
         NodeClass wkgRef = headRef;
         
         // check if the current reference is at the headRef
         if( currentRef == headRef )
            {
               // return null
               return null;
            }
         
         // otherwise, loop from the headRef to the currentRef
         while( wkgRef.nextRef != currentRef)
            {
               // increment the workingRef
               wkgRef = wkgRef.nextRef;
            }
         
         // return the workingRef since we are one before the current ref
         return wkgRef;
      }
      
      /**
       * returns value at current location
       * 
       * @return integer value at current location
       */
      public int getValueAtCurrent()
      {
         // check if the list is empty
         if( isEmpty() )
            {
               // return not found
               return NOT_FOUND;
            }
         
         // otherwise, it is not empty
         else
            {
               // return the data at current
               return currentRef.data;
            }
      }
      
      /**
       * checks for next element available in iterator
       * <p>
       * Note: Uses one line of code
       * 
       * @return Boolean result of test
       */
      public boolean hasNext()
      {
         // return if the nextRef is not null
         return ( !isEmpty() && currentRef.nextRef != null );
      }
      
      /**
       * checks for previous element available in iterator
       * <p>
       * Note: Uses one line of code
       * 
       * @return Boolean result of test
       */
      public boolean hasPrev()
      {
         // return if the headRef's nextRef is not the currentRef
         return ( !isEmpty() && headRef != currentRef );
      }
      
      /**
       * inserts item into iterator at current location
       * <p>
       * Note: Does not affect current location
       * 
       * @param newVal - integer value to be inserted
       */
      public void insertAtCurrent( int newVal )
      {
         // initialize variables
         NodeClass prior = headRef;
         
         // check if the list is not empty
         if( !isEmpty() )
            {
               // loop from the headRef to the one before the current
               while( prior.nextRef != currentRef )
                  {
                     // increment prior
                     prior = prior.nextRef;
                  }
         
               // set the prior's next ref to the newVal
               prior.nextRef = new NodeClass( newVal );
         
               // set the prior's next next ref to current
               prior.nextRef.nextRef = currentRef;
            }
         
         // otherwise, it is empty
         else
            {
               // set the headRef to the new value
               headRef = new NodeClass( newVal );
               
               // set the current ref to the headRef
               currentRef = headRef;
            }
         
      }
      
      /**
       * inserts item into iterator at end of iterator
       * <p>
       * Note: Does not affect current location
       * 
       * @param newVal - integer value to be inserted
       */
      public void insertAtEnd( int newVal )
      {
         // Initialize variables
         NodeClass endRef = headRef;
         
         //check if not empty
         if( !isEmpty() )
            {
               // loop until the end of the list
               while( endRef.nextRef != null )
                  {
                     // increment endRef
                     endRef = endRef.nextRef;
                  }
         
               // set the value at the endRef's next ref
               endRef.nextRef = new NodeClass( newVal );
            }
         
         // otherwise, it is empty
         else
            {
               // set the headRef to the new value
               headRef = new NodeClass( newVal );
               
               // set the current ref to the headRef
               currentRef = headRef;
            }
      }
      
      /**
       * inserts item into iterator at beginning of iterator
       * <p>
       * Note: Does not affect current location
       * 
       * @param newVal - integer value to be inserted
       */
      public void insertAtFront( int newVal )
      {
         // initialize variables
         NodeClass secondRef;
         
         // check if the list is not empty
         if( !isEmpty() )
            {
               // set the secondRef to the head Ref's next ref
               secondRef = headRef;
               
               // set the headRef's next Ref to the new Val
               headRef = new NodeClass( newVal );
               
               // set the headRef's next next ref to the secondRef
               headRef.nextRef = secondRef;
            }
         
         // otherwise, the list is empty
         else
            {
               // set the headRef to the new value
               headRef = new NodeClass( newVal );
               
               // set the current ref to the headRef
               currentRef = headRef;
            }
         
      }
      
      /**
       * moves current location to the right, if not at end
       * 
       * @return Boolean result of action
       */
      public boolean moveNext()
      {
         // check if there is a next ref
         if( hasNext() )
            {
               // increment the currentRef
               currentRef = currentRef.nextRef;
               
               // return true
               return true;
            }
         
         // otherwise, return false
         return false;
      }
      
      /**
       * moves current location to the left, if not at beginning
       * 
       * @return Boolean result of action
       */
      public boolean movePrev()
      {
         // initialize variables
         NodeClass prevRef = headRef;
         
         // check if there is a prev ref
         if( hasPrev() )
            {
               // loop until at one before current
               while( prevRef.nextRef != currentRef )
                  {
                     // increment the prev Ref
                     prevRef = prevRef.nextRef;
                  }
               
               // set the current Ref to prevRef
               currentRef = prevRef;
               
               // return true
               return true;
            }
         
         // otherwise, return false
         return false;
      }

      /**
       * Tests for empty linked list
       * 
       * @return Boolean result of test for empty
       */
      public boolean isEmpty()
      {
         // return the boolean result of if the headRef is null
         return ( headRef == null );
      }
      
      /**
       * removes item from iterator at current location
       * <p>
       * Note: Must reset current location if last item removed
       * <p>
       * Note: Must set current reference to null if last item removed
       * 
       * @return integer value if successful, NOT_FOUND if not
       */
      public int removeAtCurrent()
      {
         // initialize variables
         NodeClass priorRef = headRef;
         int savedVal;
         
         // check if empty
         if( isEmpty() )
            {
               // return not found
               return NOT_FOUND;
            }
         
         else if( currentRef == headRef )
            {
               // set the saved val
               savedVal = currentRef.data;
               
               // set the current to the headRef's next ref
               currentRef = headRef.nextRef;
               
               // set the headRef back to current to increment it
               headRef = currentRef;
            }
         
         // otherwise, it is not empty
         else {
            
            // loop to the node before current
            while( priorRef.nextRef != currentRef )
               {
                  // increment the prior
                  priorRef= priorRef.nextRef;
               }
            
            // check if the currentRef is equal to the headRef
            if( currentRef == headRef )
               {
                  // set the saved value
                  savedVal = currentRef.data;
                  
                  // set head and current ref to null
                  currentRef = null;
                  headRef = null;
               }
               
               // check if at the end of the list
            else if( !hasNext() )
               {
                  // set the saved value
                  savedVal = currentRef.data;
                  
                  // set the currentRef to prior
                  currentRef = priorRef;
                  
                  // set the next location to null
                  currentRef.nextRef = null;
               }
            
            // otherwise, assume there is a next and previous value
            else
               {
                  // set the saved value
                  savedVal = currentRef.data;
                  
                  // set the current to current's next
                  currentRef = currentRef.nextRef;
                  
                  // set the prior's next to current
                  priorRef.nextRef = currentRef;
               }
            
         }
         
         // return the saved value
         return savedVal;
      }
      
      /**
       * sets current location to beginning
       * 
       * @return Boolean true if list is not empty, false otherwise
       */
      public boolean setToFirst()
      {
         // check if the list is not empty
         if( !isEmpty() )
            {
               // set the currentRef to the headRef
               currentRef = headRef;
               
               // return true
               return true;
            }
         
         // return false otherwise
         return false;
      }
      
      /**
       * sets current location to end
       * 
       * @return Boolean true if list is not empty, false otherwise
       */
      public boolean setToLast()
      {
         // initialize variables
         NodeClass endRef = headRef;
         
         if( !isEmpty() )
            {
               // loop until at the end
               while( endRef.nextRef != null )
                  {
                     // increment the end Ref
                     endRef = endRef.nextRef;
                  }
               
               // set the current ref to the endRef
               currentRef = endRef;
               
               // return true
               return true;
            }
         
         // otherwise, return false
         return false;
      }
      
   }
