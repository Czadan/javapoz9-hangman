package com.sda.hangman.domain;

import com.sda.hangman.domain.model.GameStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameServiceTest {

    private HangmanGameService hangmanGameService;


    @Before
    public void init(){
        this.hangmanGameService = new HangmanGameService();
    }

    @Test
    public void shouldReturnArrayWithCharacterIndexes(){
        //given


        //when
        List<Integer> result = hangmanGameService.performCharacter('a',"Anna");

        //then
        Assert.assertEquals(2,result.size());
        Assert.assertEquals((Integer) 0,result.get(0));
        Assert.assertEquals((Integer) 3,result.get(1));
    }
    @Test
    public void shouldReturnEmptyArrayForWrongCharacter(){
        //given


        //when
        List<Integer> result = hangmanGameService.performCharacter('b',"Anna");

        //then
        Assert.assertEquals(0,result.size());

    }
    @Test
    public void shouldReturnArrayWithCharacterIndexesFromPhraseContainingWhiteSpaces(){
        //given

        //when
        List<Integer> result = hangmanGameService.performCharacter('a',"Ala ma kota");
        //then
        Assert.assertEquals(4,result.size());
        Assert.assertEquals((Integer) 0,result.get(0));
        Assert.assertEquals((Integer) 2,result.get(1));
        Assert.assertEquals((Integer) 5,result.get(2));
        Assert.assertEquals((Integer) 10,result.get(3));



    }



    @Test
    public void processNextLetterShouldUpdateCharacterStateWhenThereIsLetterInPhrase(){
        //given
        GameStatus gameStatus = new GameStatus("Kuba","Anna");
        GameStatus gameStatus2 = new GameStatus("Kuba","Anna");

        //when
         hangmanGameService.processNextLetter('a',gameStatus);

        //then
        Assert.assertNotEquals(gameStatus2.getPhraseState() , gameStatus.getPhraseState());

    }
    @Test
    public void processNextLetterShouldNotUpdateCharacterStateWhenThereIsNoLetterInPhrase() {

        //given
        GameStatus gameStatus = new GameStatus("Kuba","Anna");
        GameStatus gameStatus2 = new GameStatus("Kuba","Anna");

        //when
        hangmanGameService.processNextLetter('b',gameStatus);

        //then
        Assert.assertArrayEquals(gameStatus2.getPhraseState() , gameStatus.getPhraseState());
    }
    @Test
    public void processNextLetterShouldUpdateSuccessCharacterStateWhenThereIsLetterInPhrase(){
        //given
        GameStatus gameStatus = new GameStatus("Kuba","Anna");
        //when
        hangmanGameService.processNextLetter('a',gameStatus);
        //then
        Assert.assertEquals(1,gameStatus.getSuccessAttempts().intValue());
    }
    @Test
    public void processNextLetterShouldUpdateFailureCharacterStateWhenThereIsNoLetterInPhrase(){
        //given
        GameStatus gameStatus = new GameStatus("Kuba","Anna");
        //when
        hangmanGameService.processNextLetter('b',gameStatus);
        //then
        Assert.assertEquals(1,gameStatus.getFailedAttempts().intValue());
    }
    @Test
    public void processNextLetterShouldUpdateHistoryForNewLetter(){
        //given
        GameStatus gameStatus = new GameStatus("Kuba","Anna");
        //when
        hangmanGameService.processNextLetter('a',gameStatus);
        //then
        Assert.assertEquals(1,gameStatus.getHistory().size());
    }



}
