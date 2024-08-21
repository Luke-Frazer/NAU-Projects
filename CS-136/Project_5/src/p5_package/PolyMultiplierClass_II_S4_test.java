package p5_package;

public class PolyMultiplierClass_II_S4_test
   {

      // endline constant
      private static final int TWO_ENDLINES = 2;
      
      // degree constants
      private static final int FIRST_DEGREE = 1;
      private static final int SECOND_DEGREE = 2;
      private static final int THIRD_DEGREE = 3;
      
      public static void main( String[] args )
         {
           
         // initialize program
            
            // initialize variables
            Console_IO_Class conIO = new Console_IO_Class();
            
            int degreeForm;
            int coeffA = 0;
            int coeffB = 0;
            int coeffC = 0;
            int coeffD = 0;
            int coeffE = 0;
            int coeffF = 0;
            int xFourthCoeff;
            int xCubedCoeff;
            int xSquaredCoeff;
            int xCoeff;
            int numCoeff;

            String numberedEquation = null;
            String result = null;
           
            boolean valid = false;
            
            // display title and instructions
               // method: printString, printEndline, printEndlines
            conIO.printString( "Polynomial Calculator, Part Deux" );
            conIO.printEndline();
            conIO.printString( "================================" );
            conIO.printEndlines( TWO_ENDLINES );
            
            // display title for degree forms
               // method: printString, printEndline
            conIO.printString( "Multiplies a first degree polynomial" );
            conIO.printEndline();
            
            // display first degree form
               // method: printString, printEndline
            conIO.printString( "  by a first degree form: ( ax + b ) *"
                                                             + " ( cx + d )" );
            conIO.printEndline();

            // display second degree form
               // method: printString, printEndline
            conIO.printString( "  or by a second degree form: ( ax + b ) *"
                                                       + " ( cx^2 + dx + e )");
            conIO.printEndline();
            
            // display third degree form
               // method: printString, printEndline
            conIO.printString( "  or by a third degree form: ( ax + b ) *"
                                                + " ( cx^3 + dx^2 + ex + f )");
            conIO.printEndline();
            
            // display final line
               // method: printString, printEndlines
            conIO.printString( "depending on user selection" );
            conIO.printEndlines( TWO_ENDLINES );
            
         // input coefficients
            
            // get degree form
               // method: promptForInt, printEndline
            degreeForm = conIO.promptForInt( "Enter degree form (1-3): " );
            conIO.printEndline();
            
            // check for if the degree is valid and is within the 1-3 range
            if ( degreeForm == FIRST_DEGREE || degreeForm == SECOND_DEGREE ||
                                                   degreeForm == THIRD_DEGREE ) 
               {
                  valid = true;
               }
            
            // check for first degree and get coefficients
            if ( valid == true )
               {
                  // get coefficient a
                     // method: promptForInt
                  coeffA = conIO.promptForInt( "Enter coefficient a: " );
                  
                  // get coefficient b
                     // method: promptForInt
                  coeffB = conIO.promptForInt( "Enter coefficient b: " );

                  // get coefficient c
                     // method: promptForInt
                  coeffC = conIO.promptForInt( "Enter coefficient c: " );
                  
                  // get coefficient d
                     // method: promptForInt
                  coeffD = conIO.promptForInt( "Enter coefficient d: " );
                  
                  // check for second or third degree
                  if ( degreeForm != FIRST_DEGREE)
                     {
                        // get coefficient e
                           // method: promptForInt
                        coeffE = conIO.promptForInt( "Enter coefficient e: " );
                        
                        // check for third degree
                        if ( degreeForm == THIRD_DEGREE )
                           {
                              // get coefficient f and print the endline
                                 // method: promptForInt, printEndline
                              coeffF = conIO.promptForInt( 
                                                     "Enter coefficient f: " );
                              conIO.printEndline();
                           }
                        
                        // otherwise, print an endline if its the second degree
                        else 
                           {
                                 // method: printEndline
                              conIO.printEndline();
                           }
                     }
                  
                  // otherwise, print an endline if its the first degree
                  else 
                     { 
                           // method: printEndline
                        conIO.printEndline();
                     }
               }

         // process data
            // check for first degree and valid input
            if ( degreeForm == FIRST_DEGREE && valid == true )
               {
                  // conduct processing
                     // result for x^2 coefficient
                  xSquaredCoeff = ( coeffA * coeffC );
                  
                     // result for x coefficient
                  xCoeff = ( coeffA * coeffD ) + ( coeffB * coeffC );
                              
                     // result for the number coefficient
                  numCoeff = ( coeffB * coeffD );
                  
                     // create the equation with the user imputed numbers
                  numberedEquation =  "( " + coeffA + "x + " + coeffB + " )*( "
                                             + coeffC + "x + " + coeffD + " )";
                  
                     // create the result
                  result = xSquaredCoeff + "x^2 + " + xCoeff + "x + " 
                                                                    + numCoeff;
               }
            
            // check for second degree and valid input
            else if ( degreeForm == SECOND_DEGREE && valid == true )
               {
                  // conduct processing
                     // result for x^3 coefficient
                  xCubedCoeff = ( coeffA * coeffC );
                  
                     // result for x^2 coefficient
                  xSquaredCoeff = ( coeffB * coeffC ) + ( coeffA * coeffD );
                  
                     // result for x coefficient
                  xCoeff = ( coeffB * coeffD ) + ( coeffA * coeffE );
                              
                     // result for the number coefficient
                  numCoeff = ( coeffB * coeffE );
                  
                     // create the equation with the user imputed numbers
                  numberedEquation =  "( " + coeffA + "x + " + coeffB + " )*( "
                          + coeffC + "x^2 + " + coeffD + "x + " + coeffE + ")";
                  
                     // create the result
                  result = xCubedCoeff + "x^3 + " + xSquaredCoeff + "x^2 + "
                                                  + xCoeff + "x + " + numCoeff;
               }
            
            // check for third degree and valid input
            else if ( degreeForm == THIRD_DEGREE && valid == true )
               {
                  // conduct processing
                     // result for x^4 coefficient
                  xFourthCoeff = ( coeffA * coeffC );
                  
                     // result for x^3 coefficient
                  xCubedCoeff = ( coeffB * coeffC ) + ( coeffA * coeffD );
                  
                     // result for x^2 coefficient
                  xSquaredCoeff = ( coeffB * coeffD ) + ( coeffA * coeffE );
                  
                     // result for x coefficient
                  xCoeff = ( coeffB * coeffE ) + ( coeffA * coeffF );
                              
                     // result for the number coefficient
                  numCoeff = ( coeffB * coeffF );
                  
                     // create the equation with the user imputed numbers
                  numberedEquation =  "( " + coeffA + "x + " + coeffB + " )*( "
                  + coeffC + "x^3 + " + coeffD + "x^2 + " + coeffE + "x + " 
                                                                + coeffF + ")";
                  
                     // create the result
                  result = xFourthCoeff + "x^4 + " + xCubedCoeff + "x^3 + " 
                       + xSquaredCoeff + "x^2 + " + xCoeff + "x + " + numCoeff;
               }
            
         // display the output
            
            // display the result if there was a valid input
               // method: printString, printEndline, printEndlines
            if ( valid == true )
               {
                  conIO.printString( "Result: ");
                  conIO.printEndline();
                  conIO.printString( numberedEquation + " = " + result );
                  conIO.printEndlines( TWO_ENDLINES );
               }
            
            // display error message if there was not a valid input
               // method: printString, printEndlines
            else if ( valid == false )
               {
                  conIO.printString("Incorrect number of polynomial degrees "
                                               + "entered - Program Aborted" );
                  conIO.printEndlines( TWO_ENDLINES );
               }

         // program end
            
            // display the program end
               // method: printString, printEndline
            conIO.printString( "Program End" );
            conIO.printEndline();
           
         }

   }
