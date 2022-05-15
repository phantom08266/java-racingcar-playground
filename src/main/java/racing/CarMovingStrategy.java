package racing;

import java.security.SecureRandom;

public class CarMovingStrategy implements MoveStrategy{

    public static final int BASE_GAME_POINT = 4;

    @Override
    public boolean isMoving() {
       return createGamePoint() >= BASE_GAME_POINT;
    }

    private int createGamePoint() {
        SecureRandom secureRandom = new SecureRandom();
        return  secureRandom.nextInt(8) + 1;
    }
}
