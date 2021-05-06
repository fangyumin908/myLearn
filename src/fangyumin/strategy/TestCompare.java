package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 11:10
 */
public class TestCompare {
    public static void main(String[] args) {
        Cat cat1 = new Cat("c1",2.0,10);
        Cat cat2 = new Cat("c2",3.0,2);
        Sorter<Cat> comparer = new Sorter<>();
        System.out.println(comparer.sort(cat1, cat2, new CatCompareAge()));
        System.out.println(comparer.sort(cat1, cat2, new CatCompareWeight()));
    }
}
