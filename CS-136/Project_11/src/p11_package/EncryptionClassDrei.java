package p11_package;

/**
 * Class uses linked list to encrypt text
 * 
 * @author MichaelL
 *
 */

public class EncryptionClassDrei
   {
    /**
     * Constant for one digit offset in calculations
     */
    private final int ONE_DIGIT_OFFSET = 10;
   
    /**
     * Constant for two digit offset in calculations
     */
    private final int TWO_DIGIT_OFFSET = 100;
   
    /**
     * Constant for one digit offset in calculations
     */
    private final int THREE_DIGIT_OFFSET = 1000;
   
    /**
     * Constant for minimum random iterations in encryption
     */
    private final int MIN_ITERATIONS = 3;
   
    /**
     * Constant for maximum random iterations in encryption
     */
    private final int MAX_ITERATIONS = 5;
   
    /**
     * Constant for minimum three digit random number
     */
    private final int THREE_DIGIT_LOW = 100;
   
    /**
     * Constant for maximum three digit random number
     */
    private final int THREE_DIGIT_HIGH = 999;
   
    /**
     * Constant for minimum two digit random number
     */
    private final int TWO_DIGIT_LOW = 10;
   
    /**
     * Constant for maximum two digit random number
     */
    private final int TWO_DIGIT_HIGH = 99;
   
    /**
     * Constant for caret character
     */
    private final char CARET_CHAR = '^';
   
    /**
     * Head reference for linked list
     */
    private NodeClass headRef;
    
    /**
     * Default constructor
     * <p>
     * Sets head reference to null
     */
    public EncryptionClassDrei()
       {
          // set head reference to null
          headRef = null;
       }
    
    /**
     * Initialization constructor
     * <p>
     * Accepts and encrypts String parameter
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String value to be encrypted
     */
    public EncryptionClassDrei( String toEncrypt )
       {
          // encrypts the inputed string
             // method: encryptString
          encryptString( toEncrypt );
       }
    
    /**
     * Copy constructor
     * <p>
     * Copies other linked list into this linked list, 
     * making duplicate with new data
     * <p>
     * Dependencies: NodeClass copy constructor
     * 
     * @param copied EncryptionClassDrei object with linked list to be copied
     */
    public EncryptionClassDrei( EncryptionClassDrei copied )
       {
          // create a temporary reference
          NodeClass temporaryRef = null;
          
          // set this reference to null to start
          this.headRef = null;
          
          // check if the copied head ref is not null
          if( copied.headRef != null )
             {
                // set this head ref to a new copied node class object
                this.headRef = new NodeClass( copied.headRef );
                
                // set the temporary reference to this head reference
                temporaryRef = this.headRef;
                
                // loop until the temporary reference is null
                while( temporaryRef != null )
                   {
                      // set the temporary reference to the next ref
                      temporaryRef = temporaryRef.nextRef;
                   }
             }
       }
   
    /**
     * appendItem
     * <p>
     * Adds item to end of list, uses helper method
     * <p>
     * Dependencies: appendItemHelper
     * 
     * @param newVal long value to be appended to list
     */
    public void appendItem( long newVal )
       {
          // set the head reference to the appendItemHelper's Node using the 
          // new value
             // method: appendItemHelper
          headRef = appendItemHelper( headRef, newVal );
       }
    
    /**
     * appendItemHelper
     * <p>
     * Recursively iterates to end of list, then adds node
     * <p>
     * Dependencies: NodeClass copy constructor
     * 
     * @param wkgRef NodeClass reference pointing to current node in recursion
     * 
     * @param newVal long value to be appended to list
     * 
     * @return NodeClass reference to most recent node in recursion
     */
    private NodeClass appendItemHelper( NodeClass wkgRef, long newVal )
       {
          // check if the working Ref is not null
          if( wkgRef != null )
             {
                // call the method on the next ref to iterate recursively
                   // method: appendItemHelper
                wkgRef.nextRef = appendItemHelper( wkgRef.nextRef, newVal );
             }
          
          // otherwise, the working Ref is null
          else 
             {
                // set the working ref to a new NodeClass object using newVal
                wkgRef = new NodeClass( newVal );
             }
          
          // return the NodeClass reference to the most recent Node
          return wkgRef;
       }
    
    /**
     * decodeCharacter
     * <p>
     * Removes values encoded in long, reassembles and returns as character
     * <p>
     * Incoming character first digit is in the 7th position (000000x00, 
     * the second digit is in the fourth position (000x00000),
     * and the third digit is in the  first position (x00000000)
     * <p>
     * Dependencies: none
     * 
     * @param encodedLong long value holding encoded character value
     * 
     * @return value holding decoded character
     */
    private char decodeCharacter( long encodedLong )
       {
          // initialize the index and number of iterations for the index
          int index = 0;
          int threeIterations = 3;
          
          // initialize the changing values within the loop
          long remainder;
          long decodingValue = encodedLong;
          long decodedValue = 0;
          
          // initialize the decoded character
          char decodedChar = 0;
          
          // loop three times for the three integers to pull
          while ( index < threeIterations )
             {
                // multiply decoded value by 10 for adding the values together
                decodedValue *= ONE_DIGIT_OFFSET;
                
                // divide the encoded value by 100
                decodingValue /= TWO_DIGIT_OFFSET;
                
                // find the remainder of this value when divided by 10
                remainder = decodingValue % ONE_DIGIT_OFFSET;
                
                // divide the decoding value by ten to get to next 3 numbers
                decodingValue /= ONE_DIGIT_OFFSET;
                
                // add the remainder to the decoded value
                decodedValue += remainder;
                
                // increase the index
                index++;
             }
          
          // convert the decoded value to a character
          decodedChar = ( char )( decodedValue );
          
          // return the decoded character
          return decodedChar;
       }
        
    /**
     * decryptList
     * <p>
     * Converts linked list of encoded integers into string
     * <p>
     * Dependencies: decodeCharacter
     * 
     * @param wkgRef NodeClass reference to uncloaked linked list
     * 
     * @return String result of processing
     */
    public String decryptList( NodeClass wkgRef )
       {
          // create the decoded character variable
          char decodedChar;
          
          // create an empty string variable to add the list to
          String workingString = "";
          
          // loop until the working reference is null
          while( wkgRef != null )
             {
                // set the decoded character variable to the encrypted value's 
                // decodeCharacter() value
                   // method: decodeCharacter
                decodedChar = decodeCharacter( wkgRef.encryptedVal );
                
                // add the decodedChar to the string variable
                workingString += decodedChar;
                
                // set working reference to the next reference
                wkgRef = wkgRef.nextRef;
                
             }
       
          // return the accumulator string variable
          return workingString;
       }
   
    /**
     * displayEncryptedList (overloaded)
     * <p>
     * Displays THIS linked list as series of numbers with a specified width
     * 
     * @param width integer value specifying how many numbers on a line
     */
    public void displayEncryptedList( int width )
       {
          // call the other displayEncrypted list with our headRef and width
             // method: displayEncryptedList
          displayEncryptedList( headRef, width );
       }
   
       /**
     * displayEncryptedList (overloaded)
     * <p>
     * Displays USER PROVIDED linked list as series of numbers 
     * with a specified width
     * 
     * @param wkgRef NodeClass reference starting at head of list
     * 
     * @param width integer value specifying how many numbers on a line
     */
    public void displayEncryptedList( NodeClass wkgRef, int width )
       {
          // initialize the max number of iterations
          int index = 0;
          
          // create the decoded character variable
          char decodedChar;
          
          // print an endline to space out the chunks of text
             // method: println
          System.out.println();

          // loop until the working ref is null
          while( wkgRef != null )
             {
                // check if the index is equal to the width
                if( index == width )
                   {
                      // reset the index to zero
                      index = 0;
                      
                      // print an endline
                         // method: println
                      System.out.println();
                   }
                // set the decoded character to encrypted value's decoded char
                   // method: decodeCharacter
                decodedChar = decodeCharacter( wkgRef.encryptedVal );
                
                // print out the long value, followed by its encrypted char val
                   // method: format
                System.out.format( "%d('%c')", wkgRef.encryptedVal,
                                                                 decodedChar );
                
                // set the working ref to the next working ref
                wkgRef = wkgRef.nextRef;
                
                // increase the index
                index++;
            }
          
          // print an endline to space out the chunks of code
          System.out.println();

       }
    
    /**
     * encodeCharacter
     * <p>
     * Sets three-digit character value into nine-digit long such that
     * the first digit is in the 7th position (000000x00), the second digit 
     * is in the fourth position (000x00000)and the third digit is in the 
     * first position (x00000000)
     * <p>
     * Dependencies: getRandBetween
     * 
     * @param encodeChar character value to be encoded
     * 
     * @return long value containing encoded character
     */
    public long encodeCharacter( char encodeChar )
       {
        // initialize method, variables
       
           // set the character to an integer
           int charInt = (int)encodeChar;
           
           // get the first/LSD digit
           int firstDigit = charInt % ONE_DIGIT_OFFSET;
           
           // declare other variables
           int thirdDigit, secondDigit;
           long resultLong;
        
        // divide off first digit
        charInt /= ONE_DIGIT_OFFSET;
        
        // capture second digit
        secondDigit = charInt % ONE_DIGIT_OFFSET;
        
        // divide off second digit
        charInt /= ONE_DIGIT_OFFSET;
        
        // capture third digit
        thirdDigit = charInt;
        
        // set first digit in long value
           // method: getRandBetween
        resultLong = firstDigit * TWO_DIGIT_OFFSET 
                              + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH );
        
        // set second digit in long value
           // method: getRandBetween
        resultLong = secondDigit * TWO_DIGIT_OFFSET 
                        + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH ) 
                                              + resultLong * THREE_DIGIT_OFFSET;
        
        // set third digit in long value
           // method: getRandBetween
        resultLong = thirdDigit * TWO_DIGIT_OFFSET
                        + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH )
                                              + resultLong * THREE_DIGIT_OFFSET;
        // return long value
        return resultLong;
       }
    
    /**
     * encryptString
     * <p>
     * Generates random groups of values in linked list,
     * then places caret and next character,
     * repeats this process until end of string,
     * then adds one more random group
     * <p>
     * Each random group has a random number between 3 and 5 values
     * which are themselves random
     * <p>
     * Dependencies: .length, charAt, getRandBetween, generateNineDigitRandom,
     * encodeCharacer, appendItem
     * 
     * @param toEncrypt String value to be encrypted to linked list
     */
    public void encryptString( String toEncrypt )
       {
        // initialize method, variables
        int index = 0;
        int randIndex, numIterations;
        long nineDigitRand, charLongValue;
        char encodeChar;
        
        // loop to end of string
           // method: .length
        while( index < toEncrypt.length() )
           {
            // create number of random iterations
               // method: getRandBetween
            numIterations = getRandBetween( MIN_ITERATIONS, MAX_ITERATIONS );
            
            // loop across random iterations
            for( randIndex = 0; randIndex < numIterations; randIndex++ )
               {
                // create dummy number
                   // method: generateNineDigitRandom
                nineDigitRand = generateNineDigitRandom();
                
                // add item to linked list
                   // method: appendItem
                appendItem( nineDigitRand );
               }           
            // end loop
           
            // create value for caret
               // method: encodeCharacter
            charLongValue = encodeCharacter( CARET_CHAR );
            
            // add caret to linked list
               // method: appendItem
            appendItem( charLongValue );
            
            // get next character to encrypt
               // method: .charAt
            encodeChar = toEncrypt.charAt( index );
            
            // create value for new character
               // method: encodeCharacter
            charLongValue = encodeCharacter( encodeChar );
            
            // add item to linked list
               // method: appendItem
            appendItem( charLongValue );
            
            // increment loop index
            index++;
           }
        // end loop
        
        // add one more series of random values
        
           // create number of random iterations
              // method: getRandBetween
           numIterations = getRandBetween( MIN_ITERATIONS, MAX_ITERATIONS );
                
           // loop across random iterations
           for( randIndex = 0; randIndex < numIterations; randIndex++ )
              {
               // create new random value
                  // method: generateNineDigitRandom
               nineDigitRand = generateNineDigitRandom();
               
               // add value to linked list
                  // method: appendItem
               appendItem( nineDigitRand );
              }           
           // end loop
       }    
   
    /**
     * generateNineDigitRandom
     * <p>
     * Generates a nine digit random value for cloaking encrypted data
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return nine digit random long
     */
    private long generateNineDigitRandom()
       {
       // initialize index
          int index = 0;
          
          // initialize the three iteration variable
          int threeIterations = 3;
          
          // initialize the accumulating randomized long number
          long randomNineDigits = 0;
          
          // initialize the random number
          long randomNumber;
          
          // loop nine times
          while ( index < threeIterations )
             {
                // multiply the accumulating nine digit number by 1000 to go to 
                // the next digit set
                randomNineDigits *= THREE_DIGIT_OFFSET;
                
                // generate a random number between 100 - 999
                   // method: getRandBetween
                randomNumber = getRandBetween( THREE_DIGIT_LOW, 
                                                            THREE_DIGIT_HIGH );
                
                // add the random number to the accumulator
                randomNineDigits += randomNumber;
                
                // increase the index
                index++;
             }
       
          // return the nine digit value
          return randomNineDigits;
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
    private int getRandBetween( int low, int high )
       {
        // initialize method, variables
       
           // create range value
           int range = high - low + 1;
   
        // find random within range, inclusive, return
           // method: Math.random
        return (int)( Math.random() * range + low );
       }
    
    /**
     * isCharacter
     * <p>
     * Returns Boolean true if node holds specified character,
     * false otherwise
     * <p>
     * Dependencies: decodeCharacter
     * 
     * @param testRef NodeClass reference to given node
     * 
     * @param testChar character value to be tested in node
     * 
     * @return Boolean result of specified test
     */
    private boolean isCharacter( NodeClass testRef, char testChar )
       {
          // initialize and create the test reference long value to be decrypted
          long decryptMe = testRef.encryptedVal;
          
          // initialize and create the decrypted character from the test ref
             // method: decodeCharacter
          char decryptedChar = decodeCharacter( decryptMe );
          
          // check if the decrypted character is equal to the test character
          if( decryptedChar == testChar )
             {
                // return true if its the same thing
                return true;
             }
          
          // otherwise, return false since they are different
          return false; 
       }
    
    /**
     * uncloakList
     * <p>
     * Removes all random and caret nodes from linked list, 
     * linked list with encoded integers/characters remains
     * <p>
     * Dependencies: isCharacter
     * 
     * @return NodeClass reference to newly created linked list
     * containing only the encoded text letters
     */
    public NodeClass uncloakList()
       {
        // initialize method, variables
       
           // set working reference to head reference
           NodeClass wkgRef = headRef;
           
           // set other references to null
           NodeClass wkgResultRef = null, resultRef = null;
        
        // loop to end of linked list   
        while( wkgRef != null )
           {
            // search for caret
               // method: isCharacter
            while( wkgRef != null && !isCharacter( wkgRef, CARET_CHAR ) )
               {
                // skip ahead in linked list
                wkgRef = wkgRef.nextRef;               
               }
            
            // check for caret found (not null)
            if( wkgRef != null )
               {
                // skip over caret
                wkgRef = wkgRef.nextRef;
                
                // check for result reference null (empty)
                if( resultRef == null )
                   {
                    // set result reference to working reference
                    resultRef = wkgRef;
                    
                    // set a working result reference to the result reference
                    wkgResultRef = resultRef;
                   }
                
                // otherwise, assume result reference already has data
                else
                   {
                    // link the newest found character node
                    //   to the working result reference
                    wkgResultRef.nextRef = wkgRef;
                    
                    // advance the working result reference
                    wkgResultRef = wkgResultRef.nextRef;
                   }
               }
           }
        // end loop across linked list
        
        // set end for working result reference
        wkgResultRef.nextRef = null;
        
        // return result reference
        return resultRef;
       }
   }