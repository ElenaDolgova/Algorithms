package Lafore.Chap6_Recursion;

import Lafore.Chap6_Recursion.Anagram;
import org.junit.Test;

public class Anagram_Test {
    Anagram anagram = new Anagram("qwertyuiopa");
    //Anagram anagram = new Anagram("cat");

    @Test
    public void anagram_Test(){
        anagram.doAnagram(11);
        System.out.println(anagram.count);
    }
}
