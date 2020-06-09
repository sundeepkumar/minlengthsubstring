package minlengthsubstring;

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  List<String> convertToArray(String sub){
    List<String> listOfStr = new ArrayList<>();
    for(int i = 0; i < sub.length(); i++ )
    {
         listOfStr.add(sub.substring(i, i+1));
    }
    
    return listOfStr;
   
  }
  
  boolean checkStringinSubString(String sub, String t)
  {
       List<String> col = convertToArray(sub);
       for(int i = 0; i < t.length();i++)
       {
          int index = col.indexOf(t.substring(i,i+1));
         if(index == -1 ) 
           return false;
         else 
           col.remove(index);
       }
       return true;
  }

  int minLengthSubstring(String s, String t) {
    // Write your code here
    int window = t.length();
    while(window <= s.length() ) 
    {
      
      for(int i = 0 ; i < s.length()- window; i++ )
      {
          String sub = s.substring(i, i + window);
          if(checkStringinSubString(sub, t))
          {
            return window;
          }
      }
      window++;
    }
    return  -1; 
      
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}
