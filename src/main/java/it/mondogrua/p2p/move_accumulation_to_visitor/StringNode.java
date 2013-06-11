package it.mondogrua.p2p.move_accumulation_to_visitor;

public class StringNode implements Node {
    
    private final String text;

    public StringNode(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
