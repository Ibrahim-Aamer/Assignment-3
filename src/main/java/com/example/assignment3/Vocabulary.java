package com.example.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Vocabulary extends Thread{

    public BST run(String fileName)
    {
        BST bst = new BST();


        try {

            File myObj = new File("./src/"+fileName);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();

                StringTokenizer st = new StringTokenizer(data," ");

                String temp = st.nextToken();//avoiding FlightNumber token

                //Adding temp String object into ArrayList
                bst.insert(temp);

                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. vocabulary.txt Not Found");
            e.printStackTrace();
        }


        return bst;
    }
}
