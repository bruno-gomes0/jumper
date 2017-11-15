package br.com.luxsoft.jumper;

import br.com.luxsoft.jumper.path.PathFacade;

/**
 * Main thread of the application This is where the application runs the
 * algorithm with preset parameters
 *
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 *
 * @since 1.0
 */
public class Application extends Thread {

    private PathFacade facade = new PathFacade();

    public static void main(String[] args) {
        new Application().start();
    }

    @Override
    public void start() {

        Integer size = 8;
        Integer[][] movement = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
        Integer[][] stones = {{1, 6}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {1, 5}, {4, 5}};
        Integer[] start = {1, 8};
        Integer[] end = {1, 1};
        Integer paths = facade.getKnightShortestPathPossibilities(size, movement, stones, start, end);
        System.out.println(String.format("The number of shortest paths from start location to end location is %d", paths));

    }

}
