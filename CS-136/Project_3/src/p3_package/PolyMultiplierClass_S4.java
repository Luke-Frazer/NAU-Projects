package p3_package;

public class PolyMultiplierClass_S4
   {

      private static final char THICK_LINE  =  '=';
      
      private static final int TITLE_WIDTH  =  21;
      private static final int TWO_END_LINES  =  2;
      
      private static final String EQUATION = "( ax + b ) * ( cx + d )";
      private static final String TITLE    = "Polynomial Calculator";
      private static final String END = "Program End";
      private static final String EQUALS  =  " = ";
      private static final String X_PLUS = "x + ";
      private static final String X_SQUARED_PLUS = "x^2 + ";
      
      public static void main( String[] args )
         {

         // initialize program
            
            // initialize variables
            Console_IO_Class conIO = new Console_IO_Class();
            int coeffA;
            int coeffB;
            int coeffC;
            int coeffD;
            int xSquaredCoeff;
            int xCoeff;
            int numCoeff;
            
            String numberedEquation;
            String result;
            
            // show title, with underline
               // method: printString, printChars, printEndline, printEndlines
            conIO.printString( TITLE );
            conIO.printEndline();
            conIO.printChars( TITLE_WIDTH, THICK_LINE );
            conIO.printEndlines( TWO_END_LINES );
            
            // show equation form with text
               // method: printString, printEndline, printEndlines
            conIO.printString( "Multiplies two polynomial expressions" );
            conIO.printEndline();
            conIO.printString( "  in the form: " + EQUATION );
            conIO.printEndlines( TWO_END_LINES );

         // get the information for each coefficient
            
            // ask for the coefficient a
               // method: promptForInt
            coeffA = conIO.promptForInt( "Enter coefficient a: " );
            
            // ask for the coefficient b
               // method: promptForInt
            coeffB = conIO.promptForInt( "Enter coefficient b: " );
            
            // ask for the coefficient c
               // method: promptForInt
            coeffC = conIO.promptForInt( "Enter coefficient c: " );

            // ask for the coefficient d
               // method: promptForInt, printEndlines
            coeffD = conIO.promptForInt( "Enter coefficient d: " );
            conIO.printEndlines( TWO_END_LINES );

         // conduct processing by splitting the equation into many lines
            
            // result for x^2 coefficient
            xSquaredCoeff = ( coeffA * coeffC );
            
            // result for x coefficient
            xCoeff = ( coeffA * coeffD ) + ( coeffB * coeffC );
                        
            // result for the number coefficient
            numCoeff = ( coeffB * coeffD );
            
            // create the equation with the user imputed numbers
            numberedEquation =  "( " + coeffA + X_PLUS + coeffB + " )*( "
                                              + coeffC + X_PLUS + coeffD + " )";
            
            // create the result
            result = xSquaredCoeff + X_SQUARED_PLUS + xCoeff + X_PLUS 
                                                                     + numCoeff;
            
         // display information
            
            // display result line
               // method: printString, printEndline
            conIO.printString( "Result: " );
            conIO.printEndline();
            
            // display final equation
               // method: printString, printEndlines
            conIO.printString( numberedEquation + EQUALS + result );
            conIO.printEndlines(TWO_END_LINES);
            
         // program end
            
            // display the program end
               // method: printString, printEndline
            conIO.printString( END );
            
         }

   }
