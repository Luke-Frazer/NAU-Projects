package p2_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class RegistrarClass 
{

   /**
    * Constant default capacity
    */
   private final int DEFAULT_CAPACITY = 10;
      
   /**
    * Constant used if item not found in array
    */
   private final int NOT_FOUND = -1;
      
   /**
    * Private array holding student data
    */
   private StudentClass[] studentArr;
      
   /**
    * Private capacity and size data
    */
   private int size;
      
   /**
    * Private capacity and size data
    */
   private int capacity;
      
   /**
    * Default constructor
    */
   public RegistrarClass()
      {
         // set the default capacity
         capacity = DEFAULT_CAPACITY;
         
         // set the default temp size
         size = 0;
         
         // initialize the array
         studentArr = new StudentClass[ capacity ];
      }
      
     /**
      * Initialization constructor
      * 
      * @param initialCapacity - integer value to set class initial capacity
      */
   public RegistrarClass( int initialCapacity )
      {
         // set the capacity to the initialCapacity value
         capacity = initialCapacity;
         
         // set the temporary size value
         size = 0;
         
         // initialize the student array with capacity
         studentArr = new StudentClass[ capacity ];
      }
      
   /**
    * Copy constructor
    * 
    * @param copied - RegistrarClass object to be copied
    */
   public RegistrarClass(RegistrarClass copied)
      {
         // initialize index 
         int index; 
         
         // copy the initialized constructor capacity value
         capacity = copied.capacity;
         
         // copy the initialized constructor size value
         size = copied.size;
         
         // initialize the temp array with capacity
         StudentClass[] tempArr = new StudentClass[ capacity ];
         
         // loop through the arrays and copy items over element by element
         for( index = 0; index < capacity; index++ )
            {
               // set the temp value to the student array value
               tempArr[ index ] = new StudentClass(copied.studentArr[ index ]);
            }
         
      }
      
   /**
    * Adds a StudentClass Item to list
    * <p>
    * Note: Overloaded method
    * 
    * @param newStudent - StudentClass object to be added to array
    * 
    * @return Boolean result of item addition to array
    */
   public boolean addStudent( StudentClass newStudent )
      {
         // add the student to the end of the list
         studentArr[ size ] = newStudent;
         
         // return false if the array is too small to add student
         if( studentArr[ size ] != newStudent )
            {
               return false;
            }
         
         // increase the index
         size++;
         
         // return true as the student was added
         return true;
      }
      
   /**
    * Creates a StudentClass item, then adds to list using other method
    * <p>
    * Note: Uses anonymous StudentClass instantiation in call to other method; 
    * one line of code
    * <p>
    * Note: Overloaded method
    * 
    * @param stdName - String name of student
    * 
    * @param stdID - integer student ID of student
    * 
    * @param stdGender - character gender of student
    * 
    * @param stdGPA - double GPA of student
    * 
    * @return Boolean result of adding student
    */
   public boolean addStudent( String stdName, int stdID, 
                                          char stdGender, double stdGPA )
      {
         // initialize variables
         StudentClass newStudent;
         boolean success; 
         
         // create the new student with the inputed values
         newStudent = new StudentClass( stdName, 
                                                   stdID, stdGender, stdGPA );
         
         // add the student to the list
         success = addStudent( newStudent );
         
         // return the success variable
         return success;
      }  
      
   /**
    * Copies student list from one array to other
    * <p>
    * Note: Must create new StudentClass object to assign to each element to 
    * destination array to eliminate aliasing
    * 
    * @param dest - StudentClass array to which data is copied
    * 
    * @param source - StudentClass array from which data is copied
    */
   private void copyArrayData( StudentClass[] dest, StudentClass[] source )
      {
         // initialize variables
         int index;
         
         // loop through array
         for( index = 0; index < size; index++ )
            {
               // copy the source array value at the current index to the dest
               dest[ index ] = new StudentClass( source[ index ] );
            }
      }
      
   /**
    * Optional method, local array dump for diagnostics
    */
   public void diagnosticArrayDump()
      {
         // initialize variables
         int index;
         StudentClass data;
         
         // loop through the array
         for( index = 0; index < size; index++ )
            {
               // set the data variable to the current location's data
               data = studentArr[ index ];
               
               // dump the data to the screen
               System.out.format( "%-28s %-10d %-2c %-10f", data.name,
                                    data.studentID, data.gender, data.gpa  );
               
               // print the endline
               System.out.println();
            }
      }
 
   /**
    * Finds student in array, returns data
    * <p>
    * Note: Uses findStudentIndex
    * 
    * @param student - StudentClass object to be found
    * 
    * @return StudentClass object found, or null if not found
    */
   public StudentClass findStudent( StudentClass student )
      {
         return studentArr[ findStudentIndex( student ) ];
      }
      
   /**
    * Finds student's index in array, returns index, or returns NOT_FOUND 
    * if item is not in the array
    * <p>
    * Note: Must use appropriate comparison method for class
    * 
    * @param student - StudentClass object to be found
    * 
    * @return index of StudentClass object, or NOT_FOUND
    */
   public int findStudentIndex( StudentClass student )
      {
         // initialize variables
         int index;
   
         // loop through array
         for( index = 0; index < size; index++ )
            {
               // check if the index location is the student
               if( studentArr[ index ].compareTo( student ) == 0 )
                  {
                     // return the student's index
                     return index;
                  }
            }
   
         // return not found if the student doesn't exist
         return NOT_FOUND;
      }
     
   /**
    * Removes student from array, shifts elements down to keep array contiguous
    * <p>
    * Note: Uses findStudentIndex
    * 
    * @param student - StudentClass object to be removed
    * 
    * @return StudentClass object that was removed, or null if not found
    */
   public StudentClass removeStudent( StudentClass student )
      {
         // initialize variables
         int index, studentIndex;
        
         // find the student index location
         studentIndex = findStudentIndex( student );
      
         // loop from the student's index until the end of the array
         for( index = studentIndex; index < size; index++ )
            {
               // set the current location to the next locations value
               studentArr[ index ] = studentArr[ index + 1 ];
               
            }  
        
         // return student data if the student was found
         if( studentIndex != NOT_FOUND )
            {
               // decrement the array size 
               size--;
               
               // return the student data
               return student;
            }
         
      
         // return null as no student was found
         return null;
      }
      
   /**
    * Description: Sorts elements using the bubble sort algorithm
    * <p>
    * Note: Creates new StudentClass array, sorts contents of array, and 
    * returns the sorted result; does not modify (this) object student array
    * 
    * @return new StudentClass array with sorted items
    */
   public StudentClass[] runBubbleSort()
      {  
         // initialize variables
         StudentClass[] finalArr = new StudentClass[ size ];
         int outerIndex, innerIndex;
         
         // copy the array data
         copyArrayData( finalArr, studentArr );
         
         // outer loop
         for( outerIndex = 0; outerIndex < size; outerIndex++ )
            {
               // inner loop
               for( innerIndex = 0; innerIndex < size - 1; innerIndex++ )
                  {
                     // check if the inner index location is greater than 
                     // the inner index location + 1 and swap if yes
                     if( finalArr[ innerIndex ].compareTo( 
                                           finalArr[ innerIndex + 1 ] ) > 0 )
                        {
                           // swap the inner index with the next location
                           swapValues( finalArr, innerIndex, innerIndex + 1 );
                        }
                  }
            }
           
         // return the final sorted array
         return finalArr;
      }
      
   /**
    * Description: Sorts character elements using the insertion sort algorithm
    * <p>
    * Note: Creates new StudentClass array, sorts contents of array, and 
    * returns the sorted result; does not modify (this) object student array
    * 
    * @return new StudentClass array with sorted items
    */
   public StudentClass[] runInsertionSort()
      {
         // initialize variables
         StudentClass[] finalArr = new StudentClass[ size ];
         int outerIndex, innerIndex;
         StudentClass temp;
         
         // copy the array data
         copyArrayData( finalArr, studentArr );
         
         // outer loop
         for( outerIndex = 1; outerIndex < size; outerIndex++ )
            {
               //set the inner index to start at the outer location
               innerIndex = outerIndex;
               
               // set the temporary variable to the outer index
               temp = finalArr[ outerIndex ];
               
               // inner loop
               while( innerIndex > 0 && temp.compareTo( 
                                          finalArr[ innerIndex - 1 ] ) < 0)
                  {
                     // set the inner location to the one before itself
                     finalArr[ innerIndex ] = finalArr[ innerIndex - 1 ];
                     
                     // decrement the innerIndex
                     innerIndex--;
                           
                  }
                     
               // set the inner location to the temp value
               finalArr[ innerIndex ] = temp;
                     
            }
            
         // return the final sorted array
         return finalArr;
      }
      
   /**
    * Description: Sorts character elements using the selection sort algorithm
    * <p>
    * Note: Creates new StudentClass array, sorts contents of array, and 
    * returns the sorted result; does not modify (this) object student array
    * 
    * @return new StudentClass array with sorted items
    */
   public StudentClass[] runSelectionSort()
      {
         // initialize variables
         StudentClass[] finalArr = new StudentClass[ size ];
         int outerIndex, innerIndex, smallIndex;
         
         // copy the array data
         copyArrayData( finalArr, studentArr );
         
         // outer loop
         for( outerIndex = 0; outerIndex < size - 1; outerIndex++ )
            {
               // set the initial lowest index as the first index to be searched
               smallIndex = outerIndex; 
               
               // inner loop
               for( innerIndex = outerIndex + 1; innerIndex < size; 
                                                                  innerIndex++ )
                  {
                     // check if the current index is smaller than small index
                     if( finalArr[ innerIndex ].compareTo( 
                                          finalArr[ smallIndex ] ) < 0 )
                        {
                           // set the small value
                           smallIndex = innerIndex;
                        
                        }
                     
                  }
               // swap the smallest value with the outer index location
               swapValues( finalArr, smallIndex, outerIndex );
         
            }
               
         // return the final sorted array
         return finalArr;
      }
      
   /**
    * Uses Shell's sorting algorithm to sort an array of integers
    * <p>
    * Shell's sorting algorithm is an optimized insertion algorithm
    * <p>
    * Note: Creates new StudentClass array, sorts contents of array, and 
    * returns the sorted result; does not modify (this) object student array
    * 
    * @return new StudentClass array with sorted items
    */
   public StudentClass[] runShellSort()
      {
         int gap, gapPassIndex, insertionIndex;
         StudentClass temp;
      
         StudentClass[] finalArr = new StudentClass[ size ];
      
         copyArrayData( finalArr, studentArr );

         for( gap = size / 2; gap > 0; gap /= 2 )
            {
               for( gapPassIndex = gap; gapPassIndex < size; gapPassIndex++ )
                  {
                     temp = finalArr[ gapPassIndex ];

                     insertionIndex = gapPassIndex;

                     while( insertionIndex >= gap && finalArr[ 
                                  insertionIndex - gap].compareTo( temp ) > 0 ) 
                        {
                           finalArr[ insertionIndex ] 
                                 = finalArr[ insertionIndex - gap ];
                 
                           insertionIndex -= gap;
                        }  // end search loop

                     finalArr[ insertionIndex ] = temp;
                  }  // end list loop
         
            }  // end gap size setting loop   
     
         return finalArr;
      }
      
   /**
    * Swaps values within given array
    * 
    * @param stdArray - StudentClass array used for swapping
    * 
    * @param indexOne - integer index for one of the two items to be swapped
    * 
    * @param indexOther - integer index for the other of the two items to be 
    * swapped
    */
   private void swapValues(StudentClass[] stdArray, int indexOne, 
                                                               int indexOther)
      {
         // initialize temporary value placeholder
         StudentClass tempVal;
      
         // swap values with the temporary value
         tempVal = stdArray[ indexOne ];
      
         // set the index one to the other index value
         stdArray[ indexOne ] = stdArray[ indexOther ];
      
         // now, set the other value to the saved temporary value of index one
         stdArray[ indexOther ] = tempVal;
      
      }
}
      