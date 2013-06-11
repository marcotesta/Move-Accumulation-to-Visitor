package it.mondogrua.p2p.move_accumulation_to_visitor;

import java.util.Iterator;

public class NodeIterator {
    
    private final Iterator<Node> iterator;
    
    public NodeIterator(Iterator<Node> iterator) {
        this.iterator = iterator;
    }

    public boolean hasMoreNodes() {
        return iterator.hasNext();
    }

    public Node nextNode() {
        return iterator.next();
    }

}
