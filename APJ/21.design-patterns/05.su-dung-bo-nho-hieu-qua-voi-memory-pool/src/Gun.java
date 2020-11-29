import java.util.ArrayList;
import java.util.List;

public class Gun {
    private final List<Bullet> bulletFiringList = new ArrayList<>();
    private final BulletPool pool = new BulletPool();
    private boolean isUsingPool;

    public void fireInPool() {
        isUsingPool = true;
        firingBullets();
    }

    public void fire() {
        isUsingPool = false;
        firingBullets();
    }

    private void firingBullets() {
        bulletFiringList.clear();
        int BULLET_COUNT = 1000;
        for (int i = 0; i < BULLET_COUNT; i++) {
            handleCurrentShot();
        }
    }

    private void handleCurrentShot() {
        firingNewBullet();
        handleFlyingBullets();
    }

    private void firingNewBullet() {
        Bullet bullet = getNewBullet();
        addBulletToFiringList(bullet);
    }

    private Bullet getNewBullet() {
        return isUsingPool ? pool.getNewItem() : new Bullet();
    }

    private void addBulletToFiringList(Bullet bullet) {
        bullet.setPosition(0);
        bulletFiringList.add(bullet);
    }

    private void handleFlyingBullets() {
        for (int j = 0; j < bulletFiringList.size(); j++) {
            handleBulletOfIndex(j);
        }
        System.out.println();
    }

    private void handleBulletOfIndex(int index) {
        Bullet currentBullet = bulletFiringList.get(index);
        moveAndPrintCurrentBullet(currentBullet);
        handleBulletOutOfRange(currentBullet);
    }


    private void moveAndPrintCurrentBullet(Bullet currentBullet) {
        currentBullet.move();
        System.out.print("-" + currentBullet.getPosition());
    }

    private void handleBulletOutOfRange(Bullet currentBullet) {
        if (isOutOfRange(currentBullet)) {
            freeCurrentBulletIfUsingPool(currentBullet);
            bulletFiringList.remove(currentBullet);
        }
    }

    private boolean isOutOfRange(Bullet pp) {
        return pp.getPosition() == 10;
    }

    private void freeCurrentBulletIfUsingPool(Bullet currentBullet) {
        if (isUsingPool)
            pool.freeItem(currentBullet);
    }
}
