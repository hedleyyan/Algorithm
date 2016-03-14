package emoji;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiParser;

public class EmojiTest {
    public static void main(String[] args) {
        EmojiParser.parseToAliases("");
        
//        String str = "An 😀awesome 😃string with a few 😉emojis!";
//        String str = "\u1111";
//        String str = "\uF09F\u9884";
//        String result = EmojiParser.parseToAliases(str);
//        System.out.println(result);
        
        
        
        String str = "An :zap:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);
        
        System.out.println( "\\u" + Integer.toHexString('⚡' | 0x10000).substring(1) );
    }
}
