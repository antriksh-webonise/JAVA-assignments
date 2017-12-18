
package com.assignment.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterReplacementTest{

    @Test
    public void testCharacterReplacementCase1() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("aaaaag",'a');
        assertEquals("aag",resultString);
    }

    @Test
    public void testCharacterReplacementCase2() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("abaadfg",'a');
        assertEquals("badfg",resultString);
    }

    @Test
    public void testCharacterReplacementCase3() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("",'a');
        assertEquals("",resultString);
    }

    @Test
    public void testCharacterReplacementCase4() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("aabd",'a');
        assertEquals("bd",resultString);
    }

    @Test
    public void testCharacterReplacementCase5() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("world",'a');
        assertEquals("world",resultString);
    }

    @Test
    public void testCharacterReplacementCase6() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("aaa",'a');
        assertEquals("",resultString);
    }

    @Test
    public void testCharacterReplacementCase7() {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        String resultString = characterReplacement.replaceCharacter("dddaaa",'a');
        assertEquals("dddaaa",resultString);
    }
}

