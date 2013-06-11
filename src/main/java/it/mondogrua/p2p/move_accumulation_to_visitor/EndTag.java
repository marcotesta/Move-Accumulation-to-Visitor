package it.mondogrua.p2p.move_accumulation_to_visitor;

public class EndTag implements Node {
    
    private final String tagName;
    
    public EndTag(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return this.tagName;
    }

}
