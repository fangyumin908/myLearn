package fangyumin.tank03.collide;

import fangyumin.tank03.*;
import fangyumin.tank03.factory.NormalFactory;

import java.awt.*;

public class BulletWallCollider implements Collider{
    @Override
    public boolean compareCollide(Object o1, Object o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet =  (Bullet) o1;
            Wall wall = (Wall) o2;
            collideCheck(bullet, wall);
        }else if (o1 instanceof Wall && o2 instanceof Bullet) {
            compareCollide(o2, o1);
        }
        return false;
    }

    private boolean collideCheck(Bullet bullet, Wall wall) {

        Rectangle r1 = new Rectangle(bullet.getX(), bullet.getY(), Bullet.WIDTH, Bullet.HEIGHT);
        if (r1.intersects(wall.getRectangle())){
            bullet.die();
        }
        return false;
    }
}
