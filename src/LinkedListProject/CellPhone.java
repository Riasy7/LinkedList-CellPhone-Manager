// Java Program
//
// -----------------------------------------------------
// Books Archive Classifier
// Written by Ahmad Saadawi
// Github: https://github.com/Riasy7
// repo: https://github.com/Riasy7/LinkedList-CellPhone-Manager
// -----------------------------------------------------
/**
* This class is a CellPhone object. It has a serial number, brand, manufacturing year, and price.
* It implements Cloneable.
*/


package LinkedListProject;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CellPhone implements Cloneable {
	
	// Attributes
	private long serialNum; 
	private String brand;
	private int year;
	private double price;
	
	/**
	 * Default constructor
	 */
	public CellPhone() {
		
	}
	/**
	 * Parameterized constructor
	 * @param sn for unique serial number
	 * @param br for brand
	 * @param yr for manufacturing year
	 * @param pr for price
	 */
	public CellPhone(long sn, String br, int yr, double pr) {
		serialNum = sn;
		brand = br;
		year = yr;
		price = pr;
	}
	/**
	 * Copy constructor
	 * @param c
	 * @param sn for unique serial number
	 */
	public CellPhone(CellPhone c, long sn) {
		serialNum = sn;
		brand = c.brand;
		year = c.year;
		price = c.price;
	}
	
	/**
	 * Clone method
	 * It prompts user for a serial number and returns a cloned CellPhone with the same attributes as the original CellPhone, except for the serial number.
	 * @return cloned CellPhone
	 * @throws CloneNotSupportedException
	 * @throws InputMismatchException
	 */
	public CellPhone clone() {  
		try {
        CellPhone clonedC = (CellPhone) super.clone();
		Scanner sc = new Scanner(System.in);
		long sn;
			System.out.println("Please enter a valid serial number for your CellPhone: ");
			sn = sc.nextLong();
			clonedC.serialNum = sn;
			return clonedC;
		}catch (InputMismatchException e) {
			System.out.println("Invalid serial number, please use numbers.");
			return null;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
	/**
	 * This method returns a serial number
	 * @return serial number
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * This method sets a serial number
	 * @param sn
	 */
	public void setSerialNum(long sn) {
		serialNum = sn;
	}
	/**
	 * This method returns a brand
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * This method sets a brand
	 * @param br
	 */
	public void setBrand(String br) {
		brand = br;
	}
	/**
	 * This method returns a year
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * This method sets a year
	 * @param yr
	 */
	public void setYear(int yr) {
		year = yr;
	}
	/**
	 * This method returns a price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This method sets a price
	 * @param pr
	 */
	public void setPrice(long pr) {
		price = pr;
	}
	/**
	 * This method prints the attributes of a CellPhone
	 * @Override toString() from Object class
	 * @return String
	 */
	public String toString() {
		return "CellPhone Information: Serial Number: " + serialNum + ", Brand: " + brand 
				+ ", Manufacturing Year: " + year + ", Price: $" + price;
	}
	/**
	 * This method checks if two CellPhones are equal
	 * @Override equals() from Object class
	 * @param x
	 * @return boolean
	 */
	public boolean equals(Object x) {
		if (x.getClass() != this.getClass() || x == null) {
			return false;
		}
		else {
			CellPhone c = (CellPhone)x;
			return c.brand.equals(this.brand) && c.year == this.year && c.price == this.price;
		}
	}
	
	
	
}
