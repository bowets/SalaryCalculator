package salarycalculator.tax;

public class Prsi {

	private float[] prsiPercentage;
	private float[] prsiIncomeThreshold;
	private float minimumPrsiThreshold;
	
	private boolean qualifiesForPrsi(float income) {
		if (income < this.minimumPrsiThreshold) {
			return false;
		}
		return true;
	}
	
	public float prsiDue(float income) {
		float PRSI = 0;
		if(!this.qualifiesForPrsi(income)) {
			return PRSI;
		} else {
		
		for (int i = this.prsiIncomeThreshold.length-1; i >= 0; i--) {
			if(income > this.prsiIncomeThreshold[i]) {
				float taxableDifference = income - this.prsiIncomeThreshold[i];
				PRSI += taxableDifference * this.prsiPercentage[i];
				income = income - taxableDifference;
			}
		}
		
		
		return PRSI;
		}
	}
	
}
