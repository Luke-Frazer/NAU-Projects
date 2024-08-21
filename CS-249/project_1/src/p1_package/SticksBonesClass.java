package p1_package;

/**
 * Class manages two dimensional array of sticks or bones; 
 * includes one dimensional array of sticks
 * and one dimensional array of bones
 * <p>
 * The limit on number of sticks is 25 per cent of array height
 * and the limit on number of bones is 25 per cent of array width
 * 
 * @author Michael Leverington and Luke Frazer
 *
 */
public class SticksBonesClass
   {
    /**
     * Constant, default two dimensional array sides
     */
    private static final int TWO_DIM_ARRAY_SIDE = 50;
       
    /**
     * constant, stick and bone percentage of side length
     */
    private static final double STICK_BONE_PERCENTAGE = 0.25;

    /**
     * constant, horizontal line character
     */
    private static final char HORIZ_LINE = '-';
    
    /**
     * constant, vertical line character
     */
    private static final char VERTICAL_LINE = '|';
    
    /**
     * Master array of sticks and bones
     */
    private CellClass[][] fieldArray;
    
    /**
     * Array of sticks
     */
    private ArtifactClass[] stickArray;
    
    /**
     * height of cell array
     */
    private int fieldArrayHeight;
    
    /**
     * width of cell array
     */
    private int fieldArrayWidth;
    
    /**
     * Number of sticks
     */
    private int numSticks;
    
    /**
     * Array of bones
     */
    private ArtifactClass[] boneArray;
    
    /**
     * Number of bones
     */
    private int numBones;
    
    /**
     * Default constructor
     * <p>
     * Initializes class with random sticks and bones in square array;
     * arrays use default capacities
     */
    public SticksBonesClass()
       {
        this( TWO_DIM_ARRAY_SIDE, TWO_DIM_ARRAY_SIDE );
       }
    
    /**
     * Initialization constructor
     * <p>
     * Initializes class with random sticks and bones;
     * arrays use parameter capacities
     * 
     * @param height integer number of rows in two dimensional array
     * 
     * @param width integer number of columns in two dimensional array
     */
    public SticksBonesClass( int height, int width )
       {
        fieldArrayHeight = height;
        
        fieldArrayWidth = width;
        
        // generate random array
        createRandomStickBoneArray( height, width );
        
        // find sticks, store in array
        findAllSticks();
        
        // find bones, store in array
        findAllBones();
       }
    
    /**
     * Creates a random stick/bone array
     * <p>
     * Random x, y location, with random length of stick or bone
     * between 3 and 6
     * 
     * @param height integer value representing number of rows in array
     * 
     * @param width integer value representing number of columns in array
     */
    // create random stick/bone array
    private void createRandomStickBoneArray( int height, int width )
       {
        int rowIndex, colIndex, locIndex, index = 0;
        int yLoc, xLoc, startLoc = 0;
        int itemLength;
        int minItemLength = 3;
        int maxItemLength = 6;
        int stickCount, boneCount;
        
        fieldArrayHeight = height;
        fieldArrayWidth = width;
        
        // create array of cells
        fieldArray = new CellClass[ fieldArrayHeight ][ fieldArrayWidth ];
        
        for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ )
           {
            for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
               {
                fieldArray[ rowIndex ][ colIndex ] = new CellClass();
               }
           }
        
        // generate between 1/3 of height and full height sticks and bones
        stickCount = generateRandBetween( height / 3, height );
        boneCount = generateRandBetween( height / 3, height );

        boolean createItemSuccess;
        
        while( index < stickCount )
           {
            yLoc = generateRandBetween( startLoc, height - 1 );
            xLoc = generateRandBetween( startLoc, width - 1 );
            itemLength = generateRandBetween( minItemLength, maxItemLength );

            createItemSuccess = true;
            
            for( locIndex = 0; 
                  locIndex < itemLength && createItemSuccess; locIndex++ )
               {
                if( yLoc + locIndex >= height
                      || xLoc >= width
                           || fieldArray[ yLoc + locIndex ][ xLoc ].isUsed() )
                   {
                    createItemSuccess = false;
                   }
               }
            
            if( createItemSuccess )
               {
                for( locIndex = 0; locIndex < itemLength; locIndex++ )
                   {
                    fieldArray[ yLoc + locIndex ][ xLoc ]
                                .setCellCharacter( CellClass.STICK_BONE_CHAR );
                   }

                index++;
               }
           }
        
        index = 0;
        
        while( index < boneCount )
           {
            yLoc = generateRandBetween( startLoc, height - 1 );
            xLoc = generateRandBetween( startLoc, width - 1 );
            itemLength = generateRandBetween( minItemLength, maxItemLength );
            
            createItemSuccess = true;
            
            for( locIndex = 0; 
                  locIndex < itemLength && createItemSuccess; locIndex++ )
               {
                if( xLoc + locIndex >= width
                    || yLoc >= height
                          || fieldArray[ yLoc ][ xLoc + locIndex ].isUsed() )

                   {
                    createItemSuccess = false;
                   }
               }
            
            if( createItemSuccess )
               {
                for( locIndex = 0; locIndex < itemLength; locIndex++ )
                   {
                    fieldArray[ yLoc ][ xLoc + locIndex ]
                                .setCellCharacter( CellClass.STICK_BONE_CHAR );
                   }

                index++;
               }
           }

       }
    
    /**
     * Finds all bones, assigns to bone array
     * <p>
     * May find adjacent crossing stick and count as bone
     */
    public void findAllBones()
       {

      // initialize variables
      
         // initialize index variables
         int rowIndex, colIndex;
         int boneIndex = 0;
         
         // initialize stick/bone flag
         boolean flag;
         
         // initialize the length
         int length = 0;
         
         // initialize the location
         int xPos = 0;
         int yPos = 0;
         
         // set the capacity value to be big enough for all chars 
         int capacity = (int)( STICK_BONE_PERCENTAGE * ( fieldArrayWidth *
                                          fieldArrayHeight ) );
         
         // initialize the bone array
         boneArray = new ArtifactClass[ capacity ];
      
      // loop through rows and cols
         
         // loop through rows
         for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ ) 
         {
            
            // loop through columns
            for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
            {
               
               // set the flag state as the current location 
                  // method: isUsed()
               flag = fieldArray[ rowIndex ][ colIndex ].isUsed();
               
               // check if the flag is true
               if( flag )
               {
                  // save the starting location if the length is 0
                  if( length < 1 )
                  {
                     // set the x and y positions to the row/col index
                     xPos = colIndex;
                     yPos = rowIndex;
                  }
                  
                  // increase the length
                  length++;
               }
               
               // otherwise, check if it was a bone and append to the list
               // or just end the flag and reset the length
               else 
               {
                  
                  // check for length greater than 1
                  if( length > 1 )
                  {
                     // Append the location to the bone array
                     boneArray[ boneIndex ] = new ArtifactClass( xPos,
                                 yPos, ArtifactClass.BONE, length );
                     
                     // increase the bone index
                     boneIndex++;
                  }
                  
                  // reset the length
                  length = 0;
                  
               }
               
            }
            
         }
         
         // set the numBones to the final index value
         numBones = boneIndex;
         
       }
    
    /**
     * Finds all sticks, assigns to sticks array, 
     * <p>
     * May find adjacent crossing bone and count as stick
     */
    public void findAllSticks()
       {
      
      // initialize variables
      
      // initialize index variables
      int rowIndex, colIndex;
      int stickIndex = 0;
      
      // initialize stick/bone flag
      boolean flag;
      
      // initialize the length
      int length = 0;
      
      // initialize the location
      int xPos = 0;
      int yPos = 0;
      
      // set the capacity value to be big enough for all chars 
      int capacity = (int)( STICK_BONE_PERCENTAGE * ( fieldArrayWidth *
                                       fieldArrayHeight ) );
      
      // initialize the bone array
      stickArray = new ArtifactClass[ capacity ];
   
   // loop through rows and cols
      
      // loop through columns
      for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
      {
      
         // loop through rows
         for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ ) 
         {
         
            // set the flag state as the current location 
               // method: isUsed()
            flag = fieldArray[ rowIndex ][ colIndex ].isUsed();
            
            // check if the flag is true
            if( flag )
            {
               // save the starting location if the length is 0
               if( length < 1 )
               {
                  // set the x and y positions to the row/col index
                  xPos = colIndex;
                  yPos = rowIndex;
               }
               
               // increase the length
               length++;
            }
            
            // otherwise, check if it was a bone and append to the list
            // or just end the flag and reset the length
            else 
            {
               
               // check for length greater than 1
               if( length > 1 )
               {
                  // Append the location to the bone array
                  stickArray[ stickIndex ] = new ArtifactClass( xPos,
                              yPos, ArtifactClass.STICK, length );
                  
                  // increase the bone index
                  stickIndex++;
               }
               
               // reset the length
               length = 0;
               
            }
            
         }
         
      }
      
      // set the numBones to the final index value
      numSticks = stickIndex;
      
       }

    /**
     * Generates random values between given low, high, inclusive
     * 
     * @param low integer value representing low end of random output
     * 
     * @param high integer value representing high end of random output
     * 
     * @return integer random value returned between low and high
     * parameters, inclusive
     */
    public int generateRandBetween( int low, int high )
       {
        int range = high - low + 1;
        
        return (int)( Math.random() * range ) + low;          
       }    

    /**
     * Shows field of sticks and bones, has frame around perimeter
     */
    public void showField()
       {
      
      // initialize variables
         
         // initialize index
         int rowIndex, colIndex;    
         int index;
         
         // initialize offset
         int offset = 1;
         
         // initialize the stickBone char
         char stickBoneChar;
         
      // print title for field
         
         // print field display
            // method: System.out.print()
         System.out.print( "Field Display:" );
         
         // print endline
            // method: System.out.println();
         System.out.println();
         
      // loop until the top outline is printed
         
         for( index = 0; index <= fieldArrayWidth + offset; index++ )
         { 
            // method: System.out.print
            System.out.print( HORIZ_LINE );
            
         }
         
         // print endline
            // method: System.out.println();
         System.out.println();
      
      // loop through each row and print a pipe 
         
         for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ )
         {
            // print the vertical line before each col
               // method: System.out.print
            System.out.print( VERTICAL_LINE );
            
            // loop through the columns and print the char at each location
            for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
            {
               // set the current char
               stickBoneChar = fieldArray[ rowIndex ][ colIndex ]
                                             .getCellCharacter();
               
               // print the char at the location
               System.out.print( stickBoneChar );
               
            }
            
            // print the vertical line after each column
               // method: System.out.print
            System.out.print( VERTICAL_LINE );
            
            // print endline
               // method: System.out.println();
            System.out.println();
            
         }
      
      // Loop until the bottom line is printed
         
         for( index = 0; index <= fieldArrayWidth + offset; index++ )
         { 
            // method: System.out.print
            System.out.print( HORIZ_LINE );
            
         }
         
         // print a line to add a gap before the counter
            // method; System.out.println();
         System.out.println();
         
       }
    
    /**
     * Shows bone list, provides results in formatted, aligned output
     * Hint: Google System.out.format
     *  
     */
    public void showBoneList()
       {
        
      // initialize variables
      
         // initialize index
         int index;
         
         // initialize bone array values
         int xLoc, yLoc, len;
         
      // Show the list
         
         // print a gap
            // method: System.out.println();
         System.out.println();
         
         // show the number of bones
            // method: System.out.format
         System.out.format( "Found %d bones", numBones );
         
         // print the endline
            // method: System.out.println();
         System.out.println();
         
      // loop through bone array
         for( index = 0; index < numBones; index++ )
         {
         
            // set the bone array values to the index location's value
            xLoc = boneArray[ index ].xPos;
            yLoc = boneArray[ index ].yPos;
            len = boneArray[ index ].length;
            
            // print the formated text with the corresponding values
               // method: System.out.format
            System.out.format( "Bone at ( %2d, %2d ), Length at: %2d", 
                                             xLoc, yLoc, len );
            
            // print a gap
               // method: System.out.println();
            System.out.println();
            
         }
         
         // print a gap
            // method: System.out.prinln()
         System.out.println();
      
       }

    /**
     * Shows list of sticks, provides results in formatted, aligned output
     * Hint: Google System.out.format 
     *    
     */
    public void showStickList()
       {

      // initialize variables
      
         // initialize index
         int index;
      
         // initialize bone array values
         int xLoc, yLoc, len;
      
      // show the list
         
         // show the number of sticks
            // method: System.out.format
         System.out.format( "Found %d sticks", numSticks );
      
         // print a gap
            // method: System.out.println();
         System.out.println();
         
         // loop through bone array
         for( index = 0; index < numSticks; index++ )
         {
      
            // set the bone array values to the index location's value
            xLoc = stickArray[ index ].xPos;
            yLoc = stickArray[ index ].yPos;
            len = stickArray[ index ].length;
      
            
         
            // print the formated text with the corresponding values
               // method: System.out.format
            System.out.format( "Stick at ( %2d, %2d ), Length at: %2d", 
                                          xLoc, yLoc, len );
            
            // print a gap
               // method: System.out.println();
            System.out.println();
         }
       }
    
   }