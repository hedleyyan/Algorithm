package sort;

import java.util.List;

public interface InfoProducer {
    <T extends Comparable<? super T>> void show(List<? extends T> l);
}
