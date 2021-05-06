package fangyumin.strategy;

import java.util.Arrays;

/**
 * @author : fangym01
 * @date : 2021-05-06 11:10
 */
public class TestCompare {
    public static void main(String[] args) {
        Cat cat1 = new Cat("c1",2.0,10);
        Cat cat2 = new Cat("c2",3.0,2);
        Cat cat3 = new Cat("c3",1.0,2);
        Cat cat4 = new Cat("c4",5.0,3);
        Cat [] sortByWeight = {cat3, cat4, cat1, cat2};
        Cat [] sortByAge = {cat1, cat4, cat3, cat2};
        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sort(sortByWeight, new CatCompareWeight());
        catSorter.sort(sortByAge, new CatCompareAge());
        System.out.println("根据猫的weight排序 ： " + Arrays.toString(sortByWeight));
        System.out.println("根据猫的age排序 ： " + Arrays.toString(sortByAge));

        Dog dog1 = new Dog("d1", 1.0, 1, 1.1);
        Dog dog2 = new Dog("d2", 2.0, 2, 1.2);
        Dog dog3 = new Dog("d3", 3.0, 3, 1.3);
        Dog dog4 = new Dog("d4", 4.0, 4, 1.4);
        Dog dog5 = new Dog("d5", 5.0, 5, 1.5);
        Dog [] sortByFood = {dog2, dog3, dog5, dog1, dog4};
        Sorter<Dog> dogSorter = new Sorter<>();
        System.out.println("未排序前 ： " + Arrays.toString(sortByFood));
        dogSorter.sort(sortByFood, new DogCompareFood());
        System.out.println("根据狗的food排序 ： " + Arrays.toString(sortByFood));
//        System.out.println(comparer.sort(cats, new CatCompareAge()));
//        System.out.println(comparer.sort(cats, new CatCompareWeight()));
    }
}
