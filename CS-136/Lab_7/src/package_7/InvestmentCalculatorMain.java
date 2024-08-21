package package_7;


/**
 * Driver to test objects of type InvestmentCalculator
 * 
 * @author Dr.-Ing. Wolf-Dieter Otte
 */
public class InvestmentCalculatorMain
{
   // Constant that has the char to construct "thick" lines 
   public static final char THICK_LINE = '=';
   
   // io object to be used in main()
   public static Console_IO_Class conIO = new Console_IO_Class();
      
   /**
    * Get things started ...
    * @param args Command line arguments, not used
    */
   public static void main( String args[] ) 
   {
      // declare and initialize variables
      
         // initialize title variables
         String title = "INVESTMENT CALCULATOR:";
         int titleLength = title.length();
         double principle, rate;
         int years;
         
         InvestmentCalculator calcDefault = null;
         InvestmentCalculator calcInit    = null;
         InvestmentCalculator calcCopy    = null;
         
         // show title and thick line
            // method: printString, printEndline, printChars
         conIO.printString( title );
         conIO.printEndline();
         conIO.printChars( titleLength, THICK_LINE);
         conIO.printEndline();
        
        
      // ============== Testing Default Constructor ==============
      
         // Create object of type InvestmentCalculator by invoking
         //                                                 default constructor
         // define calcDefault as the object
         calcDefault = new InvestmentCalculator();
         
         // Print control message   
            // method: println, printEndline
         System.out.println("\nTesting Default Constructor");
         conIO.printEndline();
         
         // Print out result
            // method: displayResult, printEndline
         calcDefault.displayResult();
         conIO.printEndline();
      
      // ============== Testing Initialization Constructor ==============

         // get input from user
           // method: promptForDouble, promptForInt
         principle = conIO.promptForDouble( "Enter the original investment: " );
         rate      = conIO.promptForDouble( "Enter the rate of return in %: " );
         years     = conIO.promptForInt   ( "Enter the number of years: " );
   
         // Create object of type InvestmentCalculator by invoking 
         //                                          initialization constructor
         // define the calcInit as the object
         calcInit = new InvestmentCalculator( principle, rate, years );
         
         // Print control message
            // method: println, printEndline
         System.out.println("\nTesting Initialization Constructor");
         conIO.printEndline();
   
         // Print out result
            // method: displayResult, printEndline
         calcInit.displayResult();
         conIO.printEndline();
   
     // ============== Testing Copy Constructor ==============

         // Create object of type InvestmentCalculator by invoking copy 
         //                                                        constructor
         // We will use the object created by the initialization constructor 
         //                       to be copied from InvestmentCalculator (this)
         // define calcDefault to the object
         calcCopy = new InvestmentCalculator( calcInit );
         
         // Print control message
            // method: println, printEndline
         System.out.println("\nTesting Copy Constructor");
         conIO.printEndline();
   
         // Print out result
            // method: displayResult
         calcCopy.displayResult();

   }
}