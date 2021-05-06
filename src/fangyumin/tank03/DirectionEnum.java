package fangyumin.tank03;

public enum DirectionEnum {
    LEFT(0),
    RIGHT(1),
    UP(2),
    DOWN(3);

    private int code;

    public int getCode() {
        return code;
    }

    DirectionEnum(int code) {
        this.code = code;
    }

    public static DirectionEnum getEnumByCode(int code) {
        for (DirectionEnum direction : DirectionEnum.values()) {
            if (direction.getCode() == code) {
                return direction;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int random = (int) (Math.random() * 4);
        System.out.println(DirectionEnum.getEnumByCode(1));
        System.out.println(random);
    }
}
