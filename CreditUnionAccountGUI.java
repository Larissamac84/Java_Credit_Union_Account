/* Assignment number 01 - Software Development + Testing - Java - CreditUnionAccountGUI
   Date: 28/04/2023 | Name: Larissa | ID: L00177520 | Lecturer: Clare Assignment01

Sources:
   1-  https://docs.oracle.com/javase/tutorial/uiswing/components/textarea.html
   2-  https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets.html
   3-  https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setPrefSize-double-double-
   3-  https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html
   4-  https://jenkov.com/tutorials/javafx/index.html
   5-  https://www.baeldung.com/java-tutorial
   6-  https://www.geeksforgeeks.org/java/
   7-  https://openjfx.io/javadoc/16/javafx.graphics/javafx/scene/paint/Color.html
   8-  https://www.colorhexa.com/color-names
   9-  https://docs.oracle.com/javase/8/docs/api/java/awt/event/WindowEvent.html
   10- https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
   11- https://www.programcreek.com/java-api-examples/?class=javafx.scene.control.Label&method=setStyle

Methods:
   public void start(Stage stage)
   public void openAccount() 
   public void viewAllAccounts()
   public void exitSystem()  
   public void findAccount() 
   public void closeAccount()
   public void applyForLoan() 
   public void payOffLoanF1()  
   public void viewShareBalanceF3() 
   public void viewLoanBalanceF2() 
*/

import javafx.application.Application; //- imports the Application class from the javafx.application package
import javafx.geometry.Pos; // used to specify the position 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.control.ScrollPane; //provides a scrollable view of UI controls.
import javafx.scene.control.ScrollPane.ScrollBarPolicy; //used to specify the scroll bar policy for a ScrollPane.
import javafx.geometry.Insets; //used to specify the padding around a UI control.
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class CreditUnionAccountGUI extends Application 
   {//open class CreditUnionAccountGUI

      //Create ArrayList for CreditUnionAccoun objects
      ArrayList <CreditUnionAccount> creditList = new ArrayList<>();
   
      // Declare instance variables for GUI elements
       
      //text search 
      TextField txtcustomerName; // TextField allows users to input text into an application or form.
      TextField txtopeningBalance;
      TextField txtaccountNumber;
      TextField txtloanAmount;
      TextField txtloanDuration;
      
      //Buttons 
      Button btnopenAccount;
      Button btnviewAllAccounts;
      Button btnexitSystem;
      Button btnfindAccount;
      Button btncloseAccount;
      Button btnapplyForLoan;
      Button btnpayOffLoanF1; // Function1
      Button btnviewLoanBalancef2; // Function2
      Button btnviewShareBalanceF3; // Function2
       
      TextArea txtOutput1; //allows users to input or display multiple lines of text in an application or form. 
      TextArea txtOutput2; //large white text box

// -------- Open start Method --------//
   
      public void start(Stage stage) //open start method
      {// open start method
      
         //Create Labels for buttons
         Label lblcustomerName = new Label ("Customer Name:");
         Label lblOpeningBalance = new Label ("Opening  Balance:");
         Label lblEnterAccount = new Label ("Account Number:");
         Label lblAmountLoan = new Label   ("Amount of Loan: ");
         Label lblLoanDuration = new Label (" Loan Duration: ");
         
         //Create all TextFields
         txtcustomerName = new TextField();
         txtcustomerName.setMaxWidth(700);
         txtopeningBalance = new TextField();
         txtopeningBalance.setMaxWidth(700);
         txtaccountNumber = new TextField();
         txtaccountNumber.setMaxWidth(200);
         txtloanAmount = new TextField();
         txtloanAmount.setMaxWidth(200);
         txtloanDuration = new TextField();
         txtloanDuration.setMaxWidth(100);
         
         //Create Buttons
         btnopenAccount = new Button ("Open Account");
         btnopenAccount.setOnAction(e -> openAccount ()); //takes a single parameter e and calls the openAccount() method when the button is clicked.
         btnviewAllAccounts = new Button ("View all Accounts");
         btnviewAllAccounts.setOnAction(e -> viewAllAccounts ());
         btnexitSystem = new Button ("Exit System");
         btnexitSystem.setOnAction(e -> exitSystem ());
         btnfindAccount = new Button ("Find Account");
         btnfindAccount.setOnAction(e -> findAccount ());
         btncloseAccount = new Button ("Close Account");
         btncloseAccount.setOnAction(e -> closeAccount ());
         btnapplyForLoan = new Button ("Apply for Loan");
         btnapplyForLoan.setOnAction(e -> applyForLoan ());
         btnpayOffLoanF1 = new Button ("Pay off Loan");
         btnpayOffLoanF1.setOnAction(e -> payOffLoanF1 ());
         btnviewLoanBalancef2 = new Button ("View All Amount of Loan");
         btnviewLoanBalancef2.setOnAction(e -> viewLoanBalanceF2 ());
         btnviewShareBalanceF3 = new Button ("View All Amount of Balance");
         btnviewShareBalanceF3.setOnAction(e -> viewShareBalanceF3 ());
         
         Button btnclearButton = new Button("Clear");  // create a clear button. When the button is clicked, the event handler clears several text fields
         btnclearButton.setOnAction(e -> {             // set an event handler for the button
         txtOutput1.clear();
         txtcustomerName.clear();
         txtopeningBalance.clear();
         txtaccountNumber.clear();
         txtloanAmount.clear();
         txtloanDuration.clear();
         txtOutput2.clear();
});
   
         //Create TextArea for txtOutput1 with vertical ScrollPane
         txtOutput1 = new TextArea();
         txtOutput1.setEditable(false);
         ScrollPane scrollPane1 = new ScrollPane(txtOutput1);
         scrollPane1.setPrefViewportHeight(100); 
         scrollPane1.setFitToWidth(true);
         scrollPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
         
         //Create TextArea for txtOutput2 with vertical ScrollPane
         txtOutput2 = new TextArea();
         txtOutput2.setEditable(false); //meaning the user cannot modify its contents.read-only.
         ScrollPane scrollPane2 = new ScrollPane(txtOutput2); //provides a scrollable view of a node that is larger than the visible area.
         scrollPane2.setPrefViewportHeight(100); //  the top 100 pixels of the text area will be visible within the scroll pane.
         scrollPane2.setFitToWidth(true); //Make the ScrollPane's width adjust to the available space
         scrollPane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); //Set the vertical scroll bar policy to "ALWAYS"

         //Style - set all buttons sizes
         btnopenAccount.setPrefSize(100, 20);
         btnviewAllAccounts.setPrefSize(180, 20);
         btnexitSystem.setPrefSize(100, 20);
         btnfindAccount.setPrefSize(100, 20);
         btncloseAccount.setPrefSize(100, 20);
         btnapplyForLoan.setPrefSize(100, 20);
         btnpayOffLoanF1.setPrefSize(100, 20);
         btnviewLoanBalancef2.setPrefSize(180, 20);
         btnviewShareBalanceF3.setPrefSize(180, 20);
         btnclearButton.setPrefSize(100, 20);

         //Style - Prompt message for TextFields
         //The code sets prompts for text fields and clears them when the user focuses on the field, improving the user experience by providing guidance 
         txtcustomerName.setPromptText("e.g. Maria");
         txtcustomerName.focusedProperty().addListener((obs, oldVal, newVal) -> { if (newVal) txtcustomerName.setText(""); });

         txtopeningBalance.setPromptText("e.g. 100.00");
         txtopeningBalance.focusedProperty().addListener((obs, oldVal, newVal) -> { if (newVal) txtopeningBalance.setText(""); });
         
         txtaccountNumber.setPromptText("e.g. 101");
         txtaccountNumber.focusedProperty().addListener((obs, oldVal, newVal) -> { if (newVal) txtaccountNumber.setText(""); });

         txtloanAmount.setPromptText("e.g. 100.00");
         txtloanAmount.focusedProperty().addListener((obs, oldVal, newVal) -> { if (newVal) txtloanAmount.setText(""); });

         txtloanDuration.setPromptText("Months e.g.12");
         txtloanDuration.focusedProperty().addListener((obs, oldVal, newVal) -> { if (newVal) txtloanDuration.setText(""); });
         
         //Style -  of buttons
         btnopenAccount.setStyle("-fx-text-fill: white; -fx-background-color: #614051; -fx-font-weight: bold;");
         btnexitSystem.setStyle("-fx-text-fill: white; -fx-background-color: #483c32; " );
         btnclearButton.setStyle("-fx-text-fill: white; -fx-background-color: #177245; ");
         
         btnviewAllAccounts.setStyle("-fx-text-fill: black; -fx-background-color: #e9967a; ");
         btnfindAccount.setStyle("-fx-text-fill: black; -fx-background-color: #e9967a; ");
         btncloseAccount.setStyle( "-fx-text-fill: black; -fx-background-color: #e9967a; ");
         btnapplyForLoan.setStyle("-fx-text-fill: black; -fx-background-color: #e9967a; " );
         btnpayOffLoanF1.setStyle( "-fx-text-fill: black; -fx-background-color: #e9967a; ");
         btnviewLoanBalancef2.setStyle("-fx-text-fill: black; -fx-background-color: #e9967a; " );
         btnviewShareBalanceF3.setStyle( "-fx-text-fill: black; -fx-background-color: #e9967a; ");

         //Create HBox and add all controls for input to it
         //Adding Labels and TextBoxes across the screen
         HBox line01 = new HBox(10); // create an HBox layout with spacing of 5 between nodes
         line01.setAlignment(Pos.CENTER);// set the alignment of the HBox to center
         line01.getChildren().addAll(lblcustomerName, txtcustomerName, lblOpeningBalance, txtopeningBalance);
         
         HBox line02 = new HBox(10);
         line02.setAlignment(Pos.CENTER);
         line02.getChildren().addAll(btnopenAccount);
         
         HBox reports = new HBox(10);
         reports.setAlignment(Pos.BASELINE_LEFT);
         Label title = new Label("Report Options");
         reports.getChildren().addAll(title, btnviewAllAccounts, btnviewShareBalanceF3, btnviewLoanBalancef2);
         
         HBox line03 = new HBox(10);
         line03.setAlignment(Pos.BASELINE_LEFT);
         line03.getChildren().addAll(lblEnterAccount, txtaccountNumber,btnfindAccount,btncloseAccount);
   
         HBox loanline = new HBox(10);
         loanline.setAlignment(Pos.BASELINE_LEFT);
         Label title1 = new Label("Loan Options");
         loanline.getChildren().addAll(title1);
         
         HBox line05 = new HBox(10);
         line05.setAlignment(Pos.BASELINE_LEFT);
         line05.getChildren().addAll(lblAmountLoan, txtloanAmount, lblLoanDuration, txtloanDuration);
         
         HBox loanbuttons = new HBox(10);
         loanbuttons.setAlignment(Pos.BASELINE_LEFT);
         loanbuttons.getChildren().addAll(btnapplyForLoan, btnpayOffLoanF1);

         HBox exitclearbuttons = new HBox(450);
         exitclearbuttons.setAlignment(Pos.CENTER);
         exitclearbuttons.getChildren().addAll(btnexitSystem, btnclearButton);
         
         VBox vbox = new VBox(exitclearbuttons);
         vbox.setMargin(exitclearbuttons, new Insets(20, 0, 0, 0));
         
         //TextArea 2 appears at 7th line - txtOutput2

         //Create VBox 
         VBox root = new VBox(10);
         root.getChildren().addAll( line01, line02, reports, scrollPane1, line03, loanline, line05, loanbuttons, scrollPane2, exitclearbuttons);
         root.setPadding(new Insets(10)); // Set padding for all nodes in the VBox

         //Create Scene and add VBox to scene
         Scene scene = new Scene(root, 700, 600);
         stage.setScene(scene);
         stage.setTitle("LYIT Credit Union");
         stage.show();

         // Set the icon of the window
         Image icon = new Image("icon.png");
         stage.getIcons().add(icon);
         
      }//close start method
   
// -------- End start Method --------//

// -------- 1- Start - openAccount Method --------//
      public void openAccount() 
      {// start openAccount()
         //clear the textArea
         txtOutput1.clear();
         txtOutput2.clear();
      
         try 
         {//try
         // Get input from the text fields
            String name = txtcustomerName.getText();
            String balanceText = txtopeningBalance.getText();
            
            if (name.isEmpty() || balanceText.isEmpty()) 
            {
               txtOutput1.setText("Error: Name and balance are required.");
               return;
            }

            //Validate the customer name input
            if (!name.matches("[a-zA-Z]+")) 
            {
               txtOutput1.setText("Error: Name can only contain letters.");
               return;
            }
         
            try 
            {
               double balance = Double.parseDouble(balanceText);
               if (balance < 0) {
               txtOutput1.setText("Error: Balance cannot be negative.");
               return;
            }
            creditList.add(new CreditUnionAccount(name, balance));
            txtOutput1.setText("Account opened for " + name);
            } 
            catch (NumberFormatException e) {
               txtOutput1.setText("Error: Invalid balance.");
            }
            
            // Clear the text fields
            txtcustomerName.setText("");
            txtopeningBalance.setText("");
            }
            catch (NumberFormatException e) 
            {
            // If a NumberFormatException occurs, display an error message in the text area
               txtOutput1.setText("Error: Invalid input");
            }
      }// close openAccount()
// -------- 1- End - openAccount Method --------//
      
// -------- 2- Start - viewAllAccounts Method --------//

      public void viewAllAccounts() 
      {//start viewAllAccounts() 
         txtOutput1.clear();
         txtOutput2.clear();
         txtcustomerName.clear();
         txtopeningBalance.clear();
         try 
         {
            if (creditList.isEmpty()) {
               txtOutput1.setText("There are no accounts.");
            } 
            else 
            {
               String output = "";
            for (CreditUnionAccount account : creditList) 
            {
            //output += is the same as <output = output +>
               output += "Acc Nr " + account.getAccountNumber() + " - "  + account.getcustName() + " - Opening Balance: $" + account.getShareBalance() + "\n";
            }
               txtOutput1.setText(output);
            }
         } 
          catch (Exception ex) {
             txtOutput1.setText("An error occurred while trying to view all accounts: " );
          }
      }//end viewAllAccounts() 

// -------- 2- End - viewAllAccounts Method --------//

// -------- 3- Start - exitSystem Method --------//

      public void exitSystem() 
      {
         Stage stage = (Stage) btnexitSystem.getScene().getWindow();//btnexitSystem is a Button object, getScene() obtains the Scene object the button is in, then getWindow() returns the Window object for the scene, cast to a Stage object. The stage is then closed with close().
         stage.close();
      }
      
// -------- 3- End - exitSystem Method --------//
   
// -------- 4- Start - findAccount Method --------//

      public void findAccount() 
      {//start findAccount() 

         //clear the textArea
         txtOutput2.clear();
         txtOutput1.clear();
         txtloanAmount.clear();
         txtloanDuration.clear();
         
         
         // Get the input account number
         String accountNumber = txtaccountNumber.getText();
         
         if (accountNumber.isEmpty()) 
         {
            txtOutput2.setText("Error: Account number is required.");
            return;
         }
       
         // Loop through the creditList ArrayList and search for the account
         boolean found = false;
         for (CreditUnionAccount account : creditList) 
         {
            if (String.valueOf(account.getAccountNumber()).equals(accountNumber)) 
            {
               // Account found, display account information in txtOutput1
               txtOutput2.appendText(account.toString() + "\n");
               found = true;
               break;
            }
         }
         // If account not found, display error message in txtOutput2
         if (!found) {
            txtOutput2.setText("Account not found");
         }
      }//end findAccount() 

// -------- 4- End - findAccount Method --------//

// -------- 5- Start - closeAccount Method --------//
    
      public void closeAccount() 
      {////start closeAccount()
         // Clear the textArea
         txtOutput1.clear();
         txtOutput2.clear();
          
         String accountNumber = txtaccountNumber.getText();
      
         if (accountNumber.isEmpty()) 
         {
            txtOutput2.setText("Error: Account number is required.");
            return;
         }
      
         boolean found = false;
   
         for (int i = 0; i < creditList.size(); i++) //loop to go through a list of credit union accounts
         {
            CreditUnionAccount account = creditList.get(i);
      
            if (Integer.toString(account.getAccountNumber()).equals(accountNumber)) // Checking if the account number matches the specified number
            {
               if (account.getShareBalance() > 0 && account.getLoanBalance() == 0) //// If the account has a non-zero share balance and zero loan balance, it is removed from the list.
               {
                  creditList.remove(i);
                  found = true;
                  txtOutput2.appendText("Account " + accountNumber + " has been closed.\n");
                  break;
               } 
               else if (account.getShareBalance() <= 0) //// If the account has a zero or negative share balance, an error message is displayed and the account is marked as found
               {
                  txtOutput2.setText("Error: Account has a zero or negative opening balance.");
                  found = true;
                  break;
               } 
               else //// If the account has a non-zero share balance and a non-zero loan balance, an error message is displayed and the account is marked as found
               {
                  txtOutput2.setText("Error: Account has an outstanding loan balance.");
                  found = true;
                  break;
               }
            }
         }
   
         if (!found) // if no account with the specified account number was found in the loop above, then the following code block is executed.
         {
            txtOutput2.appendText("Error: Account " + accountNumber + " not found.\n");
         }
      }//close closeAccount()


// -------- 5- Close - closeAccount Method --------//

// -------- 6- Start - applyForLoan Method --------//

      public void applyForLoan() 
      {//start applyForLoan() 
      
         // Clear the text area
         txtOutput1.clear();
         txtOutput2.clear();
      
         // Get the input values
         String accountNumberStr = txtaccountNumber.getText();
         String loanAmountStr = txtloanAmount.getText();
         String loanDurationStr = txtloanDuration.getText();
      
         // Check if any field is empty
         if (accountNumberStr.isEmpty() || loanAmountStr.isEmpty() || loanDurationStr.isEmpty()) 
         {
            txtOutput2.setText("Error: All fields are required. \nAccount Number, Loan Amount and Amount Duration.");
            return;
         }

         // Parse the input values
         int accountNumber = Integer.parseInt(accountNumberStr); //converts the accountNumberStr string into an integer value and stores it in the accountNumber variable.
         double loanAmount = Double.parseDouble(loanAmountStr); //converts the loanAmountStr string into a double-precision floating-point value and stores it in the loanAmount variable.
         int loanDuration = (int) Math.round(Double.parseDouble(loanDurationStr)); //Converting a string to a rounded integer

         if (loanAmount < 0 || loanDuration < 0 || loanDuration > 12)  //Checks if the loan amount or duration is negative, or if the loan duration exceeds 12.
         {
             txtOutput2.setText("Error: Loan amount and duration must be non-negative, and loan duration cannot be greater than 12 months.");
             return;
         }

         try 
         {
            // Find the account and apply for the loan
            for (CreditUnionAccount account : creditList) //loop is used to search the "creditList" ArrayList for an account with the specified account number. 
            {
               if (account.getAccountNumber() == accountNumber) // If found, and if the requested loan amount is less than or equal to the account's share balance, a loan is issued for the requested amount and duration.
               {
                  if (loanAmount > account.getShareBalance()) {
                     txtOutput2.setText("Error: Loan amount cannot be greater than account balance.");
                     return;
                  }
                  account.issueLoan(loanAmount, loanDuration);
                  txtOutput2.appendText("Loan applied successfully. \nDuration: " + loanDuration + " months \nAmount: $" + loanAmount + "\n");
                  return;
               }
            }
            // Account not found
            txtOutput2.appendText("Account not found.\n");
         } 
         catch (NumberFormatException e) 
         {
            // Invalid input
            txtOutput2.appendText("Please enter valid input.\n");
         }
      } //close applyForLoan() 
   
// -------- 6- End - applyForLoan Method --------//


// -------- 7- start - Function 1 Method --------//

      public void payOffLoanF1() 
      {//start payOffLoanF1
         // Clear the textArea
         txtOutput1.clear();
         txtOutput2.clear();
         
         try 
         {
            int accountNumber = Integer.parseInt(txtaccountNumber.getText());
            //double amount = Double.parseDouble(txtloanAmount.getText());
            //int duration = (int) Math.round(Double.parseDouble(txtloanDuration.getText()));

         
            for (CreditUnionAccount account : creditList) // Find the account and pay off the loan
            {
               if (account != null && account.getAccountNumber() == accountNumber) // Check if the account has enough share balance to pay off the loan
                  {
                  if (account.getShareBalance() >= account.getLoanBalance()) //Update the account's share balance and loan balance
                  {
                     double newShareBalance = account.getShareBalance() - account.getLoanBalance();
                     account.setShareBalance(newShareBalance);
                     account.setLoanBalance(0);
                     account.setLoanDuration(0);
                     txtOutput2.setText("The loan has been successfully fully repaid.");
                     txtloanAmount.clear();
                     txtloanDuration.clear();
                     return;
                  } 
                  else 
                  {
                     txtOutput2.setText("Error: Insufficient share balance to pay off loan."); // The account doesn't have enough share balance to pay off the loan
                  return;
                  }
               }
         }
         // Account not found in the creditList
         txtOutput2.setText("Error: Account not found."); 
         } 
         catch (NumberFormatException e) 
         {
            // Handle the exception
            txtOutput2.setText("Error: Please enter valid numbers for account number, loan amount, and loan duration.");
         }
    
      }//close payOffLoanF1
 
// -------- 7- End - Function 1 Method --------//

// -------- 8- start - Function 2 Method --------//

      public void viewShareBalanceF3() 
      {
         // Clear the textArea
         txtOutput1.clear();
         txtOutput2.clear();
         
         double shareBalance = 0;
         for (CreditUnionAccount account : creditList) 
         {
            shareBalance += account.viewShareBalance();
         }
            txtOutput1.setText("Total Share Balance: " + shareBalance);
      }

// -------- 8- end - Function 2 Method --------//

// -------- 9- start - Function 3 Method --------//

      public void viewLoanBalanceF2() 
      {
         // Clear the textArea
         txtOutput1.clear();
         txtOutput2.clear();
         
         
         double loanBalance = 0;
         for (CreditUnionAccount account : creditList) 
         {
            loanBalance += account.viewLoanBalance();
         }
         txtOutput1.setText("Total Loan Balance: " + loanBalance);
      }

// -------- 9- end - Function 3 Method --------//
   
}//close class CreditUnionAccountGUI
