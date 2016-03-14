
package test;

import java.util.HashMap;
import java.util.Map;

public class Gem {

    public static void main(String[] args) {
        cal(4, 0, 2, 88);
//        cal(100, 6757, 6, 535970);
//        cal(70, 4787, 6, 219970);
    }
    
    // 扣除等级后
    public static void cal(int level, int exp, int star, int decExp) {
        int newExp = exp - decExp;
        int newLevel = level;
        while (newExp < 0) {
            newLevel--;
            newExp += getLevelExp(newLevel, star);
        }
        
        System.out.println(newLevel);
        System.out.println(newExp);
    }

    //根据等级和星级获取该等级的升级经验
    public static int getLevelExp(int level, int star) {

        Map<Integer, Double> map = new HashMap<Integer, Double>();
        map.put(1, 1.0);
        map.put(2, 1.5);
        map.put(3, 2.0);
        map.put(4, 2.5);
        map.put(5, 3.0);
        map.put(6, 4.0);
        map.put(7, 6.0);

        double star_exp = map.get(star);
        return (int)((level * (int)((level + 11) / 10.0f + 1) + 1) * star_exp) * 4;
    }

}
