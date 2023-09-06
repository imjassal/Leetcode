import java.util.*;
public class Leetcode_68 {
    public static void main(String[] args) {
        String[] words= {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        fullJustify(words,20);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> currWords = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int currentWidth = 0;
        for(String word:words){
            currentWidth+=word.length();
            if(currentWidth<=maxWidth){
                currWords.add(word);
                currentWidth++;
            }
            else{
                currentWidth-=word.length()+1;
                fillAnsList(ans,currWords,maxWidth,currentWidth);
                currWords = new ArrayList<>();
                currWords.add(word);
                currentWidth = word.length();
                currentWidth++;
            }
        }
        fillAnsList(ans,currWords,maxWidth,--currentWidth);
        return ans;
    }

    public static void fillAnsList(List<String> ans,List<String> currWords,int maxWidth,int currWidth){
        int currWordCount = currWords.size();
        int extraWordsSpaces = currWordCount-1;
        StringBuilder sb = new StringBuilder();
        if(maxWidth==currWidth){
            for(int i=0;i<currWords.size();i++) {
                sb.append(currWords.get(i));
                if(1!=currWords.size()-1)
                    sb.append(" ");
            }
            ans.add(sb.toString());
        }
        else if(maxWidth>currWidth){
            currWidth-=extraWordsSpaces;
            int diff = maxWidth-currWidth;
            int extraSpace = 0;
            int extraSpaceForFirst = 0;
            if(extraWordsSpaces==0)
                extraSpaceForFirst = diff;
            else {
                 extraSpace = diff / (currWordCount - 1);
                 extraSpaceForFirst = diff % (currWordCount - 1);
            }
            extraSpaceForFirst+=extraSpace;
            for(int i=0;i<currWords.size();i++){
                sb.append(currWords.get(i));
                if(i==0)
                    for(int j=0;j<extraSpaceForFirst;j++){
                        sb.append(" ");
                    }
                else if(i!=currWords.size()-1)
                    for(int j=0;j<extraSpace;j++){
                        sb.append(" ");
                    }
            }
            ans.add(sb.toString());
        }
    }
}
