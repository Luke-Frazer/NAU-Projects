package modprog_package;

public class ModProgramClass
   {
      
      private static final int TWO_END_LINES = 2; 
      
      private static final char COMMA = ','; 

      
      public static void main( String[] args )
      {
         
         // initialize the program
         
            // initialize the variables
            Console_IO_Class conIO = new Console_IO_Class();
            int dividend, divisor;
            int quotient, remainder;
            
         
            // show the title
               // printString, printEndlines
            conIO.printString( "Division Program" );
            conIO.printEndline();
            conIO.printString( "================" );
            conIO.printEndlines( TWO_END_LINES );
            
         // ask the user for input
         
            // get the dividend from the user
               // method: promptForInt
            dividend = conIO.promptForInt( "Enter the dividend: " );
            
         
            // get the divisor from the user
               //method: promptForInt
            divisor = conIO.promptForInt( "Enter the divisor: " );

         
         // calculate the quotient and remainder
         
            // calculate the quotient of the data
            quotient = dividend / divisor;
         
            // calculate the remainder of the data
            remainder = dividend % divisor;
         
         // display the results
            // method: printString, printInt, printEndlines
         conIO.printString( "With a dividend of " );
         conIO.printInt( dividend );
         conIO.printString( ", and a divisor of " );
         conIO.printInt( divisor );
         conIO.printChar( COMMA );
         conIO.printEndline();
         conIO.printString( "With a quotient of " );
         conIO.printInt( quotient );
         conIO.printString( ", and the remainder is: " );
         conIO.printInt( remainder );
         conIO.printEndlines( TWO_END_LINES );
         
         // end the program
         
            // display the program end
               // method: printString, printEndline
            conIO.printString( "Program End" );
            conIO.printEndline();
         
      }
   }
