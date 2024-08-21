package assignment_tools_package;


public class AssignmentToolsClass
   {

      public static void main( String[] args )
         {

            Console_IO_Class conIO = new Console_IO_Class();
            int subTotal = 25;
            int itemPrice = 35;
            int couponValue = 3;
            int tax = 2;
            int multiplyBy5 = 20, divideBy5 = 50;
            int incrementBy1 = 10;
            int decrementBy1 = 20;
            
            
            String nameString = "William";
            String middleStuff = " H. ";
            String lastName = "Smithers";
            
              
            
            subTotal += itemPrice;
            
            subTotal -= couponValue;
            
            conIO.printString( "Subtotal is currently " + subTotal);
            conIO.printEndline();
            
            subTotal += tax;
            
            conIO.printString( "Subtotal is now " + subTotal );
            conIO.printEndline();
            
            conIO.printString( "multiplyBy5 is currently " + multiplyBy5 );
            conIO.printEndline();
            conIO.printString( "divideBy5 is currently " + divideBy5 );
            conIO.printEndline();

            multiplyBy5 *= 5;
            divideBy5 /= 5;
            
            conIO.printString( "multiplyBy5 is now " + multiplyBy5 );
            conIO.printEndline();
            conIO.printString( "divideBy5 is now " + divideBy5 );
            conIO.printEndline();
            
            
            conIO.printString( "The nameString starts as " + nameString );
            conIO.printEndline();
            
            nameString += middleStuff;
            nameString += lastName;
            
            conIO.printString( "The nameString becomes " + nameString );
            conIO.printEndline();

            
            conIO.printString( "incrementBy1 starts as " + incrementBy1 );
            conIO.printEndline();
            conIO.printString( "decrementBy1 starts as " + decrementBy1 );
            conIO.printEndline();
            
            incrementBy1 ++;
            decrementBy1 ++;
            
            conIO.printString( "incrementBy1 becomes " + incrementBy1 );
            conIO.printEndline();
            conIO.printString( "decrementBy1 becomes " + decrementBy1 );
            conIO.printEndline();
            
         }

   }
