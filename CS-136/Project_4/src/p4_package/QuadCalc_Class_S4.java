package p4_package;


public class QuadCalc_Class_S4
   {
      
      // Constants
      // table display characters
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      public static final char CROSS = '+';

      // table display strings
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      public static final String CROSS_SPACE = "+ ";
      
      // table display integers
      public static final int PRECISION = 2;
      public static final int TABLE_WIDTH = 44;
      public static final int NAME_BLOCK_WIDTH = 29;
      public static final int VALUE_BLOCK_WIDTH = 12;

      // for use with printEndlines method
      public static final int TWO_ENDLINES = 2;
      
      // for comparisons
      public static final double PRECISION_OFFSET = 0.000001;

      public static void main( String[] args )
         {

         // initialize program
         
            // initialize and declare variables
            Console_IO_Class conIO = new Console_IO_Class();
            double coeffA;
            double coeffB;
            double coeffC;
            double discriminant;
            double denominator;
            double discriminantSqrt;
            double rootOne;
            double rootTwo;
            
            // show title with underline
               // method: printString, printChars, printEndline, printEndlines
            conIO.printString( "Quadratic Root Finding Program" );
            conIO.printEndline();
            conIO.printChars( NAME_BLOCK_WIDTH + 1, DOUBLE_DASH );
            conIO.printEndlines( TWO_ENDLINES );
         
         // get the inputed values from the user
         
            // ask for the coefficient a
               // method: promptForInt
            coeffA = conIO.promptForDouble( "     Enter coefficient a: " );
         
            // ask for the coefficient b
               // method: promptForInt
            coeffB = conIO.promptForDouble( "     Enter coefficient b: " );
         
            // ask for the coefficient c
               // method: promptForInt
            coeffC = conIO.promptForDouble( "     Enter coefficient c: " );
            conIO.printEndlines( TWO_ENDLINES );
         
         // process the data and find roots
         
            // break the quadratic formula into pieces
               // define the discriminant, discriminantSquared, and denominator
            discriminant = ( ( coeffB * coeffB ) - ( 4 * coeffA * coeffC ) );
            discriminantSqrt = Math.sqrt( discriminant );
            denominator = ( 2 * coeffA );
            
            // find root one
            rootOne = ( ( -coeffB + discriminantSqrt ) / denominator );
            
            // find root two
            rootTwo = ( ( -coeffB - discriminantSqrt ) / denominator );
            
         // display the output
         
            // display top line
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( TABLE_WIDTH - PRECISION, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display title of table
               // method: printChar, printString, printEndline
            conIO.printChar( PIPE );
            conIO.printString( "QUADRATIC ROOT RESULTS", 
                                            TABLE_WIDTH - PRECISION, "CENTER" );  
            conIO.printChar( PIPE );
            conIO.printEndline();

            // display underline of title
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( TABLE_WIDTH - PRECISION, DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display two subtitles
               // method: printChar, printString, printEndline
            conIO.printChar( PIPE );
            conIO.printString( "VALUE NAME", NAME_BLOCK_WIDTH, "CENTER" );  
            conIO.printChar( PIPE );
            conIO.printString( "VALUE", VALUE_BLOCK_WIDTH, "CENTER" );  
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display underline of subtitles
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display coefficient a in the table
               // method: printChar, printString, printDouble, printEndline
            conIO.printString( PIPE_SPACE );
            conIO.printString( "Coefficient A", NAME_BLOCK_WIDTH - 1, "LEFT" );  
            conIO.printChar( CROSS );
            conIO.printDouble( coeffA, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                      "RIGHT" );
            conIO.printString( SPACE_PIPE );
            conIO.printEndline();
            
            // display underline of coefficient a
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( NAME_BLOCK_WIDTH, DASH );
            conIO.printChar( PIPE );
            conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display coefficient b in the table
               // method: printChar, printString, printDouble, printEndline
            conIO.printString( PIPE_SPACE );
            conIO.printString( "Coefficient B", NAME_BLOCK_WIDTH - 1, "LEFT" );  
            conIO.printChar( CROSS );
            conIO.printDouble( coeffB, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                      "RIGHT" );
            conIO.printString( SPACE_PIPE );
            conIO.printEndline();
         
            // display underline of coefficient b
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( NAME_BLOCK_WIDTH, DASH );
            conIO.printChar( PIPE );
            conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display coefficient c in the table
               // method: printChar, printString, printDouble, printEndline
            conIO.printString( PIPE_SPACE );
            conIO.printString( "Coefficient C", NAME_BLOCK_WIDTH - 1, "LEFT" );  
            conIO.printChar( CROSS );
            conIO.printDouble( coeffC, PRECISION, VALUE_BLOCK_WIDTH - 1,
                                                                      "RIGHT" );
            conIO.printString( SPACE_PIPE );
            conIO.printEndline();
         
            // display thick underline of coefficient c
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display roots or if there are complex roots
               // check if the equation is trying to find the square root of 
               //    a negative number, making the roots complex
            if ( discriminant <= -PRECISION_OFFSET )
               {
                  // display the roots line with the value
                     // method: printString, printChar, printEndline
                  conIO.printString( PIPE_SPACE );
                  conIO.printString( "Roots", NAME_BLOCK_WIDTH - 1, "LEFT" );  
                  conIO.printChar( CROSS );
                  conIO.printString( "Complex", VALUE_BLOCK_WIDTH - 1,
                                                                      "RIGHT" );
                  conIO.printString( SPACE_PIPE );
                  conIO.printEndline();
               }
            
               // check if there is one root
            else if ( rootOne == rootTwo )
               {
                  // display the single root line with the value
                     // method: printString, printChar, 
                     //    printDouble, printEndline
                  conIO.printString( PIPE_SPACE );
                  conIO.printString( "Single Root", NAME_BLOCK_WIDTH - 1, 
                                                                       "LEFT" );  
                  conIO.printChar( CROSS );
                  conIO.printDouble( rootOne, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                      "RIGHT" );
                  conIO.printString( SPACE_PIPE );
                  conIO.printEndline();
               }
            
               // otherwise, there are two roots
            else 
               {
                  // display the root one line with the value of root one
                     // method: printString, printChar, 
                     //    printDouble,  printEndline
                  conIO.printString( PIPE_SPACE );
                  conIO.printString( "Root One", NAME_BLOCK_WIDTH - 1, "LEFT" );  
                  conIO.printChar( CROSS );
                  conIO.printDouble( rootOne, PRECISION, VALUE_BLOCK_WIDTH - 1,
                                                                      "RIGHT" );
                  conIO.printString( SPACE_PIPE );
                  conIO.printEndline();
                  
                  // display the table line separator 
                     // method: printChar, printChars, printEndline
                  conIO.printChar( PIPE );
                  conIO.printChars( NAME_BLOCK_WIDTH, DASH );
                  conIO.printChar( PIPE );
                  conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
                  conIO.printChar( PIPE );
                  conIO.printEndline();
                  
                  // display the root two line with the value
                     // method: printString, printChar, 
                     //    printDouble,  printEndline
                  conIO.printString( PIPE_SPACE );
                  conIO.printString( "Root Two", NAME_BLOCK_WIDTH - 1, "LEFT" );  
                  conIO.printChar( CROSS );
                  conIO.printDouble( rootTwo, PRECISION, VALUE_BLOCK_WIDTH - 1,
                                                                      "RIGHT" );
                  conIO.printString( SPACE_PIPE );
                  conIO.printEndline();
               }
         
            // display bottom line of table
               // method: printChar, printChars, printEndlines
            conIO.printChar( PIPE );
            conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
            conIO.printChar( PIPE );
            conIO.printEndlines( TWO_ENDLINES );
         
         // end program
            
            // display end program
               // method: printString, printEndline
            conIO.printString( "End Program" );
            conIO.printEndline();
         }

   }
