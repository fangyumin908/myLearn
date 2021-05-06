package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 11:20
 */
public interface CompareStrategy<T> {
    int compareField(T o1, T o2);
}
