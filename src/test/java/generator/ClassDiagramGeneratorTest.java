package generator;

import static org.junit.Assert.*;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ClassDiagramGeneratorTest {

	@Test
	public void test() {
		File file = new File("/Users/wataru/Developer/java/eclipse/plantuml-generator/src/main/java/sample/Sample.java");
		ClassDiagramGenerator sut = new ClassDiagramGenerator();
		try {
			sut.generate(file);
		}  catch (Exception e) {
			fail("想定していないエラーです。テストを終了します。");
		}
		File actual = new File("");
		File expected = new File("");
		assertThat(actual, is(expected));
		assertTrue(true);
	}

}
