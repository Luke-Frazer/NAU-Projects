package package_3;

import java.math.*;

public class GoldenRatio
   {

      // set table characters
      private static final char   PIPE       = '|';
      private static final char   THICK_LINE = '=';
      private static final char   THIN_LINE  = '-';
      private static final String PIPE_SPACE = "| ";
      private static final String SPACE_PIPE = " |";
      
      // set table widths
      private static final char TABLE_WIDTH        = 60;
      private static final char LEFT_COLUMN_WIDTH  = 40;
      private static final char RIGHT_COLUMN_WIDTH = 17;

      // constants for computing the golden ratio
      private static final double GOLDEN_RATIO_INVERSE = (Math.sqrt(5)-1)/2;
      private static final int    PRECISION = 3;
      
      // other constants
      private static final int TWO_END_LINES = 2;
            
      public static void main( String[] args )
         {

            // declare and initialize variables
            Console_IO_Class conIO = new Console_IO_Class();
            int titleOffset = 8;
            double length;
            double longPart;
            double shortPart;
            
            // show title and thick line
               // method: printString, printEndline, printChars, printEndlines
            conIO.printString( "COMPUTE GOLDEN RATIO PART OF LINE WITH "
                                                            + "GIVEN LENGTH:" );
            conIO.printEndline();
            conIO.printChars( TABLE_WIDTH - titleOffset, THICK_LINE );
            conIO.printEndlines( TWO_END_LINES );
            
            // get input from user
               // method: promptForDouble, printEndline
            length = conIO.promptForDouble( "Enter the length of line: " );
            conIO.printEndline();
            
            // calculate long part
               // method: calcLongPart
            longPart = calcLongPart( length );
            
            // calculate short part
               // method: calcShortPart
            shortPart = calcShortPart( length );
            
            // display results
               // method: displayResult
            displayResult( longPart, shortPart );
            
         // end main
            
         }
      
      public static double calcLongPart( double length )
      {
         
         // initialize variable
         double longPart;
         
         // calculate the long part using the golden ratio equation
         longPart = length * GOLDEN_RATIO_INVERSE;
         return longPart;
         
      }
      
      public static double calcShortPart( double length )
      {
         
         // initialize variables
         double longPart = calcLongPart ( length );
         double shortPart;
         
         // calculate the short part
         shortPart = length - longPart;
         return shortPart;
         
      }
      
      public static void displayResult( double longPart, double shortPart )
      {
         
         // initialize variables
         Console_IO_Class conIO = new Console_IO_Class();
         int tableOffset = 1;
         String leftOffset  = "LEFT";
         String rightOffset = "RIGHT";
         
         // print the top line of the table
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH - tableOffset, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();

         // print the Long Part line
            // method: printString, printChar, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( "Long Part", 
                                 LEFT_COLUMN_WIDTH - tableOffset, leftOffset );
         conIO.printChar( PIPE );
         conIO.printDouble( longPart, PRECISION, RIGHT_COLUMN_WIDTH, 
                                                                  rightOffset);
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // print divider line
            // method: printChar, printChars, printEndline 
         conIO.printChar( PIPE );
         conIO.printChars( LEFT_COLUMN_WIDTH,  THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printChars( RIGHT_COLUMN_WIDTH + tableOffset,  THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // print the Short Part line
            // method: printString, printChar, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( "Short Part", 
                                 LEFT_COLUMN_WIDTH - tableOffset, leftOffset );
         conIO.printChar( PIPE );
         conIO.printDouble( shortPart, PRECISION, RIGHT_COLUMN_WIDTH, 
                                                                  rightOffset);
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // print the bottom line of the table
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH - tableOffset, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
      }

   }
