package p6_package;

public class QuadCalcClass_II_S5
   {
      
      // initialize table characters
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      public static final char CROSS = '+';
      
      // initialize line controls
      public static final int SOLID = 1001;
      public static final int BROKEN = 2002; 

      // initialize table string components
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      public static final String CROSS_SPACE = "+ ";
      
      // initialize table widths
      public static final int PRECISION = 2;
      public static final int TABLE_WIDTH = 44;
      public static final int NAME_BLOCK_WIDTH = 29;
      public static final int VALUE_BLOCK_WIDTH = 12;

      // initialize two endlines constant
      public static final int TWO_ENDLINES = 2;

      public static void main( String[] args )
         {

         // initialize program
         
            // initialize and declare variables
            int coefA, coefB, coefC, denominator;
            int discriminant;
            double discSqrt;
            double rootOne = 0;
            double rootTwo = 0;
            double zero = 0;
            boolean complex = false;
            boolean oneRoot = false;

            // show title with underline
               // method: printTitle
            printTitle();

         // get the inputed values from the user
         
            // ask for the coefficient a
               // method: promptForCoef
            coefA = promptForCoef( "Enter coefficient A: " );
            
            // ask for the coefficient b
               // method: promptForCoef

            coefB = promptForCoef( "Enter coefficient B: " );
            
            // ask for the coefficient c
               // method: promptForCoef

            coefC = promptForCoef( "Enter coefficient C: " );

         // process the data and find roots
         
            // break the quadratic formula into pieces
            
               // calculate the denominator
                  // method: calcDenom
            
               denominator = calcDenom( coefA );
            
               // calculate the discriminant
                  // method: calcDiscrim
               
               discriminant = calcDiscrim( coefA, coefB, coefC );
               
               // calculate the discriminant square root
               
               discSqrt = Math.sqrt( (double)discriminant );
            
            // check if the discriminant is complex and set flag
            if ( discriminant < zero )
               {
                  // set complex flag true if the discriminant is less than 0
                  complex = true;
               }
               
            // check if the discriminant has one root and set flag
            else if ( discriminant == zero )
               {
                  // set oneRoot flag true if the discriminant equals 0
                  oneRoot = true;
               }
            
            // check if complex is false
            if ( complex == false )
               {
               // find root one
                  // method: calcRoot
               rootOne = calcRoot( coefB, discSqrt, denominator );

               if ( oneRoot == false )
                  {
                  // find root two
                     // method: calcRoot
                  rootTwo = calcRoot( coefB, -discSqrt, denominator );
                  }
               }

         // display the output
         
            // display title section
               // method: displayTableTitle
            displayTableTitle();

            // display underline of title with subtitle
               // method: displaySubTitle
            displaySubTitles();

            // display coefficient a in the table with thin line above
               // method: displayDataLines
            displayDataLines( "Coefficient A", coefA, DOUBLE_DASH );
            
            // display coefficient b in the table with thin line above
               // method: displayDataLines
            displayDataLines( "Coefficient B", coefB, DASH );

            // display coefficient c in the table with thin line above
               // method: displayDataLines
            displayDataLines( "Coefficient C", coefC, DASH );

            // display one root, two roots, or complex roots
               // check if the roots are complex using flag
               if ( complex == true )
                  {
                     // display complex roots section with thick line above
                        // method: displayDataLines
                     displayDataLines( "Complex Roots", zero, DOUBLE_DASH );
                  }
               
               // check if there is one root
               else if ( oneRoot == true )
                  {
                     // display the single root with thick line above
                        // method: displayDataLines
                     displayDataLines( "Single Root", rootOne, DOUBLE_DASH );
                  }
               
               // otherwise, there are two roots
               else 
                  {
                     // display two roots as separate rows with thick line above
                        // method: displayDataLines
                     displayDataLines( "Root One", rootOne, DOUBLE_DASH );
                     displayDataLines( "Root Two", rootTwo, DASH );
                  }
               
            // display bottom line of table
               // method: displayLine
            displayLine( DOUBLE_DASH, SOLID );

         // end program
            
            // display end program
               // method: displayProgramEnd
            displayProgramEnd();
         
         }
      
    /*
    name: printTitle
    process: displays the title with an underline
    method input/parameters: none
    method output/parameters: none
    method output/returned: none
    device input/keyboard: none
    device output/monitor: title displayed
    dependencies: Console IO Class Tools
    */
    
    public static void printTitle()
    {
       // initialize method/variables
       
       // display the title
          // method: printString, printEndline
       
       // display the underline with an extra endline
          // method: printchars, printEndlines

    }
      
    /*
    name: promptForCoef
    process: prompts user for coefficient
    method input/parameters: text to prompt user (string)
    method output/parameters: none
    method output/returned: an integer is returned to calling method
    device input/keyboard: user entry of a coefficient
    device output/monitor: prompt string displayed
    dependencies: Console IO Class Tools
    */
    
    public static int promptForCoef( String coefText )
    {
       // initialize method/variables

       // prompt user for coefficient
          // method: promptForInt
       
       // return user input
       return 0; // temporary stub return
    }
      
    /*
    name: calcDenom
    process: calculates the denominator and returns the calculation
    method input/parameters: the coefficient a (int) 
    method output/parameters: none
    method output/returned: the calculation result returned to calling method
    device input/keyboard: none
    device output/monitor: none
    dependencies: none
    */
    
    public static int calcDenom( int coefA )
    {
       // initialize method/variables
       
       // calculate the denominator
       
       // return the denominator
       return 0; // temporary stub return
    }
    
    /*
    name: calcDiscrim
    process: calculates the discriminant and returns the calculation
    method input/parameters: coefficients a, b, and c (int)
    method output/parameters: none
    method output/returned: the calculation result returned to calling method
    device input/keyboard: none
    device output/monitor: none
    dependencies: none
    */
    
    public static int calcDiscrim( int coefA, int coefB, int coefC )
    {
       // initialize method/variables

       // calculate the discriminant
       
       // return the discriminant
       return 0; // temporary stub return
    }
    
    /*
    name: calcRoot
    process: calculates the quadratic equation to find a single root specified
    method input/parameters: coefficient b, discriminant sqrt (double),
                                                      denominator (int)
    method output/parameters: none
    method output/returned: calculated single root (double)
    device input/keyboard: none
    device output/monitor: none
    dependencies: none
    */
    
    public static double calcRoot( int coefB, double discSqrt, int denominator )
    {
       // initialize method/variables

       // calculate the numerator
       
       // calculate the root
       
       // return the root
       return 0; // temporary stub return
    }
    
    /*
    name: displayTableTitle
    process: displays the title of the table with verticle space and a top line
    method input/parameters: none
    method output/parameters: none
    method output/returned: none
    device input/keyboard: none
    device output/monitor: the title of table with verticle space and top line 
    dependencies: Console IO Class Tools
    */
    
    public static void displayTableTitle()
    {
       // initialize method/variables

       // print an end line
          // method: printEndline
       
       // display top line
          // method: displayLine
       
       // display title
          // method: printChar, printString
       
       // print an end line
          // method: printEndline
    }
    
    /*
    name: displaySubTitles
    process: displays the subtitles with divider line above
    method input/parameters: none
    method output/parameters: none
    method output/returned: none
    device input/keyboard: none
    device output/monitor: the subtitles with a divider line above it
    dependencies: Console IO Class Tools
    */
    
    public static void displaySubTitles()
    {
       // initialize method/variables

       // display divider line above
          // method: displayLine
       
       // display subTitles
          // method: printString, printChar
       
       // print an end line
          // method: printEndline
       
    }
    
    /*
    name: displayDataLines
    process: displays the subtitle for the row with the value and divider above
    method input/parameters: name (string), value (double), 
                                              and divider type (char)
    method output/parameters: none
    method output/returned: none
    device input/keyboard: none
    device output/monitor: the proper name, value, and line above
    dependencies: Console IO Class Tools
    */
    
    public static void displayDataLines( String rowName, double value, 
                                                              char typeOfChar )
    {
       // initialize method/variables
       
       // display divider line
          // method: displayLine
       
       // display the line with the appropriate name and value
          // method: printString, printChar, printDouble
       
       // print an end line
          // method: printEndline
    }
    
    /*
    name: displayLine
    process: displays a specific line type of solid or broken
    method input/parameters: character used for line (char) and the type 
                                              if it is solid or broken (int)
    method output/parameters: none
    method output/returned: none
    device input/keyboard: none
    device output/monitor: the line that was specified
    dependencies: Console IO Class Tools
    */
      
    public static void displayLine( char typeOfChar, int typeOfLine )
    {
       // initialize method/variables

       // check if the line is broken
          
             // print the broken line using the correct character
                // method: printChar, printChars

       // otherwise the line type is solid

             // print the solid line using the correct character
                // method: printChar, printChars
       
       // print an end line
          // method: printEndline
    }
    
    /*
    name: displayProgramEnd
    process: displays the end line of the program
    method input/parameters: none
    method output/parameters: none
    method output/returned: none
    device input/keyboard: none
    device output/monitor: the end program line
    dependencies: Console IO Class Tools
    */
      
    public static void displayProgramEnd()
    {
       // initialize method/variables

       // print an end line to space it out
          // method: print endLine 
       
       // print the end program line
          // method: printString
          
       // print an end line
          // method: printEndline
    }

   }
