package p7_package;

public class FunctionToolClass
   {

      // initialize the block size constant
      public static final int MENU_BLOCK_SIZE = 30;
      
      // initialize the menu constants
      public static final int LOW_MENU_SELECTION = 1;
      public static final int HIGH_MENU_SELECTION = 3;
      
      // initialize the calculation constants
      public static final int FIND_NEXT_PRIME = 1;
      public static final int FIND_SINE = 2;
      public static final int FIND_SQUARE_ROOT = 3;

      // initialize the numerical constants
      public static final int SINE_ITERATIONS = 9;
      public static final double PRECISION = .000001;
      public static final int LONG_PRECISION = 6;
      public static final int TWO_ENDLINES = 2;
      
      // initialize the Console IO variable
      public static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main( String[] args )
         {

         // initialize program

            // initialize variables
            double value = 0;
            double result = 0;
            int operationSelection;
            
         // get the inputed values from the user

            // prompt the user for the operation
               // method: getUserSelection
            operationSelection = getUserSelection();

            // correctly prompts the user for the input data
               // method: getUserInput
            value = getUserInput( operationSelection );

         // process the data
            
            // check which selection was made
            switch ( operationSelection )
            {
               // checks if the selection value is FindNextPrime
               case FIND_NEXT_PRIME:
                  // find the next prime number of the inputed value
                     // method: findNextPrime
                  result = findNextPrime( (int)value );
                  break;
               
               // checks if the selection value is findSine
               case FIND_SINE:
                  // estimate the sine of the inputed value
                     // method: findSine
                  result = findSine( value );
                  break;
               
               // in all other cases, the selection is findSquareRoot
               default:
                  // estimate the square root of the inputed value
                     // method: findSquareRoot
                  result = findSquareRoot( value );
                  break;
               
            }
            
         // display the output
            
            // show result of the calculations from the user selected operation
               // method: showResults
            showResults( result, operationSelection );

         // end program
            
            // display the program end
               // method: printString, printEndline
            conIO.printString( "Program End" );
            conIO.printEndline();
            
         }

     /*
     name: getUserSelection
     process: allows the user to select one of three options from a menu 
                          for what calculation to execute in the program.
     method input/parameters: none
     method output/parameters: none
     method output/returned: an integer value between 1 and 3
     device input/keyboard: user entry of the which calculation to execute
     device output/monitor: menu displayed
     dependencies: Console IO Class Tools
     */
     
     public static int getUserSelection()
     {
        // initialize method/variables
        int output = 0;
        
        // display the menu and prompt the user for the operation selection
           // method: displayMenu
        output = displayMenu();
        
        // start loop to check if the selection is valid and repeat if it isn't
        while ( output > HIGH_MENU_SELECTION || output < LOW_MENU_SELECTION )
           {
              // ask for the input from the menu until the selection is valid
                 // method: displayMenu
              output = displayMenu();
           }
 
        // return the selection
        return output; // temporary stub return
        
     }
     
     /*
     name: displayMenu
     process: displays the menu of choices to the user.
     method input/parameters: none
     method output/parameters: none
     method output/returned: none
     device input/keyboard: none
     device output/monitor: menu displayed
     dependencies: Console IO Class Tools
     */
     
     public static int displayMenu()
     {
        // initialize method/variables
        int operationSelection;
                   
        // display menu Title
           // method: printString, printEndlines
        conIO.printString( "MENU", MENU_BLOCK_SIZE, "CENTER");
        conIO.printEndlines( TWO_ENDLINES );
        
        // display menu selection one
           // method: printString, printEndlines
        conIO.printString( "1. Find Next Prime");
        conIO.printEndlines( TWO_ENDLINES );
        
        // display menu selection two
           // method: printString, printEndlines
        conIO.printString( "2. Find Sine");
        conIO.printEndlines( TWO_ENDLINES );
        
        // display menu selection three
           // method: printString, printEndlines
        conIO.printString( "3. Find Square Root");
        conIO.printEndlines( TWO_ENDLINES );
        
        // get the input from the user
           // method: promptForInt, printEndline
        operationSelection = conIO.promptForInt( "enter your "
                                                     + "selection choice: " );
        conIO.printEndline();
        
        // return the selection
        return operationSelection;
        
     }
     
     /*
     name: getUserInput
     process: accepts the user selection value, correctly prompts the user
           for the appropriate input data, and return the data as a double. 
     method input/parameters: the operation selection from the user
     method output/parameters: none
     method output/returned: returns the data that is processed depending
                                 on the operation selection calculations.
     device input/keyboard: the users selection value
     device output/monitor: the prompt for the appropriate input data
     dependencies: Console IO Class Tools
     */
     
     public static double getUserInput( int operationSelection )
     {
        // initialize method/variables
        double value;
        
        // correctly prompt the user for the input data depending on operation
        switch ( operationSelection )
        {
           // check if the input was for findNextPrime
           case FIND_NEXT_PRIME:
              // display the prompt for findNextPrime
                 // method: promptFordouble, printEndlines
              value = conIO.promptForDouble( "Enter start value for finding"
                                       + " prime, must be greater than 1.0: ");
              conIO.printEndline();
              break;
              
           // check if the input was for findSine
           case FIND_SINE:
              // display the prompt for findSine
                 // method: promptFordouble, printEndlines
              value = conIO.promptForDouble( "Enter value to find"
                                       + " sine, must be greater than 1.0: ");
              conIO.printEndline();
              break;
           
           // in all other cases, the selection is findSquareRoot
           default: 
              // display the prompt for findSquareRoot
                 // method: promptFordouble, printEndlines
              value = conIO.promptForDouble( "Enter value to find square root,"
                                             + " must be greater than 1.0: ");
              conIO.printEndline();
              break;
              
        }
        
        // return the data
        return value;
        
     }
     
     /*
     name: findNextPrime
     process: starts testing at the value and iterates up until a
                                                      prime value is found.
     method input/parameters: the start value
     method output/parameters: none
     method output/returned: returns the prime value that is found through 
                                                               the testing. 
     device input/keyboard: none
     device output/monitor: none
     dependencies: isPrime
     */
     
     public static int findNextPrime( int startValue )
     {
        // initialize method/variables
        FunctionToolClass tool = new FunctionToolClass();
        int testValue;
        
        // start testing the value by iterating until a prime value is found
        for ( testValue = startValue + 1; testValue >= 1; testValue++ )
           {
              // check if the test value is a prime number
              if ( tool.isPrime( testValue ) )
                 {
                    // if it is prime, return the value
                    return testValue;
                 }
           }
        
        // return the start value as stub return
        return testValue;
        
     }
     
     /*
     name: isPrime
     process: Tests if the inputed value is a prime number.
     method input/parameters: the value being tested
     method output/parameters: none
     method output/returned: returns true if the value is prime and false
                                                              if it is not.
     device input/keyboard: none
     device output/monitor: none
     dependencies: none
     */
     
     public boolean isPrime( int value )
     {
        // initialize method/variables
        int testNumber;
        
        // iterate across the possible numbers for value to be divisible by
        for ( testNumber = 2; testNumber < value; testNumber++ )
           {
              // check if there's a remainder when the value is divided by 
              //                                            the test number
              if ( value % testNumber == 0 )
                 {
                    // if no remainder with any number, then return true prime
                    return false;
                 }
           }
        
        // return true if it is prime
        return true;
        
     }
     
     /*
     name: findSine
     process: uses a Taylor Series operation to estimate the sine value
     method input/parameters: the value that is being tested
     method output/parameters: none
     method output/returned: returns the estimated sine value
     device input/keyboard: none
     device output/monitor: none
     dependencies: findFactorial
     */
     
     public static double findSine( double value ) 
     {
        // initialize method/variables
        FunctionToolClass tool = new FunctionToolClass();
        double accumulator = 0;
        double denominator, numerator, newValue;
        double finalValue = 0;
        int iterations = 0;
        int initialExponent = 1;
        int posNeg = 1;
        int exponent;
        
        // loop through the number of iterations specified to estimate sine
        while ( iterations < SINE_ITERATIONS )
           {
              // set starting value used to accumulate the exponential value
              newValue = 1;
              
              // set temporary exponent that is reset each loop to a set value
              exponent = initialExponent;
              
              // calculate the denominator using the factorial of the exponent
              denominator = tool.findFactorial( exponent );
              
              // loop through the number of exponents to calculate the
              //                                              exponential value
              while ( exponent > 0 ) 
                 {
                    // multiply the inputed value by itself every loop until 
                    //                             every exponent has been used
                    newValue = newValue * value;
                    
                    // subtract the exponent by one each loop so that it will
                    //    run out of exponents after the number been finished
                    exponent = exponent - 1;
                    
                 }
              
              // set the numerator value to the exponential value that was just 
              //                                                     calculated 
              numerator = newValue;
              
              // increase the exponent by two for the next loop
              initialExponent = initialExponent + 2;
              
              // set accumulator value equal to the numerator over denominator
              accumulator = numerator / denominator;
              
              // set finalValue equal to the previous loop's finalValue plus
              // the accumulator times an alternating positive and negative 1
              finalValue = finalValue + ( accumulator * posNeg );
              
              // change the alternating positive/negative one's sign
              posNeg = posNeg * -1;
              
              // increase the number of iterations to complete the loop
              iterations = iterations + 1;
              
           }
        
        // return the sine value found after the loop has been completed
        return finalValue;
        
     }
     
     /*
     name: findFactorial
     process: finds the factorial value of the inputed value
     method input/parameters: the value that is being tested
     method output/parameters: none
     method output/returned: returns the factorial value of the input
     device input/keyboard: none
     device output/monitor: none
     dependencies: none
     */
     
     public long findFactorial( double value ) 
     {
        // initialize method/variables
        long testNumber;
        long temporaryNumber = 1;
        long factorialNumber;
        
        // iterate through all of the numbers of the inputed value
        for ( testNumber = (long)value; testNumber > 0; testNumber-- )
           {
              // multiply the current value by the previous value each time
              temporaryNumber = temporaryNumber * testNumber;
           }
        
        // convert the final number to a long variable
        factorialNumber = (long)temporaryNumber;
     
        // return the factorial value
        return factorialNumber; 
        
     }
     
     /*
     name: findSquareRoot
     process: finds the square root of the inputed value
     method input/parameters: the value that is being tested
     method output/parameters: none
     method output/returned: returns the square root value of the input
     device input/keyboard: none
     device output/monitor: none
     dependencies: none
     */
     
     public static double findSquareRoot( double value )
     {
        // initialize method/variables
        double testableValue = Math.abs( value );
        double temp = testableValue / 2;
        double maximum = temp;
        double minimum = 0;

        // loop until the temporary value squared is within the precision 
        //                                requirement of the tested value
        while ( temp * temp > testableValue + PRECISION || 
                        temp * temp < testableValue - PRECISION )
           {
              
              // check if the temporary value squared is greater than the 
              //                                               tested value
              if ( temp * temp > testableValue + PRECISION )
                 {
                    
                    // set maximum value equal to the current temporary value
                    maximum = temp;
                    
                    // set temporary value equal to the minimum value plus half 
                    //     of the difference between the max and min values
                    temp = minimum + ( ( maximum - minimum) / 2 );
                    
                 }
              
              // check if the temporary value squared is less than the 
              //                                               tested value
              else if ( temp * temp < testableValue - PRECISION )
                 {
                    
                    // set the minimum equal to the current temporary value
                    minimum = temp;
                    
                    // set temporary value equal to the minimum value plus half 
                    //     of the difference between the max and min values
                    temp = minimum + ( ( maximum - minimum ) / 2 );

                 }
           }
        
        // return the final value as the square root
        return temp; 
        
     }
     
     /*
     name: showResults
     process: accepts the result value and the operation selection value to
            provide an appropriate output display for the selected result.
     method input/parameters: the result and the operation selection value.
     method output/parameters: none
     method output/returned: none
     device input/keyboard: none
     device output/monitor: displays the result value of the 
                                                        operation selection.
     dependencies: Console IO Class Tools
     */
     
     public static void showResults( double result, int inputSelection ) 
     {
        // initialize method/variables
        int integerResult = (int)result;
        
        // display the appropriate output operation
        switch ( inputSelection )
        {
           // check if the input selection was findNextPrime
           case FIND_NEXT_PRIME:
              // display the text for next prime value
                 // method: printString
              conIO.printString( "Next prime value is: ");
              
              // display the next prime value
                 // method: printInt, printEndline
              conIO.printInt( integerResult );
              conIO.printEndlines( TWO_ENDLINES );
              break;
              
           // check if the input selection was findSine
           case FIND_SINE:
              // display the text for the sine value
                 // method: printString
              conIO.printString( "Sine value is: ");
           
              // display the sine value
                 // method: printDouble, printEndline
              conIO.printDouble( result, LONG_PRECISION );
              conIO.printEndlines( TWO_ENDLINES );
             break;
              
           // in all other cases, the input selection was findSquareRoot
           default:
              // display the text for the square root value
                 // method: printString
              conIO.printString( "Square root is: ");

              // display the square root value
                 // method: printDouble, printEndline
              conIO.printDouble( result, LONG_PRECISION );
              conIO.printEndlines( TWO_ENDLINES );
              break;
           
        }
        
     }
     
   }
