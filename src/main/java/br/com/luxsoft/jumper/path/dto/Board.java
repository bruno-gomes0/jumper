package br.com.luxsoft.jumper.path.dto;

/**
 * Represents the board of a chess game, wrapping a matrix for coordinates
 * 
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 * @since 1.0
 */
public class Board
{
    private Integer[][] boardMatrix;


    public Board(Integer size, Integer[][] stones)
    {
        initializeBoard(size, stones);
    }


    /**
     * 
     * @param size the size of the board (n x n)
     * @param stones the stones on the board
     * 
     * @since 1.0
     */
    private void initializeBoard(Integer size, Integer[][] stones)
    {
        boardMatrix = new Integer[size][size];
        for (Integer[] is : boardMatrix)
        {
            for (int i = 0; i < is.length; i++)
            {
                is[i] = 0;
            }
        }
        for (Integer[] stone : stones)
        {

            boardMatrix[stone[0] - 1][stone[1] - 1] = -1;
        }
    }


    public Integer[][] getBoardMatrix()
    {
        return boardMatrix;
    }


    public void setBoardMatrix(Integer[][] boardMatrix)
    {
        this.boardMatrix = boardMatrix;
    }

}
