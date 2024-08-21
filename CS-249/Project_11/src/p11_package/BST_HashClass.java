package p11_package;

/**
 * 
 * @author Luke Frazer
 * 
 * Hash Class that uses BST elements for data storage
 */
public class BST_HashClass
   {
      /**
       * Table size default
       * <p>
       * Table size (capacity) is recommended to be a prime number
       */
      private static final int DEFAULT_TABLE_SIZE = 11;
      
      /**
       * Capacity (Size) of the base table
       */
      private int tableSize;
      
      /**
       * Array for hash table
       */
      private BST_Class[] tableArray;
      
      /**
       * Default constructor
       * <p>
       * Initializes array to default table size; initializes all BST elements
       * <p>
       * Note: one line of code
       */
      public BST_HashClass()
      {
         // call initialization constructor with default value
         this( DEFAULT_TABLE_SIZE );
      }
      
      /**
       * Initialization constructor
       * <p>
       * Initializes array to specified table size; initializes all BST elements
       * 
       * @param inTableSize - sets table size
       */
      public BST_HashClass( int inTableSize )
      {
         // initialize index
         int index;
         
         // set table size
         tableSize = inTableSize;
         
         // set the table array to the initialized size
         tableArray = new BST_Class[ tableSize ];
         
         // loop through the array
         for( index = 0; index < tableSize; index++ )
            {
               //initialize the bst element at the index location
               tableArray[ index ] = new BST_Class();
            }
      }
      
      /**
       * Copy constructor
       * 
       * @param copied - BST_HashClass object to be copied
       */
      public BST_HashClass( BST_HashClass copied )
      {
         // initialize variables
         int index;
         tableSize = copied.tableSize;
         BST_Class[] tempArray = new BST_Class[ tableSize ];
         
         // loop through the array
         for( index = 0; index < tableSize; index++ )
            {
               // copy the array at the current location
               tempArray[ index ] = new BST_Class( copied.tableArray[ index ] );
            }
         
         // set the array to copied array
         tableArray = tempArray;
      }
      
      /**
       * Adds item to hash table
       * <p>
       * Uses overloaded addItem with object
       * 
       * @param inName - name of student
       * 
       * @param inStudentID - student ID
       * 
       * @param inGender - gender of student
       * 
       * @param inGPA - gpa of student
       */
      public void addItem( String inName, int inStudentID, 
                                                  char inGender, double inGPA )
      {
         // create a new studentClassNode item 
         StudentClassNode newStudent = new 
                     StudentClassNode( inName, inStudentID, inGender, inGPA );
         
         // use addItem to insert new student into the array
         addItem( newStudent );
      }
      
      /**
       * Adds item to hash table
       * <p>
       * Overloaded method that accepts StudentClass object
       * 
       * @param newItem - student class object
       */
      public void addItem( StudentClassNode newItem )
      {
         // find the hashed index
         int index = generateHash( newItem );
         
         // insert the item into the array at the hashed location
         tableArray[ index ].insert( newItem );
      }
      
      /**
       * Clears hash table by clearing all BST elements
       */
      public void clearHashTable() 
      {
         // initialize variables
         int index;
         
         // loop through array
         for( index = 0; index < tableSize; index++ )
            {
               // clear the tree at the index location
               tableArray[ index ].clearTree();
            }         
      }
      
      /**
       * Searches for item in hash table using student ID as key
       * 
       * @param studentID - used for requesting data
       * 
       * @return StudentClassNode object removed, or null if not found
       */
      public StudentClassNode findItem( int studentID )
      {
         // initialize variables
         int index; 
         StudentClassNode finalVal;
         
         // create ghost student for finding the hash
         StudentClassNode tempStudent = new StudentClassNode( 
                                                "temp", studentID, 'M', 4.0 );
         
         // find the hashed index val
         index = generateHash( tempStudent );
         
         // search for the studentID in the array's index location
         finalVal = tableArray[ index ].search( tempStudent );
         
         // return the final value
         return finalVal;
      }
      
      /**
       * Method uses student ID to generate hash value for 
       * use as index in hash table
       * <p>
       * Process sums the Unicode values of each of the student 
       * ID digits converted to characters, and then creates a hash index
       * 
       * @param studentData - StudentClasNode object from which 
       * hash value will be generated
       * 
       * @return integer value to be used as array index
       */
      public int generateHash( StudentClassNode studentData )
      {
         // initialize variables
         int studentID = studentData.studentID;
         int tempVal, sum = 0;
         
         // loop until out of ID values
         while( studentID > 0 )
            {
               // divide off 10 and save the value
               tempVal = studentID % 10; 
               
               // add the temp val to the sum
               sum += (int)( tempVal + '0' );
               
               // remove the last value from the studentID
               studentID /= 10;
            }
         
         // return the final hashed value
         return sum % tableSize;
      }
      
      /**
       * Removes Item from hash table, using student ID as key
       * 
       * @param studentID - used for requesting data
       * 
       * @return StudentClassNode object to be removed, or null if not found
       */
      public StudentClassNode removeItem( int studentID )
      {
         // initialize variables
         int index;
         StudentClassNode finalVal;
         
         // create ghost student for finding hash
         StudentClassNode tempStudent = new StudentClassNode( 
                                                "temp", studentID, 'M', 4.0 );
         
         // find the hashed index val
         index = generateHash( tempStudent );
         
         // remove the item at the index location
         finalVal = tableArray[ index ].removeNode( tempStudent );
         
         // return the final value
         return finalVal;
      }
      
      /**
       * traverses through all array bins, finds counts 
       * from each BST, then displays as table
       * <p>
       * Shows table of list lengths, then shows table size, 
       * then shows the number of empty bins and the longest 
       * linked list of the set; adapts to any size array
       */
      public void showHashTableStatus()
      {
         // initialize variables
         int length = tableSize;
         int emptyBins = 0;
         int largestBST, smallestBST, index, nodeCount;
         String nodes = "        ";
         String spacing = "           -----  -----  -----  -----  -----  -----"
                                        + "  -----  -----  -----  -----  -----";
         
         // print the title
         System.out.println();
         System.out.println( "Array node report: ");
         System.out.println();
         
         // set the starting smallest and largest bst count to the first node
         smallestBST = tableArray[ 0 ].countNodes();
         largestBST = tableArray[ 0 ].countNodes();
         
         // loop through the array
         for( index = 0; index < length; index++ )
            {
               // set the current nodeCount
               nodeCount = tableArray[ index ].countNodes();
               
               // check if the current node is less than the smallest node count
               if( nodeCount < smallestBST )
                  {
                     // set current node count to new smallest
                     smallestBST = tableArray[ index ].countNodes();
                  }
               
               // check if the current node count is larger than the biggest bst
               if( nodeCount > largestBST )
                  {
                     // set current node count to new largest
                     largestBST = tableArray[ index ].countNodes();
                  }
               
               // check if the current node count is empty
               if( nodeCount == 0 )
                  {
                     // increment the empty bin count
                     emptyBins++;
                  }
               
               // append the current node count to the string
               nodes += String.format("     %2d", nodeCount);
            }
         
         // print the nodes string
         System.out.println( nodes + "\n" + spacing );
         
         // print the index title
         System.out.print( " Index: " );
         
         // loop through the array for the index count
         for( index = 0; index < length; index++ )
            {
               // print the index counter
               System.out.format( "     %2d", index );
            }
         
         // print two endlines
         System.out.println();
         System.out.println();
         
         // print the information with endlines
         System.out.format( "With a table size of %d.", length );
         System.out.println();
         System.out.format( "The number of empty bins was %d.", emptyBins );
         System.out.println();
         System.out.format("The largest BST count was %d node(s).", largestBST);
         System.out.println();
         System.out.format("The smallest BST count was %d node(s).", 
                                                                  smallestBST );
         System.out.println();
         System.out.println();
      }
      
   }
