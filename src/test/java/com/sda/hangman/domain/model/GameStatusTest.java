package com.sda.hangman.domain.model;

import com.sda.hangman.domain.model.GameStatus.GameStatusHelper;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Enclosed.class)
public class GameStatusTest {
    public static class GameStatusHelperTest {


        @Test
        public void shouldReturnEmptyArrayWithSizeofPhrase() {
            //given

            GameStatusHelper gameStatusHelper = new GameStatusHelper();

            //when
            Character[] phraseState = gameStatusHelper.preparePhraseState("Wielkopolska");

            //then
            Assertions.assertThat(phraseState).allMatch((e) -> e == null);

//        for (int i = 0; i < phraseState.length; i++) {
//            Assert.assertEquals(null,phraseState[i]);
//
//        }
        }

        @Test
        public void isFinished_should_return_true_when_failure_attempts_equals_maxAttempts(){
            //given
        GameStatus gameStatus = new GameStatus("Kuba","Alamo",1);
            //when
        gameStatus.setFailedAttempts(1);
            //then
            Assert.assertTrue(gameStatus.isGameFinished());

        }

        @Test
        public void isFinished_should_return_false_when_max_is_bigger_then_failure_attempts(){
//given
            GameStatus gameStatus = new GameStatus("Kuba","Alamo",2);
            //when
            gameStatus.setFailedAttempts(1);
            //then
            Assert.assertFalse(gameStatus.isGameFinished());

        }

        @Test
        public void isFinished_should_return_true_when_all_letters_are_guessed(){
//given
            GameStatus gameStatus = new GameStatus("Kuba","Alamo",2);
            //when

            gameStatus.setPhraseState("Alamo".chars().mapToObj(c->(char)c).toArray(Character[]::new));

            //then
            Assert.assertTrue(gameStatus.isGameFinished());

        }




        @Test
        public void shouldReturnArrayWithNullEndSpecialCharsValuesForMultiWordsPhrase() {
            //given

            GameStatusHelper gameStatusHelper = new GameStatusHelper();

            //when
            Character[] phraseState = gameStatusHelper.preparePhraseState("Ala ma-kota");

            //then
            assertThat(phraseState).containsOnly(null, ' ', '-');
            Assert.assertEquals((Character) ' ', phraseState[3]);
            Assert.assertEquals((Character) '-', phraseState[6]);

        }

        //given
        //when
        //then
    }
}