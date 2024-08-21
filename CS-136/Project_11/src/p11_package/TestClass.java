package p11_package;

public class TestClass
   {

      public static void main( String[] args )
         {
            int[][] array = new int[ 10 ][ 10 ];
            
            sumPerimeter( array, 10, 10 );
            
            

         }

      private static char decodeCharacter( long encodedLong )
         {
          // initialize variables
          int firstValue;
          int secondValue;
          int thirdValue;
          int totalVal;
          char decodedChar;
          long inputNumber = encodedLong;

          // find the values
          firstValue = (int)(inputNumber/100)% 10;
          inputNumber /= 100;
          
          System.out.print( firstValue );
          System.out.println();
          
          secondValue = (int)(inputNumber/1000)% 10;
          inputNumber /= 1000;
          
          System.out.print( secondValue );
          System.out.println();
          
          thirdValue = (int)(inputNumber/1000)% 10;
          inputNumber /= 1000;

          System.out.print( thirdValue );
          System.out.println();
          
          // combined the values
          totalVal = firstValue;
          totalVal = totalVal*10 + secondValue ;
          totalVal = totalVal*10 + thirdValue;

          // get the value;
          decodedChar = (char)totalVal;

          // return the decoded char;
          return decodedChar;
         }
      
      private static long generateNineDigitRandom()
         {
            // initialize index
            int index = 0;
            
            // initialize the three iteration variable
            int threeIterations = 3;
            
            // initialize the accumulating randomized long number
            long randomNineDigits = 0;
            
            // initialize the random number
            long randomNumber;
            
            // loop nine times
            while ( index < threeIterations )
               {
                  // multiply the accumulating nine digit number by 10 to go to 
                  // the next digit set
                  randomNineDigits *= 1000;
                  
                  // generate a random number between 100 - 999
                  randomNumber = getRandBetween( 100, 999 );
                  
                  // add the random number to the accumulator
                  randomNineDigits += randomNumber;
                  
                  // increase the index
                  index++;
               }
         
            // return the nine digit value
            return randomNineDigits;
         }
      
      private static int getRandBetween( int low, int high )
         {
          // initialize method, variables
         
             // create range value
             int range = high - low + 1;
     
          // find random within range, inclusive, return
             // method: Math.random
          return (int)( Math.random() * range + low );
         }
      
      private boolean isCharacter( NodeClass testRef, char testChar )
         {
            
            // takes in the test Reference (long value and nodeClass reference 
            // called next ref) Look inside and decode the encrypted value 
            // compare this to the testChar
            long decryptMe = testRef.encryptedVal;
            
            long decryptedVal;
            
            char decryptedChar = decodeCharacter( decryptMe );
            
            if( decryptedChar == testChar )
               {
                  
                  return true;
               }
            
          return false; 
         }
      
     public static int sumPerimeter( int[][] arr, int numRows, int numCols )
     {
        // initialize method/variables 
        int rowIndex, colIndex;
        int sum = 0;
        
        // sum across the top
        
           // loop from left to right
           for( colIndex = 0; colIndex < numCols; colIndex++ )
              {
        
              // add top values to sum
              sum +=  arr[ 0 ][ numCols ];

              // add bottom values to sum
              sum += arr[ numRows - 1 ][ numCols ];
              
              }
           // end left/right loop
        
        // sum across the right
        
           // loop from top to bottom at right 
           // exclude top and bottom values
           for( rowIndex = 1; rowIndex < numRows - 1; rowIndex++ )
              {
        
               // add left side values to sum
               sum += arr[ rowIndex ][ 0 ]; 
                 
               // add right side values to sum
               sum += arr[ rowIndex ][ numCols - 1 ]; 
              }
           // end top/bottom loop
        
        // return the sum
        return sum;
     }
      
   }
