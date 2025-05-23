package com.nrz.efj.chapter03.item20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

public class CallbackFileProcessor {
    private String path;

    public CallbackFileProcessor(String path) {
        this.path = path;
    }

    public final int process(BiFunction<Integer, Integer, Integer> operator){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            int res = 0;
            String line = null;
            while ((line = br.readLine()) != null){
                res = operator.apply(res, Integer.parseInt(line));
            }
            return res;
        } catch (IOException e) {
            throw new IllegalArgumentException(path +"에 해당하는 파일이 없습니다.", e);
        }
    }
}
