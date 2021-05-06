package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 17:22
 */
public class DogCompareFood implements CompareStrategy<Dog>{

    @Override
    public int compareField(Dog o1, Dog o2) {
        if (o1.getFood() > o2.getFood()) return 1;
        if (o1.getFood() < o2.getFood()) return -1;
        return 0;
    }
}
