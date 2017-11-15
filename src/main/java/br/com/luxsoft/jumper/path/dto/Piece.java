package br.com.luxsoft.jumper.path.dto;

/**
 * Represents a piece of a chess game
 * 
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 * 
 * @since 1.0
 */
public abstract class Piece
{
    protected Integer[][] possibleMovement;


    public Piece(Integer[][] possibleMovement)
    {
        this.possibleMovement = possibleMovement;
    }


    public Integer[][] getPossibleMovement()
    {
        return possibleMovement;
    }


    public void setPossibleMovement(Integer[][] possibleMovement)
    {
        this.possibleMovement = possibleMovement;
    }

}
