import java.io.*;
import java.util.Scanner;

public class Main {

    static int countSearch = 0;
    static int countFound = 0;

    public static void searchBruteForce(char[][] wordPuzzle, String[] puzzleKey) {

        int row = wordPuzzle.length;
        int col = wordPuzzle[0].length;
        int numberOfPuzzleKey = puzzleKey.length;

        int countLetters;
        int keyLength;
        String key;

        for (int i = 0; i < numberOfPuzzleKey; i++) {
            key = puzzleKey[i];
            keyLength = puzzleKey[i].length();

            boolean found = false;

            for (int currRow = 0; currRow < row; currRow++) {
                for (int currCol = 0; currCol < col; currCol++) {
                    countSearch++;

                    if (wordPuzzle[currRow][currCol] == key.charAt(0)) {

                        // searchRight
                        if (!found) {
                            countLetters = 0;
                            while ((currCol + keyLength) <= col && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow][currCol + countLetters] == key.charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow][currCol + lettersIndex] = key.charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchLeft
                        if (!found) {
                            countLetters = 0;
                            while ((currCol >= keyLength - 1) && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow][currCol - countLetters] == key.charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow][currCol - lettersIndex] = key.charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchDown
                        if (!found) {
                            countLetters = 0;
                            while ((currRow + keyLength) <= row && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow + countLetters][currCol] == key.charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow + lettersIndex][currCol] = key.charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchUp
                        if (!found) {
                            countLetters = 0;
                            while ((currRow >= keyLength - 1) && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow - countLetters][currCol] == key.charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow - lettersIndex][currCol] = key.charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchDownRight
                        if (!found) {
                            countLetters = 0;
                            while ((currRow + keyLength <= row) && (currCol + keyLength <= col)
                                    && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow + countLetters][currCol + countLetters] == key
                                        .charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }

                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow + lettersIndex][currCol + lettersIndex] = key
                                            .charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchDownLeft
                        if (!found) {
                            countLetters = 0;
                            while ((currRow + keyLength <= row) && (currCol >= keyLength - 1)
                                    && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow + countLetters][currCol - countLetters] == key
                                        .charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow + lettersIndex][currCol - lettersIndex] = key
                                            .charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchUpRight
                        if (!found) {
                            countLetters = 0;
                            while ((currRow >= keyLength - 1) && (currCol + keyLength) <= col
                                    && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow - countLetters][currCol + countLetters] == key
                                        .charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow - lettersIndex][currCol + lettersIndex] = key
                                            .charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }

                        // searchUpLeft
                        if (!found) {
                            countLetters = 0;
                            while ((currRow >= keyLength - 1) && (currCol >= keyLength - 1)
                                    && (countLetters < keyLength)) {
                                countSearch++;
                                if (wordPuzzle[currRow - countLetters][currCol - countLetters] == key
                                        .charAt(countLetters)) {
                                    countLetters++;
                                } else {
                                    break;
                                }
                            }
                            if (countLetters == keyLength) {
                                found = true;
                                System.out.println(key);

                                char[][] displayPuzzle = createEmptyPuzzle(row, col);
                                for (int lettersIndex = 0; lettersIndex < keyLength; lettersIndex++) {
                                    displayPuzzle[currRow - lettersIndex][currCol - lettersIndex] = key
                                            .charAt(lettersIndex);
                                }
                                printPuzzle(displayPuzzle);
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    }

    public static int[] getData(String filename) {

        try {
            Scanner s = new Scanner(new File(filename));
            String puzzleRow = s.nextLine().replaceAll("\\s", "");

            int col = puzzleRow.length();

            int row = 0;
            String nextline = "notEmpty";
            while (s.hasNextLine() && nextline != "") {
                row++;
                nextline = s.nextLine();
            }

            int numberOfPuzzleKey = 0;
            while (s.hasNextLine()) {
                numberOfPuzzleKey++;
                s.nextLine();
            }

            s.close();

            int[] data = new int[3];

            data[0] = row;
            data[1] = col;
            data[2] = numberOfPuzzleKey;
            return data;

        } catch (Exception e) {
            System.out.println("File not found!");
            return null;
        }

    }

    public static char[][] getPuzzleMatrix(String filename, int[] puzzleData) {
        try {

            Scanner s = new Scanner(new File(filename));

            int row = puzzleData[0];
            int col = puzzleData[1];

            char[][] wordPuzzle = new char[row][col];
            int puzzleRow = 0;

            while (s.hasNextLine()) {
                int puzzleCol = 0;
                String str = s.nextLine().replaceAll("\\s", "");
                if (puzzleRow < row) {
                    while (puzzleCol < col) {
                        wordPuzzle[puzzleRow][puzzleCol] = str.charAt(puzzleCol);
                        puzzleCol++;
                    }
                    puzzleRow++;
                }
            }

            return wordPuzzle;

        } catch (Exception e) {
            System.out.println("File not found!");
            return null;
        }
    }

    public static String[] getPuzzleKey(String filename, int[] puzzleData) {
        try {

            Scanner s = new Scanner(new File(filename));

            String[] puzzleKey = new String[puzzleData[2]];

            int wordIndex = 0;

            String nextline = "notEmpty";
            while (s.hasNextLine() && nextline != "") {
                nextline = s.nextLine();
            }

            while (s.hasNextLine()) {
                nextline = s.nextLine().replaceAll("\\s", "");
                if (nextline != " ") {
                    puzzleKey[wordIndex] = nextline;
                    wordIndex++;
                }
            }
            return puzzleKey;

        } catch (Exception e) {
            System.out.println("File not found!");
            return null;
        }

    }
    
    public static char[][] createEmptyPuzzle(int row, int col) {

        countFound++;

        char[][] emptyPuzzle = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                emptyPuzzle[i][j] = '-';
            }
        }
        return emptyPuzzle;
    }

    public static void printPuzzle(char[][] wordPuzzle) {
        for (int i = 0; i < wordPuzzle.length; i++) {
            for (int j = 0; j < wordPuzzle[0].length; j++) {
                System.out.print(wordPuzzle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void puzzleSolution(char[][] wordPuzzle, String[] puzzleKey, int row, int col) {

        long startTime = System.currentTimeMillis();

        searchBruteForce(wordPuzzle, puzzleKey);

        long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        System.out.print("Insert File Name: ");
        String filename = keyboardInput.next();
        keyboardInput.close();

        File fileName = new File(filename);

        boolean exists = fileName.exists();

        if (exists) {

            int[] puzzleData = getData(filename);
            char[][] wordPuzzle = getPuzzleMatrix(filename, puzzleData);
            String[] puzzleKey = getPuzzleKey(filename, puzzleData);

            int row = puzzleData[0];
            int col = puzzleData[1];
            int nPuzzleKey = puzzleData[2];

            System.out.println();
            System.out.println("Puzzle size: " + row + "x" + col);
            System.out.println("Puzzle keywords: " + nPuzzleKey + " words");
            System.out.println();
            System.out.println("==============================");
            System.out.println("=          Solution          =");
            System.out.println("==============================");
            System.out.println();

            puzzleSolution(wordPuzzle, puzzleKey, row, col);
            System.out.println("Number of comparisons: " + countSearch);
            System.out.println("Words found: " + countFound);

        } else {
            System.out.println(filename + " does not exist!");
        }

    }
}
