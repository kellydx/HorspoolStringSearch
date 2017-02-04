/**
 * This Driver class test the HorspoolStringSearch class.
 * It will ask user to enter a file name to open a text file
 * and ask for the word the user want to search for.
 * It will also give user the option to ignore the case.
 * At the end it outputs the number of the occurrences of the searchString, 
 * and which lines the subString was found on. 
 * 
 */
import java.io.*;
import java.util.*;
import java.lang.String;
public class Driver
{ 
    public static void main(String[] args) throws IOException
    {
         //create an object for Scanner class
         Scanner keyboard = new Scanner (System.in);         
         //these are the fields
         String fileName;
         String searchString;
         String sentence;
         int lineNum=0; 
         int result=0;
         int totalResult = 0;  
         
         // create an object of the HorspoolStringSearch class
         HorspoolStringSearch stm = new HorspoolStringSearch();        
            
         //ask user to input the name and location of the text file
         System.out.println("Enter the input file name and location: ");
         fileName = keyboard.nextLine();
         // creates an Scanner object to read user's input
         Scanner inputFile = new Scanner (new File(fileName));    
         //call the askCase method to get their choice of ignore case or not
         char ignoreCase = stm.askCase();
         //ask user for the word they want to search for
         System.out.println("What word would you like to search for?");
         searchString = keyboard.nextLine();          
       
         //This loop will step throught every line of the text until it reaches the end
          while (inputFile.hasNext())
         {
             //assigns each line to variable sentence 
             sentence = inputFile.nextLine();
             //if user decides to ignored case, convert both sentence and searchString to LowerCase 
             if(ignoreCase == 'y'){
                      sentence = sentence.toLowerCase();
                      searchString = searchString.toLowerCase();
              }
             // calls the search method of the HorspoolStringMatcher class
             stm.search(sentence, searchString);
             //System.out.println(stm.getMatches());
             result = stm.horspoolSearch();
              if (result > 0)
              {
                  System.out.println("On line " + (lineNum + 1) + " it was found: " + result + " times");
                  totalResult += result;
                  result = 0;
              }
              //increase the line number   
              lineNum++;
         }   
         //Displays the output
         System.out.println("Total found: " + totalResult);   
}
}