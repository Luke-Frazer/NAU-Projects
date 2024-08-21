package p10_package;

/**
 * Class encrypts, stores, and decrypts messages encoded and stored in an array 
 * of long integers
 * 
 * @author MichaelL
 *
 */
public class EncryptionClassDeux
   {
    /**
     * Default capacity for square array
     */
    private final String DEFAULT_STRING = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constant for decoding first three digits of long
     */
    private final int THREE_DIGIT_OFFSET = 1000;
    
    /**
     * Constant for decoding second three digits of long
     */
    private final int SIX_DIGIT_OFFSET = 1000000;

    /**
     * Constant for decoding third three digits of long
     */
    private final int NINE_DIGIT_OFFSET = 1000000000;

    /**
     * Constant for random index lower limit
     */
    private final int RAND_LOWER_LIMIT = 10;

    /**
     * Constant for random index upper limit
     */
    private final int RAND_UPPER_LIMIT = 99;

    /**
     * Constant for minimum string size
     */
    private final int MIN_STRING_LENGTH = 15;

    /**
     * Constant indicating used value
     */
    private final int USED_CODE = 1;

    /**
     * Constant indicating unused value
     */
    private final int UNUSED_CODE_LOW = 2;
    
    /**
     * Constant indicating unused value
     */
    private final int UNUSED_CODE_HIGH = 9;
    
    /**
     * Constant indicating control code for number only
     */
    public static final int ENUM_NUMBER_ONLY = 1001;
    
    /**
     * Constant indicating control code for character only
     */
    public static final int ENUM_CHARACTER_ONLY = 2002;
    
    /**
     * Constant indicating control code for both number and character
     */
    public static final int ENUM_BOTH = 3003;
    
    /**
     * Constant indicating tilde character
     */
    private final char TILDE_CHAR = '~';
    
    /**
     * Constant indicating caret character
     */
    private final char CARET_CHAR = '^';
    
    /**
     * Constant indicating space character
     */    
    private final char SPACE_CHAR = ' ';
    
    /**
     * Constant indicating caret character
     */
    private final char RIGHT_CURLY_BRACE_CHAR = '}';
    
    /**
     * data array
     */
    private long array[][];
    
    /**
     * side capacity for square array
     */
    private int sideCapacity;
    
    /**
     * Default constructor
     * <p>
     * Creates an array with DEFAULT_STRING "abcdefghijklmnopqrstuvwxyz" 
     * and sets all the elements in it to random characters
     * <p>
     * Dependencies: createArray
     */
    EncryptionClassDeux()
       {
          array = createArray( DEFAULT_STRING );
       }
    
    /**
     * Initialization constructor 
     * <p>
     * Captures and encrypts string
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String object holding data to be encrypted
     * 
     */
    EncryptionClassDeux( String toEncrypt )
       {
          encryptString( toEncrypt );
       }
    
    /**
     * Copy constructor 
     * <p>
     * Dependencies: None
     * 
     * @param copied EncryptionClassDeux object to be copied into this object
     * 
     */
    EncryptionClassDeux( EncryptionClassDeux copied )
       {
          // create the copied array element
          this.array = copied.array;
       }
    
    /**
     * Create array
     * <p>
     * Finds length of string to be encrypted; 
     * if string is less than MIN_STRING_LENGTH, 
     * length is set to MIN_STRING_LENGTH;
     * either way string length is then doubled
     * <p>
     * Finds the square root of the updated string length and sets side capacity; 
     * creates local array, then calls fillArray which sets all the elements 
     * in the array to random characters other than tilde ('~')
     * <p>
     * Returns local array to calling method
     * <p>
     * Dependencies: {String}.length, Math.sqrt, fillArray
     * 
     * @param setUpString string used to find and process string length
     * 
     * @return array [][] of long values
     */
    private long [][] createArray( String setUpString )
       {
        // initialize method/variables
        int strLen = setUpString.length();        
        long [][] tempArr;
        
        // check for string length less than MIN_STRING_LENGTH
        if( strLen < MIN_STRING_LENGTH )
           {
            // set string length to MIN_STRING_LENGTH
            strLen = MIN_STRING_LENGTH; 
           }
        
        // double length of string
        strLen *= 2;
        
        // calculate side capacity
           // method: .sqrt
        sideCapacity = (int)( Math.sqrt( strLen ) );
        
        // crate new array
        tempArr = new long[ sideCapacity ][ sideCapacity ];
        
        // fill array with random
           // method: fillArray
        tempArr = fillArray( tempArr );
        
        // return array reference
        return tempArr;
       }
    
    /**
     * displayArray
     * <p>
     * Depending on control code, array is displayed one of three ways: 
     * NUMBER_ONLY: displays array of long values; CHARACTER_ONLY: displays
     * encoded characters; BOTH: displays both numbers and characters
     * <p>
     * Uses System.out.format
     * <p>
     * Dependencies: System.out.println, System.out.format, getCharValue
     * 
     * @param ctrlCode integer control code to indicate kind of display
     */
    public void displayArray( int ctrlCode )
       {
          // initialize row and column values
          int row, column;
          
          // initialize the temporary value for each array element
          long currentValue;
          
          // create the array element to be converted to a char
          long arrayElement;
          
          // create the converted character element
          char charValue;
          
          // print out the display array
             // method: format
          System.out.format( "Display Array: %n" );
          
          // check if the input is number only
          if( ctrlCode == ENUM_NUMBER_ONLY )
             {
                // loop until the number of rows is reached
                for( row = 0; row < sideCapacity; row++ )
                   {
                      // loop until the number of columns is reached
                      for( column = 0; column < sideCapacity; column++ )
                         {
                            // set the temporary current value to the array val
                            currentValue = array[ column ][ row ];
                            
                            // print the current value with a space
                               // method: format
                            System.out.format( " %d", currentValue );
                            
                         }
                      
                      // print an endline
                         // method: println
                      System.out.println();
                      
                   }
             }
          
          // check if the input is character only
          else if( ctrlCode == ENUM_CHARACTER_ONLY )
             {
                // loop until the number of rows is reached
                for( row = 0; row < sideCapacity; row++ )
                   {
                      // loop until the number of columns is reached
                      for( column = 0; column < sideCapacity; column++ )
                         {
                            // set the array element to the current array value
                            arrayElement = array[ column ][ row ];
                            
                            // set the char value to the converted array element
                               // method: getCharValue
                            charValue = getCharValue( arrayElement );
                            
                            // print the current char value with a space
                               // method: format
                            System.out.format( " ('%s')", charValue );
                         }
                      
                      // print an endline
                         // method: println
                      System.out.println();
                      
                   }
             }
          
          // check if the input is both
          else if( ctrlCode == ENUM_BOTH )
             {
                // loop until the number of rows is reached
                for( row = 0; row < sideCapacity; row++ )
                   {
                      // loop until the number of columns is reached
                      for( column = 0; column < sideCapacity; column++ )
                         {
                            // set the array element to the current array value
                            arrayElement = array[ column ][ row ];
                            
                            // set the temporary current value to the array val
                            currentValue = array[ column ][ row ];
                            
                            // set the char value to the converted array element
                               // method: getCharValue
                            charValue = getCharValue( arrayElement );
                            
                            // print the current char value with a space
                               // method: format
                            System.out.format( " %d('%s')", currentValue, 
                                                                   charValue );
                            
                         }
                      
                      // print an endline
                         // method: println
                      System.out.println();
                      
                   }
             }
          
          // print out the final endline
             // method: println
          System.out.println();
          
       }
    
    /**
     * decryptArray
     * <p>
     * Finds the tilde in the array, and tracks the elements of the array
     * to set the individual character values back into a String; 
     * list of characters ends with a caret ('^')
     * <p>
     * Dependencies: findTilde, getNextXPos, getNextYPos, getCharValue
     * 
     * @return String value containing decrypted text
     */
    public String decryptString()
       {
          // initialize the current character value of the array
          char currentChar;
          
          // initialize the next x and y positions
          int nextXPosition, nextYPosition;
          
          // create a flag for if the value is a caret
          boolean isCaret = false;
          
          // created the empty decrypted string
          String decryptedString = "";
          
          // initialize the tilde location
          long position = findTilde();

          // loop until the caret is found
          while( isCaret == false )
             {
                // get the next x and y positions of the current value
                   // method: getNextXPos
                nextXPosition = getNextXPos( position );
                nextYPosition = getNextYPos( position );
                
                // set the current character value to the array's character val
                   // method: getCharValue
                currentChar = getCharValue( array[ nextXPosition ]
                                                             [ nextYPosition ]);

                // check if the current character is a caret
                if( currentChar == CARET_CHAR ) 
                   {
                      // set the flag to true
                      isCaret = true;
                   }
                
                // otherwise, the current character is not a caret
                else
                   {
                      // add the current character to the decrypted string
                      decryptedString += currentChar;
                   }
                
                // set the new position value to the arrays next values 
                position = array[ nextXPosition ][ nextYPosition ];

             }
                   
          // return the decrypted string
          return decryptedString; 
       }
    
    /**
     * elementIsUsed
     * <p>
     * Returns true if element is used in array, or if the current y position
     * is equal to the next y position and the current x position is equal to
     * the next x position
     * <p>
     * Dependencies: None
     * 
     * @param curYPos integer current y position to be tested
     * 
     * @param curXPos integer current x position to be tested
     * 
     * @param nextYPos integer next y position to be tested
     * 
     * @param nextXPos integer next x position to be tested
     * 
     * @return Boolean value indicating state of specified testing
     */
    private boolean elementIsUsed( int curYPos, 
                                       int curXPos, int nextYPos, int nextXPos )
       {
          // initialize the isUsed flag
          boolean isUsed = false;
          
          // check if the current y position is equal to the next y position
          // and if the current x position is equal to the next x position
          if ( curYPos == nextYPos && curXPos == nextXPos )
             {
                // set the used flag equal to true
                isUsed = true;
             }
          
          // check if the first value is one
          else if ( array[ nextYPos ][ nextXPos ] / NINE_DIGIT_OFFSET == 1 )
             {
                // set the used flag to true
                isUsed = true;
             }
        
          // return the flag
          return isUsed;
       }

    /**
     * encodeData
     * <p>
     * Encodes four parts of data into long value as ucccyyyxxx
     * where u is the used flag
     * ccc is the character Unicode/ASCII value
     * yyy is the y position of an element
     * xxx is the x position of an element
     * <p>
     * Dependencies: None
     * 
     * @param used integer value indicating that the value is part 
     * of the encrypted string, which is encoded into the long value
     * 
     * @param dataChar character value encoded into the long value
     * 
     * @param yPos integer value encoded into the long value
     * 
     * @param xPos integer value encoded into the long value
     * 
     * @return long value containing encoded data
     */
    public long encodeData( int used, char dataChar, int yPos, int xPos )
       {
          // initialize the concatenated value to start as the first used digit
          long concatValue = used;
          
          // initialize dataCharInteger value as the integer form of dataChar
          int dataCharInteger = (int)( dataChar );

          // combine all of the values together
             
             // multiply the previous concatenated value by 1000 then add the 
             // dataChar value
             concatValue = ( concatValue * THREE_DIGIT_OFFSET ) + 
                                                               dataCharInteger;
             
             // multiply the previous concatenated value by 1000 then add the 
             // xPos value
             concatValue = ( concatValue * THREE_DIGIT_OFFSET ) + xPos;
          
             // multiply the previous concatenated value by 1000 then add the 
             // yPos value
             concatValue = ( concatValue * THREE_DIGIT_OFFSET ) + yPos;
        
          // return the concatenated value
          return concatValue;
       }
    
    /**
     * encryptString
     * <p>
     * Creates array using the input string which also fills array with random 
     * characters, then places characters randomly around the array starting 
     * with a tilde ('~') and ending with a caret ('^')
     * <p>
     * Each long value in the array holds a used marker, the character,
     * and the y and x position of the next character
     * <p>
     * Process generates a new random y, x pair for each character data element
     * but verifies that the y, x pair has not already been used; once these
     * are found, the long value is encoded with the used marker, the character,
     * and the next y, x positions, and placed into the array
     * <p>
     * Dependencies: {String}.length, {String}.charAt, createArray, 
     * getRandBetween, encodeData, elementIsUsed
     * 
     * @param toEncrypt String value to be encrypted
     */
    public void encryptString( String toEncrypt )
       {
        // initialize method/variables
        long encodeVal;
        int currentYPos, currentXPos;
        int nextYPos, nextXPos;        
        int strIndex, strLen;
        char postChar = TILDE_CHAR;

        // place caret character at end of string
        toEncrypt += CARET_CHAR;
        
        // get string length
           // method: .length
        strLen = toEncrypt.length();
        
        // create array
           // method: createArray
        array = createArray( toEncrypt );

        // get random values for first (tilde) character
           // method: getRandBetween
        currentYPos = getRandBetween( 0, sideCapacity - 1 );
        currentXPos = getRandBetween( 0, sideCapacity - 1 );

        // loop across string
        for( strIndex = 0; strIndex < strLen; strIndex++ )
           {
            // loop until unique y and x positions
            do
               {
                // set potential next y pos
                   // method: getRandBetween
                nextYPos = getRandBetween( 0, sideCapacity - 1 );
                
                // set potential next x pos
                   // method: getRandBetween
                nextXPos = getRandBetween( 0, sideCapacity - 1 );
                
                // encode value into long
                   // method: encodeData
                encodeVal = encodeData( USED_CODE, 
                                               postChar, nextYPos, nextXPos );
               }
            // end loop if element or previous indices are not already used
               // method: elementIsUsed
            while( elementIsUsed( currentYPos, 
                                            currentXPos, nextYPos, nextXPos ) );

            // place encoded value in array
            array[ currentYPos ][ currentXPos ] = encodeVal;
            
            // set current y and x positions to processed next ones
            currentYPos = nextYPos;            
            currentXPos = nextXPos;
            
            // set new character to be encrypted
               // method: .charAt
            postChar = toEncrypt.charAt( strIndex );
           }
        
        // set last value to last character (tilde)
           // method: encodeData
        encodeVal = encodeData( USED_CODE, postChar, currentYPos, currentXPos );
        
        // set last element
        array[ currentYPos ][ currentXPos ] = encodeVal;
       }
    
    /**
     * fillArray
     * <p>
     * Fills temporary array with a random value between UNUSED_CODE_LOW and 
     * UNUSED_CODE_HIGH, a random character other than tilde ('~'), and a 
     * randomly generated y and x location between RAND_LOWER_LIMIT and
     * RAND_UPPER_LIMIT 
     * <p>
     * Dependencies: getRandBetween, getRandomChar, encodeData
     * 
     * @param arrayToFill long [][] array to be filled with random data
     * 
     * @return long [][] array with specified random values
     */
    public long [][] fillArray( long [][] arrayToFill )
       {
          // initialize row index
          int row;
          
          // initialize column index
          int col;
          
          // create the random unused value 
          int unusedValue;
          
          // create the temporary character
          char tempChar;
          
          // create the random x and y value
          int randomX, randomY;
          
          // create the array value
          long arrayVal;
          
          // set the array row and column maxes to the randomized x and y values
          arrayToFill = new long[ sideCapacity ][ sideCapacity ];
          
          // loop until the rows value is reached
          for( row = 0; row < sideCapacity; row++ )
             {
                // loop until the columns value is reached
                for( col = 0; col < sideCapacity; col++ )
                   {
                      // set the temporary character to a randomized character
                         // method: getRandomChar
                      tempChar = getRandomChar();
                      
                      // create a random unused value
                         // method: getRandBetween
                      unusedValue = getRandBetween( UNUSED_CODE_LOW,
                                                            UNUSED_CODE_HIGH );
                      
                      // set the random x value to a random number between 10-99
                         // method: getRandBetween
                      randomX = getRandBetween( RAND_LOWER_LIMIT,
                                                             RAND_UPPER_LIMIT );
                      
                      // set the random y value to a random number between 10-99
                         // method: getRandBetween
                      randomY = getRandBetween( RAND_LOWER_LIMIT,
                                                             RAND_UPPER_LIMIT );
                      
                      // encode the data of all of the values
                         // method: encodeData
                      arrayVal = encodeData( unusedValue, tempChar, randomY,
                                                                     randomX );
                      
                      // set the row and column location to the encodedData
                      arrayToFill[ col ][ row ] = arrayVal;

                   }

             }
        
          // return the array
          return arrayToFill; 
       }
    
    /**
     * findTilde
     * <p>
     * Finds tilde encoded in two dimensional array of long values
     * <p>
     * Dependencies: getCharValue, encodeData
     * 
     * @return long encoded value containing UNUSED_CODE_LOW, TILDE_CHAR,
     * and the y and x locations of the TILDE_CHAR
     */
    private long findTilde()
       {
          // initialize row and column
          int row, column;
          
          // initialize the character value of the array 
          char characterValue; 
          
          long foundValue = 0;
          
          // loop across rows
          for( row = 0; row < sideCapacity; row++ )
             {
                // loop across columns
                for( column = 0; column < sideCapacity; column++ )
                   {
          
                      // get the character from the array element
                         // method: getCharValue
                      characterValue = getCharValue( array[ column ][ row ] );
          
                      // check for character equal to tilde
                      if( characterValue == TILDE_CHAR )
                         {
                            // encode a number
                            // UNUSED, tilde character, y/row index, 
                            // x/column index
                            foundValue = array[ column ][ row ];                   
                         }
                   }
             }
          
          // return the encoded number
          return foundValue;

       }
    
    /**
     * getCharValue
     * <p>
     * decodes long integer to return character
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded character to retrieve
     * 
     * @return character retrieved
     */
    private char getCharValue( long encoded )
       {
          // create divided value by dividing the encoded value by 1000
          long dividedValue = encoded / SIX_DIGIT_OFFSET;
          
          // create the final value by finding the remainder of the divided 
          // value divided by 1000
          long finalValue = dividedValue % THREE_DIGIT_OFFSET;
          
          // create final character value by converting the finalValue to char
          char charValue = (char)(finalValue);
          
        return charValue;  
       }
    
    /**
     * getRandBetween
     * <p>
     * Returns random value between low and high parameters, inclusive
     * <p>
     * Dependencies: Math.random
     * 
     * @param low integer value indicating low end of random range to generate
     * 
     * @param high integer value indicating high end of random range to generate
     * 
     * @return random value between low and high parameters, inclusive
     */
    public int getRandBetween( int low, int high )
       {
        // initialize method/variables
        // set range
        int range = high - low + 1;
        
        // return randomly generated value within range
           // method: .random
        return (int)( Math.random() * range + low );
       }

    /**
     * getRandomChar
     * <p>
     * Returns a Unicode/ASCII character from space (lowest printable character)
     * to right curly brace (highest printable character before tilde); 
     * tilde ('~') is never returned
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return value containing random character
     */
    private char getRandomChar()
       {
        // initialize method/variables
        int randomVal;
        
        // set random value
           // method: getRandBetween
        randomVal = getRandBetween( (int)SPACE_CHAR, 
                                                  (int)RIGHT_CURLY_BRACE_CHAR );
        
        // return random value as character
        return (char)randomVal;
       }
    
    /**
     * getNextXPos
     * <p>
     * Returns the next x position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded x location to retrieve
     * 
     * @return int x location retrieved
     */
    private int getNextXPos( long encoded )
       {
          // initialize the remainder value and find the remainder of
          // the encoded value divided by 1000
          int remainder = ( int )( encoded % THREE_DIGIT_OFFSET );

          // return the remainder value
          return remainder;  
       }

   /**
     * getNextYPos
     * <p>
     * Returns the y position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded y location to retrieve
     * 
     * @return int y location retrieved
     */
    private int getNextYPos( long encoded )
       {
          // initialize the divided value after dividing by 1000
          long dividedValue = encoded / THREE_DIGIT_OFFSET;
          
          // initialize the remainder of dividing the divided value by 1000
          int remainder = ( int )( dividedValue % THREE_DIGIT_OFFSET );
        
          // return the remainder value
          return remainder;
       }

   }
