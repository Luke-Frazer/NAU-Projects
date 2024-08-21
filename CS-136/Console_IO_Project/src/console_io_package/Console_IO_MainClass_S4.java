package console_io_package;

public class Console_IO_MainClass_S4
   {
      
      private static final int TWO_END_LINES = 2;
      private static final int TABLE_WIDTH = 60;
      private static final int NAME_WIDTH = 25;
      private static final int AGE_WIDTH = 10;
      private static final int GPA_WIDTH = 10;
      private static final int GENDER_WIDTH = 10;
      private static final int PRECISION = 2;

      private static final char EQUAL_SIGN = '=';
      private static final char PIPE = '|';
      private static final char DASH = '-';


      
      public static void main( String[] args )
      {
         // initialize program
         
            // initialize variables
            Console_IO_Class conIO = new Console_IO_Class();
            String name;
            int age;
            double gpa;
            char gender;
         
            // show title, with underline
               // method: printString, printEndlines
            conIO.printString( "Student Information" );
            conIO.printEndline();
            conIO.printString( "===================" );
            conIO.printEndlines( TWO_END_LINES );
         
         // get student information from the user
         
            // get name of student
               // method: promptForString
            name = conIO.promptForString( "Enter Student Name          : " );
         
            // get age of student
               // method: promptForInt
            age = conIO.promptForInt( "Enter Student Age           : " );

         
            // get GPA of student
               // method: promptForDouble
            gpa = conIO.promptForDouble( "Enter Student GPA           : " );

         
            // get gender of student
               // method: promptForChar
            gender = conIO.promptForChar( "Enter Student Gender (M/F)  : " );
            conIO.printEndline();

         
         // conduct processing
         
            // not conducted here
         
         // display student information in table form
         
            // display top line
               // method: printChars, printEndline
            conIO.printChars( TABLE_WIDTH, EQUAL_SIGN );
            conIO.printEndline();
         
            // display table title
               // method: printChar, printString, printEndline
            conIO.printChar( PIPE );
            conIO.printString( "Student Information",
                                                    TABLE_WIDTH - 2, "CENTER" );
            conIO.printChar( PIPE );
            conIO.printEndline();
           
            // display divider line
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( TABLE_WIDTH - 2, DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display subtitle line
               // method: printChar, printString, printEndline
            conIO.printString( "| " );
            conIO.printString( "Name",  NAME_WIDTH - 1,  "LEFT" );
            conIO.printChar( PIPE );
            conIO.printString( "Age",  AGE_WIDTH,  "CENTER" );
            conIO.printChar( PIPE );
            conIO.printString( "GPA",  GPA_WIDTH,  "CENTER" );
            conIO.printChar( PIPE );
            conIO.printString( "Gender",  GENDER_WIDTH,  "CENTER" );
            conIO.printChar( PIPE );
            conIO.printEndline();
            
            // display divider line
               // method: printChar, printChars, printEndline
            conIO.printChar( PIPE );
            conIO.printChars( TABLE_WIDTH - 2,  DASH );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display student information
               // method: printChar, printString, printInt
               // method: printDouble, printEndline
            conIO.printString( "| " );
            conIO.printString( name,  NAME_WIDTH - 1,  "LEFT" );
            conIO.printChar( PIPE );
            conIO.printInt( age,  AGE_WIDTH,  "CENTER" );
            conIO.printChar( PIPE );
            conIO.printDouble( gpa, PRECISION, GPA_WIDTH,  "CENTER" );
            conIO.printChar( PIPE );
            conIO.printChar( gender,  GENDER_WIDTH,  "CENTER" );
            conIO.printChar( PIPE );
            conIO.printEndline();
         
            // display bottom line
               // method: printChars, printEndlines
            conIO.printChars( TABLE_WIDTH, EQUAL_SIGN );
            conIO.printEndlines( TWO_END_LINES );
         
         // end program
            
            // display program end
               // method: printString, printEndline
            conIO.printString( "Program End" );
            conIO.printEndline();
            
      }
     
   }
