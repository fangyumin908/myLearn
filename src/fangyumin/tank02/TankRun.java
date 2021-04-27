package fangyumin.tank02;

public class TankRun {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tankFrame.enemiesTank.add(new Tank(i * 100, 100, DirectionEnum.DOWN, GroupEnum.BAD, tankFrame));
        }
//        for (int i = 0; i < 5; i++) {
//            tankFrame.explodes.add(new Explode(i * 100, 200, tankFrame));
//        }
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
