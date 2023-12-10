package task1;
import java.util.*;

public class Drone implements Comparable<Drone> {
    int x, y;
    Drone next = null;
    String name = "";
    Drone(int x, int y, Drone next){
        this.x = x;
        this.y = y;
        this.next = next;
    }
    Drone(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }
    @Override
    public String toString() {
        if(!name.isEmpty()){
            name = "("+name+")";
        }
        return "[" + x + ", " + y + "]" + name;
    }
    public static Drone bfs(int [][]grid, List<Drone> sources, Drone target){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Drone> queue = new LinkedList<>();
        for(Drone loc: sources){
            queue.add(loc);
        }
        int dirs[][] = new int[][]{{1, 0}, {0, 1},{-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        while(target.compareTo(queue.peek()) != 0){
            Drone source = queue.poll();
            for(int[] dir: dirs){
                int X = source.x+dir[0];
                int Y = source.y+dir[1];
                if((X < 0 || Y < 0) ||(X >= row || Y >= col))
                    continue;
                Drone next = new Drone(X, Y, source);
                if(grid[X][Y] == 0){
                    grid[X][Y] = 1;
                    queue.offer(next);
                }
            }
        }
        return queue.peek();
    }
    public static List<String> getPath(Drone source){
        List<String> path = new ArrayList<>();
        List<String> path1 = new ArrayList<>();
        while(source != null){
            path.add(source.toString());
            source = source.next;
        }
        while(!path.isEmpty()){
            path1.add(path.remove(path.size()-1));
        }
        return path1;
    }

    @Override
    public int compareTo(Drone o) {
        if(x == o.x && y == o.y){
            return 0;
        }
        return 1;
    }
}