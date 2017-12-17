package jp.techacademy.youko.wakou.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by appu2 on 2017/12/17.
 */

public class Enemy extends GameObject {

    public static final float ENEMY_WIDTH = 0.3f;
    public static final float ENEMY_HEIGHT = 0.3f;
    //    敵キャラが落ちる
    public static final int ENEMY_STATE_FALL = 1;
//    敵キャラがプレイヤーとぶつかる
    public static final int ENEMY_NONE = 1;
    //    速度
    public static final float ENEMY_MOVE_VELOCITY = 20.0f;

    int mState;

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        mState = ENEMY_STATE_FALL;
    }

    public void update(float delta, float accelX) {
        velocity.add(0, GameScreen.GRAVITY * delta);
        velocity.x = -accelX / 10 * ENEMY_MOVE_VELOCITY;
        setPosition(getX() + velocity.x * delta, getY() + velocity.y * delta);

        mState = ENEMY_STATE_FALL;

        if (getX() + ENEMY_WIDTH / 2 < 0) {
            setX(GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2);
        } else if (getX() + ENEMY_WIDTH / 2 > GameScreen.WORLD_WIDTH) {
            setX(0);
        }

    }
//    敵キャラにぶつかったとき
    public void danger(){
        mState = ENEMY_NONE;
        setAlpha(0);

    }
}
