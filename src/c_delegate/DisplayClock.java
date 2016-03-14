
package c_delegate;

import c_delegate.Clock.TimeInfoEventArgs;

public class DisplayClock implements SecondChangeHandler {

    @Override
    public void handle(Object sender, TimeInfoEventArgs args) {
        System.out.println(String.format("Current Time: %d:%d:%d", args.getHour(), args.getMinute(), args.getSecond()));
    }

}
