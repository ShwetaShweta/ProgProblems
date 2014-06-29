/*This class implements the synchronize method of Java for thread safety
 * Thread Synchronization can be done by two techniques which are Monitor and Semaphores
 * Semaphores can be further divided into counting,event,mutual exclusion semaphores
 * Some libraries in java are already thread safe like StringBuffer while others are not
 * like StringBuilder,they should be explicitly synchronized for preventing thread safety issues like
 * deadlock
 */
public class Account {
	int userNumber;
	double AccountNumber;
	String userLastName;
	String userFirstName;
	double userBalance;
	/*public synchronized boolean deposit(double amount) -This(Semaphore synchronization
	is same as synchronizing the code lines involving userBalance(also called monitor synchronization)*/
	public Account(int userBalance){
		this.userBalance = userBalance;
	}
	public boolean deposit(double amount){
		double newBalance;
		synchronized(this){
			if(amount < 0.0){
				return false;
			}
			else{
				newBalance = userBalance + amount;
				userBalance = newBalance;
				return true;
			}
		}

	}
	public boolean withdraw(double amount){
		double newBalance;
		synchronized(this){
			if(amount<0.0 || amount >userBalance){
				return false;
			}
			else{
				newBalance = userBalance - amount;
				userBalance = newBalance;
				return true;
			}
		}
	}
	public static void main(String[] args) {
        Account Sue = new Account(4000);
        Account John = Sue;
        System.out.println("Joint account balance of Sue and John is 4000$\nSue withrew 100$\n"
        		+ "Simultaneously John deposited 300$\nMeanwhile Sue withdrew 100$\nJohn also withdrew 100 dollars");
        Sue.withdraw(100);
        John.deposit(300);
        Sue.withdraw(100);
        John.withdraw(100);
        System.out.println("After processing:user balance is "+ Sue.userBalance);
	}
}
