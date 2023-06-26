/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguyenhuuhieu
 */
public class CapitalizeWords {
    public static String capitalizeWords(String input) {
            if (input == null || input.isEmpty()) {
                return input;
            }

            StringBuilder result = new StringBuilder(input.length());
            String[] words = input.trim().split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    String firstLetter = word.substring(0, 1).toUpperCase();
                    String remainingLetters = word.substring(1).toLowerCase();

                    result.append(firstLetter).append(remainingLetters).append(" ");
                }
            }

            return result.toString().trim();
            }
}
