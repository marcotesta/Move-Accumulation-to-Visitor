package it.mondogrua.p2p.move_accumulation_to_visitor;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    
    private final List<Node> nodes = new ArrayList<Node>();

    public void addNode(Node node) {
        nodes.add(node);
    }
    
    void flushScanners() {
    }

    void registerScanners() {
    }

    NodeIterator elements() {
        return new NodeIterator(nodes.iterator());
    }

}
