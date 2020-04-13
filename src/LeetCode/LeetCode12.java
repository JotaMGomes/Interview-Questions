package LeetCode;
// https://leetcode.com/problems/implement-strstr/
// Jose Luiz Mattos Gomes

public class LeetCode12 {

	public static void main(String[] args) {
		Solution12 vSolution = new Solution12();
		
		System.out.println(vSolution.strStr("hello","ll"));

	}

}

class Solution12 {
    public int strStr(String haystack, String needle) {
    	return haystack.indexOf(needle);
    }
}