/**
 * This class performs a string search using Horspool's algorithm
 * 
 * @author Xuan Duong
 *
 */

import java.util.*;
public class HorspoolStringSearch
{
    private char[] pattern, text;       // pattern(searchString), text
    private int patLength, textLength;          // pattern length, text length
    private static int alphabetSize=256;
    private int[] occurrence;         // occurrence of the search string
    private char ignoreCase; // holds the decision of ignoring the case
    Scanner keyboard =  new Scanner(System.in);   
       
     /**
     * Default constructor that sets string and substring to null
     * 
     */
    public HorspoolStringSearch()
    {
        pattern= new char[alphabetSize];
        text=new char[alphabetSize];
        occurrence=new int[alphabetSize];
    }
       
    /** 
     * this method searches the text tt for the pattern pp
     * @param t the text to search for the pattern
     * @param p the pattern needed to search for
     */ 
    public void search(String t, String p)
    {
        setText(t);
        setPattern(p);
        horspoolSearch();
    }

    /** 
     * This method sets the text
     * @param t the text to search for the pattern
     */ 
    private void setText(String t)
    {
        textLength=t.length();
        text=t.toCharArray();

    }
    
     /** 
     * This method sets the pattern
     * @param p the pattern needed to search for 
     */ 
    private void setPattern(String p)
    {
        patLength=p.length();
        pattern=p.toCharArray();
        horspoolInitocc();
    }
 
    /** 
     * This method calculates the occurrence of the pattern
     */ 
    private void horspoolInitocc()
    {
        int z, j;

        for (z=0; z<alphabetSize; z++)
            occurrence[z]=-1;

        for (j=0; j<patLength-1; j++)
        {
            z=pattern[j];
            occurrence[z]=j;
        }
    }

    /** 
     * This method step through every character of the text to count the number of occurences of the pattern
     * @return counter the number of occurrences of the pattern
     */ 
    public int horspoolSearch()
    {
        int i=0;
        int j;
        int counter =0;
        while (i<=textLength-patLength)
        {
            j=patLength-1;
            while (j>=0 && pattern[j]==text[i+j])
                j--;
            if (j<0) counter++;
            i+=patLength-1;
            i-=occurrence[text[i]];
        }
        return counter;
    }
    
    /**
     * This method ask user if they want to ignore the case while searching or not
     * 
     * @return ignoreCase user's choice to ignore case or not. 
     */    
    public char askCase(){
        System.out.println("Do you want to ignore case? Y for yes, N for no.");
        char choice = keyboard.next().charAt(0);
        
        if(choice == 'y' || choice == 'Y'){
            ignoreCase = 'y';
        }
        else
            ignoreCase = 'n';
        return ignoreCase;
    }
    
    /**
     * This method returns a string representation of the HorspoolStringMatcher class
     * @return String a representation of the HorspoolStringMatcher class
     */
    public String toString()
    { return ("The substring was found " + horspoolSearch() + " times.");
    }
}   