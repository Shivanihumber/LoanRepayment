/*
 * Loan class is about payment of monthly installment
 */
public class Loan {
	private double loanAmount;
	// amount which is taken on loan
	private double rate;
	// interest rate
	private double monthlyInstallment;
	/*
	 * every month installment //attribute of loan class are
	 * loanAmount,rate,monthlyInstallment // contractor of the class to set values
	 * of field from test class
	 */

	public Loan(double loanAmount, double rate, double monthlyInstallment) {
		this.loanAmount = loanAmount;
		this.rate = rate;
		this.monthlyInstallment = monthlyInstallment;
	}

	// getter method which takes loan amount
	public double getLoanAmount() {
		return this.loanAmount;
	}

	// getter method which takes rate
	public double getRate() {
		return this.rate;
	}

	// getter method for monthly installment
	public double getMonthlyInstallment() {
		return this.monthlyInstallment;
	}

	// setter method for setting loan amount
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	// setter method for setting rate
	public void setRate(double rate) {
		this.rate = rate;
	}

	// setter method for setting monthly installment
	public void setMonthlyInstallment(double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

	// printing table method which takes all values and format it and give
	// LoanRepaymentSchedul
	public void printLoanRepaymentSchedule() {
		// printing method prints header of the table with payment number,Balance before
		// payment, Amount Paid,
		// Interest paid, Principal repaid, Balance after payment, principal repaid,
		// Balance after payment */
		System.out.format("%15s|%25s|%20s|%20s|%20s|%25s|\n", "Payment Number", "Balance before payment", "Amount Paid",
				"Interest paid", "Principal repaid", "Balance after payment", "principal repaid",
				"Balance after payment");
		// counter for each iteration assigned by one
		int counter = 1;
		// loan amount value is assigned to balance before payment
		double balanceBeforePayment = loanAmount;
		// amount paid initial is initialized by zero
		double amountPaid = 0;
		// interest variable is initialized by zero
		double interest = 0;
		// variable balance after payment is initialized by zero
		double balanceAfterPayment = 0;
		// variable principalRepaid shows how much principal paid
		double principalRepaid = 0;
		// variable totalMonthlyInstallment is about monthly total Installment
		// initialized by zero
		double totalMonthlyInstallment = 0;
		// variable totalInterest is initialized by zero is for total Interest
		double totalInterest = 0;
		// totalPrincipalRepaid variable is about how much monthly Principal is Repaying
		double totalPrincipalRepaid = 0;
		// monthlyPayment is for monthly payment is initialized by zero
		double monthlyPayment = 0;
		/*
		 * while loop till balance before Payment is greater then zero it calculates
		 * interest which is equal to balanceBeforePayment and rate multiplication
		 * balanceAfterPayment is equal to balance Before Payment take away monthly
		 * Payment plus interest
		 */ // if balanceBeforePayment is less then monthlyInstallment then assign
			// monthlyPayment with addition of balanceBeforePayment plus interest
		while ((int) balanceBeforePayment > 0) {
			interest = balanceBeforePayment * rate / 1200;
			monthlyPayment = monthlyInstallment;
			balanceAfterPayment = balanceBeforePayment - monthlyPayment + interest;
			principalRepaid = monthlyPayment - interest;
			if (balanceBeforePayment < monthlyInstallment) {
				monthlyPayment = balanceBeforePayment + interest;
				balanceAfterPayment = 0;
				principalRepaid = balanceBeforePayment;
			}
			/*
			 * after while loop taking all the value and prints table in format way with
			 * counter, balanceBeforePayment, monthlyPayment, interest,
			 * principalRepaid,balanceAfterPayment counter should go till
			 * balanceBeforePayment is equal to balanceAfterPayment
			 */

			System.out.format("%15d|%25.2f|%20.2f|%20.2f|%20.2f|%25.2f|\n", counter, balanceBeforePayment,
					monthlyPayment, interest, principalRepaid, balanceAfterPayment);
			// assigning the value balanceAfterPayment to balanceBeforePayment
			balanceBeforePayment = balanceAfterPayment;
			// counter for each iteration
			counter++;
			// totalMonthlyInstallment =totalMonthlyInstallment+ monthlyPayment
			totalMonthlyInstallment += monthlyPayment;
			// totalInterest =totalInterest+ interest;
			totalInterest += interest;
			// totalPrincipalRepaid =totalPrincipalRepaid+ principalRepaid;
			totalPrincipalRepaid += principalRepaid;
		}
		// printing table with
		// totalMonthlyInstallment,totalInterest,totalPrincipalRepaid
		System.out.format("%s%36s%20.2f|%20.2f|%20.2f|", "Totals", "", totalMonthlyInstallment, totalInterest,
				totalPrincipalRepaid);
	}

}
