package com.nrz.efj.chapter01.item05.dependencyinjection;

import static org.junit.jupiter.api.Assertions.*;

import com.nrz.efj.chapter01.item05.DefaultDictionary;
import com.nrz.efj.chapter01.item05.MockDictionary;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    @Test
    void isValid(){
//        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
//        SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new);
//        SpellChecker spellChecker = new SpellChecker(DictionaryFactory::get);
        SpellChecker spellChecker = new SpellChecker(MockDictionary::new);
        spellChecker.isValid("test");
    }
}