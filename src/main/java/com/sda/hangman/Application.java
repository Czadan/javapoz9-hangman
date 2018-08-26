package com.sda.hangman;

import com.sda.hangman.domain.port.PhraseRepository;
import com.sda.hangman.infrastructure.memory.InMemoryPhraseRepository;

import java.util.Scanner;

public class Application {

    private static Scanner scanner;
    private static PhraseRepository phraseRepository;

    public static void main(String[] args) {
        phraseRepository = new InMemoryPhraseRepository();
        scanner = new Scanner(System.in);
        boolean menuFlag = true;
        do {
            System.out.println("1. Start");
            System.out.println("2. Wyniki");
            System.out.println("Inne. Koniec");
            int decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    System.out.println("Tutaj bedzie logika do start");
                    break;
                case 2:
                    System.out.println("Tutaj bedzie logika do wnikow");
                    break;
                default:
                    System.out.println("Tutaj bedzie koniec");
                    menuFlag = false;
            }
        } while (menuFlag);

    }
    public static void startGame(){
        System.out.println("Podaj swoje imie:");
        String name = scanner.nextLine();
        System.out.println("Kliknij enter zeby zaczac gre");
        String phrase = phraseRepository.getPhrase();

    }
}
