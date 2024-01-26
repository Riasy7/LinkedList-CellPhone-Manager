// Java Program
//
// -----------------------------------------------------
// Books Archive Classifier
// Written by Ahmad Saadawi
// Github: https://github.com/Riasy7
// repo: https://github.com/Riasy7/LinkedList-CellPhone-Manager
// -----------------------------------------------------
/**
 * This is the "driver" class or the CellListUtilization class. It contains the main method.
 * It tests the methods of the CellList class.
 */

package LinkedListProject;

import java.util.Scanner;
import java.io.*;

public class CellListUtilization  {
	
	/**
     * This is the main method. It tests the methods of the CellList class.
     * @param args
     */
	public static void main(String [] args) {
		
		// creation of CellList
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		CellList list3 = new CellList();
		
		try {
			Scanner sc = new Scanner(new FileInputStream("Cell_Info.txt")); // read from file
			
			while (sc.hasNextLine()) { // while there is a next line
				
                // read attributes and store them in variables
				long sn = sc.nextLong(); 
				String brand = sc.next();
				double price = sc.nextDouble();
				int year = sc.nextInt();
				
                // create CellPhone object with the attributes
				CellPhone c = new CellPhone(sn, brand, year, price);
                    
                // add CellPhone object to list if the serial number is not already in the list using the contains method
				if (!list1.contains(sn)) {
                    // add CellPhone object to the start of the list
				    list1.addToStart(c);
				}
			}
				
			list1.showContent();	// show the content of the list
				
				
		} catch (FileNotFoundException e) {
		
		}
		
		/*
        
        // Test addToStart
        CellPhone c1 = new CellPhone(123456, "Apple", 2020, 1000);
        list2.addToStart(c1);
        list2.showContent(); // Should show the Apple phone
        
        // Test insertAtIndex
        CellPhone c2 = new CellPhone(789012, "Samsung", 2021, 800);
        list2.insertAtIndex(c2, 0);
        list2.showContent(); // Should show the Samsung phone at the start
        
        // Test deleteFromIndex
        list2.deleteFromIndex(0);
        list2.showContent(); // Should show only the Apple phone
        
        // Test deleteFromStart
        list2.deleteFromStart();
        list2.showContent(); // Should show an empty list
        
        // Test replaceAtIndex
        list2.addToStart(c1);
        list2.replaceAtIndex(c2, 0);
        list2.showContent(); // Should show the Samsung phone
        
        // Test find
        System.out.println(list2.find(789012)); // Should find the Samsung phone
        
        // Test contains
        System.out.println(list2.contains(123456)); // Should return false
        
        // Test equals
        list3.addToStart(c2);
        System.out.println(list2.equals(list3)); // Should return true
        
        // Test copy constructor
        CellList list4 = new CellList(list2);
        list4.showContent(); // Should show the copied Samsung phone
		
		
		CellList list = new CellList();

        // Add 5 CellPhones to the list
        list.addToStart(new CellPhone(123456, "Samsung", 2020, 1000.0));
        list.addToStart(new CellPhone(234567, "Apple", 2021, 1200.0));
        list.addToStart(new CellPhone(345678, "Google", 2019, 800.0));
        list.addToStart(new CellPhone(456789, "OnePlus", 2020, 900.0));
        list.addToStart(new CellPhone(567890, "Huawei", 2018, 700.0));

        // Show the content of the list
        list.showContent();

        // Test insertAtIndex
        System.out.println("\nInserting a new CellPhone at index 2...");
        list.insertAtIndex(new CellPhone(678901, "Nokia", 2017, 600.0), 2);
        list.showContent();

        // Test deleteFromIndex
        System.out.println("\nDeleting the CellPhone at index 3...");
        list.deleteFromIndex(3);
        list.showContent();

        // Test deleteFromStart
        System.out.println("\nDeleting the first CellPhone...");
        list.deleteFromStart();
        list.showContent();

        // Test replaceAtIndex
        System.out.println("\nReplacing the CellPhone at index 1...");
        list.replaceAtIndex(new CellPhone(789012, "Sony", 2021, 1100.0), 1);
        list.showContent();

        // Test find
        System.out.println("\nFinding the CellPhone with serial number 234567...");
        System.out.println(list.find(234567));

        // Test contains
        System.out.println("\nChecking if the list contains a CellPhone with serial number 999999...");
        System.out.println(list.contains(999999) ? "Yes" : "No");

        // Test equals
        System.out.println("\nChecking if the list is equal to itself...");
        System.out.println(list.equals(list) ? "Yes" : "No");
        */
		
	}
}
