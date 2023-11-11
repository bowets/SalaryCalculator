package salarycalculator.tax;

public class TaxCalculator {

	public static void main(String[] args) {
		float income = 75000;
		Usc tax = new Usc(); 
		System.out.println(tax);
		float taxDue = tax.uscDue(income);
		System.out.println(taxDue);
	}
	
}
