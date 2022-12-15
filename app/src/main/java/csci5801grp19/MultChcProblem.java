package csci5801grp19;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class MultChcProblem extends AbstractProblem {

  public MultChcProblem(File sc) {
    int lncount = 0; // number of lines in src code file

    // read file into solution string

    String original = ""; // "shadow" variable for solution

    try {
      Scanner reader = new Scanner(new File(sc.getAbsolutePath())); // open a scanner using the file found at sc's abs
                                                                    // path
      while (reader.hasNextLine()) { // run until end of file

        original = original.concat(reader.nextLine()); // add on next line and enter
        original = original.concat("\n");
        lncount = lncount + 1; // increase for each line
      }
      reader.close(); // close scanner
    } catch (FileNotFoundException nofile) // catch error if src file isn't found
    {
      System.out.println("Source code file not found");
      nofile.printStackTrace();
    }

    this.solution = original; // set original to solution


    String[] mutates = {"", "", "", ""};

    int counter = 0;
    Random rand = new Random(new Date().getTime()); // use time for random seeding to avoid using same seeds
    int origL = rand.nextInt(lncount); // pick two random numbers from 0 to lncount (exclusive)
    

    try {
      Scanner reader = new Scanner(new File(sc.getAbsolutePath())); // open scanner on sc
      while (reader.hasNextLine()) { // go until end of file

        if (counter == origL) // if the counter is equal to a line to be swapped save that line's content
        {
          mutates[0] = reader.nextLine();
        }
        else
        {
          reader.nextLine(); // if not equal just read it in to keep moving
        }
        counter++; // increase per line
        
      }
      reader.close(); // close scanner
      } catch (FileNotFoundException nofile) // catch error if src file isn't found
      {
        System.out.println("Source code file not found");
        nofile.printStackTrace();
      }

      
      counter = 0; // reset counter because we're going back through

      String[] python_keywords = { "and", "as", "assert", "break",
      "class", "continue", "def", "del", "elif", "else", "except",
      "False", "finally", "for", "from", "global", "if", "import",
      "in", "is", "lambda", "None", "nonlocal", "not", "or", "pass",
      "raise", "return", "True", "try", "while", "with", "yield" };

      String[] python_arithmetic = { "+", "-", "*", "/", "%", "**", "//" };

      String[] python_assignment = { "=", "+=", "-=", "*=", "/=", "%=", "//=",
      "**=", "&=", "|=", "^=", ">>=", "<<=" };

      String[] python_comparison = { "==", "!=", ">", "<", ">=", "<=" };

      String[] python_bitwise = {"&","|","^","~","<<",">>"};

      for(int i = 1; i<4; i++)
      {
        for(int j = 0; j<5; j++)
        {
          if(j==0) //if its a keyword sub for a new keyword
          {
            for(int l = 0; l<python_keywords.length; l++)
            {
              if(mutates[0].contains(python_keywords[l]))
              {
                int index = rand.nextInt(python_keywords.length);
                while(index==l)
                {
                  index = rand.nextInt(python_keywords.length);
                }
                mutates[i] = mutates[0].replace(python_keywords[l], python_keywords[index]);
                break;
              }
            }
          }
          else if(j==1) //same concept for comparisons
          {
            for(int l = 0; l<python_arithmetic.length; l++)
            {
              if(mutates[0].contains(python_arithmetic[l]))
              {
                int index = rand.nextInt(python_arithmetic.length);
                while(index==l)
                {
                  index = rand.nextInt(python_arithmetic.length);
                }
                mutates[i] = mutates[0].replace(python_arithmetic[l], python_arithmetic[index]);
                break;
              }
            }
          }
          else if(j==2)
          {
            for(int l = 0; l<python_assignment.length; l++)
            {
              if(mutates[0].contains(python_assignment[l]))
              {
                int index = rand.nextInt(python_assignment.length);
                while(index==l)
                {
                  index = rand.nextInt(python_assignment.length);
                }
                mutates[i] = mutates[0].replace(python_assignment[l], python_assignment[index]);
                break;
              }
            }
          }
          else if(j==3)
          {
            for(int l = 0; l<python_comparison.length; l++)
            {
              if(mutates[0].contains(python_comparison[l]))
              {
                int index = rand.nextInt(python_comparison.length);
                while(index==l)
                {
                  index = rand.nextInt(python_comparison.length);
                }
                mutates[i] = mutates[0].replace(python_comparison[l], python_comparison[index]);
                break;
              }
            }
          }
          else if(j==4)
          {
            for(int l = 0; l<python_bitwise.length; l++)
            {
              if(mutates[0].contains(python_bitwise[l]))
              {
                int index = rand.nextInt(python_bitwise.length);
                while(index==l)
                {
                  index = rand.nextInt(python_bitwise.length);
                }
                mutates[i] = mutates[0].replace(python_bitwise[l], python_bitwise[index]);
                break;
              }
            }
          }
          else
          {
            mutates[i] = mutates[0].replace(";", "");
          }
        }
      }



    String ask = this.solution.replace(mutates[0], "______");
    this.question = "Below, a line has been selected and mutated into 3 incorrect versions. Pick the original (correct) line of code. Ensure that it is logically consistent with the intended output\n" + ask;
    // print out question statement and then the problem (reorder)

    // mutates[0] = "What is this line?";
    ArrayList<String> order = new ArrayList<String>();
    order.add(mutates[0]);
    order.add(mutates[1]);
    order.add(mutates[2]);
    order.add(mutates[3]); // add question choices to an variable-size arraylist

    String choices = "";

    int sizer = order.size(); // set sizer (which will decrease) to lncount
    int val = 0; // represents random index chosen
    while (sizer > 0) // while order is not empty
    {
      val = rand.nextInt(sizer); // choose random index of arraylist
      choices = choices.concat(order.get(val)); // concat that answer onto choices
      choices = choices.concat("\n");
      order.remove(val); // remove that answer from the list
      sizer--; // dec sizer
    }

    this.options = choices; // set options to choices
  }
}
