package com.example.designpattern.LLDPractice.HashMap;

public class CustomConcurrentHashMapDriver {

    public static void main(String[] args) {
        CustomHashMap<String, String> hashMap = new CustomHashMapImpl<>(10,.8,2);
        hashMap.put("sdsda","3242342");
        hashMap.put("asdasdsda","324232342");
        hashMap.put("scxdsda","32342");
        hashMap.put("5sdsda","89872342");
        hashMap.put("sdsda65","97772342");
        hashMap.put("11sdsda","3242342");
        hashMap.put("422asdasdsda","324232342");
        hashMap.put("54scxdsda","32342");
        hashMap.put("gfsdsda","89872342");
        hashMap.put("iisdsda65","97772342");
        hashMap.put("dasdsda","3242732342");
        hashMap.put("ghgxdsda","323742");
        hashMap.put("99hdsda","898727342");
        hashMap.put("1dasdsda","3242532342");
        hashMap.put("2ghgxdsda","323412");
        hashMap.put("399hdsda","898723142");
        hashMap.put("4dasdsda","3242323342");
        hashMap.put("5ghgxdsda","323432");
        hashMap.put("799hdsda","898723442");

        System.out.println("======================GET================");
        System.out.println(hashMap.get("asdasdsda"));
        System.out.println(hashMap.get("as1212dasdsda"));
        System.out.println(hashMap.contains("11sdsda"));
        System.out.println(hashMap.get("54scxdsda"));
        System.out.println(hashMap.get("gfsdsda"));
        System.out.println(hashMap.size());


    }
}
