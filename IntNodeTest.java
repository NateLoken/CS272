public class IntNodeTest{
    public static void main(String[] args) {
        IntNode node1 = new IntNode();
        System.out.println(node1.toString());
        System.out.println("The data in node1 is " + node1.getData());
        System.out.println("Node1 is linked to " + node1.getLink());
        node1.setData(7);
        System.out.println("The new data of node1 is " + node1.getData());
        System.out.println("The length of node1 is " + node1.listLength(node1));
        System.out.println();
        IntNode node2 = new IntNode(11, null);
        System.out.println("Node2 is linked to " + node2.getLink());
        node1.setLink(node2);
        System.out.println("Node1 is now linked to " + node1.getLink());
        System.out.println(node1.toString());
        System.out.println("The length of this list is " + node1.listLength(node1));

        node2.addNodeAfterThis(40);
        System.out.println("Node2 is now linked to " + node2.getLink());
        System.out.println(node2.toString());
        node2.removeNodeAfterThis();
        System.out.println("Node2 is now linked to " + node2.getLink());

        for(int i = 1; i < 11; i++)
            node2.addNodeAfterThis(i);
        System.out.println(node2.toString());
        System.out.println("The length of the list is " + node1.listLength(node2));

        System.out.println("This list has what you're looking for " + node2.search(node2, 5));
        System.out.println("This list has what you're looking for " + node2.search(node2, 40));

    }
}