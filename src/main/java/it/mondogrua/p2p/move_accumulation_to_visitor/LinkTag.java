package it.mondogrua.p2p.move_accumulation_to_visitor;

public class LinkTag implements Node {
    
    private final String linkText;
    
    public LinkTag(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkText() {
        return this.linkText;
    }

    public String getLink() {
        return "";
    }


}
