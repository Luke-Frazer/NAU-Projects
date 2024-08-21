package package_5;

public class InvestmentCalculator
   {

      // initialize table characters
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      
      // initialize table string components
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      
      // initialize two endlines constant
      public static final int TWO_ENDLINES = 2;
      
      // initialize table widths
      public static final int PRECISION = 3;
      public static final int TABLE_WIDTH = 58;
      public static final int LEFT_COLUMN_WIDTH = 40;
      public static final int RIGHT_COLUMN_WIDTH = 17;
      
      // initialize offset constants
      public static final String LEFT_ALIGN = "LEFT";
      public static final String RIGHT_ALIGN = "RIGHT";
      
      // initialize console IO as a global variable
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main( String[] args )
         {

         // initialize program
            
            // initialize title variables
            String title = "INVESTMENT CALCULATOR:";
            int titleLength = title.length();
            
            // initialize input variables
            double principle;
            double rate;
            int years;
            
            //initialize processing variables
            double doublingPeriod;
            double total;
            int compoundsPerYear = 1;
            
            // display the title
               // method: printString, printChars, printEndline, printEndlines
            conIO.printString( title );
            conIO.printEndline();
            conIO.printChars( titleLength, DOUBLE_DASH);
            conIO.printEndlines( TWO_ENDLINES );
            
         // get the inputed values from the user
            
            // get the original investment
               // method: promptForDouble
            principle = conIO.promptForDouble( 
                                           "Enter the original investment: " );
            
            // get the rate of return % 
               // method: promptForDouble
            rate = conIO.promptForDouble( "Enter the rate of return in %: " );
            
            // get the number of years
               // method: promptForInt, printEndline
            years = conIO.promptForInt( "Enter the number of years: " );
            conIO.printEndline();
            
         // process the data
            
            // compute the total
               // method: computeTotal
            total = computeTotal( principle, rate, years, compoundsPerYear );
            
            // compute the doubling period
               // method: computeDoublingPeriod
            doublingPeriod = computeDoublingPeriod( rate );
            
         // display the output
            
            // display the result in table format
               // method: displayResult
            displayResult( principle, total, doublingPeriod );
            
         // end program
            
         }
      
      /*
      name: computeTotal
      process: computes the sum of the starting investment (principle) plus the
      compounded interest over a given number of years at a given interest rate
      method input/parameters: the starting principle investment (double), the 
      given interest rate (double), the number of years (int) and the number of
                                                      compounds per year (int)
      method output/parameters: none
      method output/returned: the total sum after the calculations (double)
      device input/keyboard: none
      device output/monitor: the end program line
      dependencies: none
      */
      
      public static double computeTotal( double principle, double rate,
                                        int years, int numberCompoundsPerYear )
      {
         // initialize method/variables
         int hundred = 100;
         int formulaConstant = 1;
         double parenthesis;
         double exponent;
         double trueRate = rate / hundred;
         double total;

         // calculate the number in the parenthesis
         parenthesis = ( formulaConstant + ( trueRate / 
                                                    numberCompoundsPerYear ) );
         
         // calculate the exponent
         exponent = ( numberCompoundsPerYear * years );
         
         // calculate the total
         total = principle * Math.pow( parenthesis, exponent );
        
         // return the total
         return total;
      }
      
      /*
      name: computeDoublingPeriod
      process: computes the period of time during which the original investment
                                          doubles by way of compounded interest
      method input/parameters: the compounded interest rate (double)
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: none 
      dependencies: none 
      */
      
      public static double computeDoublingPeriod( double rate )
      {
         // initialize method/variables
         int ruleOf72 = 72;
         double doublingPeriod;
         
         // calculate the doubling period
         doublingPeriod = ruleOf72 / rate;
         
         // return the result
         return doublingPeriod;
      }

      /*
      name: displayResult
      process: displays the final result in table format
      method input/parameters: the principle investment (double), the total  
                                     (double), and the doubling period (double)
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: The table with the proper values and subtitles
      dependencies: Console IO Class Tools
      */
      
      public static void displayResult( double principle, double total,
                                                        double doublingPeriod )
      {
         // initialize method/variables
         String principleTitle = "Principle";
         String interestTitle = "Principle + Compounded Interest";
         String doublingPeriodTitle = "Approximate Doubling Period";

         // display the top line of table
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH, DOUBLE_DASH );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the principle line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( principleTitle, LEFT_COLUMN_WIDTH - 1, 
                                                                  LEFT_ALIGN );
         conIO.printChar( PIPE );
         conIO.printDouble( principle, PRECISION, RIGHT_COLUMN_WIDTH - 1,
                                                                 RIGHT_ALIGN );   
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display thick divider line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH, DOUBLE_DASH );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the principle + interest line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( interestTitle, LEFT_COLUMN_WIDTH - 1, 
                                                                  LEFT_ALIGN );
         conIO.printChar( PIPE );
         conIO.printDouble( total, PRECISION, RIGHT_COLUMN_WIDTH - 1,
                                                                 RIGHT_ALIGN );   
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();

         // display thin divider line
         conIO.printChar( PIPE );
         conIO.printChars( LEFT_COLUMN_WIDTH, DASH );
         conIO.printChar( PIPE );
         conIO.printChars( RIGHT_COLUMN_WIDTH, DASH );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the doubling period line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( doublingPeriodTitle, LEFT_COLUMN_WIDTH - 1, 
                                                                  LEFT_ALIGN );
         conIO.printChar( PIPE );
         conIO.printDouble( doublingPeriod, PRECISION, RIGHT_COLUMN_WIDTH - 1,
                                                                 RIGHT_ALIGN );   
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display the bottom thick line
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH, DOUBLE_DASH );
         conIO.printChar( PIPE );
         conIO.printEndline();
      }
      
   }
