package doublelist;

public class Node {
    
    private Node left, right;
    private String data;
    
    public Node(String _data){
        data = _data;
    }
    
    public Node(String _data, Node _left, Node _right){
        data = _data;
        setLeft(_left);
        setRight(_right);
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.right = this;
    }
    
    public void setNullLeft(){
        this.left = null;
    }
    
    public void setNullRight(){
        this.right = null;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        right.left = this;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
}
