class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for(char c: letters){
            seen[c-'a'] = true;
        }
        for(int i= target -'a' +1; i< 26; i++) {
            if(seen[i]) return (char)(i+ 'a');
        }
        for(int i=0; i<= target -'a';i++){
            if (seen[i]) return (char) (i + 'a');
        }
        return letters[0];
    }
}