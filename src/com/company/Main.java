package com.company;

import java.io.IOException;
import java.util.Scanner;

/**
 * COP 3710 Final Coding Assignment
 * Date: April 26, 2020
 * @author Yoisi Kristy Low Gonzalez
 * Acknowledgement: Prof. Greenwell's coding videos were used as reference to complete this assignment
 */
public class Main {

  public static void main(String[] args) throws IOException {
    //load the message file and create bigram
    WordPair myPair = new WordPair();
    myPair.createBigram("./src/messages.txt");

    //Get user input
    Scanner scan = new Scanner(System.in);
    System.out.println("Type a word");
    String userWord = scan.next();
    myPair.compareWord(userWord);
  }
}
