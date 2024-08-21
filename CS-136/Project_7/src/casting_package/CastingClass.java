package casting_package;

public class CastingClass
   {
      
      private static final int PRECISION = 2;

      public static void main( String[] args )
         {

            Console_IO_Class conIO = new Console_IO_Class();
            int people = 72;
            int lasagnaPans = 15;
            double lasagnaPerPerson;
            
            // calculate lasagna pans per person
            lasagnaPerPerson = (double)lasagnaPans / people;
            
            // display the pans per person
            conIO.printString( "Fraction of a lasagna pan per person: " );
            conIO.printDouble( lasagnaPerPerson,  PRECISION );
            conIO.printEndline();
         }

   }
