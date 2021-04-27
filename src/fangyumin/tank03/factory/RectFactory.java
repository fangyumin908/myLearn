package fangyumin.tank03.factory;

import fangyumin.tank03.RectExplode;
import fangyumin.tank03.TankFrame;
import fangyumin.tank03.facade.GameModel;

public class RectFactory extends AbstractFactory{

    private final static RectFactory RECT_FACTORY = new RectFactory();

    private RectFactory(){

    }

    public static RectFactory getInstance(){
        return RECT_FACTORY;
    }

    @Override
    BaseTankFactory createTank() {
        return null;
    }

    @Override
    BaseBulletFactory createBullet() {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, GameModel gm) {
        return new RectExplode(x, y, gm);
    }
}
