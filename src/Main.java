import java.util.List;

/**
 * Created by ai.khafizov
 * on 12.05.2022
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Создаем лабиринт размерностью 10 на 10
         * Стартовая позиция 0,0
         * Конечная позиция 9,9
         * 0.2 - 20% заполнение лабиринта препятствиями
         */
        Maze m = new Maze(10, 10, new Maze.MazeLocation(0, 0), new Maze.MazeLocation(9, 9), 0.2);
        System.out.println(m);

        GenericSearch.Node<Maze.MazeLocation> solution1 = GenericSearch.dfs(m.start,
                m::goalTest, m::successors);
        if (solution1 == null) {
            System.out.println("No solution found using depth-first search!");
        } else {
            List<Maze.MazeLocation> path1 = GenericSearch.nodeToPath(solution1);
            m.mark(path1);
            System.out.println(m);
            m.clear(path1);
        }
        GenericSearch.Node<Maze.MazeLocation> solution2 = GenericSearch.bfs(m.start,
                m::goalTest, m::successors);
        if (solution2 == null) {
            System.out.println("No solution found using breadth-first search!");
        } else {
            List<Maze.MazeLocation> path2 = GenericSearch.nodeToPath(solution2);
            m.mark(path2);
            System.out.println(m);
            m.clear(path2);
        }
        GenericSearch.Node<Maze.MazeLocation> solution3 = GenericSearch.astar(m.start,
                m::goalTest, m::successors, m::manhattanDistance);
        if (solution3 == null) {
            System.out.println("No solution found using A*!");
        } else {
            List<Maze.MazeLocation> path3 = GenericSearch.nodeToPath(solution3);
            m.mark(path3);
            System.out.println(m);
            m.clear(path3);
        }
    }
}