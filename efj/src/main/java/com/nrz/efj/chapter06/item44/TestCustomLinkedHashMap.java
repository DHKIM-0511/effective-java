package com.nrz.efj.chapter06.item44;
/**
 * removeEldestEntry를 재정의하여 사이즈 3을 유지하는 LinkedHashMap을 만들 수 있다.
 * 다만, 이렇게 ({@link EldestEntryRemovalFunction},{@link  CustomLinkedHashMap}) 사용할 필요는 없다.
 * 필요한 용도에 맞는게 있다면 표준 함수형 인터페이스를 활용하자.
 *
 * 다만, 표준 함수형 인터페이스는 객체 인스턴스 필드에 접근하기 어려운듯?
 * */
public class TestCustomLinkedHashMap {
    public static void main(String[] args) {
        CustomLinkedHashMap<String, Integer> map =
            new CustomLinkedHashMap<>((m, eldest) -> m.size() > 3);

        CustomLinkedHashMapWithBiPredicate<String, Integer> mapWithBiPredicate =
            new CustomLinkedHashMapWithBiPredicate<>((k, v) -> "A".equals(k));

        map.put("A", 1);
        mapWithBiPredicate.put("A", 1);
        map.put("B", 2);
        mapWithBiPredicate.put("B", 2);
        map.put("C", 3);
        mapWithBiPredicate.put("C", 3);
        map.put("D", 4);
        mapWithBiPredicate.put("D", 4);
        map.put("E", 5);
        mapWithBiPredicate.put("E", 5);

        System.out.println(map);
        System.out.println(mapWithBiPredicate);
    }
}
