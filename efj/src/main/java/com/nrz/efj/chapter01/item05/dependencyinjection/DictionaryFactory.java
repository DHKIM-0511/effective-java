package com.nrz.efj.chapter01.item05.dependencyinjection;

import com.nrz.efj.chapter01.item05.DefaultDictionary;
import com.nrz.efj.chapter01.item05.Dictionary;

public class DictionaryFactory {
    public static DefaultDictionary get(){
        return new DefaultDictionary();
    }
}
