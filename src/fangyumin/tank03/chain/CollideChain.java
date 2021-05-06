package fangyumin.tank03.chain;

import fangyumin.tank03.collide.BulletTankCollider;
import fangyumin.tank03.collide.Collider;
import fangyumin.tank03.collide.TankTankCollider;

import java.util.LinkedList;
import java.util.List;

public class CollideChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public CollideChain() {
        addCollide(new TankTankCollider());
        addCollide(new BulletTankCollider());
    }

    public CollideChain(List<Collider> colliders) {
        this.colliders = colliders;
    }

    public void addCollide(Collider collider) {
        this.colliders.add(collider);
    }


    @Override
    public boolean compareCollide(Object o1, Object o2) {
        return false;
    }

    public void collide(Object front, Object rear) {
        for (int i = 0; i < this.colliders.size(); i++) {
//            colliders.get(i).compareCollide(front, rear);
            if (colliders.get(i).compareCollide(front, rear)) {
                break;
            }
        }
    }
}
