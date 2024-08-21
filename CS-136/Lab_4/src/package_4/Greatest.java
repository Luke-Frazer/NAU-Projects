package package_4;

public class Greatest
{

      // set table characters
      private static final char PIPE = '|';
      private static final String PIPE_SPACE = "| ";
      private static final String SPACE_PIPE = " |";
      private static final char THICK_LINE = '=';
      private static final char THIN_LINE = '-';

      // set title width
      private static final int TITLE_WIDTH = 36;
      
      // set table widths
      private static final int TABLE_WIDTH = 60;
      private static final int LEFT_COLUMN_WIDTH = 40;
      private static final int RIGHT_COLUMN_WIDTH = 17;
      
      // set endlines value
      private static final int TWO_ENDLINES = 2;
      
      // precision
      private static final int PRECISION = 3;
      
      // string justify constants 
      private static final String LEFT_JUSTIFY = "LEFT";
      private static final String RIGHT_JUSTIFY = "RIGHT";
      private static final String CENTER_JUSTIFY = "CENTER";

      // (static) IO object
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String[] args)
      {

         // declare and initialize variables
            
            // declare the three numbers being compared
            double first;
            double second;
            double third;
            
            // declare the result number
            double result;
         
         // show title and thick line
            
            // show the title
               // method: printString, printEndline
            conIO.printString( "FIND THE GREATEST OF THREE NUMBERS: " );
            conIO.printEndline();
           
            // show the thick line
               // method: printChars, printEndlines
            conIO.printChars( TITLE_WIDTH, THICK_LINE );
            conIO.printEndlines( TWO_ENDLINES );
         
         // get input from the user
            
            // get the first number
               // method: promptForDouble
            first = conIO.promptForDouble( "Enter the first number: " );
            
            // get the second number
               // method: promptForDouble
            second = conIO.promptForDouble( "Enter the second number: " );
         
            // get the third number
               // method: promptForDouble, printEndline
            third = conIO.promptForDouble( "Enter the third number: " );
            conIO.printEndline();
         
         // get greatest number
            
            // set result value as largest number from the getGreatest method
               // method: getGreatest
            result = getGreatest( first, second, third );
         
         // display results
            // method: displayResult;
            displayResult( first, second, third, result );
                     
         // end main
            
      }
      
      public static double getGreatest( double first, double second,
                                                                 double third )
      {
            
         // check if the first value is greater than the other two
         if( first > second && first > third )
            {
               return first;
            }
         
         // check if the second value is greater than the other two
         else if( second > third )
            {
               return second;
            }
         
         // otherwise, third is the largest value
         else 
            {
               return third;
            }
         
      }

      public static void displayResult( double first, double second,
                                                  double third, double result )
      {
            
         // display the top line of the table
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the first number line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( "First Number", LEFT_COLUMN_WIDTH, LEFT_JUSTIFY );
         conIO.printChar( PIPE );
         conIO.printDouble( first, PRECISION, RIGHT_COLUMN_WIDTH, 
                                                               RIGHT_JUSTIFY );
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display the divider line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( LEFT_COLUMN_WIDTH + 1, THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printChars( RIGHT_COLUMN_WIDTH + 1, THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the second number line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( "Second Number", LEFT_COLUMN_WIDTH, LEFT_JUSTIFY );
         conIO.printChar( PIPE );
         conIO.printDouble( second, PRECISION, RIGHT_COLUMN_WIDTH,
                                                               RIGHT_JUSTIFY );
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display the divider line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( LEFT_COLUMN_WIDTH + 1, THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printChars( RIGHT_COLUMN_WIDTH + 1, THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
      
         // display the third number line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( "Third Number", LEFT_COLUMN_WIDTH, LEFT_JUSTIFY );
         conIO.printChar( PIPE );
         conIO.printDouble( third, PRECISION, RIGHT_COLUMN_WIDTH, 
                                                               RIGHT_JUSTIFY );
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
            
         // display the thick divider line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the result line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( "Result Number", LEFT_COLUMN_WIDTH, LEFT_JUSTIFY );
         conIO.printChar( PIPE );
         conIO.printDouble( result, PRECISION, RIGHT_COLUMN_WIDTH,
                                                               RIGHT_JUSTIFY );
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display the bottom line of the table
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
      }
         
}
