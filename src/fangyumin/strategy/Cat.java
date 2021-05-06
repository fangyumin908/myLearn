package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 10:57
 */
public class Cat {
    private String name;
    private double weight;
    private int age;

    public Cat() {
    }

    public Cat(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
