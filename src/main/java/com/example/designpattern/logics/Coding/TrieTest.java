//package com.example.designpattern.logics.Coding;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TrieTest {
//
//    private TrieNode rootTrieNode;
//
//    public TrieTest() {
//        this.rootTrieNode = new TrieNode();
//    }
//
//    void insert(String name, String phoneNo){
//
//        TrieNode trieNode = rootTrieNode;
//
//        for(int i=0;i<name.length();i++){
//            char ch = name.charAt(i);
//            int chIndex = ch-'a';
//
//            if(trieNode.getTrieChildren()[chIndex]==null ){
//                //System.out.println(ch);
//                TrieNode newTrieNode = new TrieNode();
//                trieNode.getTrieChildren()[chIndex] = newTrieNode;
//            }
//            trieNode = trieNode.getTrieChildren()[chIndex];
//        }
//
//        trieNode.setEndOfWord(true);
//        List<String> list =  trieNode.getPhoneNo();
//        list.add(phoneNo);
//        trieNode.setPhoneNo(list);
//
//    }
//
//
//    List<String> search(String name){
//        System.out.print(name + "  ");
//        TrieNode trieNode = rootTrieNode;
//        for(int i=0;i<name.length();i++){
//            char ch = name.charAt(i);
//            int chIndex = ch-'a';
//            if(trieNode.getTrieChildren()[chIndex]==null ){
//                return new ArrayList<>();
//            }
//            trieNode = trieNode.getTrieChildren()[chIndex];
//            List<String> sd= trieNode.getPhoneNo();
//            sd.
//
//        }
//        return getPhonNo(trieNode);
//
//    }
//
//    List<String> getPhonNo(TrieNode trieNode){
//
//        if(trieNode ==null){
//            return new ArrayList<>();
//        }
//        if(trieNode.isEndOfWord()){
//            return trieNode.getPhoneNo();
//        }
//        List<String> phonNoList = new ArrayList<>();
//
//        for(int i=0;i<26;i++){
//            if(trieNode.getTrieChildren()[i]!=null){
//                phonNoList.addAll(getPhonNo(trieNode.getTrieChildren()[i]));
//            }
//
//        }
//        return phonNoList;
//    }
//
//
//    public static void main(String[] args) {
//        TrieTest trieTest = new TrieTest();
//        trieTest.insert("krishna","96");
//        trieTest.insert("kriti","25");
//        trieTest.insert("kran","45");
//        trieTest.insert("pranav","251");
//        trieTest.insert("prakesh","45");
//
//
//        System.out.println(trieTest.search("kri"));
//        System.out.println();
//        System.out.println(trieTest.search("kr"));
//        System.out.println();
//        System.out.println(trieTest.search("pra"));
//        System.out.println();
//        System.out.println(trieTest.search("prak"));
//        System.out.println();
//        System.out.println(trieTest.search("tushar"));
////
////        test.insert("kran","45");
////        test.insert("pranav","251");
////        test.insert("prakesh","45");
//    }
//}
//
//
//@Getter
//@Setter
//class TrieNode {
//    private TrieNode[] trieChildren;
//    private List<String> phoneNo;
//    private boolean isEndOfWord;
//
//    public TrieNode() {
//        trieChildren = new TrieNode[26];
//        phoneNo = new ArrayList<>();
//        isEndOfWord=false;
//        phoneNo.stream().sorted(String::lastIndexOf).forEach(System.out::println);
//    }
//
//    public TrieNode[] getTrieChildren() {
//        return trieChildren;
//    }
//
//    public void setTrieChildren(TrieNode[] trieChildren) {
//        this.trieChildren = trieChildren;
//    }
//
//    public List<String> getPhoneNo() {
//        return phoneNo;
//    }
//
//    public void setPhoneNo(List<String> phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//    public boolean isEndOfWord() {
//        return isEndOfWord;
//    }
//
//    public void setEndOfWord(boolean endOfWord) {
//        isEndOfWord = endOfWord;
//    }
//}
//
