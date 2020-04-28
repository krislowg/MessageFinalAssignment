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

public class WordPair {

  public void createBigram(String messagePath) throws IOException {
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
    }

    public void compareWord(String userInput){

    }
}
