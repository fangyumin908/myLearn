package fangyumin.strategy;

/**
 * @author : fangym01
 * @date : 2021-05-06 10:57
 */
public class Dog {
    private String name;
    private double weight;
    private int age;
    private double food;

    public Dog() {
    }

    public Dog(double weight) {
        this.weight = weight;
    }

    public Dog(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Dog(String name, double weight, int age, double food) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.food = food;
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

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", food=" + food +
                '}';
    }
}
