package test;

import java.util.ArrayList;
import java.util.List;

public class Node {

public Node parent;//the parent of the current node
public List<Node> children = new ArrayList<Node>();//the children of the current node
public String name;//or any other property that the node should contain, like 'info'

public static int maxNrOfChildren;//equal to the k-arity; 

public Node (String nodeName)
{
    name=nodeName; 
}



public void addChild(Node childNode)
{
    if(this.children.size()>=maxNrOfChildren)
    {
        //do nothing (just don't add another node), or throw an error
    }
    else
    {
        childNode.parent=this;
        this.children.add(childNode);
    }
}
}