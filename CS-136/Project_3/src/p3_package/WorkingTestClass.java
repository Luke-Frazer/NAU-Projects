package p3_package;

public class WorkingTestClass
   {
    public static final char ASTERISK_CHAR = '*';

    public static final char SPACE_CHAR = ' ';

    public static void main(String[] args)
       {
        
          // print first asterisk
             // method: printAsterisk
          printAsterisk();
          
          // print second asterisk
             // method: printAsterisk
          printAsterisk();
          
          // print third asterisk
             // method: printAsterisk
          printAsterisk();

          
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
