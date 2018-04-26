import java.util.*;
public class BankAccount {
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int accountsCreated = 0;
	public static double totalBalance = 0;
	
	public BankAccount() {
		accountsCreated++;
		accountNumber = Integer.toString(this.accountNumber());
	}
	
	public int accountNumber() {
		Random rng = new Random ();
		return rng.nextInt(999999999);
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	public void deposit(String account, double amount) {
		if (account == "savings") {
			checkingBalance += amount;
		} else if (account == "checking") {
			savingsBalance += amount;
		}
		totalBalance += amount;
	}
	
	public void withdraw(String account, double amount) {
		if (account == "savings") {
			if (this.savingsBalance < amount) {
				System.out.println("NSF");
			}
			else {
				checkingBalance -= amount;
				totalBalance -= amount;
			}
		} else if (account == "checking") {
			if (this.savingsBalance < amount) {
				System.out.println("NSF");
			}
			else {
				savingsBalance -= amount;
				totalBalance -= amount;
			}
		}
	}


	public double getTotalBalance() {
		return totalBalance;
	}

	public static int totalNumberOfAccounts() {
		return accountsCreated;
	}
	
}
