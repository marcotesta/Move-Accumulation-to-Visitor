package it.mondogrua.p2p.move_accumulation_to_visitor;

public class TextExtractor {
    private Parser parser;
    
    public TextExtractor(Parser parser) {
        this.parser = parser;
    }

    public String extractText() throws ParserException {
        Node node;
        boolean isPreTag= false;
        boolean isScriptTag = false;
        StringBuffer result = new StringBuffer();
        
        parser.flushScanners();
        parser.registerScanners();
        
        for (NodeIterator e = parser.elements(); e.hasMoreNodes(); ) {
            node = e.nextNode();
            if (node instanceof StringNode) {
                if (!isScriptTag) {
                    StringNode stringNode = (StringNode) node;
                    if (isPreTag) {
                        result.append(stringNode.getText());
                    } else {
                        String text= Translate.decode(stringNode.getText());
                        if (getReplaceNonBreakingSpace()) {
                            text = text.replace('\u00a0',' ');
                        }
                        if (getCollapse()) {
                            collapse(result, text);
                        } else {
                            result.append(text);
                        }
                    }
                }
            } else if (node instanceof LinkTag) {
                LinkTag link =(LinkTag)node;
                if (isPreTag) {
                    result.append(link.getLinkText());
                } else {
                    collapse(result, Translate.decode(link.getLinkText()));
                }
                if (getLinks()) {
                    result.append("<");
                    result.append(link.getLink());
                    result.append(">");
                }
            } else if (node instanceof EndTag) {
                EndTag endTag = (EndTag) node;
                String tagName = endTag.getTagName();
                if (tagName.equalsIgnoreCase("PRE")) {
                    isPreTag = false;
                } else if (tagName.equalsIgnoreCase("SCRIPT")) {
                    isScriptTag = false;
                }
            } else if (node instanceof Tag) {
                Tag tag = (Tag) node;
                String tagName = tag.getTagName();
                if (tagName.equalsIgnoreCase("PRE")) {
                    isPreTag = true;
                } else if (tagName.equalsIgnoreCase("SCRIPT")) {
                    isScriptTag = true;
                }
            }
        }
        return (result.toString());
    }

    private boolean getLinks() {
        // TODO Auto-generated method stub
        return false;
    }

    private void collapse(StringBuffer result, String text) {
        // TODO Auto-generated method stub
        
    }

    private boolean getCollapse() {
        // TODO Auto-generated method stub
        return false;
    }

    private boolean getReplaceNonBreakingSpace() {
        // TODO Auto-generated method stub
        return false;
    }
    

}
