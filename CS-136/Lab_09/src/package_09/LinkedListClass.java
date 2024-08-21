package package_09; 


public class LinkedListClass 
{ 

   Student head; // head of list 
  
  
   // Method to insert a new node 
   public LinkedListClass insert( LinkedListClass list, int id, String name ) 
      { 
         // Create a new node with id and name
         // make sure to set next = null
         Student newNode = new Student( id, name );
         newNode.next = null;
         
         // create the current node
         Student currentNode;

         // If the Linked List is empty, 
         // then make the new node as head 
         if( head == null )
            {
               // set the head to the new node
               head = newNode;
            }
         
         // Else traverse till the last node 
         // and insert the new_node there 
         else 
            {
               // set the current node to the head
               currentNode = head;
               
               // loop until the final node is null
               while( currentNode.next != null)
                  {
                     // set the new current node to the next pointed node
                     currentNode = currentNode.next;
                     
                  }
               
               // Insert the new_node at last node 
               currentNode.next = newNode;
               
            }
         
         // Return the list  
          return list;
      } 


   // Method to print the LinkedList. 
   public void printList(LinkedListClass list) 
      { 
         // create the current head pointer
         Student current = head;
         
         // print the title
            // method: print, println
         System.out.print( "LinkedList: ");
         System.out.println();
         
         // Traverse through the LinkedList 
         while( current != null )
            {
          
               // Print the name and id at the current node 
                  // method: print, println
               System.out.print( current.name + " " + current.id );
               System.out.println();
               
               // Go to next node 
               current = current.next;
                
            }
      } 




}