package chapter3;
// Your code complexity score is 25.92 (best for this step is 21.73).
import java.util.Random;
import chapter3.Direction;

public class Exercise_33_2 {
    public static void main(String[] args) {
        int toX = new Random().nextInt(100);;
        int toY = new Random().nextInt(100);;
        Robot myRobby = new Robot();
        System.out.println("Head: " + myRobby.getDirection());
        System.out.println("Робот (" + myRobby.getX() + " : " + myRobby.getY() + ")");
        System.out.println("Точка (" + toX + " : " + toY + ")");

        moveRobot(myRobby, toX, toY);
        System.out.println("");
        if (myRobby.getX() == toX && myRobby.getY() == toY){
            System.out.println("Робот в заданной точке");
        }
        else {
            System.out.println("Ошибка:");
            System.out.println("    HeadP: " + myRobby.getDirection());
            System.out.println("    Робот (" + myRobby.getX() + " : " + myRobby.getY() + ")");
        }
    }
    public static void moveRobot(Robot robot, int toX, int toY) {
        class Solve {
            Robot rob;
            Solve(Robot rob){
                this.rob = rob;
            }
            void posHead(Direction dir) {
                while (rob.getDirection() != dir){
                    rob.turnLeft();
                }
            }
            void moveBody(int pos, Direction dir1, Direction dir2) {
                if (pos != 0){
                    this.posHead((pos < 0) ? dir1: dir2);
                    for (int i = 1; i<= Math.abs(pos); i++ )
                        robot.stepForward();
                }
            }

        }
        Solve solver = new Solve(robot);
        solver.moveBody(toX - robot.getX(), Direction.LEFT, Direction.RIGHT);
        solver.moveBody(toY - robot.getY(), Direction.DOWN, Direction.UP);
    }
}
