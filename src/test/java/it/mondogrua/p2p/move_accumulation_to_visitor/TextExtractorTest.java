package it.mondogrua.p2p.move_accumulation_to_visitor;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextExtractorTest {

    @Test
    public void testExtractText() throws Exception {
        Parser parser = new Parser();
        parser.addNode(new Tag("HTML"));
        parser.addNode(new Tag("BODY"));
        parser.addNode(new StringNode("Hello, and welcome to may web page!"));
        
        parser.addNode(new EndTag("BODY"));
        parser.addNode(new EndTag("HTML"));

        String expected = new String("Hello, and welcome to may web page!");
        
        TextExtractor instance = new TextExtractor(parser);
        
        String result = instance.extractText();
        assertEquals(expected, result);
    }

}
