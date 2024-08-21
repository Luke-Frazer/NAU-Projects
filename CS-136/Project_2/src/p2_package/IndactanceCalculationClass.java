package p2_package;

public class IndactanceCalculationClass
    {
       
     public static final char DASH = '-';
     public static final char DOUBLE_DASH = '=';
     public static final char PIPE = '|';
     public static final char CROSS = '+';
     
     public static final int TWO_ENDLINES = 2;
     public static final int PRECISION = 2;
     public static final int TABLE_WIDTH = 65;
     public static final int MEASURED_BLOCK_WIDTH = 20;
     public static final int NAME_BLOCK_WIDTH = 29;
     public static final int VALUE_BLOCK_WIDTH = 12;

     public static final String PIPE_SPACE = "| ";
     public static final String SPACE_PIPE = " |";
     public static final String CROSS_SPACE = "+ ";

     public static final double TWO_PI = 2.0 * Math.PI;
     
     public static void main( String[] args )
        {
         // initialize program
           
           // initialize variables
           Console_IO_Class conIO = new Console_IO_Class();
           double current;
           double resistance;
           double frequency;
           double capacitance;
           double numerator;
           double denominator;
           double capIndactance;
           
           // show title with underline
              // method: printString, printEndlines
           conIO.printString( "Indactance Calculation Program" );
           conIO.printEndline();
           conIO.printString( "==============================" );
           conIO.printEndlines( TWO_ENDLINES );
           
        // get information for calculations
           
           // get current
              // method: promptForDouble
           current = conIO.promptForDouble( "  Enter Current       (A): " );
           
           // get resistance
              // method: promptForDouble
           resistance = conIO.promptForDouble( "  Enter Resistance (Ohms): " );
           
           // get frequency
              // method: promptForDouble
           frequency = conIO.promptForDouble( "  Enter Frequency    (hz): " );
           
           // get capacitance
              // method: promptForDouble
           capacitance = conIO.promptForDouble( "  Enter Capacitance   (F): " );
           conIO.printEndline();

        // conduct processing
           
           // calculate the capacitive indactance
           numerator = ( current * resistance );
           denominator = ( TWO_PI ) * ( frequency * capacitance );
           capIndactance = ( numerator ) / ( denominator );
           
        // display information for the table
           
           // draw the top line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( TABLE_WIDTH - 2, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print main title
              // method: printChar, printString, printEndline
           conIO.printChar( PIPE );
           conIO.printString( "INDACTANCE CALCULATION PROGRAM", 
                                                  TABLE_WIDTH - 2, "CENTER");
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print divider before subtitles
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( TABLE_WIDTH - 2, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print subtitles
              // method: printString, printChar, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "MEASURED", MEASURED_BLOCK_WIDTH - 1, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printString( "NAME", NAME_BLOCK_WIDTH, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printString( "VALUE", VALUE_BLOCK_WIDTH, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print divider after subtitles
              // printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print Current Line
              // method: printString, printChar, printDouble, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Current", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printChar( CROSS );
           conIO.printDouble( current, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                    "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // print separator
              // printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print Resistance Line
              // method: printString, printChar, printDouble, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Resistance", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printChar( CROSS );
           conIO.printDouble( resistance, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                    "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // print separator
              // printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print Frequency Line
              // method: printString, printChar, printDouble printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Laboratory", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Frequency", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printChar( CROSS );
           conIO.printDouble( frequency, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                    "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // print separator
              // printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print Capacitance Line
              // method: printString, printChar, printDouble, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Capacitance", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printChar( CROSS );
           conIO.printDouble( capacitance, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                    "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // print separator
              // printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // print Capacitive Indactance line
              // method: printString, printChar, printDouble, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Calculated Result", MEASURED_BLOCK_WIDTH - 1, 
                                                                      "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Capacitive Indactance", NAME_BLOCK_WIDTH - 1, 
                                                                      "LEFT" );
           conIO.printChar( CROSS );
           conIO.printDouble( capIndactance, PRECISION, VALUE_BLOCK_WIDTH - 1, 
                                                                    "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // print final separator
              // printChar, printChars, printEndlines
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndlines(TWO_ENDLINES);
           
        // end program
           
           // display program end
              // method: printString, printEndline
           conIO.printString( "End Program" );
           conIO.printEndline();
           
        }

    } 

