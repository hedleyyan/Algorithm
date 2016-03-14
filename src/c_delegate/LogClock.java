
package c_delegate;

import c_delegate.Clock.TimeInfoEventArgs;

public class LogClock implements SecondChangeHandler {

    @Override
    public void handle(Object sender, TimeInfoEventArgs args) {
        System.out.println(String.format("Logging to file: %d:%d:%d", args.getHour(), args.getMinute(),
                args.getSecond()));
    }

}
