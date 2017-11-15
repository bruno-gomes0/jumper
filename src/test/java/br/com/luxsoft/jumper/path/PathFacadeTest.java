package br.com.luxsoft.jumper.path;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test implementation of {@link PathFacade}
 * 
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 * 
 * @since 1.0
 */
@RunWith(value = Parameterized.class)
public class PathFacadeTest {

    @Parameter
    public PathFacadeTestWrapper pathFacadeTestWrapper;

    @Parameters(name = "Test of number {index}: Shortest Path")
    public static Collection<PathFacadeTestWrapper> data() {
        Collection<PathFacadeTestWrapper> testCases = new ArrayList<PathFacadeTestWrapper>();
        testCases.add(new PathFacadeTestWrapper(8,
                new Integer[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}},
                new Integer[][]{{1, 6}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {1, 5}, {4, 5}},
                new Integer[]{1, 8},
                new Integer[]{1, 1},
                3));
        testCases.add(new PathFacadeTestWrapper(8,
                new Integer[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}},
                new Integer[][]{{1, 6}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {7, 6}, {8, 6},
                {1, 5}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}, {8, 5}},
                new Integer[]{1, 8},
                new Integer[]{1, 1},
                0));

        testCases.add(new PathFacadeTestWrapper(8,
                new Integer[][]{{1, 1}, {-1, 1}, {1, -1}, {-1, -1}},
                new Integer[][]{{1, 6}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {8, 6},
                {1, 5}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}},
                new Integer[]{1, 8},
                new Integer[]{1, 1},
                0));

        testCases.add(new PathFacadeTestWrapper(8,
                new Integer[][]{{1, 1}, {-1, 1}, {1, -1}, {-1, -1}},
                new Integer[][]{{1, 6}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {8, 6},
                {1, 5}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}},
                new Integer[]{1, 8},
                new Integer[]{1, 2},
                8));

        testCases.add(new PathFacadeTestWrapper(8,
                new Integer[][]{{1, 1}, {-1, 1}, {1, -1}, {-1, -1}},
                new Integer[][]{
                    {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1},
                    {5, 2}, {6, 2},
                {5, 3}, {6, 3},
                {5, 4}, {6, 4},
                {3, 5}, {4, 5},{5, 5}, {6, 5},
                {5, 6}, {6, 6},
                {5, 2}, {6, 2}},
                new Integer[]{8, 1},
                new Integer[]{1, 2},
                2));
        
        testCases.add(new PathFacadeTestWrapper(9,
                new Integer[][]{{1, 1}, {-1, 1}, {1, -1}, {-1, -1}},
                new Integer[][]{
                    {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1},
                    {5, 2}, {6, 2},
                {5, 3}, {6, 3},
                {5, 4}, {6, 4},
                {3, 5}, {4, 5},{5, 5}, {6, 5},
                {5, 6}, {6, 6},
                {5, 2}, {6, 2}},
                new Integer[]{9, 1},
                new Integer[]{1, 3},
                12));
        return testCases;
    }

    /**
     * Test of getKnightShortestPathPossibilities method, of class PathFacade.
     */
    @Test
    public void testGetKnightShortestPathPossibilities() {
        PathFacade instance = new PathFacade();

        Integer result = instance.getKnightShortestPathPossibilities(pathFacadeTestWrapper.boardSize,
                pathFacadeTestWrapper.movement, pathFacadeTestWrapper.stones,
                pathFacadeTestWrapper.start, pathFacadeTestWrapper.end);
        assertEquals(pathFacadeTestWrapper.expected, result);

    }

    private static class PathFacadeTestWrapper {

        private Integer boardSize;
        private Integer[][] movement;
        private Integer[][] stones;
        private Integer[] start;
        private Integer[] end;
        private Integer expected;

        public PathFacadeTestWrapper(Integer boardSize, Integer[][] movement, Integer[][] stones, Integer[] start, Integer[] end, Integer expected) {
            this.boardSize = boardSize;
            this.movement = movement;
            this.stones = stones;
            this.start = start;
            this.end = end;
            this.expected = expected;
        }

    }

}
