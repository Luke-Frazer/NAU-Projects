package p9_package;

public class BinaryAdderClass
   {

      // constant default capacity 
      private final int DEFAULT_CAPACITY = 50;
      
      // constant character for space
      private final char SPACE = ' ';
      
      // base two constant, for use in operations
      private final int BASE_TWO = 2;
      
      // private bit array
      private int[] bitArray;
      
      // private number of valid bits
      int numBits;
      
      /*
      name: constructor - default
      process: initializes object to default values provided as constants
      method input/parameters: none
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */

      public BinaryAdderClass()
      {
         // set number of valid bits to default value and create empty array
         numBits = 0;
         
         bitArray = new int[ DEFAULT_CAPACITY ];
     
      }
      
      /*
      name: constructor - initialization
      process: sets array with binary values in array along with the number of 
                                               valid binary digits (i.e., bits)
      method input/parameters: decimalValue (int) to be converted to binary 
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: convertToBinary
      */
      
      public BinaryAdderClass( int decimalValue )
      {
         // initialize bitArray and numBits using the converToBinary method
            // method: convertToBinary
         bitArray = convertToBinary( decimalValue );

      }
      
      /*
      name: constructor - copy
      process: copies another BinaryAdderClass object into this one
      method input/parameters: copied object reference (BinaryAdderClass) 
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: Alternative construction call
                        - this( copied.decimalValue )
      */
      
      public BinaryAdderClass( BinaryAdderClass copied )
      {
         // set the bitArray and numBits to quantities from the copied object
            // method: copied
         bitArray = copied.bitArray;
         numBits = copied.numBits;
      }
      
      /*
      name: addValue
      process: Add value to this object using decimal value input Note: Creates
                    temporary BinaryAdderClass object, then adds to this object
      method input/parameters: decimalValue (int) to be converted into 
                          BinaryAdderClass object and then added to this object
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: addValue( BinaryAdderClass addend )
      */
      
      public void addValue( int decimalValue )
      {
         // initialize BinaryAdderClass object
         BinaryAdderClass addedVal = new BinaryAdderClass ( decimalValue );
         
         // use the new object in the addValue method
            // method: addValue
         addValue( addedVal );
         
      }
      
      /*
      name: addValue
      process: Add value to this object using another object
      method input/parameters: addend - BinaryAdderClass object to be added to 
                                                                  this object
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: BinaryAdderClass added variable, findMax
      */
      
      public void addValue( BinaryAdderClass addend )
      {
         // initialize the max value as the returned value from findMax method
            // method: findMax
         int maxValue = findMax( this.numBits, addend.numBits );
         
         // initialize temporary index
         int tempIndex = 0;
         
         // initialize final index 
         int finalIndex = 0;
         
         // initialize the carry value as zero
         int carry = 0;
         
         // initialize the added value
         int addedValue;
         
         // initialize an empty temporary array
         int[] tempArray = new int[ DEFAULT_CAPACITY ];
         
         // loop until the index value hits the maxValue
         while( tempIndex < maxValue )
            {
               // check if the index value is less than both the numBits value
               if( tempIndex < this.numBits && tempIndex < addend.numBits )
                  {
                     // add the carry to the two index values of the arrays
                     addedValue = carry + this.bitArray[ tempIndex ] + 
                                                  addend.bitArray[ tempIndex ];
                     
                     // find the added value modulo 2
                     tempArray[ tempIndex ] = addedValue % BASE_TWO;
                     
                     // find the carry value
                     carry = addedValue / BASE_TWO;
                  }
               
               // check if the index value is less or equal to this numBits
               //               value but more than the addended numBits value
               else if( tempIndex <= this.numBits && tempIndex > addend.numBits)
               {
                  
                  // add the carry value if applicable to this array
                  addedValue = carry + this.bitArray[ tempIndex ];
                  
                  // find the added value
                  tempArray[ tempIndex ] = addedValue;
               }
               
               // check if the index value is more than this numBits value
               //         but less than or equal to the addended numBits value
               else if( tempIndex > this.numBits && tempIndex <= addend.numBits)
                  {
                     // add the carry value if applicable to the addended array
                     addedValue = carry + addend.bitArray[ tempIndex ];
                     
                     // find the added value
                     tempArray[ tempIndex ] = addedValue;
                  }
               
               // increase the index
               tempIndex++;
            }
         
         // check if there is a carry value
         if( carry == 1 )
            {
               // set the final index location to the carry value
               tempArray[ tempIndex ] = carry;
            }
         
         // set numBits to the final index 
         numBits = tempIndex + 1;
         
         // set the bitArray to have the length of the numBits
         bitArray = new int[ numBits ];
         
         // loop until the index reaches the index value
         for( finalIndex = 0; finalIndex < numBits; finalIndex++ )
            {
               // set the index location of the final array to the index
               //                          of the temporary array's value
               bitArray[ finalIndex ] = tempArray[ finalIndex ];
            }
         
      }
      
      /*
      name: convertToBinary
      process: creates local array, processes conversion, then returns
      method input/parameters: decimalValue (int) to be converted to binary
      method output/parameters: none
      method output/returned: integer array result of conversion to binary
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      private int[] convertToBinary( int decimalValue )
      {
         // initialize index
         int index = 0;
         
         // initialize the empty array
         int[] tempArray = new int[ DEFAULT_CAPACITY ];
         
         // loop until the decimal value is zero
         while( decimalValue > 0 )
            {
               
               // assign index location within the array to the remainder value
               tempArray[ index ] = decimalValue % BASE_TWO;
               
               // divide off the base two from the decimal value
               decimalValue /= BASE_TWO;
               
               // increase index by one
               index++;
                    
            }
         
         // set the numBits to the index value
         numBits = index;
         
         // return the bitArray
         return tempArray;
         
      }
      
      /*
      name: displayBits
      process: display in block - right justifies array
      method input/parameters: blockSize (int) - size of block to create
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      public void displayBits( int blockSize )
      {
         // initialize index
         int index;
         
         // initialize the final string to display the bits
         String finalOutput = "";
         
         // find the empty space value before the binary values
         int gap = blockSize - numBits;
         
         // loop until the number of spaces required is reached to print the gap
         for( index = 0; index < gap; index++ )
            {
               // print the space
                  // method: print
               System.out.print( SPACE );
            }
         
         // loop until the numBits reaches zero
         for( index = numBits - 1; index >= 0; index-- )
            {
               // add the current index location of the array to final output
               finalOutput += bitArray[ index ];
            }
         
         // print the final output string with an endline
            // methods: print, println
         System.out.print( finalOutput );
         System.out.println();
         
      }
      
      /*
      name: displayChars
      process: displays characters, using recursive printing strategy
      method input/parameters: numChars (int) - number of characters to print,
                               outChar (char) - character to be output
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      public void displayChars( int numChars, char outChar )
      {
         // initialize the index
         int index;
         
         // loop until the number of characters is reached
         for( index = 0; index < numChars; index++ )
            {
               // print the output character
                  // method: print
               System.out.print( outChar );
            }
      }
      
      /*
      name: findMax
      process: finds maximum of two values
      method input/parameters: valOne (int) - value to be compared to valOther,
                               valOther (int) - value to be compared to valOne
      method output/parameters: none
      method output/returned: integer value that is largest of the two
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      private int findMax( int valOne, int valOther )
      {
         // checks if valOne is greater than valOther
         if( valOne > valOther )
            {
               // return the valOne since it is larger
               return valOne;
            }
         
         // check if valOne is less than valOther
         else if( valOne < valOther )
            {
               // return valOther since it is larger
               return valOther;
            }
         
         // otherwise, the two are equal and we set the max to default valOne
         return valOne;
         
      }
      
      /*
      name: toString
      process: toString, overrides Object version in class java.lang.Object
      method input/parameters: none
      method output/parameters: none
      method output/returned: String representation of array bits
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      @Override
      public String toString()
      {
         // initialize index
         int index;
         
         // initialize the result string 
         String resultString = "";
         
         // loop until the index is 0, starting at one less than the numBits
         for( index = numBits - 1; index >= 0; index-- )
            {
               // set the result string to the current result string plus the
               //                                           index located value
               resultString += bitArray[ index ];
            }
         
         // return the final result string
         return resultString;
         
      }
   }
