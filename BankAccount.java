import java.util.Scanner;
public class BankAccount {
	private Person[] holders = new Person[3];
	private int max;
	private double balance,interestrate,time;
	private Date opendate, lastdate;
	BankAccount(){
		holders[0] = new Person();
		holders[1] = new Person();
		holders[2] = new Person();
		balance =0.0;
		interestrate =0.0;
		time = 0.0;
		opendate=new Date();
		lastdate=new Date("05/10/2018");
	}
	BankAccount(Person P, Person P2, Person P3, double b, double i, Date od, Date ld,double t){
		holders[0]= P;
		holders[1]= P2;
		holders[2]= P3;
		balance =b;
		interestrate =i;
		opendate=od;
		lastdate=ld;
		time = t;
	}
	BankAccount(Person P, double b, double i, Date od, Date ld,double t){
		holders[0]=P;
		balance =b;
		interestrate =i;
		opendate=od;
		lastdate=ld;
		time = t;
	}
	BankAccount(Person P, Person P2, double b, double i, Date od, Date ld,double t){
		holders[0]=P;
		holders[2]=P2;	
		balance =b;
		interestrate =i;
		opendate=od;
		lastdate=ld;
		time = t;
	}
	double getbalance() {
		return balance;
	}
	double getinterest() {
		return interestrate;
	}
	String getopendate() {
		return opendate.toString();
	}
	String getlastdate() {
		return lastdate.toString();
	}
	double gettime() {
		return time;
	}
	String getLname() {
		return holders[0].getLName();
	}
	int getSSN() {
		return holders[0].getSSN();
	}
	void setbalance(double b) {
		balance=b;
	}
	void setinterest(double i) {
		interestrate=i;
	}
	void setopendate(String s) {
		opendate = new Date(s);
	}
	void setlastdate(String s) {
		lastdate = new Date(s);
	}
	void settime(double t) {
		time=t;
	}
	double interestcalculator() {
		double calc = (this.balance*this.time*this.interestrate)/100;
		return calc;
	}
	public void read(Scanner in) {	
		System.out.println("How many account holders do you want to create?(max. 3)");
		max = in.nextInt();
		in.nextLine();
		for(int i =0;i<max;i++) {
			holders[i].read(in);
		}
		System.out.println("Enter Opening Balance: ");
		this.setbalance(in.nextDouble());
		in.nextLine();
		System.out.println("Enter Opening Date (mm/dd/yyyy):");
		String d = in.nextLine();
		this.setopendate(d);
		System.out.println("Enter Interest Rate: ");
		this.setinterest(in.nextDouble());
		in.nextLine();
		System.out.println("Enter Last Date Interest was payed (mm/dd/yyyy):");
		String l = in.nextLine();
		this.setlastdate(d);
		System.out.println("Enter the time period: ");
		this.settime(in.nextDouble());
		in.nextLine();
	}
	public void modify(Scanner s, String l) {
		for (int i=0; i<holders.length;i++) {
			if (l.equalsIgnoreCase(holders[i].getLName())) {
				System.out.println("Enetr the new address: ");
				holders[i].setAddress(s.nextLine());
				System.out.println("Enter the new interest rate");
				this.setinterest(s.nextDouble());
				s.nextLine();
			}
		}
		if (max<3) {
			System.out.println("Do you want to add a holder? (max. 2)");
			int x = s.nextInt();
			s.nextLine();	
			for(int i =0;i<x;i++) {
				holders[i].read(s);
			}
		}
	}
	public String toString() {		
		String st ="Account Holders : \n";
		for (int i=0; i<max;i++) {
			st = st + holders[i].toString() +	"\n" ;
		}
		st = st +"Balance Amount: " + this.getbalance() +
				" Opening Date: " + this.getopendate() +" Last Date Interest Paid: "
				+ this.getlastdate() + " Interest: " + this.interestcalculator();
		return st;
	}

}


		