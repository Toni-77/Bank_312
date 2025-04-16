# Bank 312 Application - README

Mission Statement: The scope of this project is to build a user-friendly, secure, and efficient bank Java application for small banks, logically enabling proactive banking.

Code of conduct: Be honest and transparent in all interactions with contributors. Treat all contributors with respect and honor. Take responsibility for your code and its impact. Work together with developers to form leaders and communities. Different opinions are actively encouraged to enhance the project.
Unacceptable Behaviors include:
Public or Private Harassment
Disruptive Behavior
Conduct that is deemed unprofessional in most professional settings.

This is a bank application implemented in Java. It simulates a basic banking system that allows employees to log in and manage customer accounts, including transaction processing, account management, and loan payments. Below is an overview of the different modules of the application.

# Please Note
In order to start the application you should go to Bank_312_Case_Study (which contains the main method) and run it. If you want to run the original forked application (ATM_case_Study) you should comment out the first line of code inside the main method and remove the comments from the next two lines of code.

This application is a work in progress. The project is open-source and modifiable by all who have access to the GitHub repository.

## Features

1. **Employee Login**:
    - Employees can log in using a username and password.
    - If login is successful, the main application window (`Bank_312_Main_GUI`) is shown, allowing the employee to interact with customer data.
    - Forgotten username/password can be reset through the `Bank_312_Password_Reset_GUI` window.

2. **Account Management**:
    - Employees can search for clients and create new client accounts.
    - Client account details include various account types such as Checking, Savings, and Loans.
    - The system allows employees to view the account balance, perform deposits, and withdrawals, and make loan payments on a customer’s behalf.

3. **Transaction History**:
    - Detailed transaction records are maintained for each account.
    - Employees can view past transactions of a specific account by clicking on the `Transaction History` button.
    - Note*transaction history currently does not save and is preset. Upon closure of the program, new clients added are lost.

4. **Account Types**:
    - Accounts supported include `Checking`, `Savings`, `Credit Card`, `Car Loan`, and `Mortgage`.

5. **Transaction Types**:
    - Supported transaction types include:
        - **Deposit**: Adding funds to Checking or Savings accounts.
        - **Withdraw**: Removing funds from Checking or Savings accounts.
        - **Payment**: Payments toward a loan.

6. **Database**:
    - Transactions are recorded in a `Bank_312_TransactionsDB`.
    - Employees and clients are stored in `Bank_312_EmployeesDB` and `Bank_312_ClientDB`.
    - Accounts and loans are stored in each Bank_312 client object.

---

## Structure of the Program

The project consists of the following main classes and modules:

- `Bank_312_Welcome_GUI`:
    - The welcome/login page for bank employees to access the system.
    - Verifies login credentials and navigates to the main application window.

- `Bank_312_Main_GUI`:
    - The left window side allows employees to search for clients by one of (first + last name, phone, social)
    - The right window side creates a new client (first + last name, phone, social, address, email)

- `Bank_312_ClientDB_GUI`:
    - Displays one or more findings from the client search form is used
    - Displays all the clients plus the recently added one after the client create form is used
    - After clicking on a table row the client and his relationship is displayed in the next JFrame

- `Bank_312_Transaction_GUI`:
    - Allows employees to manage client accounts by performing deposits, withdrawals, and payments.
    - Displays transaction history and provides an interface for managing customer accounts.
    - Enables employees to add additional bank products to the current client in next JFrame


- `Bank_312_Account_GUI`:
    - In this JFrame the employee could open an account/loan with an starting amount > 0

- `Bank_312_Client`:
    - Represents individual client information and account details.
    - Includes methods to manage account balances and transaction operations.

- `Bank_312_Account (abstract)`:
    - Represents individual accounts linked to clients (e.g., Checking, Savings).
    - Includes functionality to deposit, withdraw, and query account balances.
    - Checking and Savings classes extend this class to create their versions of withdraw methods and how the account numbers are assigned.

- `Bank_312_Loan (abstract)`:
    - Represents a loan account linked to a client (e.g., Car Loan, Mortgage).
    - Includes functionality to manage loan balances and payments.
- Credit Card, Car Loan and Mortgage classes extend this class to create their own versions of assigning loan numbers

- `Bank_312_TransactionsDB`:
    - Stores and manages a list of all transactions that have occurred in the bank.
    - Includes methods to add and retrieve transactions.

- `Bank_312_EmployeesDB`:
    - Stores employee credentials (username, password).
    - Provides methods for verifying employee login.

- `Bank_312_ClientDB`:
    - Stores client details and manages client accounts.
    - Provides methods for searching and creating new clients.

—

## *Testing*
Manual Testing:
All testing can be done by manually finding bugs when starting the program. Please notify the master branch owner of any bug findings.

## Automated Testing:
Automated testing is set up within the code of the program.
In the code directory, navigate to the /out/production/312-Bank path.
A folder named 312_Testing can be found.
All testing cases are modifiable to a contributor’s liking. The current tests implemented in the program test account types and transaction interactions.


## Requirements

- Java 8 or later
- Java Swing for the GUI components
- An IDE to run the program (IntelliJ/Eclipse)

---

## How to Run

1. Clone the repository to your local machine.
2. Open the project in your Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run the `Bank_312_Case_Study_GUI` class.
4. Use the employee credentials to log in. Employee credentials can be added in the Bank_312_EmployeesDB.
5. After successful login, interact with client data through the main interface.

## Making Modification

Any changes and modifications will be approved by the originators of the program. Please submit pull requests for any merging changes and they will be verified at the earliest convenience.

## Licensing

The program is currently not licensed under any license.

Additional suggested changes :
Deletion of accounts (more like disabling/freezing them)?
A table to show total deposit, withdrawals and deposits
Additional Bank products (Personal loan, HELOC etc)
Additional transactions on accounts and loans (Overdraft, cash advance etc)
Payment reminders for loans, and fees for late payments
Adding a pin for Clients
