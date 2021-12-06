package com.example.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class InputFile extends Thread{

    public Vector<String> run(String fileName)
    {
        BST bst = new BST();

        Vector<String> strings = new Vector<String>();
        //creating new Vector of strings

        try {

            File myObj = new File("./src/"+fileName);
            Scanner myReader = new Scanner(myObj);
            String data;
            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();

                StringTokenizer st = new StringTokenizer(data," ");

                //loop to iterate over line
                while(true) {

                    try {
                        String temp = st.nextToken();//avoiding FlightNumber token
                        //Adding temp String object into ArrayList

                        if(!temp.equals(null)) {
                            strings.add(temp);
                        }
                        //System.out.println("token:"+ temp);
                    }
                    catch(Exception e)//catching no more tokens in line exception
                    {
                        //System.out.println(e.getMessage());
                        //System.out.println("Moving to next line");
                        break;
                    }
                }


                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. vocabulary.txt Not Found");
            e.printStackTrace();
        }


        return strings;
    }
}
