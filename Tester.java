import java.util.*;
public class Tester {
	public static void main(String[] args) {
		boolean check = true;
		Vector<BankAccount> list = new Vector<BankAccount>();
		while(check)
		{
		System.out.println("Choose an option:");
		System.out.println("1. Create Account");
		System.out.println("2. Modify Account");
		System.out.println("3. Retrieve(Display) Account");
		System.out.println("4. Delete Account");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		s.nextLine();
		boolean bool = false;
		while(!bool){
			if(input < 1 || input > 4){
				System.out.println("Please select valid option.");
				input = s.nextInt();
				}
			else{
				bool = true;	
			}
		}
		if(input == 1){
			BankAccount account1 = new BankAccount();
			account1.read(s);
			list.add(account1);
			System.out.println("Account Created...... \n " + account1.toString());
		}else if(input == 2){
			int a = -1;
			System.out.println("Which one do you want to enter? 1. Last Name 2. SSN");
			int x= s.nextInt();
			s.nextLine();
			if(x == 1){
				System.out.println("Enter a last name");    
				String xy = s.nextLine();
				for(int i=0; i< list.size(); i++){
					if(list.get(i).getLname().equals(xy)){
						a = i;
					}
				}
			}
			else if(x==2) {
				System.out.println("Enter SSN");     
				int y = s.nextInt();
				s.nextLine();
				for(int i=0; i< list.size(); i++){
					if(list.get(i).getSSN() == y){
						a = i;
				}
				}
			}
			if(a < 0){
				System.out.println("Not found");
			}else
			{
				System.out.println("Modifying the account....");
				BankAccount b = list.get(a);
				b.modify(s,b.getLname());
				list.add(b);
			}
			}else if(input == 3){
				int a = -1;
				System.out.println("Which one do you want to enter? 1. Last Name 2. SSN");
				int x= s.nextInt();
				s.nextLine();
				if(x == 1){
					System.out.println("Enter a last name");  
					String xy = s.nextLine();
					for(int i=0; i< list.size(); i++){
						if(list.get(i).getLname().equals(xy)){
							a = i;
						}
					}
				}
				else if(x==2) {
					System.out.println("Enter SSN");      
					int y = s.nextInt();
					for(int i=0; i< list.size(); i++){
						if(list.get(i).getSSN() == y){
							a = i;
					}
					}
				}
				if(a < 0){
					System.out.println("Not found");
				}else
				{
					BankAccount b = list.get(a);
					System.out.println(b.toString());
			}
		}
		else if(input == 4)	{
			int a = -1;
			System.out.println("Which one do you want to enter? 1. Last Name 2. SSN");
			int x= s.nextInt();
			//s.nextLine();
			if(x == 1){
				System.out.println("Enter a last name");    
				String xy = s.nextLine();
				for(int i=0; i< list.size(); i++){
				if(list.get(i).getLname().equals(xy)){
					a = i;
				}
				}
				}
			else if(x==2) {
				System.out.println("Enter SSN");     
				int y = s.nextInt();
				for(int i=0; i< list.size(); i++){
					if(list.get(i).getSSN() == y){
						a = i;
				}
				}
			}
			if(a < 0){
				System.out.println("Not found");
			}else
			{
				BankAccount b = list.get(a);
				list.remove(b);
		}
		}else if(input==5) {
		check=false;
		}
		System.out.println();
		System.out.println("Do you want to continue? (Y/N)");
		String x =s.nextLine();
		if (x.charAt(0) == 'Y' || x.charAt(0) == 'y') {
			System.out.println();
			check=true;
		}else {
			System.out.println("Thank you for banking with us");
			check=false;
		}
		}
		
	}
}