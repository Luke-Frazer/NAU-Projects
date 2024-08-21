package operator_precedence_class;

public class OperatorPrecedenceClass
   {
      
      private static final int PRECISION = 2;
      
      public static void main( String[] args )
      {
         
         Console_IO_Class conIO = new Console_IO_Class();
         int lemonadeDrinkers = 5;
         double priceOfLemonade = 3.99;
         int numberOfColaDrinkers = 3;
         double priceOfCola = 2.99;
         double totalDrinkPrice_1, totalDrinkPrice_2, totalDrinkPrice_3;
         
         totalDrinkPrice_1 = lemonadeDrinkers * priceOfLemonade
                        + numberOfColaDrinkers * priceOfCola;
         
         totalDrinkPrice_2 = (lemonadeDrinkers * priceOfLemonade)
                        + (numberOfColaDrinkers * priceOfCola);
         
         totalDrinkPrice_3 = lemonadeDrinkers * (priceOfLemonade
                        + numberOfColaDrinkers) * priceOfCola;
         
         conIO.printString( "For the calculation of " 
                           + "lemonadeDrinkers * priceOfLemonade" 
                           + " + numberOfColaDrinkers * priceOfCola, "
                           + "the total would be: " + totalDrinkPrice_1 );
         conIO.printEndline();
         
         
         conIO.printString( "For the calculation of " 
               + "lemonadeDrinkers * priceOfLemonade" 
               + " + numberOfColaDrinkers * priceOfCola, "
               + "the total would be: " + totalDrinkPrice_2 );
         conIO.printEndline();
         
         conIO.printString( "For the calculation of " 
               + "lemonadeDrinkers * priceOfLemonade" 
               + " + numberOfColaDrinkers * priceOfCola, "
               + "the total would be: " );
         conIO.printDouble( totalDrinkPrice_3, PRECISION );
         conIO.printEndline();

         
         
      }
   }
