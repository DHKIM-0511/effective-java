package com.nrz.efj.chapter01.item05.springioc;

import com.nrz.efj.chapter01.item05.Dictionary;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SpringDictionary implements Dictionary {

    @Override
    public boolean contains(String word) {
        System.out.println("contains " + word);
        return false;
    }

    @Override
    public List<String> closeWordsTo(String typo) {
        return List.of();
    }
}
