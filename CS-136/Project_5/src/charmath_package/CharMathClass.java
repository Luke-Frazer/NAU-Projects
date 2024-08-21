package charmath_package;

public class CharMathClass
   {
      
      private static final char SPACE = ' ';
      private static final char PERIOD = '.';

      
      private static final int TWO_END_LINES = 2;
      
      public static void main( String[] args )
      {
         
         // initialize program/variables
         Console_IO_Class conIO = new Console_IO_Class();
         int numAStudents = 45;
         int numBStudents = 25;
         int numCStudents = 10;
         int numberInAlphabet;
         char letterGrade = 'A';
         char upperCaseLetter, lowerCaseLetter;
         char letter;
         
         
         // show A students, increment letter
            // method: printString, printInt, printEndline
         conIO.printString( "There are " );
         conIO.printInt( numAStudents );
         conIO.printString( " \'");
         conIO.printChar( letterGrade );
         conIO.printString( "\' grades in the class." );
         conIO.printEndlines( TWO_END_LINES );
         letterGrade = (char)( letterGrade + 1 );
         
         
         // show B students, increment letter
            // method: printString, printInt, printEndline
         conIO.printString( "There are " );
         conIO.printInt( numBStudents );
         conIO.printString( " \'");
         conIO.printChar( letterGrade );
         conIO.printString( "\' grades in the class." );
         conIO.printEndlines( TWO_END_LINES );
         letterGrade = (char)( letterGrade + 1 );
         
         // show C students, increment letter
            // method: printString, printInt, printEndline
         conIO.printString( "There are " );
         conIO.printInt( numCStudents );
         conIO.printString( " \'");
         conIO.printChar( letterGrade );
         conIO.printString( "\' grades in the class." );
         conIO.printEndlines( TWO_END_LINES );
         letterGrade = (char)( letterGrade + 1 );
         
         // end program
         
         
         // get upper case letter from user
            // method: promptForChar
         upperCaseLetter = conIO.promptForChar( "Enter an upper case letter: ");
         
         // find lower case value
         lowerCaseLetter = (char)( upperCaseLetter - 'A' + 'a' );
          
         
         // show lower case value to user
            // method: printString, printChar, printEndline
         conIO.printString( "The upper case letter \'" );
         conIO.printChar( upperCaseLetter );
         conIO.printString("\' has been converted to the lower case letter \'");
         conIO.printChar( lowerCaseLetter );
         conIO.printString( "\'. " );
         conIO.printEndline();
         
         
         // end program
         
         
         // get an upper case letter from the user
            // method: promptForChar
         letter = conIO.promptForChar( "Enter upper case letter: " );
         
         
         // calculate the letter's number in the alphabet
         numberInAlphabet = letter - 'A' + 1;
         
         // show the number in the alphabet
            // method: printString, printChar, printEndline
         conIO.printString( "The number for the letter \'" );
         conIO.printChar( letter );
         conIO.printString( "\' in the alphabet is " );
         conIO.printInt( numberInAlphabet );
         conIO.printChar( PERIOD );
         conIO.printEndline();
         
         
         // end program
      }
   }
