package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sound.midi.ShortMessage;

public class Main {

  public static void main(String[] args) throws IOException
  {
    Path msgPath = Paths.get("./src/messages.txt");

    Stream<String> msgLines = Files.lines(msgPath)
        .filter(line -> !line.isEmpty());
    // Then amend our earlier example by adding a split & flatMapping our Arrays
    List<String> msgWords = msgLines
        .map(String::toLowerCase)
        .map(line -> line.split("\\s+"))
        .flatMap(Arrays::stream)
        .collect(Collectors.toList());

    msgWords.forEach(System.out::println);

    //Creation of the hashmap
    Map<Set<String>, Integer> bgrams = new HashMap<>();

    for (int i = 1; i < msgWords.size(); i++) {
      bgrams.merge(new HashSet<>(Arrays.asList(

          msgWords.get(i-1),
          msgWords.get(i))),
          1, Integer::sum);
      // See we were using a version of MapReduce
      // We just combined the shuffle & reduce in the same step
    }

    bgrams.forEach((key, value) -> System.out.println(key + ", " + value));

    // Trying
    System.out.println(bgrams);
    // System.out.println(bgrams.get(homework, dude));
    System.out.println(bgrams.size());
    // System.out.println(bgrams.get("[homework, dude]"));
    System.out.println(bgrams.keySet());

    //User input
    Scanner scan = new Scanner(System.in);
    System.out.println("Type a word");
    String userWord = scan.next();

    /*Build a List of possible "next words" at least 3 words in length
    *If the support of a word pair is >65% suggest that as one of the possible next word to be typed
    Similar to how your phone gives you a list of possible next words when typing
    If no words with support >65% suggest the three most common English connector words:
      the, this, of
    If less than 3 words found - pad the list with words from the most common Connectors (the this of)
    Print out the list with each word on its own line similar to:
    "Your next word might be <word here>.\n"
    * */

    // Suggest next word to user. 3 word suggestions
    System.out.println("Your next word might be"  );
    System.out.println("Your next word might be"  );
    System.out.println("Your next word might be"  );
  }
  }

