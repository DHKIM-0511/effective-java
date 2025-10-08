package com.nrz.efj.chapter11.item87;

import java.io.Serializable;

/**
 * 객체의 물리적 표현과 논리적 내용이 같다면 기본 직렬화 형태라도 무방하다
 */
public class Name implements Serializable {
    /**
     * 성. null 이 아니어야 함
     * @serial
     */
    private final String lastName;
    /**
     * 이름. null 이 아니어야 함
     * @serial
     */
    private final String firstName;
    /**
     * 중간이름. 중간이름이 없다면 null
     * @serial
     */
    private final String middleName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    //.. 나머지생략
}
