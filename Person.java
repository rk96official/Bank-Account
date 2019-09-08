//Design class Person to inherite from Date, because every person "is" a birth date
import java.util.Scanner;
public class Person extends Date {
	private String fName, lName, Address;
	private int ssn;
	//default constructor 
	public Person() {
		//we call the default constructor of Date
		super();
		//set all provate members to default values
		fName = "unknown";
		lName = "unknown";
		Address = "unknown";
		ssn = 0;
	}
	public Person (String dob, String fn, String ln, String addr, int s) {
		super(dob);
		fName = fn;
		lName = ln;
		Address = addr;
		ssn = s;
	}
	//getters
	public String getFName() {
		return fName;
	}
	public String getLName() {
		return lName;
	}
	public String getAddress() {
		return Address;
	}
	public int getSSN() {
		return ssn;
	}
	//setters
	public void setFName(String n) {
		fName = n;
	}
	public void setLName(String n) {
		this.lName = n;
	}
	public void setAddress(String a){
		Address = a;
	}
	public void setSSN(int n) {
		ssn = n;
	}
	public void setDOB(String s){
		this.setDate(s);
	}
	public void setDOB(int m, int d, int y){
		String date = m+"/"+d+"/"+y;
		this.setDate(date);
	}
	public String toString() {
		String st = "DoB: " + super.toString() + ", SSN: " + ssn + ", First Name: " 
				+ fName + ", Last Name: " + lName + " Address: "+ Address;	
		return st;
	}
	public void read(Scanner in) {
		System.out.println("Enter your birth day (mm/dd/yyyy):");
		String d = in.nextLine();
		this.setDate(d);
		System.out.println("enter SSN: " );
		this.setSSN(in.nextInt());
		this.setFName(in.nextLine());//the carriage return will be still inthe buffer 
		//nextLinen if invoked will read one character (carriage return) and return
		//we need to empty the buffer before reading a string, we read a line for nothing
		System.out.println("enter first name: " );
		this.setFName(in.nextLine());
		System.out.println("enter last name: " );
		this.setLName(in.nextLine());
		System.out.println("enter address: " );
		this.setAddress(in.nextLine());
	}
}