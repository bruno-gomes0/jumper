package br.com.luxsoft.jumper.path;

import br.com.luxsoft.jumper.path.dto.MovementTreeNode;
import br.com.luxsoft.jumper.path.dto.Board;
import br.com.luxsoft.jumper.path.dto.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for Path operations based on a {@link Piece} and a {@link Board}
 * 
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 * 
 * @since 1.0
 */
class PathSearch
{

    private Board board;
    private Piece piece;


    public PathSearch(Board board, Piece piece)
    {
        this.board = board;
        this.piece = piece;
    }


    /**
     * Prepare a {@link ShortestPathWrapper} object using an algorithm based on 
     * depth-first search
     * 
     * @param node the root of the tree, being the start spot of a piece on the 
     * board
     * @param end the desired end coordinates of the piece on the board
     * 
     * @return a {@link ShortestPathWrapper} containing the count of possible 
     * shortest paths and the quantity of moves
     * 
     * @version 1.0
     */
    public ShortestPathWrapper getShortestPath(MovementTreeNode<Integer> node, Integer[] end)
    {
        ShortestPathWrapper path = new ShortestPathWrapper();
        search(path, node, end, 1);
        return path;
    }

    /**
     * Wrapper of shortest possible moves and paths quantity
     * 
     * @version 1.0
     */
    class ShortestPathWrapper
    {
        private Integer shortest = null;
        private Integer count = 0;


        public Integer getShortest()
        {
            return shortest;
        }


        public void setShortest(Integer shortest)
        {
            this.shortest = shortest;
        }


        public Integer getCount()
        {
            return count;
        }


        public void setCount(Integer count)
        {
            this.count = count;
        }

    }


    /**
     * Recursive method using a modified depth search algorithm for finding 
     * the amount of shortest paths
     * 
     * Recursion was used for simplifying algorithm reading and comprehension.
     * 
     * {@link MovementTreeNode} objects have a visited attribute in order to grant
     * the graph search to be acyclic
     * 
     * @param path the shortest path reference 
     * @param node the current node on recursion (should be started using the first node)
     * @param end the end coordinates measured
     * @param depth the current depth of the tree (by definition, depth = parent's depth +1)
     * 
     * @version 1.0
     */
    private void search(final ShortestPathWrapper path, MovementTreeNode<Integer> node, Integer[] end, int depth)
    {
        
        board.getBoardMatrix()[node.getCoordinates()[0] - 1][node.getCoordinates()[1] - 1] = 1;
        node.setChildren(buildChildren(node));
        List<MovementTreeNode<Integer>> children = node.getChildren();
        for (int i = 0; i < children.size(); i++)
        {
            MovementTreeNode<Integer> n = children.get(i);
            if (n != null && !n.isVisited())
            {
                if (n.getCoordinates()[0] == end[0]
                    && n.getCoordinates()[1] == end[1])
                {
                    if (path.getShortest() == null
                        || path.getShortest() > depth)
                    {
                        path.setShortest(depth);
                        path.setCount(0);
                    }
                    path.setCount(path.getCount() + 1);
                }
                else if (path.getShortest() == null
                    || path.getShortest() > depth)
                {
                    
                    search(path, n, end, depth + 1);
                    n.setVisited(true);
                    board.getBoardMatrix()[n.getCoordinates()[0] - 1][n.getCoordinates()[1] - 1] = 0;
                }

            }
        }
    }

    /**
     * Builds all the possible children based on the board
     * 
     * @param element the parent element of the child elements
     * @return a List of {@link MovementTreeNode} based on the parent element
     * 
     * @version 1.0
     */
    private List<MovementTreeNode<Integer>> buildChildren(MovementTreeNode<Integer> element)
    {
        List<MovementTreeNode<Integer>> children = new ArrayList<>();
        Integer[] elementCoor = element.getCoordinates();
        for (Integer[] coordinates : piece.getPossibleMovement())
        {
            Integer[] childCoor = new Integer[2];
            childCoor[0] = elementCoor[0] + coordinates[0];
            childCoor[1] = elementCoor[1] + coordinates[1];
            if (childCoor[0] - 1 >= 0 && childCoor[1] - 1 >= 0
                && board.getBoardMatrix().length >= childCoor[0]
                && board.getBoardMatrix()[childCoor[0] - 1].length >= childCoor[1]
                && board.getBoardMatrix()[childCoor[0] - 1][childCoor[1] - 1] == 0)
            {
                children.add(new MovementTreeNode<>(element, childCoor));
            }
        }
        return children;
    }
}
