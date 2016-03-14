package c_delegate;

import c_delegate.Clock.TimeInfoEventArgs;

public interface SecondChangeHandler {
    public void handle(Object sender, TimeInfoEventArgs args);
}
