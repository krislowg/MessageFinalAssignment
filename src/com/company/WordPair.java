package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * WordPair class includes the methods that create the bigram from the messages.txt file & the
 * confidence value and the method that compares the user input word with the ones in the bigram map
 * & suggests the next word depending on the percentage of support.
 */
public class WordPair {

  /**
   * Metoh that creates a bigram using the content from the messages.txt file and the confidence
   * value
   *
   * @param messagePath
   * @throws IOException
   */
  public void createBigram(String messagePath) throws IOException {
    Path msgPath = Paths.get(messagePath);

    Stream<String> msgLines = Files.lines(msgPath).filter(line -> !line.isEmpty());
    // Then amend our earlier example by adding a split & flatMapping our Arrays
    List<String> msgWords =
        msgLines
            .map(String::toLowerCase)
            .map(line -> line.split("\\s+"))
            .flatMap(Arrays::stream)
            .collect(Collectors.toList());

    msgWords.forEach(System.out::println);

    // Creation of the hashmap
    Map<Set<String>, Integer> bgrams = new HashMap<>();

    for (int i = 1; i < msgWords.size(); i++) {
      bgrams.merge(
          new HashSet<>(Arrays.asList(msgWords.get(i - 1), msgWords.get(i))), 1, Integer::sum);

      // See we were using a version of MapReduce
      // We just combined the shuffle & reduce in the same step
    }

    bgrams.forEach((key, value) -> System.out.println(key + ", " + value));

    // Trying
    System.out.println(bgrams);
    // Total bigrams created
    System.out.println("Bigrams total: " + bgrams.size());
    // System.out.println(bgrams.get("[homework, dude]"));
    System.out.println(bgrams.keySet());
  }

  /**
   * compareWord method compare the user input word with the words in the bigram map calculates the
   * support and based on the support percentage it will suggest the next possible word
   *
   * @param userInput
   */
  public void compareWord(String userInput) {
    double support;
    /* if (bgrams.getKey().equal(userInput)) {
      //Get the support by using the value of the word pair and dividing by the word pair total
      support = bgrams.getValue() / bgrams.size();

      //if support of wordpair >65% suggest possible next word
      if (support > 0.65) {
        System.out.println("Your next word might be " + bgrams.getKey());
      }else{ //<65% suggest common connectors
        System.out.println("Your next word might be: the");
        System.out.println("Your next word might be: this");
        System.out.println("Your next word might be: of");
      }
    }else{ //The word entered is not in the messages.txt file
      System.out.println("No matches for this word");
    }*/
  }
}
