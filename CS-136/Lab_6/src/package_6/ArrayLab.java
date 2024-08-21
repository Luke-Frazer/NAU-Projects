package package_6;

public class ArrayLab
{
   
   // initialize high and low constants
   private final static int LOW_VALUE = 1;
   private final static int HIGH_VALUE = 100;
   
   // initialize precision constant
   private final static int PRECISION = 1;
   
   // initialize the final number constant
   private final static int FINAL_NUMBER = 1;
   
   // initialize string constants for printout
   private final static String COMMA_SPACE = ", ";
   
   // initialize the Console IO variable
   public static Console_IO_Class conIO = new Console_IO_Class();
   
   public static void main(String[] args)
      {
            
         // initialize program
         
            // declare variables, array capacity is a variable not a constant
            //            add in variables as needed to store the return values
            int capacity = 20;
            int index;
            int min;
            int max;
            double avg;
            
            // declare print messages
            String minMessage      = "Min value is: ";
            String maxMessage      = "Max value is: ";
            String avgMessage      = "Average value is: ";
            String arrayValMessage = "Array values";

         
            // declare array
            int[] intArray = new int[capacity];
       
            // for loop using getRandBetween method to initialize array
            for( index = 0; index < intArray.length; index++ )
               {
                  // create a random array using the random number generator
                     // method: getRandBetween
                  intArray[ index ] = getRandBetween( LOW_VALUE, HIGH_VALUE );
               }
         
         // process the data and call methods to return the values
         
            // calculate the minimum value
               // method: calcMin
            min = calcMin( intArray );
            
            // calculate the maximum value
               // method: calcMax
            max = calcMax( intArray );
            
            // calculate the average value
               // method: calAvg
            avg = calcAverage( intArray );
       
         
         // use Console IO Class to print min, max, average
            
            // print the minimum value
               // method: printString, printInt, printEndline
            conIO.printString( minMessage );
            conIO.printInt( min );
            conIO.printEndline();
            
            // print the maximum value
               // method: printString, printInt, printEndline
            conIO.printString( maxMessage );
            conIO.printInt( max );
            conIO.printEndline();
            
            // print the average value
               // method: printString, printDouble, printEndline
            conIO.printString( avgMessage );
            conIO.printDouble( avg, PRECISION );
            conIO.printEndline();
            
            
         // use a for loop and Console IO Class to print out all
         // elements in the array
            
            // print the array message
               // method: printString
            conIO.printString( arrayValMessage );
            conIO.printEndline();
            
            // print the array
               // method: printArray
            printArray( intArray );
        
         // end program
       
      }

   /*
   name: getRandomBetween
   process: generate a random number within the given range
   method input/parameters: the low and high range
   method output/parameters: none
   method output/returned: returns the random number
   device input/keyboard: none
   device output/monitor: none
   dependencies: Math
   */ 
   
   public static int getRandBetween( int low, int high )
      {
         // initialize variables
         int value, range = high - low + 1;
       
         // set the value equal to a random number within the range given
            // method: random
         value = (int)( Math.random() * range );
       
         // return the value
         return low + value;
      }

   /*
   name: calcMin
   process: find the minimum value within an array
   method input/parameters: array name
   method output/parameters: none
   method output/returned: returns the minimum value in the array
   device input/keyboard: none
   device output/monitor: none
   dependencies: none
   */
   
   public static int calcMin( int[] intArray )
   {
      // initialize variables
      int tempVal = intArray[ 0 ];
      int index;   
      
      // loop through the whole array until the minimum value is found
      for( index = 0; index < intArray.length; index++ ) 
         {
            // check if previous min value is greater than current array value
            if ( tempVal >= intArray[ index ] )
               {
                  // set the temporary minimum value to current value
                  tempVal = intArray[ index ];
                  
               }

         }
               
      // return the final minimum value
      return tempVal;
      
   }
   
   /*
   name: calcMax
   process: finds the maximum value within an array
   method input/parameters: array name
   method output/parameters: none
   method output/returned: returns the maximum value in the array
   device input/keyboard: none
   device output/monitor: none
   dependencies: none
   */
   
   public static int calcMax( int[] intArray )
   {
      
      // initialize variables
      int tempVal = intArray[ 0 ];
      int index;   
      
      // loop through the whole array until the maximum value is found
      for( index = 0; index < intArray.length; index++ ) 
         {
            // check if previous max value is less than current array value
            if ( tempVal <= intArray[ index ] )
               {
                  // set the temporary maximum value to current value
                  tempVal = intArray[ index ];
                  
               }

         }
               
      // return the final maximum value
      return tempVal;
   }
   
   /*
   name: calcAverage
   process: finds the average value within an array
   method input/parameters: array name
   method output/parameters: none
   method output/returned: returns the average value in the array
   device input/keyboard: none
   device output/monitor: none
   dependencies: none
   */
   
   public static double calcAverage( int[] intArray )
   {
      // initialize variables
      int index;
      double average;
      double accumulator = 0; 
      
      // loop through the array and add up all the number
      for( index = 0; index < intArray.length; index++ ) 
         {
            // add the previous value to the current array value until all
            //                                  numbers are added together
            accumulator += intArray[ index ];
            
         }
      
      // find the final average by dividing the accumulated number by the 
      //                                              number of array values
      average = accumulator / intArray.length;
      
      // return the final average
      return average; 
      
   }
   
   /*
   name: printArray
   process: prints the array elements separated by commas
   method input/parameters: array name
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: the array elements separated by commas
   dependencies: Console IO Class Tools
   */

   public static void printArray( int[] intArray )
   {
      // initialize variables
      int index;

      // loop through array and print each value of the array
      for( index = 0; index < intArray.length; index++ ) 
         {
            
            // print out each value
               // method: printInt
            conIO.printInt( intArray[ index ] );
            
            // check if it isn't the last number and print a comma space if so
            if( index < intArray.length - FINAL_NUMBER )
               {
                  // print a comma space
                  conIO.printString( COMMA_SPACE );
                  
               }
           
         }
      
   }
   
}