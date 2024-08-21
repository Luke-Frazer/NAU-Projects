package p6_package;

public class WorkingTestClass
   {
    public static final char ASTERISK_CHAR = '*';

    public static final char SPACE_CHAR = ' ';

    public static void main(String[] args)
       {
          // print first line
             // methods : printSpace, printAsterisk, printEndline
          printSpaces( 4 );
          printAsterisk();
          printEndline();
          
          // print second line
             // methods : printSpace, printAsterisk, printEndline
          printSpaces( 3 );
          printAsterisks( 3 );
          printEndline();
          
          // print third line
             // methods : printSpace, printAsterisk, printEndline
          printSpaces( 2 );
          printAsterisks( 5 );
          printEndline();
          
       }
          
    public static void printAsterisk()
       {
        System.out.print( "" + ASTERISK_CHAR );
       }
    
    public static void printSpace()
       {
        System.out.print( "" + SPACE_CHAR );
       }

    public static void printAsterisks( int numAsterisks )
       {
        if( numAsterisks > 0 )
           {
            printAsterisk();
            
            printAsterisks( numAsterisks - 1 );
           }
       }

    public static void printSpaces( int numSpaces )
       {
        if( numSpaces > 0 )
           {
            printSpace();
              
            printSpaces( numSpaces - 1 );
           }
       }

    public static void printEndline()
       {
        System.out.println();
       }
    
   }
