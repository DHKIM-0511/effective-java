package com.nrz.efj.chapter08.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetElementsWithURL {

    public static void main(String[] args) throws IOException {
        try(InputStream in = new URL("https://www.naver.com").openStream()){
            in.transferTo(System.out);
        }
    }
}
