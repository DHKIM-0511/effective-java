package com.nrz.efj.chapter01.item05.dependencyinjection;

import static org.junit.jupiter.api.Assertions.*;

import com.nrz.efj.chapter01.item05.DefaultDictionary;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    @Test
    void isValid(){
        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
        spellChecker.isValid("test");
    }
}