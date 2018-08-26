package com.sda.hangman.domain.model;

import com.sda.hangman.domain.HangmanGameService;
import com.sda.hangman.domain.model.GameStatus.GameStatusHelper;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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