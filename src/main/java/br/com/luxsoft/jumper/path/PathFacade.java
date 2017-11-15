package br.com.luxsoft.jumper.path;

import br.com.luxsoft.jumper.path.dto.Board;
import br.com.luxsoft.jumper.path.dto.Knight;
import br.com.luxsoft.jumper.path.dto.MovementTreeNode;
import br.com.luxsoft.jumper.path.dto.Piece;

/**
 * Class responsible for simplifying more complex demeanor
 * 
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 * 
 * @since 1.0
 */
public class PathFacade
{
    /**
     * 
     * @param boardSize the size of the board (n x n)
     * @param movement jumper is a chess Knight, possible movements of the piece 
     * based on its position
     * @param stones the coordinates of stones on the board
     * @param start the start point of the piece
     * @param end the endpoint of the piece
     * 
     * @return the number of shortest paths from start location to end location
     * 
     * @version 1.0
     */
    public Integer getKnightShortestPathPossibilities(Integer boardSize, Integer[][] movement,
        Integer[][] stones, Integer[] start, Integer[] end)
    {
        Board b = new Board(boardSize, stones);
        Piece p = new Knight(movement);
        PathSearch path = new PathSearch(b, p);
        MovementTreeNode<Integer> node = new MovementTreeNode<>(null, start);
        PathSearch.ShortestPathWrapper shortest = path.getShortestPath(node, end);
        return shortest.getCount();
    }
}
