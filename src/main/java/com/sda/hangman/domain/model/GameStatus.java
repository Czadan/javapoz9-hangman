package com.sda.hangman.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
public class GameStatus {
    private String name;
    private String phrase;
    private Character[] phraseState;
    private Integer maxAttempts;
    private Integer attempts;
    private Integer failedAttempts;
    private Integer successAttempts;
    private List<Character> history;


    public GameStatus(String name, String phrase, Integer maxAttempts) {
        this.name = name;
        this.phrase = phrase;
        this.phraseState = new GameStatusHelper().preparePhraseState(phrase);
        this.maxAttempts = maxAttempts;
        this.successAttempts = 0;
        this.failedAttempts = 0;
        this.history = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public String getPhrase() {
        return phrase;
    }

    public Character[] getPhraseState() {
        return phraseState;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public Integer getSuccessAttempts() {
        return successAttempts;
    }

    public List<Character> getHistory() {
        return history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setPhraseState(Character[] phraseState) {
        this.phraseState = phraseState;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public void setSuccessAttempts(Integer successAttempts) {
        this.successAttempts = successAttempts;
    }

    public void setHistory(List<Character> history) {
        this.history = history;
    }

    public boolean historyContains(char letter){
        return history.contains(letter);
    }

    public void incrementFailureCounter() {
        failedAttempts ++;
    }
    public void incrementSuccessCounter() {
        successAttempts ++;
    }

    public void updateHistory(char letter) {
        history.add(letter);
    }

    public boolean isGameFinished() {
        if(failedAttempts>=maxAttempts){
            return true;
        }

        for (Character character : phraseState) {
            if(character==null){
                return false;
            }
        }
        return true;
    }


    public static class GameStatusHelper {
        public Character[] preparePhraseState(String phrase){
            char[] chars = phrase.toCharArray();
            Character[] result = new Character[chars.length];
            for (int i = 0; i <chars.length ; i++) {
                if (!Character.isLetter(chars[i])){
                    result[i] = chars[i];
                }

            }
            return result;
        }
    }

}
