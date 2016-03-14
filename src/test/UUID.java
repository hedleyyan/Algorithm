package test;

import java.util.ArrayList;
import java.util.List;


public class UUID {
    
    public static int UDID_USERNAME_NUM = 50;
    
    
    public static String getUDIDUsernameTable(String udid) {
        return "udid_username_" + String.format("%02d", Math.abs(udid.hashCode() % 50));
    }
    
    
    
    public static void main(String[] args) {
        
        List<String> usernameL = new ArrayList<String>();
        
        usernameL.add("u02216508565_218s");
        usernameL.add("u02216508565_221s");
        
        List<String> sSQL = new ArrayList<String>();
        List<String> uSQL = new ArrayList<String>();
        
        for (String name : usernameL) {
            String accountTable = getAccountTable(name);
//            String sql2 = String.format("select last_server,left(right(reg_servers,6),2) from %s where username='%s';", accountTable, name);
            String sql2 = String.format("select * from %s where username='%s';", accountTable, name);
            String sql1 = String.format("update %s set last_server=(left(right(reg_servers,6),2)) where username='%s';", accountTable, name);
            
            sSQL.add(sql2);
            uSQL.add(sql1);
        }
        
        for (int i = 0; i < sSQL.size(); i++) {
            System.out.println(sSQL.get(i));
        }
        
        for (int i = 0; i < uSQL.size(); i++) {
            System.out.println(uSQL.get(i));
        }
        
        
        testGmail();
        testGmailGPGID();
        testUUID();
    }
    
    
    public static String getAccountTable(String username) {
        return "account_" + String.format("%02d", Math.abs(username.hashCode() % 100));
    }
    
    
    public static String getGPAccountUsernameTable(String gpAccount) {
        return "gp_account_username_"
                + String.format("%02d", Math.abs(gpAccount.hashCode() % UDID_USERNAME_NUM));
    }
    
    
    public static String aoe2_register_getUsernameByGpAccount(String gpAccount) {
        String gpTable = getGPAccountUsernameTable(gpAccount);
        String sql = "select username from " + gpTable + " where google_plus_account='" + gpAccount + "'";
        return sql;
    }
    
    public static void testGmail() {
        List<String> emails = new ArrayList<String>();
        emails.add("bigrowe23@gmail.com");
        emails.add("whiteman992@gmail.com");
        emails.add("eric-duval@hotmail.com");
        
        for (String email : emails) {
            System.out.println(aoe2_register_getUsernameByGpAccount(email));
        }
    }
    
    
    
    
    
    public static String aoe2_register_getUsernameByGpgId(String gpgId) {
        String gpgTable = getGPGidUsernameTable(gpgId);
        String sql = "select username from " + gpgTable + " where google_play_games_id='" + gpgId + "'";
        return sql;
    }
    
    public static String getGPGidUsernameTable(String gpgId) {
        return "gpg_id_username_" + String.format("%02d", Math.abs(gpgId.hashCode() % UDID_USERNAME_NUM));
    }
    
    public static void testGmailGPGID() {
        List<String> emails = new ArrayList<String>();
        emails.add("102951299122124038802");
        emails.add("105365854072490533874");
        emails.add("100745061707252356682");
        
        for (String email : emails) {
            System.out.println(aoe2_register_getUsernameByGpgId(email));
        }
    }
    
    
    public static void testUUID() {
        List<String> udids = new ArrayList<String>();
        udids.add("353768051338759-B0C4E7B60C57");
        
        for (String udid : udids) {
            System.out.println(getUDIDUsernameTable(udid));
        }
    }
}
