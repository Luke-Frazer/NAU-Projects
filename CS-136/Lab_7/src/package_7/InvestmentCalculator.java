package package_7;

public class InvestmentCalculator 
{
    // finance constants
    private static final int NUM_COMPOUNDS_PER_YEAR = 1;
    private static final int RULE_OF_72_FACTOR = 72;
    
    // default constructor default values
    private static final double DEFAULT_RATE = 0.05;
    private static final double DEFAULT_PRINCIPLE = 100000;
    private static final int    DEFAULT_YEARS = 30;
    
   // set table characters
   private static final char PIPE = '|';
   private static final String PIPE_SPACE = "| ";
   private static final String SPACE_PIPE = " |";
   private static final char THICK_LINE = '=';
   private static final char THIN_LINE = '-';

   // set table widths
   private static final int TABLE_WIDTH = 60;
   private static final int LEFT_COLUMN_WIDTH = 40;
   private static final int RIGHT_COLUMN_WIDTH = 17;

   // precision
   private static final int PRECISION = 3;

   // member variables
   private double principle;
   private double rate;
   private int    years;

   /*
   name: constructor - default
   process: initializes object to default values provided as constants
   method input/parameters: none
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: none 
   dependencies: none 
   */
   
   /**
    * Default constructor
    */
   public InvestmentCalculator()
   {

      // initialize principle, rate, and years to default quantities 
      principle = DEFAULT_PRINCIPLE;
      rate = DEFAULT_RATE;
      years = DEFAULT_YEARS;
      
   }
   
   /*
   name: constructor - initialize 
   process: initializes object to variables provided as parameters
   method input/parameters: the principle investment (double), rate (double)
                                                  and the number of years (int)
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: none 
   dependencies: none 
   */
   
   /**
    * Initialization Constructor
    * 
    * @param principle Initial investment
    * @param rate Rate of return
    * @param years Number of years compounded
    */
   public InvestmentCalculator( double setPrinciple, double setRate,
                                                                 int setYears )
   {
      // initialize principle, rate, and years to given (parameter) quantities
      principle = setPrinciple;
      rate = setRate / 100;
      years = setYears;

    }

   
   /*
   name: constructor - copy
   process: initializes object to values provided from other object
   method input/parameters: copied object reference (InvestmentCalculator)
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: none 
   dependencies: Alternative constructor call 
                         - this( copied.principle, copied.rate, copied. years )
   */
   
   /**
    * Copy constructor
    * 
    * @param copied Object to copy from
    */
   public InvestmentCalculator( InvestmentCalculator copied )
   {
      // initialize principle, rate, and years to copied quantities
      this.principle = copied.principle;
      this.rate = copied.rate;
      this.years = copied.years;

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
   
   /**
    * Computes number of years in which the principle doubles by compounding interest
    * 
    * @return Returns number of years
    */
   public double computeDoublingPeriod( double rate )
   {
      // initialize method/variables
      int ruleOf72 = RULE_OF_72_FACTOR;
      double doublingPeriod;
      
      // calculate the doubling period
      doublingPeriod = ruleOf72 / ( rate * 100 );
      
      // return the result
      return doublingPeriod;
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
   
   /**
    * Computes Computes the overall total, after the principle has compounded
    * for the given number of years at the given rate of return
    * 
    * @return Returns the overall total
    */
   public double computeTotal( double principle, double rate,
                                    int years ) 
   {
      // initialize method/variables
         int formulaConstant = 1;
         double parenthesis;
         double exponent;
         double total;
   
         // calculate the number in the parenthesis
         parenthesis = ( formulaConstant + ( rate / 
                                                   NUM_COMPOUNDS_PER_YEAR ) );
         
         // calculate the exponent
         exponent = ( NUM_COMPOUNDS_PER_YEAR * years );
         
         // calculate the total
            // method: pow
         total = principle * Math.pow( parenthesis, exponent );
        
         // return the total
         return total;    
   }

   /*
   name: displayResult
   process: displays the final result in table format
   method input/parameters: none
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: The table with the proper values and subtitles
   dependencies: Console IO Class Tools
   */
   
   /**
    * Displays the results in table format
    */
   public void displayResult() 
   {
         // initialize conIO variable  
         Console_IO_Class conIO = new Console_IO_Class();
         
         // initialize variables
         String principleTitle = "Principle";
         String interestTitle = "Principle + Compounded Interest";
         String doublingPeriodTitle = "Approximate Doubling Period";
           
         // initialize methods for computation
            // method: computeDoublingPeriod, computeTotal
         double doublingPeriod = computeDoublingPeriod( rate );
         double total = computeTotal( principle, rate, years );
   
         // display the top line of table
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH - 2, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the principle line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( principleTitle, LEFT_COLUMN_WIDTH - 1, "LEFT" );
         conIO.printChar( PIPE );
         conIO.printDouble( principle, PRECISION, RIGHT_COLUMN_WIDTH - 1,
                                                                     "RIGHT" );   
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display thick divider line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH - 2, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the principle + interest line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( interestTitle, LEFT_COLUMN_WIDTH - 1, "LEFT" );
         conIO.printChar( PIPE );   
         conIO.printDouble( total, PRECISION, RIGHT_COLUMN_WIDTH - 1, "RIGHT" );   
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
   
         // display thin divider line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( LEFT_COLUMN_WIDTH, THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printChars( RIGHT_COLUMN_WIDTH, THIN_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
         
         // display the doubling period line
            // method: printString, printChar, printDouble, printEndline
         conIO.printString( PIPE_SPACE );
         conIO.printString( doublingPeriodTitle, LEFT_COLUMN_WIDTH - 1, 
                                                                      "LEFT" );
         conIO.printChar( PIPE );
         conIO.printDouble( doublingPeriod, PRECISION, RIGHT_COLUMN_WIDTH - 1,
                                                                     "RIGHT" );   
         conIO.printString( SPACE_PIPE );
         conIO.printEndline();
         
         // display the bottom thick line
            // method: printChar, printChars, printEndline
         conIO.printChar( PIPE );
         conIO.printChars( TABLE_WIDTH - 2, THICK_LINE );
         conIO.printChar( PIPE );
         conIO.printEndline();
   }

}