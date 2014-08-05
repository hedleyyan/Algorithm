package exercise;

import java.io.File;

public class _1_3_43_ListingFiles {
    
    public static void list (File f, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("      ");
        }
        
        if (f.isDirectory()) {
            System.out.println("[DIRECTORY]" + f.getName());
            for (File subF : f.listFiles()) {
                list(subF, ++index);
                --index;
            }
        } else {
            System.out.println("[FILE]" + f.getName());
        }
    }

    public static void list (String path, int index) {
        File f = new File(path);
        list (f, index);
    }
    
    public static void main(String[] args) {
        list("D:\\SVN\\Docs\\Record", 0);
    }
}
