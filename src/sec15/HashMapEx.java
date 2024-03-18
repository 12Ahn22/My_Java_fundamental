package sec15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>(); // Wrapper클래스를 사용한다.

        // 객체 저장
        map.put("홍길동", 90);
        map.put("안아영", 100);
        map.put("홍길동", 100); // 가장 최근에 넣은 값으로 값이 덮어씌워진다!
        map.put("고양이", 10);
        map.put("강아지", 87);

        // Map이 비었는지 확인하기
        System.out.println("Map이 비어있나요? " + map.isEmpty());
        // map의 총 size
        System.out.println("총 Entry의 개수:" + map.size());

        // 키로 값을 얻기
        String key = "홍길동";
        int value = map.get(key);
        System.out.println("key: " + key + "," + value);

        // 해당 key를 가지고 있는지 여부
        if(map.containsKey("홍길동1")){
            // 없기때문에 이 {}는 실행되지않는다.
            value = map.get("홍길동1");
            System.out.println("key: " + key + "," + value);
        }else{
            System.out.println("해당 키는 존재하지않습니다!");
        }

        // Map은 key를 Set 컬렉션으로 관리한다.
        Set<String> keySet = map.keySet(); // key들을 반환해준다.
        Iterator<String> keyIterator = keySet.iterator(); // Set은 iterator를 사용가능하다.
        // iterator를 사용해 모든 key 값 출력하기
        while(keyIterator.hasNext()){ // key를 순회하기 전에 다음 set데이터인 key가 있는지 확인하는 메서드
            String k = keyIterator.next(); // 현재 가리키는 key를 반환
            Integer v = map.get(k);
            // int v = map.get(k); int로 써도된다. 자동으로 언박싱 처리를 해줌
            System.out.println(k + " : " + v);
        }

//        엔트리 Set 컬렉션을 얻고 반복해서 키와 값을 얻는 방법
//        실제론 이렇게 잘 쓰지않는다.
        System.out.println("map을 순회하는 옛날 방식");
        Set<Entry<String,Integer>> entrySet = map.entrySet(); // Set 컬렉션으로 Entry들을 반환해준다.
        Iterator<Entry<String,Integer>>  entryIterator = entrySet.iterator(); // entry를 set으로 관리했기 때문에 iterator 사용가능
        while(entryIterator.hasNext()){
            Entry<String,Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("요새 map을 순회하는 방법1");
        for(Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("요새 map을 순회하는 방법2");
        for(var entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//        key로 엔트리 삭제하기
        map.remove("홍길동");
        System.out.println("총 Entry 개수:" + map.size());
    }
}
