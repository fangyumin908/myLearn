package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 10:51
 */
public class Sorter<T> {

    public int sort(T o1, T o2, CompareStrategy<T> compareStrategy) {

        return compareStrategy.compareField(o1, o2);

    }
}
