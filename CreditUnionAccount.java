/*Assignment number 02 - Software Development - Java - CreditUnionAccount
Date: 27/02/2023 | Name: Larissa | ID: L00177520 | Lecturer: Clare Assignment02

Math.round: source:
1-https://www.javatpoint.com/java-math-round-method
2-https://www.w3schools.com/jsref/jsref_round.asp
3-https://stackoverflow.com/questions/70851644/round-off-numbers-and-math-round-method
4-https://intellipaat.com/community/35143/how-to-round-up-to-2-decimal-places-in-java
*/

public class CreditUnionAccount
{//Start - public class CreditUnionAccount

   //Instance variables (properties)
   private static int lastAccountNumber = 100; //a static variable to keep track of the last account number created
   private int accountNumber;
   private String custName;
   private double shareBalance = 50.0;
   private double loanBalance;
   private int loanDuration;
   
   //Contructor 1
   //The first constructor should deal with this and set remaining instance variables to their default values.
   //Ensure every customer gets an unique Account Number. Both of your constructors should deal with this. Every new customer will receive an opening Balance of €50.00.
   
   public CreditUnionAccount ()
   {//Start Constructor 01
      lastAccountNumber++; //increment the static variable to generate a unique account number for the new customer
      accountNumber = lastAccountNumber;
      custName = "";
      shareBalance  = 50.0;
      loanBalance  = 0.0;
   loanDuration = 0;
   }//End Constructor 01
   
    //Contructor 2
    //The second constructor should accept user input to set the Customer Name and the Balance.
    //The €50.00 opening balance also needs to be added to this. All remaining instance variables should be set to their default values.
    
   public CreditUnionAccount(String name, double balance) 
   {//Start Constructor 02
      lastAccountNumber++;
      accountNumber = lastAccountNumber; //increment the static variable to generate a unique account number for the new customer
      custName = name;
      shareBalance = balance + 50.0;
      loanBalance = 0.0;
      loanDuration = 0;   
   }//End Constructor 02
 

//Start Methods setters (Mutator Methods)
   public void setAccountNumber(int accNr) {
      accountNumber = accNr; //set the account number with the accNr parameter
   }  
   public void setcustName(String n) {
      custName = n; //set the customer name with the n parameter
   }  
   public void setShareBalance(double balance) {
      shareBalance = balance; // set the share balance with the balance parameter
   }  
   public void setLoanBalance(double loan) {
      loanBalance = loan; // set the loan balance with the loan parameter
   }  
   public void setLoanDuration(int lduration) {
      loanDuration = lduration; // set the loan duration with the lduration parameter
   }
//End Methods setters (Mutator Methods) 
   
//Start Methods getters (Accessor methods)
   public int getAccountNumber()    {  
      return accountNumber; // return the account number
   }
   public String getcustName()    {  
      return custName;
   }
   public double getShareBalance () {
      return shareBalance;
   }
   public double getLoanBalance () {
      return loanBalance;
   }
   public int getLoanDuration()    {  
      return loanDuration;
   }
//End Methods getters (Accessor methods)

// Other Methods

//Method nr 01    
   public String toString() 
   {//Method nr 01 - View all details of an CreditUnionAccount (toString)
      return "Account Number: " + accountNumber + "\nCustomer Name: " + custName + "\nShare Balance: " + shareBalance + "\nLoan Balance: " + loanBalance + "\nLoan Duration: " + loanDuration + " months";
   }
   
//Method nr 02   
   public int viewAccNoViewCName() 
   {//Method nr 02 - User can view Account Number and Customer Name
      System.out.println("Account Number: " + accountNumber);
      System.out.println("Customer Name: " + custName);
      return accountNumber;
   }  

//Method nr 03   
   public double viewShareBalance () 
   {//Method nr 03 - User can view Share Balance
      System.out.println("Share Balance: " + shareBalance);
      return shareBalance;
   }
   
//Method nr 04  
   public double viewLoanBalance () 
   {//Method nr 04 - User can view Loan Balance
      System.out.println("Loan Balance: " + loanBalance);
      return loanBalance;
   }
   
//Method nr 05   
   public double depositShare (double amount) //public void depositToShares(double amount)
   {//Method nr 05 - User can deposit to Shares
      shareBalance = shareBalance + amount;
      System.out.println("Share Balance: " + shareBalance);
      return shareBalance;
   }
   
//Method nr 06   
   public double withdrawShare (double amount)  // public void withdrawFromShares(double amount)
   // test1 amount=40; loanBalance=0; shareBalance=50. // output Share balance after withdrawal: 10.0
   // test2 amount=40; loanBalance=200; shareBalance=50 //output Insufficient share balance, outstanding loan of: 200.0 
   // test3 amount=80; loanBalance=100; shareBalance=50 //output Insufficient share balance, maximum withdrawal amount is -50.0
   {//Method nr 06 - User can withdraw from Shares
      double maxWithdrawal = shareBalance - loanBalance; 
      if (maxWithdrawal >= amount) 
      {
         shareBalance -= amount;
         System.out.println("Share balance after withdrawal: " +(shareBalance-loanBalance));
         return shareBalance;
      }
      else if (maxWithdrawal <= amount) 
      {
         if (loanBalance > 0) 
         {
            System.out.println("Insufficient share balance, outstanding loan of: " +loanBalance+ "\tThe Balance of the account is:" +maxWithdrawal);
         }
         else
         {
            System.out.println("Insufficient share balance, maximum withdrawal amount is " + maxWithdrawal);
            return 0.0;
         }
      }
      return 0.0;
   } 

//Method nr 07 
/*
   public double loanApply (double amount, int duration) //public void issueLoan(double value, int duration)
   //test1 - 1st loan - amount: 500;  duration: 18; Balance=0 // Output Loan amount exceeds limit. The allowed amount for a loan at the moment is: 150.0
   //test2 - 1st loan - amount: 200;  duration: 12; Balance=400 // Output Loan taken : 200.0	Duration in months: 12
   //test3 - 2nd loan - amount:  50;  duration: 12; - Balance: 450 //Output You cannot take another loan until the existing loan is fully paid off. The amount remained is: 200.0
   {//Method nr 07 - User can apply for a loan
   double maxAmountLoan = 3 * shareBalance; // maxAmountLoan is a local variable that will take de Balance and multiply it per 3 and that amount will be the allowed value to apply for a loan
      if (loanBalance > 0) // check if user already has a loan
      {
         System.out.println("You cannot take another loan until the existing loan is fully paid off. The amount remained is: "+loanBalance);
      }
      else if (amount <= maxAmountLoan && duration>=12) // condition that check if the amount required by the user is eligeble criteria of 3 times the value of the balance "shareBalance" AND duration minimum of 12 months
      {
         loanBalance = loanBalance + amount;
         loanDuration = duration;
         System.out.println("Loan taken : " + loanBalance+ "\tDuration in months: " +loanDuration);
         return loanBalance;
      }
      else 
      {
         System.out.println("Loan amount exceeds limit. The allowed amount for a loan at the moment is: "+maxAmountLoan);
         return 0.0;
      }
      return loanBalance;
   }    
   */ 
   
   public void issueLoan(double amount, int duration) 
   { 
      loanBalance = amount;
      loanDuration = duration;
   }
   
   
      
//Method nr 08
   public double payOffLoan (double amount)
   //test1 - amount = 100, loanBalance = 500, shareBalance = 200 // output: "Loan Balance : 400"
   //test2 - amount = 400, loanBalance = 500, shareBalance = 200 // output: "Loan Balance after payment : 100.0"
   //test3 - amount = 600, loanBalance = 500, shareBalance = 200 // output: "Loan balance cannot be overpaid, Please enter the amount : 500"
   {//Method nr 08 - User can Pay off Loan Balance
      if (amount == loanBalance )
      {
         loanBalance = loanBalance - amount;
         System.out.println("Loan Balance : " + loanBalance);
      }
      else if (amount <= loanBalance)
      {
         loanBalance = loanBalance - amount;
         System.out.println("Loan Balance after payment : " + loanBalance);
      }

      else
      {
         System.out.println("Loan balance cannot be overpaid, Plase enter the amount : "+loanBalance);
      }
         return loanBalance; // return the updated loan balance
   }
   
   //Method nr extra
   public double payOffLoanv2 (double amount )
   //test1 - amount = 100, loanBalance = 500, shareBalance = 200 // output: "Loan Balance : 400"
   //test2 - amount = 400, loanBalance = 500, shareBalance = 200 // output: "Loan Balance after payment : 100.0"
   //test3 - amount = 600, loanBalance = 500, shareBalance = 200 // output: "Loan balance cannot be overpaid, Please enter the amount : 500"
   {//Method nr 08 - User can Pay off Loan Balance
      if (amount == loanBalance )
      {
         loanBalance = loanBalance - amount;
         System.out.println("Loan Balance : " + loanBalance);
      }
      else if (amount <= loanBalance)
      {
         loanBalance = loanBalance - amount;
         System.out.println("Loan Balance after payment : " + loanBalance);
      }

      else
      {
         System.out.println("Loan balance cannot be overpaid, Plase enter the amount : "+loanBalance);
      }
         return loanBalance; // return the updated loan balance
   }

//Method nr 09      
   public double calcWeeklyLoan() 
   {//Method nr 09 - User can View Weekly Loan Repayment
      double numOfWeeks = ((loanDuration * 52) / 12.0); // convert months to weeks
      double weeklyRepayment = loanBalance / numOfWeeks;
      return Math.round(weeklyRepayment * 100.0) / 100.0;
   }
   
   /*  public double calcWeeklyLoan()
   {  
      if(loanBalance > 0)
      {
         return loanBalance / (loanDuration * 4.345);
      }
      else
      {
         return 0;
      }
   }
   */
   
//Method nr 10   
   public double calcMonthLoan() 
   {//Method nr 10 - User can View Monthly Loan Repayment
      double monthlyRepayment = loanBalance / loanDuration ;
      return Math.round(monthlyRepayment * 100.0) / 100.0;
   }
   
   /*
      //method to calculate monthly loan repayments
   public double calcMonthLoan()
   {
      if(loanBalance > 0)
      {
         return loanBalance / loanDuration;
      }
      else
      {
         return 0;
      }   
   }*/
   
   
   
}//End - public class CreditUnionAccount

   
