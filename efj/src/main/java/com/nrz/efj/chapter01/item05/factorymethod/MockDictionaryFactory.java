package com.nrz.efj.chapter01.item05.factorymethod;

import com.nrz.efj.chapter01.item05.Dictionary;
import com.nrz.efj.chapter01.item05.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory{

    @Override
    public Dictionary getDictionary() {
        return new MockDictionary();
    }
}
