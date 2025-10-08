package com.nrz.efj.chapter11.item87;

import java.io.Serializable;

/**
 * 직렬화 형태에 적합하지 않은 예시
 * 논리적으로 이 클래스는 일련의 문자열을 표현한다.
 * 물리적으로 문자열들을 이중 연결 리스트로 연결했다.
 *
 * 기본 직렬화를 사용하면, 각 노드의 양방향 연결 정보를 포함해 모든 엔트리를 철두 철미하게 기록한다.
 * 즉, 쓸모 없는(저장하지 않아야 할) 정보까지 같이 저장한다
 */
public final class StringList implements Serializable {
    private int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable{
        String data;
        Entry next;
        Entry previous;
    }
    //... 나머지 코드 생략
}
