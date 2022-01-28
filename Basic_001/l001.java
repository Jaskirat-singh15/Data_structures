import java.util.*; // this will include all the libraries of java to use pre defined functions

public class l001 {

  public static Scanner scn = new Scanner(System.in); // this lines helps to take input from user (decalred globally)

  // class name should be same as that of file name

  // this is function definition(where the code resides)
  public static void printZ() {
    System.out.println("*****");
    System.out.println("   *");
    System.out.println("  *");
    System.out.println(" *");
    System.out.println("*****");
  }

  public static void test() {
    int n = 12345;
    System.out.println(n);
  }

  public static void input() {
    System.out.println("please, enter a number");
    int n = scn.nextInt();
    System.out.println("number entered is " + n);
  }

  public static void gradingSystem(int marks) {
    //    System.out.println("enter marks of the student");
    //   int marks = scn.nextInt();
    if (marks > 90) {
      System.out.println("Excellent");
    } else if (marks > 80 && marks <= 90) {
      System.out.println("good");
    } else if (marks > 70 && marks <= 80) {
      System.out.println("fair");
    } else if (marks > 60 && marks <= 70) {
      System.out.println("meets expectations");
    } else if (marks <= 60) {
      System.out.println("below par");
    }
  }

  public static void oddEven(int num) {
    if (num % 2 == 0) {
      System.out.println("even");
    } else if (num % 2 != 0) {
      System.out.println("Odd");
    }
  }

  public static void printTable(int num){
      for(int i=1 ; i<=10; i++){
          System.out.println(num+ "*" + i + "="+ num*i);
      }
  }

  // this is done using nested for loop 
// this makes the code difficult to red and understand
//see the nest block of code 
  public static void printMultipleTables(int num){
      for(int i=1 ; i<=num ; i++){
          for(int j=1 ; j<=10 ; j++){
              System.out.println(i + " * " + j + " = " + i*j);
          }
          System.out.println();

      }
  }

// this is more industry suitable code bacuse it is more readable and divided into functions
  public static void printAllTables(int num){
      for(int i=1 ; i<=num ; i++){
          printTable(i);
          System.out.println();
      }
  }

  public static void OddEvenMultiple() {
    int count;
    System.out.println("entre the number of inputs");
    count = scn.nextInt();
    for (int i = 0; i < count; i++) {
      int num = scn.nextInt();
      if (num % 2 == 0) {
        System.out.println("Even");
      }
       else {
        System.out.println("Odd");
      }
    }
  }

  public static void main(String[] args) { // execution of the program starts from here (the main function)
    System.out.println("hello, class"); // hard code because the output doesnot depend upon the input

    // printZ(); // this is function call
    // test();
    // input();

    // System.out.println("enter marks of the student");
    // int marks = scn.nextInt();
    // gradingSystem(marks);

    // System.out.println("enter number to be checked");
    // int num = scn.nextInt();
    // oddEven(num);

    // OddEvenMultiple();
     System.out.println("enter number :");
     int num = scn.nextInt();
    // printTable(num);
    // printMultipleTables(num);
    printAllTables(num);
  }
}
