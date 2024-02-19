package com.example.designpattern.LLDPractice.TreeMap;

public class CustomHashMapDriver {

    public static void main(String[] args) {
        CustomTreeMap<String, String> treeMap = new CustomTreeMapImpl<>();
        treeMap.put("sdsda","3242342");
        treeMap.put("asdasdsda","324232342");
        treeMap.put("scxdsda","32342");
        treeMap.put("5sdsda","89872342");
        treeMap.put("sdsda65","97772342");
        treeMap.put("11sdsda","3242342");
        treeMap.put("422asdasdsda","324232342");
        treeMap.put("54scxdsda","32342");
        treeMap.put("gfsdsda","89872342");
        treeMap.put("iisdsda65","97772342");
        treeMap.put("dasdsda","3242732342");
        treeMap.put("ghgxdsda","323742");
        treeMap.put("99hdsda","898727342");
        treeMap.put("1dasdsda","3242532342");
        treeMap.put("2ghgxdsda","323412");
        treeMap.put("399hdsda","898723142");
        treeMap.put("4dasdsda","3242323342");
        treeMap.put("5ghgxdsda","323432");
        treeMap.put("799hdsda","898723442");

        System.out.println("======================GET================");
        System.out.println(treeMap.get("asdasdsda"));
        System.out.println(treeMap.get("as1212dasdsda"));
        System.out.println(treeMap.contains("11sdsda"));
        System.out.println(treeMap.get("54scxdsda"));
        System.out.println(treeMap.get("gfsdsda"));
        System.out.println(treeMap.size());


    }
}
