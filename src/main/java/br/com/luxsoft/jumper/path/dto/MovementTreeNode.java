package br.com.luxsoft.jumper.path.dto;

import java.util.List;

/**
 * Represents a node of a Tree wrapping a coordinates array
 * Can be used as a graph with distinct child nodes
 * 
 * @author Bruno Oliveira <bruno.gomes0@live.com>
 * 
 * @since 1.0
 */
public class MovementTreeNode<T>
{
    private MovementTreeNode<T> parent;
    private List<MovementTreeNode<T>> children;
    private T[] coordinates;
    private boolean visited = false;


    public MovementTreeNode(MovementTreeNode<T> parent, T[] coordinates)
    {
        this.coordinates = coordinates;
        this.parent = parent;
    }


    public MovementTreeNode<T> getParent()
    {
        return parent;
    }


    public List<MovementTreeNode<T>> getChildren()
    {
        return children;
    }


    public void setChildren(List<MovementTreeNode<T>> children)
    {
        this.children = children;
    }


    public T[] getCoordinates()
    {
        return coordinates;
    }


    public void setCoordinates(T[] coordinates)
    {
        this.coordinates = coordinates;
    }


    public boolean isVisited()
    {
        return visited;
    }


    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

}
