package chapter3;

import chapter3.Direction;
import java.util.Random;

public class Robot {
    private int x = new Random().nextInt(100);
    private int y = new Random().nextInt(100);
    private int dir = new Random().nextInt(4);

    public Direction getDirection() {
        // текущее направление взгляда
        return Direction.values()[dir];
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        dir = --dir < 0 ? 3 : dir;
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        dir = ++dir % 4;
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (this.getDirection()){
            case UP: y++; break;
            case DOWN: y--; break;
            case LEFT: x--; break;
            case RIGHT: x++; break;
        }


    }
}
