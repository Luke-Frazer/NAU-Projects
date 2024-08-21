package package_8;

public class TimesTable {

   // contains the dimensions of the times table
   private int rows = 0;
   private int cols = 0;
   
   // helper variables to be able to traverse through the array elements
   private int index_rows, index_cols;
   
   // default row and columns constants
   private final int DEFAULT_ROW = 10;
   private final int DEFAULT_COL = 10;
   
   // create the space constant
   private final char SPACE = ' ';
   
   // initialize the true value constant 
   private final int TRUE_VALUE = 1;
   
   // this variable holds the 2-dim array data
   int [][] timesTableData = null;
   
   /**
    * Initialization constructor
    * @param rows
    * @param cols
    */
   public TimesTable(int rows, int cols)
   {
      // set the dimensions
      this.rows = rows;
      this.cols = cols;
      
      // create new 2-dim integer object
      timesTableData = new int[rows][cols];
      
      // fill times table with data
      fillTimesTable();
   }
   
   /*
   name: constructor - default
   process: creates a times table object of 10x10 using the default values
   method input/parameters: none
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: none
   dependencies: none
   */
  
   public TimesTable()
   {
      // set the default dimensions using the default constants
      rows = DEFAULT_ROW;
      cols = DEFAULT_COL;
      
      // create the new 2-dim integer object using the row and column
      timesTableData = new int[rows][cols];
      
      // fill the table with data
      fillTimesTable();
   }
   
   
   /*
   name: fillTimesTable
   process: fills the times table with the proper data
   method input/parameters: none
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: none
   dependencies: none
   */
   
   private void fillTimesTable()
   {
      
      // create the multiplied number
      int multipliedNumber;
      
      // loop until the number of rows is reached
      for( index_rows = 0; index_rows < rows; index_rows++ )
         {
            
            // loop until the columns are reached
            for ( index_cols = 0; index_cols < cols; index_cols++ )
               {
                  // multiply the rows by the column
                  multipliedNumber = ( index_rows + TRUE_VALUE ) * 
                                                    ( index_cols + TRUE_VALUE );
                 
                  // set the row and column location to the found number 
                  timesTableData[ index_rows ][ index_cols ] = multipliedNumber;
                  
               }
         }
   }
   
   
   /*
   name: printTimesTable
   process: print the times table with columns spaced with spaces
   method input/parameters: none
   method output/parameters: none
   method output/returned: none
   device input/keyboard: none
   device output/monitor: the times table printout 
   dependencies: Console_IO_Class
   */
   
   void printTimesTable()
   {
      // create the IO object
      Console_IO_Class conIO = new Console_IO_Class(); 
      
      // create the default spacing value
      int defaultSpacing = 1;
      
      // create the medium spacing value
      int mediumSpacing = 2;
      
      // create the large spacing value
      int largeSpacing = 3;
      
      // loop until the number of rows is reached
      for( index_rows = 0; index_rows < rows; index_rows++ )
         {
            
            // loop until the columns are reached
            for ( index_cols = 0; index_cols < cols; index_cols++ )
               {
                  
                  // check if the number has more than
                  // print column location's value within the row with a space
                     // printInt
                  conIO.printInt( timesTableData[ index_rows ][ index_cols ] );
                  
                  // check if the number has more than 2 digits
                  if( timesTableData[ index_rows ][ index_cols ] > 99 )
                     {
                        // print 1 spaces to make up for the three digit number 
                        conIO.printChars( defaultSpacing, SPACE );
                     }
                  
                  // check if the number has more than one spacing
                  else if( timesTableData[ index_rows ][ index_cols ] > 9 )
                     {
                        // print 2 spaces to make up for the two digit number
                        conIO.printChars( mediumSpacing, SPACE );
                     }
                  
                  // otherwise, use single spacing
                  else 
                     {
                        // print 1 space for the one digit number
                        conIO.printChars( largeSpacing, SPACE );
                     }
                  
               }
            
            // print an endline to move to the next row
            conIO.printEndline();
         }
      
      // print an endline after the entire table
      conIO.printEndline();
      
   }
   
   
   /*
   name: getResult
   process: look up a specific number in the table and return the value
   method input/parameters: the row location a (int) and col location b (int)
   method output/parameters: none
   method output/returned: the looked up value
   device input/keyboard: none
   device output/monitor: none
   dependencies: none
   */ 
   
   int getResult(int a, int b)
   {
      
      // initialize the final value
      int finalValue;
      
      // initialize the true a value for the array
      int trueA = a - TRUE_VALUE;
      
      // initialize the true b value for the array
      int trueB = b - TRUE_VALUE;
      
      // get the index location value of a and b
      finalValue = timesTableData[ trueA ][ trueB ];
      
      // return the final value
      return finalValue;
   }
   
   
   /**
    * Driver
    * 
    * @param args
    */
   public static void main( String [] args )
   {
      // create times table
      TimesTable tt = new TimesTable();
      
      // create variables for two factors
      int a = 5, b = 7;
      
      // create the IO object
      Console_IO_Class conIO = new Console_IO_Class(); 
      
      // print out whole table
      tt.printTimesTable();
      
      // print out a specific result
      conIO.printString("Result is: " + tt.getResult(a, b));
   }
}