package p3_package;

/**
 * 
 * @author Luke Frazer
 *
 */
public class LogN_SortDriverClass
   {

      /**
       * Default constructor, takes no action for this static tool class
       */
      public LogN_SortDriverClass()
      {
         
      }
      
      /**
       * Compares two strings character by character set to lower case to see 
       * which is alphabetically greater than the other;
       * <p>
       * if all tested letters of a name are equal, then compares string lengths
       * <p>
       * Results are as follows:
       * <p>
       * Alphabetically, if strOne is greater than strTwo, returns value 
       * greater than zero (e.g., Susan is greater than Bill);
       * <p>
       * if strOne is less than strTwo, returns value less than zero (e.g., 
       * Roger is less than Zelda);
       * <p>
       * if strOne is equal to strTwo both alphabetically and in length, 
       * returns zero (e.g., Susan is equal to Susan)
       * <p>
       * Note: .length utility method may used in this method
       * 
       * @param strOne - first String value to be compared
       * @param strTwo - second String value to be compared
       * @return integer difference as specified
       */
      public static int compareStrings( String strOne, String strTwo )
      {
         // initialize variables
         int diff = 0, index = 0;
         int strOneLength = strOne.length();
         int strTwoLength = strTwo.length();
         char charOne, charTwo;
         
         // loop while index is less than both strings
         while( index < strOneLength && index < strTwoLength )
            {
               // find string one char at the index location
               charOne = strOne.charAt( index );
               
               // find string two char at the index location
               charTwo = strTwo.charAt( index );
               
               // set the difference to strOnes index val minus strTwo index val
               diff = toLowerCase( charOne ) - toLowerCase( charTwo );
               
               // if the characters are not equal return the difference
               if( diff != 0 )
                  {
                     return diff;
                  }
              
               // increment the index
               index++;
            }
         
         // return zero as values are equal
         return strOneLength - strTwoLength;
      }
         
      /**
       * Merges String values brought in between a low and high index segment 
       * (inclusive) of an array
       * <p>
       * Note: uses locally sized single array for temporary storage
       * 
       * @param localArray - String array holding unsorted values
       * @param lowIndex - lowest index of array segment to be managed
       * @param middleIndex - middle index of array segment to be managed
       * @param highIndex - high index of array segment to be managed
       */
      private static void runMerge( String[] localArray, int lowIndex,
                                                int middleIndex, int highIndex )
      {
         // find the capacity needed for the local array and create the array
         int capacity = (highIndex - lowIndex) + 1;
         int leftIndex, rightIndex, sourceIndex, leftLimit, rightLimit;
         int index = 0;
         int copyIndex = lowIndex;
         String[] newArray = new String[ capacity ];
         
         // load the data from the source array into newly created local array
         while( index < capacity )
            {
               // copy the index value at the current location over to new array
               newArray[ index ] = localArray[ copyIndex ];

               // increment both index values
               index++;
               copyIndex++;
               
            }
       
         // calculate the indices necessary for left and right side groups
         leftIndex = 0;
         rightIndex =  ( capacity / 2 );
         leftLimit = ( capacity / 2 ) - 1;
         rightLimit = capacity - 1;
         sourceIndex = lowIndex;
         
         // loop until either left or right group is out of values
         while( leftIndex < leftLimit && rightIndex < rightLimit )
            {
               // check if the first available value in the left group 
               // is less than the first available value in the right group
               if( compareStrings( newArray[ leftIndex ], 
                                                newArray[ rightIndex ] ) < 0 )
                  {
                     // assign first available left value to source array's 
                     // first available element
                     localArray[ sourceIndex ] = newArray[ leftIndex ];
                     
                     // increment left group index
                     leftIndex++;
                  }
               
               // otherwise, assume the right group's first value is less
               else
                  {
                     // assign first available right value to source array's 
                     // first available element
                     localArray[ sourceIndex ] = newArray[ rightIndex ];
                     
                     // increment the right group index
                     rightIndex++;
                  }
                    
               // increment source index
               sourceIndex++;

            }
         // end comparison loop
         
         // loop until left side group is out of values
         while( leftIndex < leftLimit )
            {
               // assign first available left value to the source Array's 
               // first available element
               localArray[ sourceIndex ] = newArray[ leftIndex ];
               
               // increment the left group index
               leftIndex++;
               
               // increment the source array's index
               sourceIndex++;
               
            }
         // end left side clean out loop
         
         // loop until right side group is out of values
         while( rightIndex < rightLimit )
            {
               // assign first available left value to the source Array's 
               // first available element 
               localArray[ sourceIndex ] = newArray[ rightIndex ];
               
               // increment the left group index
               rightIndex++;
               
               // increment the source array's index
               sourceIndex++;
               
            }
         // end right side clean out loop

      }
      
      /**
       * String data sorted using merge sort algorithm
       * <p>
       * Note: Calls runMergeSortHelper with lower and upper indices of array 
       * to be sorted
       * 
       * @param localArray - String array holding unsorted values
       * @param size - integer value holding number of values in array
       */
      public static void runMergeSort( String[] localArray, int size)
      {
         // initialize variables
         int lowIndex = 0;
         int highIndex = size - 1;
         
         // call runMergeSortHelper
         runMergeSortHelper( localArray, lowIndex, highIndex );
      }
      
      /**
       * Merge sort helper, recursively breaks given array segment down to 
       * smaller segments between lowIndex and highIndex (inclusive), then 
       * sorts data using merge sort method
       * 
       * @param localArray - String array holding unsorted values
       * @param lowIndex - lowest index of array segment to be managed; 
       * this varies as the segments are broken down recursively
       * @param highIndex - highest index of array segment to be managed; 
       * this varies as the segments are broken down recursively
       */
      private static void runMergeSortHelper( String[] localArray, int lowIndex,
                                                               int highIndex )
      {
         // initialize variables
         int midPoint;
         
         // make sure the lower index is less than upper index
         if( lowIndex < highIndex )
            {
               // calculate midpoint
               midPoint = ( highIndex + lowIndex ) / 2;
               
               // call mergeSortHelper for left side
               runMergeSortHelper( localArray, lowIndex, midPoint );
               
               // call mergeSortHelper for right side
               runMergeSortHelper( localArray, midPoint + 1, highIndex );
               
               // merge the two lists back together
               runMerge( localArray, lowIndex, midPoint, highIndex );
            }

         
      }
      
      /**
       * Partitions array using the first value as the partition; when this 
       * method is complete the partition value is in the correct location 
       * in the array
       * 
       * @param localArray - String array holding unsorted values
       * @param lowIndex - low index of array segment to be partitioned
       * @param highIndex - high index of array segment to be partitioned
       * @return integer index of partition pivot
       */
      private static int runPartition( String[] localArray,
                                                   int lowIndex, int highIndex )
      {
         // initialize variables
         int workingIndex, pivot;
         
         // set working index to lowIndex
         workingIndex = lowIndex;
         
         // set the pivot index to lowIndex
         pivot = lowIndex;
         
         // loop from low index to the high index
         while( workingIndex < highIndex )
            {
               // check if the value at the current working index is less than 
               // original pivot value
               if( compareStrings( localArray[ workingIndex ], 
                            localArray[ lowIndex ] ) < 0 )
                  {
                     // increment the pivot index
                     pivot++;
                     
                     // swap value at working index with value at pivot index
                     swapValues( localArray, workingIndex, pivot );
                  }
               // increment the working index
               workingIndex++;
            }
         // end working loop
         
         // swap original pivot value (low index) with the value at the current
         // pivot index
         swapValues( localArray, lowIndex, pivot );
         
         // return the pivot index
         return pivot;
      }
      
      /**
       * Data sorted using quick sort algorithm
       * <p>
       * Note: Call runQuickSortHelper with lower and upper indices of array 
       * to be sorted
       * 
       * @param localArray - String array holding unsorted values
       * @param size - integer value holding the number of values in the array
       */
      public static void runQuickSort ( String[] localArray, int size )
      {
         // initialize variables
         int lowIndex = 0;
         int highIndex = size;
         
         // call quick sort helper
         runQuickSortHelper( localArray, lowIndex, highIndex );
         
      }
      
      /**
       * Helper method run with parameters that support recursive access
       * 
       * @param localArray - String array holding unsorted values
       * @param lowIndex - low index of the segment of the array to be processed
       * @param highIndex - high index of the segment of the array to be 
       * processed
       */
      private static void runQuickSortHelper ( String[] localArray,
                                                   int lowIndex, int highIndex )
      {
         // initialize variables
         int pivot;
         
         // check if the lowIndex is less than the highIndex 
         if( lowIndex < highIndex ) { 
            // set pivot value
            pivot = runPartition( localArray, lowIndex, highIndex );
            
            // run quickSortHelper on low to pivot index
            runQuickSortHelper( localArray, lowIndex, pivot );
            
            // run quicksortHelper on pivot + 1 to high index
            runQuickSortHelper( localArray, pivot + 1, highIndex );
         }
         
      }
      
      /**
       * Swaps values within given array
       * 
       * @param localArray - array of Strings used for swapping
       * @param indexOne - integer index for one of the two items to be swapped
       * @param indexOther - integer index for the other of the two items to 
       * be swapped
       */
      private static void swapValues ( String[] localArray, int indexOne,
                                                               int indexOther )
      {
         // initialize variables
         String tempVal = localArray[ indexOne ];
         
         // swap index one with other
         localArray[ indexOne ] = localArray[ indexOther ];
         
         // swap index other with the saved temp value
         localArray[ indexOther ] = tempVal;
         
      }
      
      /**
       * If character is upper case letter (i.e., 'A' - 'Z'), 
       * changes letter to lower case (i.e., 'a' - 'z'); 
       * otherwise, returns character unchanged
       * 
       * @param testChar - character value to be tested and possibly modified
       * @return character value modified as specified
       */
      private static char toLowerCase ( char testChar )
      {
         // check if the newChar is upper case and convert to lower case
         if( testChar >= 'A' && testChar <= 'Z' )
            {
               // return the lower case testChar
               return (char)(testChar - 'A' + 'a' );
               
            }
         // otherwise, it isn't upper case and can be returned back as normal
         
         // return the testChar
         return testChar;
         
      }
      
   }
