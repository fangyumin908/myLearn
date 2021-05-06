package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 10:51
 */
public class Sorter<T> {

    public void sort(T[] ts, CompareStrategy<T> compareStrategy) {

        for (int i = 0 ; i < ts.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < ts.length; j++) {
                maxIndex = compareStrategy.compareField(ts[maxIndex], ts[j]) == 1 ? maxIndex : j;
            }
            swap(ts, i, maxIndex);
        }

    }

    private void swap(T[] ts, int i, int maxIndex) {
        T t = ts[i];
        ts[i] = ts[maxIndex];
        ts[maxIndex] = t;
    }
}
