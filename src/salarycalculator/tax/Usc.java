package salarycalculator.tax;

public class Usc {

	private float[] UscPercentage = {0.005f, 0.02f, 0.045f, 0.08f};
	private float[] UscIncomeThresholds = {0, 12_012f, 22_920f, 70_044f};
	private float UscMinimumThreshold = 13000;
	
	private boolean qualifiesForUsc(float income) {
		if (income < this.UscMinimumThreshold) {
			return false;
		}
		return true;
	}
	
	public float uscDue(float income) {
		float USC = 0;
		if(!this.qualifiesForUsc(income)) {
			return USC;
		} else {
		
		for (int i = this.UscIncomeThresholds.length-1; i >= 0; i--) {
			if(income > this.UscIncomeThresholds[i]) {
				float taxableDifference = income - this.UscIncomeThresholds[i];
				USC += taxableDifference * this.UscPercentage[i];
				income = income - taxableDifference;
			}
		}
		
		
		return USC;
		}
	}
}
