public class NpeThief {
    public void callManyNPEInLoop() {
        for (int i = 0; i <= 100000; i++) {
            try {
                ((Object)null).getClass();
            } catch (Exception e) {
                // This will switch from 2 to 0 (indicating our problem is happening)
                System.out.println(e.getStackTrace().length);
            }
        }
    }
    public static void main(String ... args) {
        NpeThief thief = new NpeThief();
        thief.callManyNPEInLoop();
    }
}