package fangyumin.tank03.collide;

import fangyumin.tank03.Bullet;
import fangyumin.tank03.Tank;
import fangyumin.tank03.Wall;

import java.awt.*;

public class TankWallCollider implements Collider{
    @Override
    public boolean compareCollide(Object o1, Object o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            collideCheck(tank, wall);
        }else if (o1 instanceof Wall && o2 instanceof Tank) {
            compareCollide(o2, o1);
        }
        return false;
    }

    private boolean collideCheck(Tank tank, Wall wall) {

        Rectangle r1 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (r1.intersects(wall.getRectangle())){
            tank.setX(tank.getOldX());
            tank.setY(tank.getOldY());
        }
        return false;
    }
}
