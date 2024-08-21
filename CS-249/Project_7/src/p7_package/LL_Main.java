package p7_package;

public class LL_Main
   {

      public static void main(String[] args)
         {

            LL_IteratorClass iterate = new LL_IteratorClass();
            LL_QueueClass queue = new LL_QueueClass();
            LL_StackClass stack = new LL_StackClass();
            
            System.out.println( "Iterator Class Output: ");
            System.out.println();
            
            iterate.insertAtFront( 39 );
            
            iterate.setToFirst();
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 50 );
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 89 );
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 12 );
         
            iterate.displayIterator();
            
            iterate.insertAtFront( 90 );
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 53 );
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 37 );
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 24 );
            
            iterate.displayIterator();
            
            iterate.insertAtFront( 43 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 29 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 82 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 84 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 37 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 62 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 26 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 78 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 65 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 86 );
            
            iterate.displayIterator();
            
            iterate.insertAtEnd( 55 );
            
            iterate.displayIterator();
            
            iterate.setToLast();
            
            iterate.displayIterator();

            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            iterate.movePrev();
            
            iterate.displayIterator();

            iterate.removeAtCurrent();
            
            iterate.displayIterator();
            
            while( iterate.hasNext() )
               {
                  iterate.moveNext();
               }
            
            iterate.displayIterator();

            iterate.removeAtCurrent();
            
            iterate.displayIterator();

            iterate.setToFirst();
            
            iterate.displayIterator();

            iterate.setToLast();
            
            iterate.displayIterator();
            
            iterate.clear();
            
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println( "QueueClass Output: " );
            System.out.println();

            System.out.println( "Queue Tests Conducted----------------" );
            System.out.println();

            System.out.format( "Value %d Enqueued.", 0 );
            queue.enqueue( 0 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Enqueued.", 3 );
            queue.enqueue( 3 );   
            System.out.println();
            System.out.println();         

            System.out.format( "Value %d Enqueued.", 6 );
            queue.enqueue( 6 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Enqueued.", 9 );
            queue.enqueue( 9 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d Enqueued.", 12 );
            queue.enqueue( 12 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d Enqueued.", 18 );
            queue.enqueue( 18 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d Enqueued.", 21 );
             queue.enqueue( 21 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Enqueued.", 24 );
            queue.enqueue( 24 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d Enqueued.", 27 );
            queue.enqueue( 27 );
            System.out.println();
            System.out.println();

            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();

            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();

            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d Dequeued.", queue.dequeue() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.println();
            System.out.println();
            System.out.println();

            queue.clear();
            
            System.out.format( "Front Value: %d", queue.peekFront() );
            System.out.println();
            System.out.println();
            
            System.out.println( "StackClass Output: " );
            System.out.println();

            System.out.println( "Queue Tests Conducted----------------" );
            System.out.println();

            System.out.format( "Value %d pushed.", 0 );
            stack.push( 0 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d pushed.", 5 );
            stack.push( 5 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d pushed.", 10 );
            stack.push( 10 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d pushed.", 15 );
            stack.push( 15 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d pushed.", 20 );
            stack.push( 20 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d pushed.", 25 );
            stack.push( 25 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d pushed.", 30 );
            stack.push( 30 );
            System.out.println();
            System.out.println();
           
            System.out.format( "Value %d pushed.", 35 );
            stack.push( 35 );
            System.out.println();
            System.out.println();
         
            System.out.format( "Value %d pushed.", 40 );
            stack.push( 40 );
            System.out.println();
            System.out.println();

            System.out.format( "Value %d pushed.", 45 );
            stack.push( 45 );
            System.out.println();
            System.out.println();
            
            System.out.format( "Top Value: %d", stack.peekTop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Top Value: %d", stack.peekTop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Top Value: %d", stack.peekTop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Value %d popped.", stack.pop() );
            System.out.println();
            System.out.println();
            
            System.out.format( "Top Value: %d", stack.peekTop() );
            System.out.println();
            System.out.println();
            
            stack.clear();
            
            System.out.format( "Top Value: %d", stack.peekTop() );
            System.out.println();
            System.out.println();
            
         }

   }
