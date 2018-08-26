package com.sda.hangman.domain;

import com.sda.hangman.domain.model.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameService {

    public List<Integer> performCharacter(char c, String phrase){

        char[] charsFromPhrase = phrase.toCharArray();

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <charsFromPhrase.length ; i++) {
            if(equalsIgnoreCase(c,charsFromPhrase[i])){
                result.add(i);
            }
        }


        return result;
    }

    public GameStatus createGameStatus(String name, String phrase){
        return new GameStatus(name,phrase,5);
    }


    private boolean equalsIgnoreCase(char a, char b){
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public void processNextLetter(char letter, GameStatus gameStatus) {

        String phrase = gameStatus.getPhrase();
        boolean letterAlredyUsed = gameStatus.historyContains(letter);
        if (letterAlredyUsed){
            gameStatus.incrementFailureCounter();
        }else {

            List<Integer> letterIds = performCharacter(letter,phrase);
            Character[] phraseState = gameStatus.getPhraseState();
            letterIds.forEach(index->{
                phraseState[index] = gameStatus.getPhrase().charAt(index);
            });
            performCounterIncrement(letterIds.size()>0,gameStatus);
        }
        gameStatus.updateHistory(letter);

    }

    private void performCounterIncrement(boolean success, GameStatus gameStatus){
        if(success){
            gameStatus.incrementSuccessCounter();
        }else {
            gameStatus.incrementFailureCounter();
        }
    }
}
