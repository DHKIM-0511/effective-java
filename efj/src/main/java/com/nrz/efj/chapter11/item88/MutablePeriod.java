package com.nrz.efj.chapter11.item88;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 가변 공격의 예시
 * Period 인스턴스는 불변식을 유지한 채 생성되었지만, 의도적으로 내부의 값을수정했다.
 * 실제로도 String 이 불변이라는 사실에 기댄 클래스들이 존재하기 때문에 수많이 보안 문제가 발생한다.
 *
 * 문제 원인: Period 의 readObject 메서드가 방어적 복사를 충분히 하지 않아서 그렇다.
 * Period 의 readObject 에서 방어적 복사 코드를 추가하면 더이상 문제가 발생하지 않는다.
 */
public class MutablePeriod {
    public final Period period;
    public final Date start;
    public final Date end;

    public MutablePeriod(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            //유효한 Period 인스턴스를 직렬화한다.
            out.writeObject(new Period(new Date(), new Date()));

            /*
             * 악의적인 '이전 객체 참조', 즉 내부 Date 필드로의 참조를 추가한다.
             * 상세 내용은 자바 객체직렬화 명세의 6.4절을 참고하자.
             */
            byte[] ref = {0x71, 0, 0x7e, 0, 5};
            bos.write(ref); // 시작 필드
            ref[4] = 4; // 참조 # 4
            bos.write(ref); // 종료 필드

            //Period 역직렬화 후 Date 참조를 훔친다
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        }catch (IOException | ClassNotFoundException e){
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        pEnd.setYear(78);
        System.out.println(p);

        pEnd.setYear(69);
        System.out.println(p);
    }
}
