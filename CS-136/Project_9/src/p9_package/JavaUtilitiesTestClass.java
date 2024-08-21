package p9_package;


public class JavaUtilitiesTestClass
   {
      public static void main( String[] args )
      {
         
         Console_IO_Class conIO = new Console_IO_Class();
         double someValue = 25;
         double someBase = 5;
         double someExponent = 5;
         double sqrtResult, exponentResult;
         
         // find square root
         sqrtResult = Math.sqrt( someValue );
         
         // find exponent
         exponentResult = Math.pow( someBase,  someExponent );
         
         conIO.printString( "The square root of the value " + someValue
                           + " is " + sqrtResult );
         conIO.printEndline();
         
         conIO.printString( "The value " + someBase + " to the exponent of "
                           + someExponent + " is " + exponentResult );
         conIO.printEndline();
         
      }
   }
