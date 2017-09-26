/**
 * 
 */
package assignment5_3;
import java.util.Scanner;

/**
 * Class with employee details and abstract methods for employee class
 *
 */

abstract class Employee {
	
	int empId; 																// Declaring employee id as instance variable
	String empName;															// Declaring employee name as Instance Variable
	int total_leaves;														// Declaring total leaves for a employee as Instance Variable
	double total_salary;													// Declaring total salary for an employee as Instance Variable
	
	/**
	 * Method the calculate and print leave balance of Employee
	 */
	abstract void calculate_balance_leaves();								// Abstract method to calculate leaves
	/**
	 * Avail leave based on the availability of the leaves for each Employee
	 * 
	 * @param no_of_leaves
	 * @param type_of_leave
	 * @return boolean
	 * 
	 */
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);		// Abstract method to avail leave, returns boolean
	/**
	 * 
	 * Calculate salary of the employee from basic, hra and pf
	 * 
	 * hra=basic/2;														
	 * pfa=0.12*basic;
	 * total_salary=basic+hra-pfa;
	 */
	abstract void calculate_salary();										// Abstract method to calculate salary of employee
		
}

/**
 * Permanent Employee class, that extends Employee class, and overrides its methods to calculate salary and leave details 
 *
 */
class PermanentEmp extends Employee {
	
	int paid_leave, sick_leave, casual_leave;								// Declaring various types of leaves as instance variables
	double basic, hra, pfa;													// Declaring salary components as instance variables
	int no_of_leaves;
	char type_of_leave;
	
	PermanentEmp() {														// Default constructor to print message and assign leave at instance of object
		
		System.out.println("Hello! Permanent Employee. You have following leaves alloted to you");	
		System.out.println("10 - Paid leaves");								// Print paid leaves
		System.out.println("9  - Sick leaves");								// Print sick leaves
		System.out.println("12 - Casual leaves");							// Print casual leaves
		
		paid_leave=10;														// Assigning value to variables paid leave
		sick_leave=9;														// Assigning value to variables sick leave
		casual_leave=12;													// Assigning value to variables causal leave  
		
	}
	
	/**
	 * Method to print leave details availed by Employee ( from avail_leave method )
	 */
	void print_leave_details() {
		
		if (type_of_leave=='C') { 											// If leave availed is causal leave
			System.out.println("You have successfully availed "+no_of_leaves+ " Casual leaves" ); // Print causal leave availed
		}
		else if (type_of_leave=='P') {										// If leave availed is Paid Leave
			System.out.println("You have successfully availed "+no_of_leaves+ " Paid leaves" );	// Print Paid leave availed
		}
		else if (type_of_leave=='S') {										// If leave availed is Sick Leave
			System.out.println("You have successfully availed "+no_of_leaves+ " Sick leaves" ); // Print Sick leave availed
		}	
		
	}
	/* 
	 * @see assignment5_3.Employee#calculate_balance_leaves()
	 */
	void calculate_balance_leaves() {
		
		total_leaves=paid_leave+sick_leave+casual_leave; 					// Adding all leaves to obtain total leaves
		
		System.out.println("You have "+sick_leave+" sick leaves");			// Printing number of remaining sick leaves
		System.out.println("You have "+casual_leave+" casual leaves");		// Printing number of remaining Casual Leaves
		System.out.println("You have "+paid_leave+" Paid leaves");			// Printing number of remaining Paid Leaves
		System.out.println("Your current leave balance is "+total_leaves );	// Printing total leaves
		
	} 
	/* 
	 * @see assignment5_3.Employee#avail_leave(int, char)
	 */
	boolean avail_leave(int no_of_leaves,char type_of_leave) {
		
		this.no_of_leaves=no_of_leaves;										// Assign value to no_of_leaves
		this.type_of_leave=type_of_leave;									// Assign value to type_of_leave
		
		if (type_of_leave=='C'&& casual_leave>=no_of_leaves  ) {			// If availing casual leave and leave is available
			casual_leave=casual_leave-no_of_leaves;							// Deduct leaves from available leaves
			print_leave_details();											// Print leave details
			return true; 													// return leave availed
		}
		else if (type_of_leave=='P'&& paid_leave>=no_of_leaves  ) {			// If availing casual leave and leave is available
			paid_leave=paid_leave-no_of_leaves;								// Deduct leaves from available leaves
			print_leave_details();											// Print leave details
			return true;													// return leave availed
		}
		else if (type_of_leave=='S'&& sick_leave>=no_of_leaves  ) {			// If availing casual leave and leave is available
			sick_leave=sick_leave-no_of_leaves;								// Deduct leaves from available leaves
			print_leave_details();											// Print leave details
			return true;													// return leave availed
		}
		else
			return false;													// return leave avail failed
		
	} 
	/* (non-Javadoc)
	 * @see assignment5_3.Employee#calculate_salary()
	 */
	void calculate_salary() {
		
		hra=basic/2;														// Calculating hra from basic
		pfa=0.12*basic;														// Calculating pfa from basic
		
		total_salary=basic+hra-pfa;											// Calculating total Salary
		
		System.out.println("Salary of the Employee is "+total_salary+" Rs");// Print total Salary
		
	}
}
/**
 * Temporary Employee class, that extends Employee class, and overrides its methods to calculate salary and leave details 
 *
 */
class TemporaryEmp extends Employee {
	
	int paid_leave, sick_leave, casual_leave;								// Declaring various types of leaves as instance variables
	double basic, hra, pfa;													// Declaring salary components as instance variables
	
	TemporaryEmp() {														// Default constructor to print message and assign leave at instance of object
			
		System.out.println("Hello! Temporary Employee. Your have following leaves alloted to you");	
		System.out.println("9 - Paid leaves");								// Print paid leaves
		System.out.println("9 - Sick leaves");								// Print sick leaves
		System.out.println("9 - Casual leaves");							// Print casual leaves
		
		paid_leave=9;
		sick_leave=9;
		casual_leave=9;
		
	}
	
	/* 
	 * @see assignment5_3.Employee#calculate_balance_leaves()
	 */
	void calculate_balance_leaves() {
		
		total_leaves=paid_leave+sick_leave+casual_leave; 					// Adding all leaves to obtain total leaves
		
		System.out.println("You have "+sick_leave+" sick leaves");			// Printing number of remaining sick leaves
		System.out.println("You have "+casual_leave+" casual leaves");		// Printing number of remaining Casual Leaves
		System.out.println("You have "+paid_leave+" Paid leaves");			// Printing number of remaining Paid Leaves
		System.out.println("Your current leave balance is "+total_leaves );	// Printing total leaves
		
		
	}
	
	/* 
	 * @see assignment5_3.Employee#calculate_salary()
	 */
	void calculate_salary() {
		
		hra=basic/2;														// Calculating hra from basic
		pfa=0.12*basic;														// Calculating pfa from basic
		
		total_salary=basic+hra-pfa;											// Calculating total Salary
		
		System.out.println("Salary of the Employee is "+total_salary+" Rs");// Print total Salary
		
	}
	
	/* 
	 * @see assignment5_3.Employee#avail_leave(int, char)
	 */
	boolean avail_leave(int no_of_leaves,char type_of_leave) {
		
		if (type_of_leave=='C'&& casual_leave>=no_of_leaves  ) {			// If availing casual leave and leave is available
			casual_leave=casual_leave-no_of_leaves;							// Deduct leaves from available leaves
			return true; 													// return leave availed
		}
		else if (type_of_leave=='P'&& paid_leave>=no_of_leaves  ) {			// If availing casual leave and leave is available
			paid_leave=paid_leave-no_of_leaves;								// Deduct leaves from available leaves
			return true;													// return leave availed
		}
		else if (type_of_leave=='S'&& sick_leave>=no_of_leaves  ) {			// If availing casual leave and leave is available
			sick_leave=sick_leave-no_of_leaves;								// Deduct leaves from available leaves
			return true;													// return leave availed
		}
		else
			return false;													// return leave avail failed
	}
	
}
/**
 * Class to calculate salary , Leave details of a Temporary or permanent employee
 *
 */
public class Assignment5_3 { 

	/**
	 * @param args
	 */
	public static void main(String[] args) {								// Main method starts
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);								// Creating object for Scanner
		System.out.println("Enter P for Permanent Employee (or) T for Temporary employee : "); // Asking for input to select Permanent or Temporary Employee
		String input=sc.nextLine();											// Taking input and Assigning to local variable

		if(input.equals("P")){ 												// If permanent employee
			
			PermanentEmp mEmp= new PermanentEmp();							// Create object for Permanent Employee
			System.out.println("Enter Employee Name :");					// Asking for input to enter Employee name
			mEmp.empName=sc.nextLine();										// Taking input and Assigning to Instance variable
			
			System.out.println("Enter Employee ID :");						// Asking for input to enter Employee ID
			mEmp.empId=sc.nextInt();										// Taking input and Assigning to Instance variable
			
			System.out.println("Enter Basic salary of employee :");			// Asking for input to Basic Salary
			mEmp.basic=sc.nextDouble();										// Taking input and Assigning to Instance variable
			int num;														// Declaring local variable to take decision on whether to avail leave or not
			
			mEmp.calculate_balance_leaves();								// Printing leave balance using calculate_balance_leaves method
			mEmp.calculate_salary();										// Printing Salary using calculate_salary method
			
			System.out.println("Do you want avail leave, Enter 1 for yes (or) Enter 0 for no "); // Taking input to whether employee want to avail leave or not
			num = sc.nextInt();												// Assigning to local variable
			
			while(num==1){													// Looping Until no more leaves needs to be applied
				
				System.out.println("Enter C to avail casual leave (or) Enter S to avail Sick leave (or) Enter P to avail Paid leave :"); // Asking for type of leave needs to applied
				char type_of_leave=sc.next().charAt(0);						// Taking input to local variable
				
				System.out.println("Enter the number of leave you want to avail :");	// Asking for number of leaves to avail
				int no_of_leaves=sc.nextInt();								// Taking input to local variable
				
				if (mEmp.avail_leave(no_of_leaves, type_of_leave))			// if avail method returns true , print leave applied
					System.out.println("Leave Approved");					// Print leave approved
				else {
					System.out.println("No leaves left to be availed, avail from below"); // Print no leaves left in selected category to apply
					mEmp.calculate_balance_leaves();  						// Print leave balance
					}
				
				System.out.println("Do you want to avail more leaves, Enter 1 for yes (or) Enter 0 for no " ); // Asking if user needs to apply more leaves
				if(sc.nextInt()==1)											// if Yes, continue with loop by giving num=1
					num=1;										
				else 
					num=0;													// else exit out of loop by giving 0
			}
			
			mEmp.calculate_balance_leaves();								// Print leave balance					
			}
		
		else if(input.equals("T")) {										// If Temporary Employee
			
			TemporaryEmp mEmp= new TemporaryEmp();							// Create object for Temporary Employee
			System.out.println("Enter Employee Name :");					// Asking for input to enter Employee name
			mEmp.empName=sc.nextLine();										// Taking input and Assigning to Instance variable
			
			System.out.println("Enter Employee ID :");						// Asking for input to enter Employee ID
			mEmp.empId=sc.nextInt();										// Taking input and Assigning to Instance variable
			
			System.out.println("Enter Basic salary of employee :");			// Asking for input to Basic Salary
			mEmp.basic=sc.nextDouble();										// Taking input and Assigning to Instance variable
			int num;														// Declaring local variable to take decision on whether to avail leave or not
			
			mEmp.calculate_balance_leaves();								// Printing leave balance using calculate_balance_leaves method
			mEmp.calculate_salary();										// Printing Salary using calculate_salary method
			
			System.out.println("Do you want avail leave, Enter 1 for yes (or) Enter 0 for no "); // Taking input to whether employee want to avail leave or not
			num = sc.nextInt();												// Assigning to local variable
			
			while(num==1){													// Looping Until no more leaves needs to be applied
				
				System.out.println("Enter C to avail casual leave (or) Enter S to avail Sick leave (or) Enter P to avail Paid leave :"); // Asking for type of leave needs to applied
				char type_of_leave=sc.next().charAt(0);						// Taking input to local variable
				
				System.out.println("Enter the number of leave you want to avail :");	// Asking for number of leaves to avail
				int no_of_leaves=sc.nextInt();								// Taking input to local variable
				
				if (mEmp.avail_leave(no_of_leaves, type_of_leave))			// if avail method returns true , print leave applied
					System.out.println("Leave Approved");					// Print leave approved
				else {
					System.out.println("No leaves left to be availed, avail from below"); // Print no leaves left in selected category to apply
					mEmp.calculate_balance_leaves();  						// Print leave balance
					}
				
				System.out.println("Do you want to avail more leaves, Enter 1 for yes (or) Enter 0 for no " ); // Asking if user needs to apply more leaves
				if(sc.nextInt()==1)											// if Yes, continue with loop by giving num=1
					num=1;										
				else 
					num=0;													// else exit out of loop by giving 0
			}
			
			mEmp.calculate_balance_leaves();								// Print leave balance				
			
			}

		
		sc.close();															// Close scanner object
		
	}

}
