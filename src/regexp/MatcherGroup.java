package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherGroup {
    public static void main(String[] args) {
        String response = "{\"orderId\":\"12999763169054705758.1337077487510810\",\"packageName\":\"com.stac.empire.main\",\"productId\":\"gold_102\",\"purchaseTime\":1433862617781,\"purchaseState\":0,\"developerPayload\":\"{\"server_id\":249,\"user_id\":3087}\",\"purchaseToken\":\"pbjckjlcapkeiifnpgohlkcc.AO-J1Ox0gdvhfQGSzqrDZTjwFzl1KLbsx6JeZeY1DQQCQmRafUcae5Yga4FSDVCchmte7rNOhp3_QhlY0ACWwAI5yBQVc7PSDFpS_zRrhq4waCJcVZiWMo0\"}";
        Pattern pattern = Pattern.compile(".*\"server_id\":([0-9]+).*\"user_id\":([0-9]+).*");
        Matcher m = pattern.matcher(response);
        if (m.find()) {
            int rServerId = Integer.valueOf(m.group(1));
            int rUserId = Integer.valueOf(m.group(2));
            if (rServerId != 249 || rUserId != 3087) {
                String message = String.format("deal response info:{server_id:%d, user_id:%d}", rServerId, rUserId);
                System.out.println(message);
            }
        }
    }
}
