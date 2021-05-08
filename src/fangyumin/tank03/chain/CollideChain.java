package fangyumin.tank03.chain;

import fangyumin.tank03.collide.*;

import java.util.LinkedList;
import java.util.List;

public class CollideChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public CollideChain() {
        addCollide(new TankTankCollider());
        addCollide(new BulletTankCollider());
        addCollide(new BulletWallCollider());
        addCollide(new TankWallCollider());
    }

    public CollideChain(List<Collider> colliders) {
        this.colliders = colliders;
    }

    public void addCollide(Collider collider) {
        this.colliders.add(collider);
    }


    @Override
    public boolean compareCollide(Object o1, Object o2) {
        for (int i = 0; i < this.colliders.size(); i++) {
//            colliders.get(i).compareCollide(front, rear);
            if (colliders.get(i).compareCollide(o1, o2)) {
                return true;
            }
        }
        return false;
    }

    public void collide(Object front, Object rear) {
        for (int i = 0; i < this.colliders.size(); i++) {
            if (colliders.get(i).compareCollide(front, rear)) {
                break;
            }
        }
    }
}
