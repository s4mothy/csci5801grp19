package csci5801grp19;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class OrderingProblem extends AbstractProblem {

  public OrderingProblem(File sc) { //constructor for the reorder or swap problem specifically this will fill in variables from AbstractProblem
  
    int lncount = 0; //number of lines in src code file

    //read file into solution string

    String original = ""; //"shadow" variable for solution

    try
    {
      Scanner reader = new Scanner(new File(sc.getAbsolutePath())); //open a scanner using the file found at sc's abs path
      while(reader.hasNextLine()){ //run until end of file
       
        original = original.concat(reader.nextLine()); //add on next line and enter
        original = original.concat("\n");
        lncount = lncount + 1; //increase for each line
      }
      reader.close(); //close scanner
    }
    catch(FileNotFoundException nofile) //catch error if src file isn't found
    {
      System.out.println("Source code file not found");
      nofile.printStackTrace();
    }
    
    this.solution = original; //set original to solution
  

    //reorder
    String reorder = "";
    String holder1 = ""; //created needed strings and counters
    String holder2 = "";
    int counter = 0;
    Random rand = new Random(new Date().getTime()); //use time for random seeding to avoid using same seeds
    int swap1 = rand.nextInt(lncount); //pick two random numbers from 0 to lncount (exclusive)
    int swap2 = rand.nextInt(lncount);


    while(swap2 == swap1)
    {
      swap2 = rand.nextInt(lncount); //make sure swap2 doesn't equal swap1
    }

    try
    {
      Scanner reader = new Scanner(new File(sc.getAbsolutePath())); //open scanner on sc
      while(reader.hasNextLine()){ //go until end of file
       
        if(counter==swap1) //if the counter is equal to a line to be swapped save that line's content
        {
          holder1 = reader.nextLine();
        }
        else if(counter==swap2)
        {
          holder2 = reader.nextLine();
        }
        else
        {
          reader.nextLine(); //if not equal just read it in to keep moving 
        }
        counter++; //increase per line
      }

      reader.close(); //close scanner
      counter = 0; //reset counter because we're going back through

      Scanner writer = new Scanner(new File(sc.getAbsolutePath())); //open another scanner

      while(writer.hasNextLine()){ //go until end
        if(counter==swap1) //if we reach a swappable line put in the other swappable line's content from the holder
        {
          reorder = reorder.concat(holder2);
          reorder = reorder.concat("\n");
          writer.nextLine();
        }
        else if(counter==swap2)
        {
          reorder = reorder.concat(holder1);
          reorder = reorder.concat("\n");
          writer.nextLine();
        }
        else
        {
          reorder = reorder.concat(writer.nextLine()); //otherwise concatenate as normal
          reorder = reorder.concat("\n");
        }
        counter++; //inc per line
      }

    }
    catch(FileNotFoundException nofile) //print error if no file found
    {
      System.out.println("Source code file not found");
      nofile.printStackTrace();
    }

    this.question = "Below, two lines have been swapped or reordered. Pick which two need to be swapped back to make c equal 
    to its original value. They are ordered incrementally starting at 0 (like an array index).\n" + reorder;
    //print out question statement and then the problem (reorder)
     
    //create options
    String choices = ""; //create needed strings
    String correct = swap1 + ", " + swap2 + "\n"; //create correct answer that needs to be there
    String incorrect1 = "";
    String incorrect2 = "";
    String incorrect3 = "No change, the code produces the correct logical value\n"; //create a standard no change answer that will be there too

    
    int wrong1 = rand.nextInt(lncount); //select random number 0 to lncount (exclusive)
    int wrong2 = rand.nextInt(lncount);
    int wrong3 = rand.nextInt(lncount);
    int wrong4 = rand.nextInt(lncount);

    while((wrong1 == wrong2) || ((wrong1 == swap1) && (wrong2 == swap2))) //ensure wrongs aren't the same and they're not the solution
    {
      wrong2 = rand.nextInt(lncount);
    }

    while((wrong3 == wrong4) || ((wrong3 == swap1) && (wrong4 == swap2)))
    {
      wrong4 = rand.nextInt(lncount);
    }

    incorrect1 = wrong1 + ", " + wrong2 + "\n"; //put into string format
    incorrect2 = wrong3 + ", " + wrong4 + "\n";

    ArrayList<String> order = new ArrayList<String>();
    order.add(correct);
    order.add(incorrect1);
    order.add(incorrect2);
    order.add(incorrect3); //add question choices to an variable-size arraylist

    int sizer = lncount; //set sizer (which will decrease) to lncount
    int val = 0; //represents random index chosen
    while(sizer > 0) //while order is not empty
    {
      val = rand.nextInt(sizer); //choose random index of arraylist
      choices = choices.concat(order.get(val)); //concat that answer onto choices
      order.remove(val); //remove that answer from the list
      sizer--; //dec sizer
    }

    this.options = choices; //set options to choices

  }
}
