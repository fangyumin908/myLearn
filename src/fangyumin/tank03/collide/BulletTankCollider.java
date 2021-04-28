package fangyumin.tank03.collide;

import fangyumin.tank03.Bullet;
import fangyumin.tank03.Explode;
import fangyumin.tank03.GroupEnum;
import fangyumin.tank03.Tank;
import fangyumin.tank03.factory.RectFactory;

import java.awt.*;

/**
 * 子弹与坦克相撞检测实现
 */
public class BulletTankCollider implements Collider {
    @Override
    public void compareCollide(Object o1, Object o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            collideCheck(bullet, tank);
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            compareCollide(o2, o1);
        }
    }

    private void collideCheck(Bullet bullet,Tank enemyTank) {
        if (bullet.getGroup() == GroupEnum.BAD) return;
        if (bullet.getGroup() == GroupEnum.GOOD && enemyTank.getGroup() == GroupEnum.GOOD) return;

        Rectangle r1 = new Rectangle(bullet.getX(), bullet.getY(), Bullet.WIDTH, Bullet.HEIGHT);
        Rectangle r2 = new Rectangle(enemyTank.getX(), enemyTank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (r1.intersects(r2)){
            int explodeX = enemyTank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int explodeY = enemyTank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;

            bullet.getGm().getGameObjects().add(RectFactory.getInstance().createExplode(explodeX,explodeY,bullet.getGm()));
            bullet.die();
            enemyTank.die();
        }
    }
}
