package p8_package;

public class EncryptionClass
   {

      // initialize endline constant
      public static final int TWO_ENDLINES = 2;
      
      // initialize the Console IO variable
      public static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main( String[] args )
         {

         // initialize program
            
            // initialize String variables
            String numberSeries;
            String encryptThisString;
            String decryptNumberSeries;
            String decryptThisString;
            
            // initialize character array variables
            char[] encryptedString;
            char[] decryptedString;
            char[] encryptableStringArray;
            char[] decryptStringArray;
            
            // initialize integer array variables
            int[]  numberSeriesArray;
            int[]  decryptKeyArray;
           
            // display the title
               // method: printString, printEndlines
            conIO.printString( "Encryption / Decryption Program" );
            conIO.printEndlines( TWO_ENDLINES );
        
            // display the instructions for part one
               // method: printString, printEndlines
            conIO.printString( "Part one accepts a series of key integers"
                                    + " and then a string to be encrypted." );
            conIO.printEndlines( TWO_ENDLINES );

         // get the inputed values from the user for part one
            
            // get the series of numbers
               // method: promptForString
            numberSeries = conIO.promptForString( "Enter series of numbers: " );
            
            // get the string to be encrypted
               // method: promptForString, printEndline
            encryptThisString = conIO.promptForString( "Enter string to be "
                                                             + "encrypted: " );
            conIO.printEndline();
            
         // process the data for part one
            
            // convert the number series key String to integer array
               // method: convertStringToIntArray
            numberSeriesArray = convertStringToIntArray( numberSeries );
            
            // convert the input String to a char array
               // method: convertStringToCharArray
            encryptableStringArray = convertStringToCharArray( 
                                                           encryptThisString );
            
            // find the encrypted message
               // method: encryptString
            encryptedString = encryptString( encryptableStringArray, 
                                                           numberSeriesArray );
            
         // display output for part one and switch to part two
            
            // display the encrypted string
               // displayStringWithLeader
            displayStringWithLeader( "Encrypted String: ", encryptedString );
            
            // display the instructions for part two
               // method: printString, printEndlines
            conIO.printString( "Part two accepts a series of key integers"
                                    + " and then a string to be decrypted." );
            conIO.printEndlines( TWO_ENDLINES );

         // get the inputed values from the user for part one

            // get the series of numbers to decrypt
               // method: promptForString
            decryptNumberSeries = conIO.promptForString( "Enter series of "
                                                               + "numbers: " );
            
            // get the string to be decrypted
               // method: promptForString, printEndline
            decryptThisString = conIO.promptForString( "Enter string to be "
                                                             + "decrypted: " );
            conIO.printEndline();
            
         // process the data for part two
            
            // convert number series key String to integer array
               // method: convertStringToIntArray
            decryptKeyArray = convertStringToIntArray( decryptNumberSeries );
            
            // convert input string to character array
               // method: convertStringToCharArray
            decryptStringArray = convertStringToCharArray( decryptThisString );
            
            // decrypt the two arrays
               // method: decryptString
            decryptedString = decryptString( decryptStringArray,
                                                             decryptKeyArray );
            
         // display the output for part two
            
            // display the decrypted string
               // displayStringWithLeader
            displayStringWithLeader( "Decrypted String: ", decryptedString );
            
         // end program
            
            // display the program end
               // printString, printEndline
            conIO.printString( "End Program" );
            conIO.printEndline();

         }

      /*
      name: charToInt
      process: Accepts a character and converts it to an integer if the char 
                                                                  was a number.
      method input/parameters: the character to be converted
      method output/parameters: none
      method output/returned: the integer value of the character inputed
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      public int charToInt( char convertableCharacter )
      {
         // initialize variables
         int finalInteger;
         int failedConversion = -1;
         
         // check if the character is a number
         if( convertableCharacter >= '0' && convertableCharacter <= '9' )
            {
               // convert a character to an integer
               finalInteger = (int)( convertableCharacter - '0' );
            }
         
         // otherwise, the character is not a number
         else
            {
               // return a negative one if the inputed value was not a number
               return failedConversion;
               
            }
          
         // return the integer
         return finalInteger; 
         
      }
      
      /*
      name: convertStringToCharArray
      process: Converts an input string to a character array
      method input/parameters: the string to be converted
      method output/parameters: none
      method output/returned: the character array of the converted string
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      public static char[] convertStringToCharArray( String convertableString )
      {
         
         // initialize variables
        
            // get string length
               // method: length
            int stringLength = convertableString.length();
            
            // create the array
            char[] characterArray = new char[ stringLength ];
         
            // create an index
            int index;
            
            // create the temporary character
            char tempChar;
         
         // start loop up to the string length 
            
            for( index = 0; index < stringLength; index++ )
               {
                  // get the character from the string
                     // method: charToInt
                  tempChar = convertableString.charAt( index );
                  
                  // assign the character in the array
                  characterArray [ index ] = tempChar;
               }
            
         // return the array
            return characterArray;
         
      }
      
      /*
      name: convertStringToIntArray
      process: Converts an input string to an integer array
      method input/parameters: the string to be converted
      method output/parameters: none
      method output/returned: the integer array of the converted string
      device input/keyboard: none
      device output/monitor: none
      dependencies: CharToInt
      */
      
      public static int[] convertStringToIntArray( String convertableString )
         {
            
            // initialize variables
            
               // initialize the charToInt method
               EncryptionClass tool = new EncryptionClass();
            
               // get string length
                  // method: length
               int stringLength = convertableString.length();
            
               // create the array with the array size as the stringlength
               int[] integerArray = new int[ stringLength ];
               
               // create an index
               int index;
               
               // create the temporary character
               char tempChar;
               
               // create the temporary integer value of the character
               int tempInt;
               
            // start loop up to the string length
               for( index = 0; index < stringLength; index++ )
                  {
                     // get the character from the string
                        // method: charAt
                     tempChar = convertableString.charAt( index );
                     
                     // convert that character to an integer
                        // method: charToInt
                     tempInt = tool.charToInt( tempChar );
                     
                     // assign the character in the array
                     integerArray[ index ] = tempInt;
                  }
            
            // return the array
               return integerArray; 
            
         }
      
      /*
      name: decryptString
      process: Repeatedly subtracts the integer array values from the encrypted 
                                   input string to create the decrypted string.
      method input/parameters: the two arrays
      method output/parameters: none
      method output/returned: the decrypted message
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
      
      public static char[] decryptString( char[] characterArray,
                                                           int[] integerArray )
      {
         
         // initialize variables
            
            // get characterArray length
               // method: length
            int charArrayLength = characterArray.length;
            
            // get integerArray length
               // method: length
            int intArrayLength = integerArray.length;
            
            // create an index
            int index;
            
            // create a repeating key index location
            int keyIndex;
         
            // create the looping key value
            int key; 
            
            // create temporary character value 
            char tempChar;
            
            // create the new character values of the decrypted char
            char newChar;
            
            // create the decrypted string
            char[] decryptedArray = new char[ charArrayLength ];
            
         // start loop up to the input string length
            for( index = 0; index < charArrayLength; index++ )
               {
                  // find the repeating key index using modulo 
                  keyIndex = ( index % intArrayLength );
                  
                  // iterate through the keys and repeat when it ends
                  key =  integerArray[ keyIndex ];
                  
                  // find the temporary character at the given index
                  tempChar = characterArray[ index ];
                  
                  // add the key value to the char value of the index location
                  newChar = (char)(tempChar - key);
                  
                  // set the index location of the decrypted string array to 
                  //                                    new decrypted character
                  decryptedArray[ index ] = newChar;                  
               }
         
         // return the encrypted string
            return decryptedArray;
            
      }
      
      /*
      name: displayStringWithLeader
      process: takes a string leader quantity and a character array string to 
                                                         display the message.
      method input/parameters: String leader quantity
      method output/parameters: none
      method output/returned: none
      device input/keyboard: none
      device output/monitor: displays the encrypted or decrypted string
      dependencies: Console IO Class Tools
      */
      
      public static void displayStringWithLeader( String leader, 
                                                        char[] characterArray )
      {
      
         // initialize variables
         
            // create an index
            int index;
            
            // create the temporary character 
            char tempChar;
         
            // create the character array length variable
               // method: length
            int characterArrayLength = characterArray.length;
         
         // display the string message with the string leader
            
            // print the leader message
               // method: printString
            conIO.printString( leader );
            
            // print the encrypted message
            
               // start loop up to the length of the character array
               for( index = 0; index < characterArrayLength; index++ )
                  {
                     // convert temporary character to the index located char
                     tempChar = characterArray[ index ];
                     
                     // add the current index value of the array to the string
                        // method: printChar
                     conIO.printChar( tempChar );
                     
                  }
         
            // print endlines for spacing
               // method: printEndlines
            conIO.printEndlines( TWO_ENDLINES );
         
      }
      
      /*
      name: encryptString
      process: repeatedly adds the integer array values to the input string to 
                                                  create the encrypted message.
      method input/parameters: the two arrays
      method output/parameters: none
      method output/returned: the encrypted message
      device input/keyboard: none
      device output/monitor: none
      dependencies: none
      */
    
      public static char[] encryptString( char[] characterArray, 
                                                           int[] integerArray )
      {
         // initialize variables
         
            // get characterArray length
               // method: length
            int charArrayLength = characterArray.length;
            
            // get integerArray length
               // method: length
            int intArrayLength = integerArray.length;
            
            // create an index
            int index;
            
            // create a repeating key index location
            int keyIndex;
         
            // create the looping key value
            int key; 
            
            // create temporary character value 
            char tempChar;
            
            // create the new character values of the encrypted char
            char newChar;
            
            // create the encrypted string
            char[] encryptedArray = new char[ charArrayLength ];
            
         // start loop up to the input string length
            for( index = 0; index < charArrayLength; index++ )
               {
                  // find the repeating key index using modulo 
                  keyIndex = ( index % intArrayLength );
                  
                  // iterate through the keys and repeat when it ends
                  key =  integerArray[ keyIndex ];
                  
                  // find the temporary character at the given index
                  tempChar = characterArray[ index ];
                  
                  // add the key value to the char value of the index location
                  newChar = (char)(tempChar + key);
                  
                  // set the index location of the encrypted string array to 
                  //                                    new encrypted character
                  encryptedArray[ index ] = newChar;
                  
               }
         
         // return the encrypted string
            return encryptedArray;
      }
      
   }
