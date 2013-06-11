package it.mondogrua.p2p.move_accumulation_to_visitor;

public class Tag implements Node {
    
    private final String tagName;
    
    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

}
