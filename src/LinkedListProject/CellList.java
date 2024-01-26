// Java Program
//
// -----------------------------------------------------
// Books Archive Classifier
// Written by Ahmad Saadawi
// Github: https://github.com/Riasy7
// repo: https://github.com/Riasy7/LinkedList-CellPhone-Manager
// -----------------------------------------------------
/**
 * This class is a linked list of CellPhone objects. It has a head, which is a reference to the first node in the list, and a size, which is the number of nodes in the list.
 */

package LinkedListProject;

import java.util.NoSuchElementException;

public class CellList {

	/**
	 * This class is a node of the linked list. It has a CellPhone object and a reference to the next node.
	 * It implements Cloneable.
	 * Privacy leak suggestions:
	 * 1. Make the attributes private
	 * 2. Make the CellNode class private
	 * 3. Make CellPhone class and CellNode class immutable (no setters)
	 * 4. OR consider providing controlled access to attributes through methods that require validation and encapsulation.
	 */

	//start of inner class node
	private class CellNode implements Cloneable {
		
		// attributes
		private CellPhone cellphone;
		private CellNode next;
		
		/**
		 * Default constructor
		 * @param cellphone initializes cellphone to null
		 * @param next initializes next to null
		 */
		public CellNode() {
			cellphone = null;
			next = null;
		}
		/**
		 * Parameterized constructor
		 */
		public CellNode(CellPhone cell, CellNode p) {
			cellphone = new CellPhone(cell, cell.getSerialNum());
			next = p;	
		}
		/**
		 * Copy constructor
		 */
		public CellNode(CellNode cn) { // ask professor if i need deep copy of the "next" as well.
			cellphone = cn.cellphone.clone();
			next = cn.next;
		}
		
		/**
		 * @Override
		 * Clone method
		 * This method returns a deep copy of the CellNode object
		 * @return clonedNode
		 */
		public CellNode clone() {
			CellNode clonedNode;
			try {
				clonedNode = (CellNode)super.clone();
				
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
			clonedNode = new CellNode(this);
			return clonedNode;
			
		}

		// POTENTIAL PRIVACY LEAK: Consider removing or securing the getters and setters for the 'cellphone' and 'next' attributes.
		// removing CellNode setter and getter, and CellPhone would make the class immutable, hence increasing privacy
		// like said before we can also provide controlled access to attributes through methods that require validation and encapsulation.
		
		/**
		 * This method returns the cellphone object
		 * @return cellphone
		 */
		public CellPhone getCellPhone() { 
			return cellphone;
		}
		/**
		 * This method sets the cellphone object
		 * @param cell
		 */
		public void setCellPhone(CellPhone cell) {
			cellphone = cell;
		}
		/**
		 * This method returns the next node
		 * @return next
		 */
		public CellNode getCellNode() {
			return next;
		}
		/**
		 * This method sets the next node
		 * @param p
		 */
		public void setCellNode(CellNode p) {
			next = p;
		}
		
	} // end of inner class CellNode

		// attributes
		private CellNode head;
		private int size;
		
		/**
		 * Default constructor
		 * @param head initliazes head to null
		 * @param size initializes size to 0
		 */
		public CellList() {
			head = null;
			size = 0;
		}
		/**
		 * Copy constructor
		 * This method is a deep copy of the CellList object
		 * It has 2 cases: if the copied list is empty, then the head of the new list is set to null
		 * If the copied list is not empty, then the head of the new list is set to a new CellNode object, which is a deep copy of the head of the copied list
		 * The second case is done using a while loop that iterates through the copied list and copies each node one by one
		 * @param cl
		 */
		public CellList(CellList cl) {
			if (cl.head == null) { // this is a simple way of setting the head to null if the copied one is empty
				head = null;
			}
			else {
				head = null; // head is the beginning of the list
				CellNode temp1, temp2; // two temp variables
				temp1 = cl.head; // this one is to traverse through the list
				temp2 = null; // this one is to BUILD the new list
				
				while (temp1 != null) { // loop to check until we stop at null
					if (head == null) { // this line will only go thru ONCE
						temp2 = new CellNode(temp1.cellphone.clone(), null); // create first node in the list
						head = temp2; // set the head of the list we are creating to the first node
					}
					else { // this block is what will iterate after if block goes through
						temp2.next = new CellNode(temp1.cellphone.clone(), null);  // this is line where we keep copying each node 1 by 1 as we iterate
						temp2 = temp2.next; // this is where we iterate
					}
					temp1 = temp1.next; // this is where we iterate for the main while LOOP
				}
				
			}
			size = cl.size; // simply copy size since its an int
		}

		/**
		 * This method returns the size of the list
		 * @return size
		 */
		public void addToStart(CellPhone cell) {
			head = new CellNode(cell, head);
			size++;
		}

		/**
		 * This method adds a node to the end of the list
		 * @param cell
		 */
		public void insertAtIndex(CellPhone cell, int index) {
			if (index < 0 || index > size-1) {
				throw new NoSuchElementException("Index not between 0 and size-1");
			}
			if (index == 0){
				addToStart(cell);
				return;
			}
			CellNode temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			temp.next = new CellNode(cell, temp.next);
			size++;
		}

		/**
		 * This method adds a node to the end of the list
		 * @param cell
		 */
		public void deleteFromIndex(int index) {
			if (index < 0 || index > size-1) {
				throw new NoSuchElementException("Index not between 0 and size-1");
			}
			if (index == 0) {
				head = head.next;
			}
			else {
				CellNode temp = head;
		        for (int i = 0; i < index - 1; i++) {
		            temp = temp.next;
		        }
		        temp.next = temp.next.next;
		        
		    }
		    size--;
		}

		/**
		 * This method deletes a node from the start of the list
		 */
		public void deleteFromStart() {
			if (size == 0) {
				return;
			}
			if (size == 1) {
				head = null;
			}
			else {
				head = head.next;
			}
			size--;
		}

		/**
		 * This method replaces a node at a given index with a new node
		 */
		public void replaceAtIndex(CellPhone cell, int index) { 
			if (index < 0 || index > size-1) {
				return;
			}
			CellNode temp = head;
			for (int i = 0; i < index; i++) {
		            temp = temp.next;
			}
			temp.cellphone = cell;
		}

		/**
		 * This method checks if a node exists in the list
		 * @param cell
		 * @return the Node if it exists, null otherwise
		 */
		public CellNode find(long sn) {
			CellNode temp = head;
			int i = 0;
			while (temp != null) {
				if(temp.cellphone.getSerialNum() == sn) {
					System.out.println("Found after " + i + " iterations.");
					return temp;
				}
				temp = temp.next;
		        i++;
			}
			System.out.println("Not found after " + i + " iterations.");
		    return null;
		}
		/**
		 * This method checks if a node exists in the list
		 * @param cell
		 * @return true if it exists, false otherwise
		 */
		public boolean contains(long sn) {
			CellNode temp = head;
			while (temp != null) {
				if (temp.cellphone.getSerialNum() == sn) {
					return true;
				}
				temp = temp.next;
			}
			return false;
			
		}

        /**
		 * This method prints the contents of the list
		 */
		public void showContent() {
		    System.out.println("The current size of the list is " + size + ". Here are the contents of the list\n" +
		                       "===============================================================================");
		    CellNode temp = head;
		    for (int i = 0; i < size; i++) {
		        System.out.print("[" + temp.cellphone.getSerialNum() + ": " + temp.cellphone.getBrand() +
		                         " " + temp.cellphone.getPrice() + "$ " + temp.cellphone.getYear() + "] ---> ");
		        if (i == size-1) {
		            System.out.print("X");
		        }
		        if ((i + 1) % 3 == 0) {
		            System.out.println();
		        }
		        temp = temp.next;
		    }
		    System.out.println();
		}

		/**
		 * This method returns the size of the list
		 * @return size
		 */
		public boolean equals(CellList cl) {
			if (size != cl.size) {
				return false;
			}
			CellNode temp1 = head; // so here we make two temp variables each one is individually responsible of iterating through each of the lists being compared
			CellNode temp2 = cl.head;
			while (temp1 != null && temp2 != null) {
				if (!temp1.cellphone.equals(temp2.cellphone)) {
					return false;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			return true;
		}
				
}
