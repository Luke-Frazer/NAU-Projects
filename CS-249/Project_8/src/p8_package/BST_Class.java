package p8_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class BST_Class
   {

      /**
       * Root of BST
       */
      private StudentClassNode BST_Root;
      
      /**
       * Used for acquiring ordered tree visitations in String form
       */
      private String outputString;
      
      /**
       * Default class constructor, initializes BST
       */
      public BST_Class()
      {
         // initialize the output string to be empty
         outputString = "";
         
         // initialize the BST
         BST_Root = null;
      }
      
      /**
       * Copy constructor
       * <p>
       * Note: Uses copyConsHelper
       * 
       * @param copied - BST_Class object to be copied
       */
      public BST_Class( BST_Class copied )
      {
         // initialize the output string to be empty
         outputString = "";
         
         // sets root to copied BST
         BST_Root = copyConstHelper( copied.BST_Root );
      }
      
      /**
       * Copy constructor helper, recursively adds nodes to duplicate tree
       * 
       * @param copiedRef - StudentClassNode reference for accessing 
       * copied object data
       * 
       * @return StudentClassNode reference to node added at current 
       * level of recursion
       */
      private StudentClassNode copyConstHelper( StudentClassNode copiedRef )
      {
         // initialize variables
         StudentClassNode localRef = null;
         
         // check for copied reference not null
         if( copiedRef != null )
            {
               // create a new node to copy current node
               localRef = new StudentClassNode( copiedRef ); 
         
               // call recursion to the left and assign result to the left 
               // child of new node
               localRef.leftChildRef = copyConstHelper(
                                                    copiedRef.leftChildRef );
         
               // call recursion to the right and assign result to the right 
               // child of the new node
               localRef.rightChildRef = copyConstHelper(
                                                   copiedRef.rightChildRef );
            }
         
         // return the new local reference, either null or with node
         return localRef;
      }
      
      /**
       * Clears tree
       */
      public void clearTree()
      {
         // set the root node to null
         BST_Root = null;
      }
      
      /**
       * Insert method for BST
       * <p>
       * Note: uses insert helper method to insert by student ID key
       * 
       * @param inData - StudentClassNode data to be added to BST
       */
      public void insert( StudentClassNode inData )
      {
         // check if the tree is empty
         if( !isEmpty() )
            {
               // call the recursive process
               insertHelper( BST_Root, inData );
            }
         
         // otherwise, it is empty
         else
            {
               // assign the node to the root ref
               BST_Root = new StudentClassNode( inData );
            }
      }
      
      /**
       * Insert helper method for BST insert action
       * <p>
       * Note: Inserts by student ID key
       * <p>
       * Note: Uses look-down strategy and links to current node; 
       * handles special case of empty tree
       * 
       * @param localRoot - StudentClassNode tree root reference 
       * at the current recursion level
       * 
       * @param inData - StudentClassNode item to be added to BST
       */
      private void insertHelper( StudentClassNode localRoot,
                                                      StudentClassNode inData )
      {
         // check if search value is less than local data
         if( inData.studentID < localRoot.studentID )
            {
               // check if left child does not exist
               if( localRoot.leftChildRef == null )
                  {
                     // assign the current node's left child to a new node
                     // with the given data
                     localRoot.leftChildRef = new StudentClassNode( inData );
                  }
               
               // otherwise, assume left child does exist
               else
                  {
                     // call the recusion to the left
                     insertHelper( localRoot.leftChildRef, inData );
                  }
            }
         
         // otherwise, assume the value is greater than local data
         else
            {
               // check if right child does not exist
               if( localRoot.rightChildRef == null )
                  {
                     // assign the current node's right child to a new node
                     // with the given data
                     localRoot.rightChildRef = new StudentClassNode( inData );
                  }
               
               // otherwise, assume left child does exist
               else
                  {
                     // call the recursion to the right
                     insertHelper( localRoot.rightChildRef, inData );
                  }
            }
      }
      
      /**
       * Test for empty tree
       * 
       * @return Boolean result of test
       */
      public boolean isEmpty()
      {
         // check if the root is equal to null
         return ( BST_Root == null );
      }
      
      /**
       * Provides inOrder traversal for user as a string
       * 
       * @return String containing in order output
       */
      public String outputInOrder()
      {
         // reset the outputString
         outputString = ""; 
         
         // call the helper on the first root to start recursive process
         outputInOrderHelper( BST_Root );
         
         // return the final string
         return outputString;
      }
      
      /**
       * Provides inOrder traversal action helper
       * <p>
       * Note: Updates string with each call
       * 
       * @param localRoot - StudentClassNode tree root reference 
       * at the current recursion level
       */
      private void outputInOrderHelper( StudentClassNode localRoot )
      {
         // initialize variables 
         String endline = "\n";
         
         // check for local root not null
         if( localRoot != null )
            {
               // call recursion to the left
               outputInOrderHelper( localRoot.leftChildRef );
               
               // append the current data to the string
               outputString += localRoot.toString();
               outputString += endline;
               
               // call recursion to the right
               outputInOrderHelper( localRoot.rightChildRef );
            }
      }
      
      /**
       * Provides postOrder traversal for use as a string
       * 
       * @return String containing post order output
       */
      public String outputPostOrder()
      {
         // reset the output string
         outputString = "";
         
         // call the helper on the first root to start recursive process
         outputPostOrderHelper( BST_Root );
         
         // return the final string
         return outputString;
      }
      
      /**
       * Provides postOrder traversal action helper
       * <p>
       * Note: Updates string with each call
       * 
       * @param localRoot - StudentClassNode tree root reference 
       * at the current recursion level
       */
      private void outputPostOrderHelper( StudentClassNode localRoot )
      {
         // initialize variables 
         String endline = "\n";
         
         // check for local root not null
         if( localRoot != null )
            {
               // call recursion to the left
               outputPostOrderHelper( localRoot.leftChildRef );
               
               // call recursion to the right
               outputPostOrderHelper( localRoot.rightChildRef );
               
               // append the current data to the string with an endline after
               outputString += localRoot.toString();
               outputString += endline;
            }
      }
      
      /**
       * Provides preOrder traversal for user as a string
       * 
       * @return String containing pre order output
       */
      public String outputPreOrder()
      {
         // reset the output string
         outputString = "";
         
         // call the helper on the first root to start recursive process
         outputPreOrderHelper( BST_Root );
         
         // return the final string
         return outputString;
      }
      
      /**
       * Provides preOrder traversal action helper
       * <p>
       * Note: Updates string with each call
       * 
       * @param localRoot - StudentClassNode tree root 
       * reference at the current recursion level
       */
      private void outputPreOrderHelper( StudentClassNode localRoot )
      {
         // initialize variables 
         String endline = "\n";
         
         // check for local root not null
         if( localRoot != null )
            {
               // append the current data to the string with an endline after
               outputString += localRoot.toString();
               outputString += endline; 
               
               // call recursion to the left
               outputPreOrderHelper( localRoot.leftChildRef );
               
               // call recursion to the right
               outputPreOrderHelper( localRoot.rightChildRef );
               
            }  
      }
      
      /**
       * Searches tree from given node to maximum value node below it, 
       * unlinks and returns found node
       * 
       * @param parent - StudentClassNode reference to current node
       * 
       * @param child - StudentClassNode reference to child node to be tested
       * 
       * @return StudentClassNode reference containing removed node
       */
      private StudentClassNode removeFromMax( StudentClassNode parent, 
                                                       StudentClassNode child )
      {
         // initialize variables
         StudentClassNode removedVal;
         
         // check if the child has a right child
         if( child.rightChildRef != null )
            {
               // call recursion with the child as the parent and child's right 
               // ref as the child and assign result to the removedVal
               removedVal = removeFromMax( child, child.rightChildRef );
            }
         
         // otherwise, the child's right child is null
         else
            {
               // set the child to the removedVal
               removedVal = new StudentClassNode( child );;
               
               // check if the child has a left child, 
               // unlink the removed value and relink to the child's leftChild
               if( child.leftChildRef != null )
                  {
                     // set the parent's right child to the child's left child
                     parent.rightChildRef = child.leftChildRef;
                  }
               
               // otherwwise, the child does not have a left child
               else
                  {
                     // set the parents right child to null
                     parent.rightChildRef = null;
                  }
            }
         
         // return the removedVal
         return removedVal;
      }
      
      /**
       * Removes data node from tree using student ID key
       * <p>
       * Note: uses remove helper method
       * <p>
       * Note: Verifies if data is available with search method, 
       * then if found, calls remove
       * 
       * @param inData - StudentClassNode that includes the student ID key
       * 
       * @return StudentClassNode result of remove action
       */
      public StudentClassNode removeNode( StudentClassNode inData )
      {
         // initialize variables
         StudentClassNode localRef, removedRef = null;
         
         // search for item and assign it to the ref
         localRef = search( inData );
         
         // check if the ref is not null
         if( localRef != null )
            {
               // create new node from the removed ref and assign it to removed
               removedRef = new StudentClassNode( localRef );
                     
               // call the helper and return this to the root node
               return removeNodeHelper( inData, localRef );
            }
         
         // return the removed reference
         return removedRef;
      }
      
      /**
       * Remove helper for BST remove action for removing by student ID key
       * <p>
       * Note: uses removeFromMax method
       * <p>
       * Note: Assumes removed node is available since it was previously 
       * found by search in removeNode
       * 
       * @param localRoot - StudentClassNode tree root reference at 
       * the current recursion level
       * 
       * @param outData - StudentClassNode item that includes the student ID key
       * 
       * @return StudentClassNode reference result of remove helper action
       */
      private StudentClassNode removeNodeHelper( StudentClassNode localRoot, 
                                                      StudentClassNode outData )
      {
         // initialize variables
         StudentClassNode localRef = null;
         
         // check for the outData < localRoot
         if( outData.studentID < localRoot.studentID )
            {
               // recurse left, assign to left child of localRoot
               localRoot.leftChildRef = removeNodeHelper( 
                                             localRoot.leftChildRef, outData );
            }
         
         // otherwise, check for outData > localRoot
         else if( outData.studentID > localRoot.studentID )
            {
               // recurse right, assign to right child of localRoot
               localRoot.rightChildRef = removeNodeHelper( 
                                            localRoot.rightChildRef, outData );
            }
         
         // otherwise, check for left child null 
         else if( localRoot.leftChildRef == null )
            {
               // assign right child to local
               return localRoot.rightChildRef; 
            }
         
         // otherwise, check for right child null
         else if( localRoot.rightChildRef == null )
            {
               // assign right child to local
               return localRoot.leftChildRef; 
            }
         
         // otherwise, check if the left child has a right child
         else if( localRoot.leftChildRef.rightChildRef != null )
            {
               // set the current root to the localRef
               localRef = localRoot;
               
               // call removeFromMax and assign the data to the local ref
               localRoot = removeFromMax( localRoot.leftChildRef, 
                                         localRoot.leftChildRef.rightChildRef );
            }
         
         // otherwise, assume left child has no right child
         else 
            {
               // assign data from left child to local
               localRef = localRoot.leftChildRef;
               
               // link around the left Child to remove node
               localRoot.leftChildRef = localRoot.leftChildRef.leftChildRef;
            }
         
         // return the local Ref
         return localRef;
      }
      
      /**
       * Searches for data in BST given StudentClassNode with necessary key
       * 
       * @param searchData - StudentClassNode item containing key
       * 
       * @return StudentClassNode reference to found data
       */
      public StudentClassNode search( StudentClassNode searchData )
      {
         // return the recursive result of the search
         return searchHelper( BST_Root, searchData );
      }
      
      /**
       * Helper method for BST search action
       * 
       * @param localRoot - StudentClassNode tree root reference 
       * at the current recursion level
       * 
       * @param searchData - StudentClassNode item containing key
       * 
       * @return StudentClassNode item found
       */
      private StudentClassNode searchHelper( StudentClassNode localRoot, 
                                                StudentClassNode searchData )
      {
         // initialize variables
         StudentClassNode localRef = null;
         
         // check if root not null
         if( localRoot != null )
            {
               // check if the search data is less than this node
               if( searchData.studentID < localRoot.studentID )
                  {
                     // call recursion to left
                     localRef = searchHelper( localRoot.leftChildRef, 
                                                                   searchData );
                  } 
         
               // otherwise, check if the value is greater than this node
               else if( searchData.studentID > localRoot.studentID )
                  {
                          // call recursive process to the right
                     localRef = searchHelper( localRoot.rightChildRef, 
                                                                   searchData );
                  }
         
               // otherwise, this is the value and return the data
               else
                  {
                     // return the current root
                     localRef = localRoot;
                  }
            }
         // return the localRef
         return localRef;
      }
      
   }
