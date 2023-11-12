package salarycalculator.tax;

public class Prsi {

	private float prsiPercentage = 0.04f;
	private float prsiIncomeThreshold = 352f;
	private float prsiReducedRateThreshold = 424f;
	private float prsiReducedRateCredit = 12f;

	private float calcWeeklyIncome(float income) {
		return income / 52;
	}

	private int checkPrsiStatus(float weeklyIncome) {
		if (weeklyIncome <= prsiIncomeThreshold)
			return 0;
		if (weeklyIncome > prsiIncomeThreshold && weeklyIncome <= prsiReducedRateThreshold)
			return 1;
		return 2;
	}

	private float calcReducedPRSIContribution(float weeklyIncome) {
		float actualReducedCredit = prsiReducedRateCredit - ((weeklyIncome - prsiIncomeThreshold) / 6);
		float prsiDue = weeklyIncome * prsiPercentage;
		float adjustedPrsi = prsiDue - actualReducedCredit;

		return adjustedPrsi * 52;
	}

	private float calcPrsi(float weeklyIncome) {
		return (weeklyIncome * prsiPercentage) * 52;
	}

	public float calculatePrsi(float income) {
		float weeklyIncome = calcWeeklyIncome(income);
		float PRSI;
		switch (checkPrsiStatus(weeklyIncome)) {
			case 1 -> PRSI = calcReducedPRSIContribution(weeklyIncome);
			case 2 -> PRSI = calcPrsi(weeklyIncome);
			default -> PRSI = 0;
		}
		return PRSI;

	}
}
