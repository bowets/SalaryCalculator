package salarycalculator.tax;

public class TaxCalculator {

	public static void main(String[] args) {
		float income = 16000;
		Usc tax = new Usc(); 
		Prsi prsi = new Prsi();
		float taxDue = tax.uscDue(income);
		System.out.println(taxDue);
		float prsiDue = prsi.calculatePrsi(income);
		System.out.println(prsiDue);
	}
	
}
