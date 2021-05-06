package fangyumin.tank03.collide;

import fangyumin.tank03.*;
import fangyumin.tank03.factory.RectFactory;

import java.awt.*;

/**
 * 坦克与坦克相撞的逻辑动作实现
 */
public class TankTankCollider implements Collider{
    @Override
    public boolean compareCollide(Object o1, Object o2) {

        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            collideCheck(t1, t2);
        }
        return false;

    }

    private void collideCheck(Tank t1, Tank t2) {
        int t1Width,t1Height;
        int t2Width,t2Height;
        if (t1.getGroup() == GroupEnum.BAD){
            t1Width = Tank.BAD_WIDTH;
            t1Height = Tank.BAD_HEIGHT;
        }else {
            t1Width = Tank.WIDTH;
            t1Height = Tank.HEIGHT;
        }
        if (t2.getGroup() == GroupEnum.BAD){
            t2Width = Tank.BAD_WIDTH;
            t2Height = Tank.BAD_HEIGHT;
        }else {
            t2Width = Tank.WIDTH;
            t2Height = Tank.HEIGHT;
        }
        Rectangle r1 = new Rectangle(t1.getX(), t1.getY(), t1Width, t1Height);
        Rectangle r2 = new Rectangle(t2.getX(), t2.getY(), t2Width, t2Height);
        if (r1.intersects(r2)){

            if (t1.getGroup().equals(GroupEnum.BAD)) {
                changeDirection(t1);
            }
            if (t2.getGroup().equals(GroupEnum.BAD)) {
                changeDirection(t2);
            }
            t1.setX(t1.getOldX());
            t1.setY(t1.getOldY());
            t2.setX(t2.getOldX());
            t2.setY(t2.getOldY());

        }
    }

    public static void changeDirection(Tank tank) {

        int random = 0;
        //敌方坦克才改变方向
        if (tank.getGroup().equals(GroupEnum.BAD)) {
            do{
                random = (int) (Math.random() * 4);

            }while (tank.getDirection().getCode() == random);
            tank.setDirection(DirectionEnum.getEnumByCode(random));
        }

    }

    private int getRandomInt() {
        //随机数字，代表随机方向
        return (int) (Math.random() * 4);
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.setGroup(GroupEnum.BAD);
        tank.setDirection(DirectionEnum.DOWN);
        changeDirection(tank);
        System.out.println(tank.getDirection());
    }

}
