package math_tests;

public class MathTestClass
   {

      public static void main( String[] args)
      {
         // initialize program
         
            Console_IO_Class conIO = new Console_IO_Class();
         
            //initialize variables
            int myAge = 19;
            int herAge = 22;
            int hisAge = 78;
            int theOtherGuysAge = 51;
            int totalStudents = 15, newStudents = 3;
            int sumOfAges, differenceOfAges;
            int numCandyBarsInBox = 25;
            int numberOfBoxes = 12;
            int numberOfCandyBars;
            int result;
            int numberOfPeople = 300;
            int numberOfBuses = 7;
            int peoplePerBus;
            
         // adding ages to get a sum
         sumOfAges = myAge + herAge + hisAge;
         
         sumOfAges = sumOfAges + theOtherGuysAge;
         
         totalStudents = totalStudents + newStudents;
         
         // show the sum of the students
            // method: conIO.printString, conIO.printInt, conIO.printEndline
         conIO.printString( "The sum of the students is: " );
         conIO.printInt( totalStudents );
         conIO.printEndline();
         
         
         // subtracting my age from his age
         differenceOfAges = hisAge - myAge;
         
         //show the difference of the ages
            //method: conIO.printString, conIO.printInt, conIO.printEndline
         conIO.printString( "The difference of the students is: " );
         conIO.printInt( differenceOfAges );
         conIO.printEndline();
         
         // subtracting her age from my age and his age
         differenceOfAges = differenceOfAges - herAge;
         
         //show the difference of the ages
            //method: conIO.printString, conIO.printInt, conIO.printEndline
         conIO.printString( "The difference of the students is: " );
         conIO.printInt( differenceOfAges );
         conIO.printEndline();
         
         
         
         // find the number of candy bars
         numberOfCandyBars = numCandyBarsInBox * numberOfBoxes;
         
         // print the results
            // method: conIO.printString, conIO.printInt, conIO.printEndline
         conIO.printString( "Number of candy bars: " );
         conIO.printInt( numberOfCandyBars );
         conIO.printEndline();
         
         // test division
         result = 100 / 99;
         
         // print the results
            // method: conIO.printString, conIO.printInt, conIO.printEndline
         conIO.printString( "Result: " );
         conIO.printInt( result );
         conIO.printEndline();
         
         
         // test division
         peoplePerBus = numberOfPeople / numberOfBuses;
         
         // print the results
            // method: conIO.printString, conIO.printInt, conIO.printEndline
         conIO.printString( "People per bus: " );
         conIO.printInt( peoplePerBus );
         conIO.printEndline();
         
      }
      
   }
