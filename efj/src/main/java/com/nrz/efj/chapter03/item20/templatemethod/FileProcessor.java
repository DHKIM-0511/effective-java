package com.nrz.efj.chapter03.item20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileProcessor {
    private String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public final int process(){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            int res = 0;
            String line = null;
            while ((line = br.readLine()) != null){
                res = getResult(res, Integer.parseInt(line));
            }
            return res;
        } catch (IOException e) {
            throw new IllegalArgumentException(path +"에 해당하는 파일이 없습니다.", e);
        }
    }
    protected abstract int getResult(int result, int number);
}
