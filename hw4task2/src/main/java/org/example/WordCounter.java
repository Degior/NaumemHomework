package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File file = FileUtils.getFile("hw4task2/input.txt");
        Map<String, Integer> wordCountMap = new LinkedHashMap<>();
        try {
            for (String line : FileUtils.readLines(file, "UTF-8")) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.length() == 0) continue;
                    wordCountMap.computeIfAbsent(word, k -> 0);
                    wordCountMap.computeIfPresent(word, (k, v) -> v + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }
        List<Map.Entry<String, Integer>> sortedWordCounts = new ArrayList<>(wordCountMap.entrySet());
        sortedWordCounts.sort(Map.Entry.comparingByValue());
        System.out.println("TOP 10 words:");
        for (int i = sortedWordCounts.size() - 1; i >= Math.max(0, sortedWordCounts.size() - 10); i--) {
            System.out.println(sortedWordCounts.get(i).getKey() + ": " + sortedWordCounts.get(i).getValue());
        }
        System.out.println("\nLAST 10 words:");
        for (int i = 0; i < Math.min(sortedWordCounts.size(), 10); i++) {
            System.out.println(sortedWordCounts.get(i).getKey() + ": " + sortedWordCounts.get(i).getValue());
        }
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - start) + " мс");
    }
}
