import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        String filePath;
        int a;
        System.out.println("Enter difficulty level you want level -1 level -2 level -3");
        Scanner obj = new Scanner(System.in);
        a=obj.nextInt();
        switch(a)
        {
            case 1:
                filePath = "dictionary.txt";
                  break;
            case 2:
                filePath = "level2.txt";
                break;
            case 3:
                 filePath = "level3.txt";
                break;
            default :
                System.out.println("Error you choose wrong difficulty level");
                return ;
        }
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Could not find file");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));
        int wrong_ans = 0;

        ArrayList<Character> dashstate = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            dashstate.add('_');
        }


        while (wrong_ans <=6) {
            if(!dashstate.contains('_'))
            {
                System.out.println("");
                System.out.println("!!!You guessed word write!!!");
                System.out.println("!!!Word was "+word+"!!!");
                System.out.println("YOU WIN");
                break;
            }

            if(wrong_ans==6)
            {
                System.out.println("");
                System.out.println("!!!GAME OVER!!!");
                System.out.println("Correct answer was "+word);
                break;
            }
            printHangman(wrong_ans);
            System.out.print("word ");

            for (char j : dashstate) {
                System.out.print(j + " ");
            }
            System.out.println(" ");
            System.out.println("Enter the guess");
            char guess = obj.next().toLowerCase().charAt(0);
            if (word.indexOf(guess) >= 0) {
                System.out.println("");
                System.out.println("correct answer");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess)
                    {
                        dashstate.set(i, guess);
                    }
                }

            }
            else
            {
                wrong_ans++;
                System.out.println("");
                System.out.println("wrong answer");
            }

        }
        obj.close();
        printHangman(wrong_ans);
    }
    public static void printHangman(int wrong) {
        switch (wrong) {
            case 0:
                System.out.println("""
                    +---+
                    |   |
                        |
                        |
                        |
                        |
                    ========""");
                System.out.println("");
                break;
            case 1:
                System.out.println("""
                    +---+
                    |   |
                    O   |
                        |
                        |
                        |
                    ========""");
                System.out.println("");
                break;
            case 2:
                System.out.println("""
                    +---+
                    |   |
                    O   |
                    |   |
                        |
                        |
                    ========""");
                System.out.println("");
                break;
            case 3:
                System.out.println("""
                    +---+
                    |   |
                    O   |
                   /|   |
                        |
                        |
                    ========""");
                System.out.println("");
                break;

            case 4:
                System.out.println("""
                    +---+
                    |   |
                    O   |
                   /|\\  |
                        |
                        |
                    ========""");
                System.out.println("");
                break;
            case 5:
                System.out.println("""
                    +---+
                    |   |
                    O   |
                   /|\\  |
                   /    |
                        |
                    ========""");
                System.out.println("");
                break;
            case 6:
                System.out.println("""
                    +---+
                    |   |
                    O   |
                   /|\\  |          
                   / \\  |
                        |
                    ========""");
                System.out.println("");
                break;

            default:
                System.out.println("Error: Invalid hangman stage.");
        }
    }
}