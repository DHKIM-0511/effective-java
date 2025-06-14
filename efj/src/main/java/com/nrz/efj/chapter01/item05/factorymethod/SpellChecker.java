package com.nrz.efj.chapter01.item05.factorymethod;

import com.nrz.efj.chapter01.item05.Dictionary;
import java.util.List;

//client code
public class SpellChecker {

    private Dictionary dictionary; // product

    public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.getDictionary();
    }

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
