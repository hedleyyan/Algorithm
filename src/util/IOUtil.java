package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class IOUtil {
    
    /**
     * <pre>
     * 一次性读取文件，返回字符串.
     * 
     * date: 2014年8月5日
     * </pre>
     * @author yandeli
     * @param file
     * @param encoding
     * @return
     */
    public static String readToString(File file, String encoding) {
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String result = null;
        try {
            result = new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
        }
        return result;
    }
    
    public static String readToString(String path, String encoding) {
        return readToString(new File(path), encoding);
    }
}
