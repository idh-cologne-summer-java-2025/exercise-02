package idh.java;

public class Konto {

    int kontostand;
    int id;

    public Konto(int id, int status) {
	this.id = id;
	this.kontostand = status;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getBalance() {
	return kontostand;
    }

    public void setBalance(int status) {
	this.kontostand = status;
    }

    /**
     * Withdraws a sum of money from the account
     * 
     * @param sum
     */
    public void withdraw(int sum) {
	this.kontostand = kontostand - sum;
    }

}
