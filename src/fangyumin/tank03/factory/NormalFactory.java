package fangyumin.tank03.factory;

import fangyumin.tank03.Explode;
import fangyumin.tank03.RectExplode;
import fangyumin.tank03.facade.GameModel;

public class NormalFactory extends AbstractFactory{

    private final static NormalFactory RECT_FACTORY = new NormalFactory();

    private NormalFactory(){

    }

    public static NormalFactory getInstance(){
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
        return new Explode(x, y, gm);
    }
}
