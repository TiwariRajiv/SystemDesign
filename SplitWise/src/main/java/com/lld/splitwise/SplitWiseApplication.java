package com.lld.splitwise;

import com.lld.splitwise.entities.User;
import com.lld.splitwise.enums.ExpenseType;
import com.lld.splitwise.enums.Operations;
import com.lld.splitwise.services.BalanceSheetService;
import com.lld.splitwise.services.UserService;
import com.lld.splitwise.services.expense.ExpenseService;
import com.lld.splitwise.services.expense.factory.ExpenseServiceFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitWiseApplication {

  private final UserService userService = new UserService();
  private final BalanceSheetService balanceSheetService = new BalanceSheetService();

  public static void main(String[] args) {
    SplitWiseApplication splitWiseApplication = new SplitWiseApplication();
    splitWiseApplication.run(args);
  }

  public void run(String[] args) {
    System.out.println("Welcome to Split Wise");
    System.out.print("Enter count of users : ");
    Scanner sc = new Scanner(System.in);
    int userCount = sc.nextInt();
    for (int i = 1; i <= userCount; i++) {
      System.out.println("Enter details of user " + i);
      String userId = "u" + i;
//      System.out.print("Name : ");
//      String name = sc.next();
//      System.out.print("Email : ");
//      String email = sc.next();
//      System.out.print("Mobile Number : ");
//      String mobileNumber = sc.next();
      //userService.addUser(new User(userId, name, email, mobileNumber));
      userService.addUser(new User(userId, null, null, null));
    }

    boolean continueProcessing = true;
    sc.nextLine();
    while (continueProcessing) {
      String input = sc.nextLine();
      String[] userInput = input.split(" ");
      switch (Operations.valueOf(userInput[0])) {
        case SHOW:
          if (userInput.length == 2) {
            balanceSheetService.printUserBalanceSheet(userInput[1]);
          } else {
            balanceSheetService.printBalanceSheet();
          }
          break;
        case EXPENSE:
          String paidByUserId = userInput[1];
          float amount = Float.parseFloat(userInput[2]);
          int count = Integer.parseInt(userInput[3]);
          List<String> owedByUsers = new ArrayList<>();
          for (int i = 4; i < 4 + count; i++) {
            owedByUsers.add(userInput[i]);
          }
          String[] splitValues;
          if (5 + count == userInput.length) {
            splitValues = new String[0];
          } else {
            splitValues = Arrays.copyOfRange(userInput, 5 + count, userInput.length);
          }
          ExpenseService expenseService = ExpenseServiceFactory.getExpenseService(ExpenseType.valueOf(userInput[4 + count]));
          expenseService.splitExpense(paidByUserId, owedByUsers, amount, splitValues);
          break;
        case QUIT:
          continueProcessing = false;
          break;
        default:
          throw new RuntimeException("Invalid operation type");
      }
    }
  }
}
