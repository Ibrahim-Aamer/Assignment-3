package com.example.assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;


public class ThreadProgram extends Thread{

    public void run(String str)
    {
        System.out.println("Running thread"+ str);
    }


    public static void main(String[] args)
    {

        System.out.println("Input File Names : ");
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);

        Vocabulary t1 = new Vocabulary();
        BST bst = t1.run(args[0]);//Passing name of vocabulary file
                                    //BST stored bst object

        //For input file 1
        InputFile inputFile1 = new InputFile();
        Vector<String> wordsVector = inputFile1.run(args[1]);//passing inputFile1 name into new object ,gets vector

        //For input file 2
        InputFile inputFile2 = new InputFile();
        wordsVector.addAll(inputFile2.run(args[2]));//vector of words from input file 2 added in same vector

        //Getting matched words and their frequency
        ArrayList<Word> wordsArr = wordCount(wordsVector,bst);


        String choice = new String();
        choice = "1";

        while(!choice.equals("5")) {

            System.out.println("=============================================");
            System.out.println("|-------------------MENU--------------------|");
            System.out.println("=============================================");
            System.out.println("| 1.Display Vocabulary BST                  |");
            System.out.println("| 2.Display Input files Vectors             |");
            System.out.println("| 3.Viewing Match words and their frequency |");
            System.out.println("| 4.Search a query                          |");
            System.out.println("| 5.Exit                                    |");
            System.out.println("=============================================");

            //InputFile t2 = new InputFile();
            //t2.run("Hello MF");

            System.out.print("Enter Choice : ");
            Scanner scanInput = new Scanner(System.in);  // Create a Scanner object
            choice = scanInput.nextLine();  // Read user input

            //Input validation loop
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")
                    && !choice.equals("4") && !choice.equals("5")) {
                System.out.println("Invalid Choice!\n");
                System.out.print("Enter Choice : ");
                choice = scanInput.nextLine();  // Read user input
            }

            if (choice.equals("1"))//Display bst
            {
                bst.inorder();//Display bst
            } else if (choice.equals("2"))//Display vectors
            {
                System.out.println("--------------");
                System.out.println("Vector:");
                for (int c = 0; c < wordsVector.size(); c++) {
                    System.out.println(wordsVector.get(c));
                }
                System.out.println("--------------");
            } else if (choice.equals("3"))//View Match words and frequency
            {
                System.out.println("=====================");
                System.out.println("Word Count = " + wordsArr.size());
                System.out.println("---------------------");
                for (int c = 0; c < wordsArr.size(); c++) {
                    System.out.println(wordsArr.get(c).DisplayFrequency());
                }
                System.out.println("=====================");
            }
            else if (choice.equals("4"))
            {
                System.out.println("==================================");
                System.out.print("Enter File Name : ");
                String fileName = scanInput.nextLine();

                boolean flag = false;

                for(int c=0 ; c<3; c++)
                {
                    if(fileName.equals(args[c]))
                    {
                        System.out.println("File Exists !");
                        flag = true;
                    }
                }

                if(flag == false)
                {
                    System.out.println("File Doesn't Exist !");
                }
                System.out.println("==================================");
            }
        }




    }

    //Function to match words from vector with bst and count frequency
    static ArrayList<Word> wordCount(Vector<String> vector,BST bst)
    {
        ArrayList<Word> wordsArr = new ArrayList<Word>();

        //iterating over vector
        for(int c=0 ; c<vector.size(); c++)
        {
            //Searching for vector object in bst
            if(bst.search(vector.get(c)) == true)
            {
               // System.out.println(vector.get(c)+" true");
                //If word found the word is added in words array list and frequency incremented

                boolean addedFlag;
                addedFlag = false;

                //if the word is already in wordArray list then its incremented else new word added
                for(int i=0 ; i<wordsArr.size(); i++)
                {
                    if(vector.get(c).equals(wordsArr.get(i).getWord()))
                    {
                        wordsArr.get(i).IncFrequency();//frequency incremented
                        addedFlag = true;
                        break;
                    }
                }

                if(addedFlag == false)
                {
                    Word temp = new Word(vector.get(c));
                    wordsArr.add(temp);
                }


            }
            else
            {
                //System.out.println("false");
            }

        }

        return wordsArr;//return wordsArr
    }



}