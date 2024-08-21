package package_2;

public class FahrenheitToCelsius
   {
      // set table characters
      private static final char    PIPE        =  '|';
      private static final String  PIPE_SPACE  =  "| ";
      private static final String  SPACE_PIPE  =  " |";
      private static final char    THICK_LINE  =  '=';
      private static final char    THIN_LINE   =  '-';

      // set table widths
      private static final int TABLE_WIDTH         = 60;
      private static final int LEFT_COLUMN_WIDTH   = 40;
      private static final int RIGHT_COLUMN_WIDTH  = 17;
      private static final int TITLE_WIDTH         = 32;
      
      // conversion constants
      private static final double F_TO_C_OFFSET = 32;
      private static final double F_TO_C_FACTOR  = 5.0/9.0;
      private static final int    C_PRECISION     = 3;
      private static final int    F_PRECISION     = 1;
      
      // other constants
      private static final int TWO_END_LINES = 2;
      private static final int WIDTH_ADD   = 1;
      
      // title constant
      private static final String  TITLE  = "FAHRENHEIT TO CELSIUS CONVERSION";
      
      // string constants
      private static final String  F_PROMPT  = "Enter Fahrenheit Value: ";
      private static final String  FAR  = "FAHRENHEIT";
      private static final String  CEL  = "CELSIUS";
      private static final String  LEFT  = "LEFT";
      private static final String  RIGHT  = "RIGHT";

      public static void main( String[] args )
         {
            
         // initialize program
            // declare and initialize variables
            Console_IO_Class conIO = new Console_IO_Class();
            double fahrenheit;
            double celsiusAnswer;

         // show title and thick line
            // display title
               // method: printString, printEndline
            conIO.printString( TITLE );
            conIO.printEndline();
            
            // display thick underline
               // method: printChars, printEndlines
            conIO.printChars( TITLE_WIDTH, THICK_LINE );
            conIO.printEndlines( TWO_END_LINES );
            
         // get the input from the user
            // get fahrenheit value
               // method: promptForDouble, printEndline
            fahrenheit = conIO.promptForDouble( F_PROMPT );
            conIO.printEndline();
            
         // calculate result
            celsiusAnswer = (fahrenheit - F_TO_C_OFFSET) * (F_TO_C_FACTOR);
            
         // display result
            // first line, thick line
               // method: printEndline, printChar, printChars
            conIO.printChar( PIPE );
            conIO.printChars( TABLE_WIDTH, THICK_LINE );
            conIO.printChar( PIPE );
            conIO.printEndline();
            
            // show first line of content of table
            // display left column
               // method: printString
            conIO.printString( PIPE_SPACE );
            conIO.printString( FAR, LEFT_COLUMN_WIDTH, LEFT );
            
            // separate column
               // method: printChar
            conIO.printChar( PIPE);
            
            // display right side of column
               // method: printString, printDouble, printEndline
            conIO.printDouble( fahrenheit, F_PRECISION, RIGHT_COLUMN_WIDTH,
                                                                        RIGHT );
            conIO.printString( SPACE_PIPE );
            conIO.printEndline();
            
            // show divider thin line of content of table
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( LEFT_COLUMN_WIDTH + WIDTH_ADD, THIN_LINE );
            conIO.printChar( PIPE );
            conIO.printChars( RIGHT_COLUMN_WIDTH + WIDTH_ADD, THIN_LINE );
            conIO.printChar( PIPE );
            conIO.printEndline();
            
            // show second line of content of table
            // display left column
               // method: printString
            conIO.printString( PIPE_SPACE );
            conIO.printString( CEL, LEFT_COLUMN_WIDTH, LEFT );
            
            // separate column
               // method: printString
            conIO.printChar( PIPE );
            
            // display right side of column
               // method: printDouble, printString, printEndline
            conIO.printDouble( celsiusAnswer, C_PRECISION, 
                                                  RIGHT_COLUMN_WIDTH, RIGHT );
            conIO.printString( SPACE_PIPE );
            conIO.printEndline();
            
            // show bottom thick line of table
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( TABLE_WIDTH, THICK_LINE );
            conIO.printChar( PIPE );
            conIO.printEndline();
            
        // end program

         }

   }
