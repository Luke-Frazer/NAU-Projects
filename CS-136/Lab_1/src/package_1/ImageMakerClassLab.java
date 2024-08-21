package package_1;

public class ImageMakerClassLab
   {

      private static final char CROSS = 'x';
      private static final char SPACE = ' ';
      
      private static final int GAP = 10;
      private static final int MIDDLE_GAP = 8;
      private static final int SINGLE_CHAR = 1;
      
      public static void main(String[] args)
         {

         // initialize program
            
            // initialize variables
            Console_IO_Class conIO = new Console_IO_Class();

            // display top line of x's 10 characters long
               // method: printChars, printEndline
            conIO.printChars( GAP, CROSS );
            conIO.printEndline();
            
            // display middle sections of x's with none in the center going 10
            // characters down
               // method: printChars, printEndline
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printChars( MIDDLE_GAP, SPACE );
            conIO.printChars( SINGLE_CHAR, CROSS);
            conIO.printEndline();

            // display bottom line of x's 10 characters long
               // method: printChars, printEndline
            conIO.printChars( GAP, CROSS );
            conIO.printEndline();
            
            // end program
            
         }

   }
