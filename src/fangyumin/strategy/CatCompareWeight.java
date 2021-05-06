package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 11:22
 */
public class CatCompareWeight implements CompareStrategy<Cat>{

    @Override
    public int compareField(Cat o1, Cat o2) {
        if (o1.getWeight() > o2.getWeight()) return 1;
        if (o1.getWeight() < o2.getWeight()) return -1;
        return 0;
    }
}
