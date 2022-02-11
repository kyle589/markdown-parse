import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.Assert.*;
import org.junit.*;
//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
//something
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinksTestFile() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinksBracketFile() throws IOException{
        Path fileName = Path.of("bracket-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinksNewFile() throws IOException{
        Path fileName = Path.of("image-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinksNoLinkFile() throws IOException{
        Path fileName = Path.of("nolink-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
}
