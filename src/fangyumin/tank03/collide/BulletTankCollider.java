package fangyumin.tank03.collide;

import fangyumin.tank03.Bullet;
import fangyumin.tank03.Explode;
import fangyumin.tank03.GroupEnum;
import fangyumin.tank03.Tank;
import fangyumin.tank03.factory.NormalFactory;

import java.awt.*;

/**
 * 子弹与坦克相撞检测实现
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean compareCollide(Object o1, Object o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            return collideCheck(bullet, tank);
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            return compareCollide(o2, o1);
        }
        return false;
    }

    private boolean collideCheck(Bullet bullet,Tank tank) {
        if (bullet.getGroup() == GroupEnum.BAD) return false;
        if (bullet.getGroup() == GroupEnum.GOOD && tank.getGroup() == GroupEnum.GOOD) return false;

        Rectangle r1 = new Rectangle(bullet.getX(), bullet.getY(), Bullet.WIDTH, Bullet.HEIGHT);
        Rectangle r2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (r1.intersects(r2)){
            int explodeX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int explodeY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;

            bullet.getGm().getGameObjects().add(NormalFactory.getInstance().createExplode(explodeX,explodeY,bullet.getGm()));
            bullet.die();
            tank.die();
            return true;
        }
        return false;
    }
}
