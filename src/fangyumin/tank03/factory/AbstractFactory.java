package fangyumin.tank03.factory;

import fangyumin.tank03.TankFrame;

public abstract class AbstractFactory {

    abstract BaseTankFactory createTank();

    abstract BaseBulletFactory createBullet();

    abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);
}
