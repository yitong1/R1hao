package ÖØ¹¹;
import java.util.*;
//¹Ë¿Í
public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public  Customer (String name) {
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	
	public String getName() {
		return _name;
	}
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental  each = (Rental) rentals.nextElement();
			
			thisAmount = each.getCharge();
			
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
			totalAmount += each.getCharge();
		}
		//add footer lines
		result += "Amount owned is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequewnt renter points";
		return result;
		}
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	private double getTotalFrequentRenterPoints() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
  private double amountFor(Rental aRental){
	return aRental.getCharge();
  }
}
