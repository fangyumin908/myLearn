package fangyumin.tank03;

import fangyumin.tank03.utils.PropertiesLoaderUtil;

import java.io.IOException;
import java.util.Objects;

public class TankRun {
    public static void main(String[] args) throws InterruptedException, IOException {
        TankFrame tankFrame = new TankFrame();

//        for (int i = 0; i < 5; i++) {
//            tankFrame.explodes.add(new Explode(i * 100, 200, tankFrame));
//        }
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
