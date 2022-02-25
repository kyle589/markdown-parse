import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.Assert.*;
import org.junit.*;

//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
// /software/CSE/oracle-java-se-14/jdk-14.0.2/bin/javac
//scp -r . cs15lwi22akq@ieng6.ucsd.edu:~/markdown-parse; ssh cs15lwi22akq@ieng6.ucsd.edu "cd markdown-parse; javac MarkdownParse.java; java MarkdownParse test-file.md"
//scp -r . cs15lwi22akq@ieng6.ucsd.edu:~/markdown-parse; ssh cs15lwi22akq@ieng6.ucsd.edu "cd markdown-parse; /software/CSE/oracle-java-se-14/jdk-14.0.2/bin/javac MarkdownParse.java; /software/CSE/oracle-java-se-14/jdk-14.0.2/bin/javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java; /software/CSE/oracle-java-se-14/jdk-14.0.2/bin/java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest"
public class MarkdownParseTest {
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
    @Test
    public void getLinksSnippet1() throws IOException{
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinksSnippet2() throws IOException{
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), MarkdownParse.getLinks(contents));
    }
    // @Test
    // public void getLinksSnippet3() throws IOException{
    //     Path fileName = Path.of("snippet3.md");
    //     String contents = Files.readString(fileName);
    //     assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), MarkdownParse.getLinks(contents));
    // }
}
