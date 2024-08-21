package p9_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class TwoThreeTreeClass
   {

      /**
       * constant used for identifying one data item stored
       */
      private final int ONE_DATA_ITEM = 1;
      
      /**
       * constant used for identifying two data items stored
       */
      private final int TWO_DATA_ITEMS = 2;
      
      /**
       * constant used for identifying three data items stored
       */
      private final int THREE_DATA_ITEMS = 3;
      
      /**
       * Used for acquiring ordered tree visitations in String form
       */
      private String outputString;
      
      /**
       * root of tree
       */
      private TwoThreeNodeClass root;
      
      /**
       * Default 2-3 tree constructor
       */
      public TwoThreeTreeClass()
      {
         // set root to null
         root = null;
         
         // set empty output string
         outputString = "";
      }
      
      /**
       * copy 2-3 tree constructor
       * 
       * @param copied - TwoThreeTreeClass object to be duplicated; 
       * data is copied, but new nodes and references must be created
       */
      public TwoThreeTreeClass( TwoThreeTreeClass copied )
      {
         // set output string to empty
         outputString = "";
         
         // call recursion and set to root
         root = copyConstructorHelper( copied.root );
      }
      
      /**
       * Implements tree duplication effort with recursive method; 
       * copies data into newly created nodes and creates all new 
       * references to child nodes
       * 
       * @param workingCopiedRef - TwoThreeNodeClass reference that is 
       * updated to lower level children with each recursive call
       * 
       * @return TwoThreeNodeClass reference to next higher level node; 
       * last return is to root node of THIS object
       */
      private TwoThreeNodeClass copyConstructorHelper( TwoThreeNodeClass 
                                                             workingCopiedRef )
      {
         // initialize variables/method
         TwoThreeNodeClass localRef = null;
         
         // check if workingCopiedRef is not null
         if( workingCopiedRef != null )
            {
               // create new node
               localRef = copyConstructorHelper( workingCopiedRef );
               
               // set the left child to the recursive call to the left
               localRef.leftChildRef = copyConstructorHelper( 
                                                workingCopiedRef.leftChildRef );
               
               // check if left child exists
               if( localRef.leftChildRef != null )
                  {
                     // set left child's parent to localRef
                     localRef.leftChildRef.parentRef = localRef;
                  }
               
               if( workingCopiedRef.numItems == TWO_DATA_ITEMS )
                  {
                     // set localRef items to 2
                     localRef.numItems = TWO_DATA_ITEMS;
                     
                     // set center child to recursive call to center
                     localRef.centerChildRef = copyConstructorHelper( 
                                             workingCopiedRef.centerChildRef );
                     
                     // check for center exists
                     if( localRef.centerChildRef != null )
                        {
                           // set center child's parent to localRef
                           localRef.centerChildRef.parentRef = localRef;
                        }
                     
                  }
               
               // set the right child to the recursive call to the left
               localRef.rightChildRef = copyConstructorHelper( 
                                              workingCopiedRef.rightChildRef );
               
               // check if left child exists
               if( localRef.rightChildRef != null )
                  {
                     // set left child's parent to localRef
                     localRef.rightChildRef.parentRef = localRef;
                  }
               
               // return localRef
               return localRef;
               
            }
         
         // otherwise, return null
         return null;
      }
      
      /**
       * Method is called when addItemHelper arrives at the 
       * bottom of the 2-3 search tree (i.e., all node's children are null);
       * <p>
       * Assumes one- or two- value nodes and adds one more to the 
       * appropriate one resulting in a two- or three- value node
       * 
       * @param localRef - TwoThreeNodeClass reference has original node 
       * data and contains added value when method completes; 
       * method does not manage any node links
       * 
       * @param itemStr - String value to be added to 2-3 node
       */
      private void addAndOrganizeData( TwoThreeNodeClass localRef, 
                                                               String itemStr )
      {
         // check if localRef not null
         if( localRef != null )
            {
               // check if we are a one node
               if( localRef.numItems == ONE_DATA_ITEM )
                  {
                     // check if new val is less than center data
                     if( compareStrings( itemStr, localRef.centerData ) < 0)
                        {
                           // increment the numItems
                           localRef.numItems = TWO_DATA_ITEMS; 
                           
                           // set center data to the right (greater) data
                           localRef.rightData = localRef.centerData;
                           
                           // set the new val to the left (lesser) data
                           localRef.leftData = itemStr;
                           
                        }
                     
                     // otherwise, check if the new val is greater than data
                     else if( compareStrings(itemStr, localRef.centerData ) > 0)
                        {
                           // increment the numItems
                           localRef.numItems = TWO_DATA_ITEMS; 
                           
                           // set center data to the right (greater) data
                           localRef.leftData = localRef.centerData;
                           
                           // set the new val to the left (lesser) data
                           localRef.rightData = itemStr;
                           
                           // set the center to null
                           localRef.centerData = null;
                        }
                  }
               
               // otherwise, check if we are a two node
               else if( localRef.numItems == TWO_DATA_ITEMS )
                  {
                     // increment the num items
                     localRef.numItems = THREE_DATA_ITEMS;
                     
                     // check if new val is less than left data
                     if( compareStrings( itemStr, localRef.leftData ) < 0 )
                        {
                           // set the left data to the center
                           localRef.centerData = localRef.leftData;
                           
                           // set the new val to the left data
                           localRef.leftData = itemStr;
                        }
                     
                     // otherwise, check if the new val is greater than right
                     else if(compareStrings( itemStr, localRef.rightData ) > 0)
                        {
                           // set the right data to the center
                           localRef.centerData = localRef.rightData;
                           
                           // set the new val to the right data
                           localRef.rightData = itemStr;
                        }
                     
                     // otherwise, assume the new val is between left and right
                     else
                        {
                           // set the new value to center
                           localRef.centerData = itemStr;
                        }
                  }
               
               // call the fix up insert
               fixUpInsert( localRef );
               
            }
      }
      
      /**
       * Adds item to 2-3 tree using addItemHelper as needed
       * 
       * @param itemStr - String value to be added to the tree
       */
      public void addItem( String itemStr )
      {
         // call the helper on the first item
         addItemHelper( root, itemStr );
      }
      
      /**
       * Helper method searches from top of tree to bottom using divide 
       * and conquer strategy to find correct location (node) for new 
       * added value; once location is found, item is added to node using 
       * addAndOrganizeData and then fixUpInsert is called in case the updated 
       * node has become a three-value node
       * 
       * @param localRef - TwoThreeNodeClass reference to the 
       * current item at the same given point in the recursion process
       * 
       * @param itemStr - String value to be added to the tree
       */
      private void addItemHelper( TwoThreeNodeClass localRef, String itemStr )
      {
         // initialize variables/methods
         
         // check for current node null
         if( localRef == null )
            {
               addAndOrganizeData( localRef, itemStr );
            }
         
         // check if we are a one node
         else if( localRef.numItems == ONE_DATA_ITEM )
            {
               // check if we are not a leaf
               if( localRef.leftChildRef != null )  
                  {
                     // check if the new val is less than the data
                     if( compareStrings( itemStr, localRef.centerData ) < 0 )
                        {
                           // recurse to the left
                           addItemHelper( localRef.leftChildRef, itemStr );
                        }
                  
                     // otherwise, check if the new val is greater than center
                     else if(compareStrings( itemStr, localRef.centerData ) > 0)
                        {
                           // recurse to the right
                           addItemHelper( localRef.rightChildRef, itemStr );
                        }
                  }
               
               // otherwise, we are a leaf
               // add and organize the data
               addAndOrganizeData( localRef, itemStr );
            }
         
         // otherwise, check if we are a two node
         else if( localRef.numItems == TWO_DATA_ITEMS )
            {
               // check if we are not a leaf
               if( localRef.leftChildRef != null )  
                  {
                     // check if the new val is less than the left data
                     if( compareStrings( itemStr, localRef.leftData ) < 0 )
                        {
                           // recurse to the left
                           addItemHelper( localRef.leftChildRef, itemStr );
                        }
                     
                     // otherwise, check if the new val is greater than right
                     else if(compareStrings( itemStr, localRef.rightData ) > 0)
                        {
                           // recurse to the right
                           addItemHelper( localRef.rightChildRef, itemStr );
                        }
                     
                     // otherwise, assume new val is in the middle
                     else
                        {
                           // recurse to the center
                           addItemHelper( localRef.centerChildRef, itemStr );
                        }
                  }
               
            }
         
         
      }
      
      /**
       * Method clears tree so that new items can be added again
       */
      public void clear()
      {
         // set the root to null
         root = null;
      }
      
      /**
       * Compares two strings
       * <p>
       * Returns value greater than zero if left string 
       * greater than right string
       * <p>
       * Returns value less than zero if left string less than right string
       * <p>
       * Returns zero if strings are equal
       * 
       * @param leftStr - String to be compared
       * 
       * @param rightStr - String to be compared
       * 
       * @return integer result of test as specified
       */
      public int compareStrings( String leftStr, String rightStr )
      {
         // initialize variables
         int diff = 0, index = 0;
         int leftStrLength = leftStr.length();
         int rightStrLength = rightStr.length();
         char charOne, charTwo;
         
         // loop while index is less than both strings
         while( index < leftStrLength && index < rightStrLength )
            {
               // find string one char at the index location
               charOne = leftStr.charAt( index );
               
               // find string two char at the index location
               charTwo = rightStr.charAt( index );
               
               // set the difference to strOnes index val minus strTwo index val
               diff = charOne - charTwo;
               
               // if the characters are not equal return the difference
               if( diff != 0 )
                  {
                     return diff;
                  }
              
               // increment the index
               index++;
            }
         
         // return zero as values are equal
         return leftStrLength - rightStrLength;
      }
      
      /**
       * Method used to fix tree any time a three-value node has been 
       * added to the bottom of the tree; it is always called but decides 
       * to act only if it finds a three-value node
       * <p>
       * Resolves current three-value node which may add a value to the 
       * node above; if the node above becomes a three-value node, then 
       * this is resolved with the next recursive call
       * <p>
       * Recursively climbs from bottom to top of tree resolving 
       * any three-value nodes found
       * 
       * @param localRef - TwoThreeNodeClas reference initially 
       * given the currently updated node, then is given parent node 
       * recursively each time a three-value node was resolved
       */
      private void fixUpInsert( TwoThreeNodeClass localRef )
      {
         // initialize variables/methods
         TwoThreeNodeClass newNode;
         
         // check for three node
         if( localRef.numItems == THREE_DATA_ITEMS )
            {
               // check for at root
               if( localRef == root )
                  {
                     // create new node
                     newNode = new TwoThreeNodeClass( localRef.centerData );
                     
                     // set new node parent to root and localRef's parent
                     newNode.parentRef = root.parentRef;
                     
                     // set root ref to this new node
                     root = newNode;
                     
                     // set localRef's left child to special constructor with 
                     // select left method
                     localRef.leftChildRef = new TwoThreeNodeClass( 
                           TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                     
                     // set localRef's right child to special constructor with 
                     // select right method
                     localRef.rightChildRef = new TwoThreeNodeClass( 
                           TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                  }
               
               // check for being a one node above
               if( localRef.parentRef.numItems == ONE_DATA_ITEM )
                  {
                     // make parent a two node
                     localRef.parentRef.numItems = TWO_DATA_ITEMS;
                     
                     // check for being left child 
                     if( localRef.parentRef.leftChildRef == localRef )
                        {
                           // set parent's right value to parent's center value
                           localRef.parentRef.rightData = 
                                                 localRef.parentRef.centerData;
                           
                           // set the parent's left value to localRef's 
                           // center value
                           localRef.parentRef.leftData = localRef.centerData;
                                 
                           // call super constructor for left child 
                           // with left select
                           localRef.leftChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                           
                           // call super constructor for center child 
                           // with right select
                           localRef.centerChildRef = new TwoThreeNodeClass( 
                              TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                        }
                     
                     // otherwise, check for being a right child
                     else if( localRef.parentRef.rightChildRef == localRef )
                        {
                           // set parent's left value to parent's center value
                           localRef.parentRef.leftData = 
                                                localRef.parentRef.centerData;
                           
                           // set the parent's right val to the center val
                           localRef.parentRef.rightData = localRef.centerData;
                                 
                           // call super constructor for center child 
                           // with left select
                           localRef.centerChildRef = new TwoThreeNodeClass( 
                                TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                           
                           // call super constructor for right child 
                           // with right select
                           localRef.rightChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                        }
                  }
               
               // check for being a 2 node above
               if( localRef.parentRef.numItems == TWO_DATA_ITEMS )
                  { 
                     // make the parent a one node
                     localRef.parentRef.numItems = THREE_DATA_ITEMS;
                     
                     // check for being a left child
                     if( localRef.parentRef.leftChildRef == localRef )
                        {
                           // set parents center val to parents left
                           localRef.parentRef.centerData = 
                                                localRef.parentRef.leftData;
                           
                           // set parents left val to localRef center val
                           localRef.parentRef.leftData = localRef.centerData;
                           
                           // call super constructor for left child 
                           // with left select
                           localRef.leftChildRef = new TwoThreeNodeClass( 
                                TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                           
                           // call super constructor for center child 
                           // with right select
                           localRef.centerChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                           
                           // call recursion on the parent
                           fixUpInsert( localRef.parentRef );
                        }
                     
                     // check for being a center child
                     else if( localRef.parentRef.centerChildRef == localRef )
                        {
                           // set parents center val to localRef center val
                           localRef.parentRef.centerData = localRef.centerData;
                           
                           // call super constructor for left child 
                           // with left select
                           localRef.leftChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                           
                           // call super constructor for center child 
                           // with right select
                           localRef.rightChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                           
                           // call recursion on the parent
                           fixUpInsert( localRef.parentRef );
                        }
                     
                     // check for being a right child
                     else if( localRef.parentRef.rightChildRef == localRef )
                        {
                           // set parents center val to their right val
                           localRef.parentRef.centerData = 
                                                   localRef.parentRef.rightData;
                           
                           // set parents right val to localRef center val
                           localRef.parentRef.rightData = localRef.centerData;
                           
                           // call super constructor for left child 
                           // with left select
                           localRef.centerChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                           
                           // call super constructor for center child 
                           // with right select
                           localRef.rightChildRef = new TwoThreeNodeClass( 
                               TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                           
                           // call recursion on the parent
                           fixUpInsert( localRef.parentRef );
                           
                        }
                     
                  }
               
            }
         
      }
      
      /**
       * Tests center value if single node, tests left and right 
       * values if two-value node; returns true if specified data 
       * is found in any given node
       * <p>
       * Note: Method does not use any branching operations such as if/else/etc.
       * 
       * @param localRef - TwoThreeNodeClass reference to node with 
       * one or two data items in it
       * 
       * @param searchStr - String value to be found in given node
       * 
       * @return boolean result of test
       */
      private boolean foundInNode(TwoThreeNodeClass localRef, String searchStr)
      {
         // return if the search value is in any of the three data spots
         return (localRef.leftData == searchStr || 
                localRef.rightData == searchStr || 
                                            localRef.centerData == searchStr ); 
      }
      
      /**
       * Public method called by user to display data in order
       * 
       * @return String result to be displayed and/or analyzed
       */
      public String inOrderTraversal()
      {
         // reset the output string
         outputString = "";
         
         // call the helper on the first root to start recursive process
         inOrderTraversalHelper( root );
         
         // return the final string
         return outputString;
      }
      
      /**
       * Helper method conducts in order traversal with 2-3 tree
       * <p>
       * Shows location of each value in a node: "C" at center of 
       * single node "L" or "R" at left or right of two-value node
       * 
       * @param localRef - TwoThreeNodeClass reference to current 
       * location at any given point in the recursion process
       */
      private void inOrderTraversalHelper( TwoThreeNodeClass localRef )
      {
         // initialize variables 
         String endline = "\n";
         
         // check for local root not null
         if( localRef != null )
            {
               // call recursion to the left
               inOrderTraversalHelper( localRef.leftChildRef );
               
               // check if the data is one node
               if( localRef.numItems == ONE_DATA_ITEM )
                  {
                     // append the current data to the string
                     outputString += " | C: " + localRef.centerData;
                     outputString += endline;
                  }
               
               // otherwise, check if the data is two nodes
               else if( localRef.numItems == TWO_DATA_ITEMS )
                  {
                     // call recursion to center
                     inOrderTraversalHelper( localRef.centerChildRef );
                     
                     // append the current left data to the string
                     outputString += " | L: " + localRef.leftData;
                     
                     // append the current right data to the string
                     outputString += " | R: " + localRef.rightData;
                     outputString += endline;
                  }
               
               // call recursion to the right
               inOrderTraversalHelper( localRef.rightChildRef );
            }
      }
      
      /**
       * Search method used by programmer to find specified item in 2-3 tree
       * 
       * @param searchStr - String value to be found in tree
       * 
       * @return boolean result of search effort
       */
      public boolean search( String searchStr )
      {
         // call search helper on first string
         return searchHelper( root, searchStr );
      }
      
      /**
       * Search helper method that traverses through tree in a 
       * recursive divide and conquer search fashion to verify 
       * that a string is in the 2-3 tree*
       * 
       * @param localRef - TwoThreeNodeClass reference to given 
       * node at any point during the recursive process
       * 
       * @param searchStr - String value to be found in tree
       * 
       * @return boolean result of search effort
       */
      private boolean searchHelper(TwoThreeNodeClass localRef, String searchStr)
      {
         // check if the localRef is not null
         if( localRef != null )
            {
               // check if we are a one node
               if( localRef.numItems == ONE_DATA_ITEM )
                  {
                     // check if the value is less than the current data
                     if( compareStrings( searchStr, localRef.centerData ) < 0 )
                        {
                           // call recursion to the left
                           return searchHelper( localRef.leftChildRef, 
                                                                    searchStr );
                        }
                     
                     // otherwise, check if the value is greater than the data
                     else if( compareStrings( searchStr, 
                                                    localRef.centerData ) > 0 )
                        {
                           // call recursion to right
                           return searchHelper( localRef.rightChildRef, 
                                                                   searchStr );
                        }
                     
                     // otherwise, we found the data
                     else if( foundInNode( localRef, searchStr ) )
                        {
                           // return true as the value is in the tree
                           return true;
                        }
                     
                  }
               
               // otherwise, check if we are two node
               else if( localRef.numItems == TWO_DATA_ITEMS )
                  {
                     // check if the value is less than the current data
                     if( compareStrings( searchStr, localRef.leftData ) < 0 )
                        {
                           // call recursion to the left
                           return searchHelper( localRef.leftChildRef, 
                                                                    searchStr );
                        }
                     
                     // otherwise, check if the value is greater than the data
                     else if( compareStrings( searchStr, 
                                                    localRef.rightData ) > 0 )
                        {
                           // call recursion to right
                           return searchHelper( localRef.rightChildRef, 
                                                                   searchStr );
                        }
                     
                     // otherwise, check if the value is in between the data
                     else if( compareStrings( searchStr, localRef.leftData ) > 0 
                        && compareStrings( searchStr, localRef.rightData ) < 0 )
                        {
                           // call recursion to the center
                           return searchHelper( localRef.centerChildRef, 
                                                                    searchStr );
                        }
                     
                     // otherwise, the value is in the current data
                     else
                        {
                           // return true since we found the data
                           return true;
                        }
                  }
            }
         
         // otherwise, the data is null and so return false
         return false;
      }
   }
