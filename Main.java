package task1;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the no. n X n: ");
        int n= in.nextInt();
        int[][] grid = new int[n][n];
        int x,y;
        List<Drone> drones = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter the coordinates of Drone " + (i + 1));
            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();
            drones.add(new Drone(x, y, "drone" + (i + 1)));
            grid[x][y] = 1;
        }
        System.out.println("Enter the coordinates of the target: ");
        System.out.print("X: ");
        x = in.nextInt();
        System.out.print("Y: ");
        y = in.nextInt();
        Drone target = new Drone(x, y, "target");
        List<String> path =
                Drone.getPath(Drone.bfs(grid, drones, target));
        System.out.println("The path is: ");
        for (String loc : path) {
            System.out.print(loc + " -> ");
        }
        System.out.print("Target Reached.");
    }
}
