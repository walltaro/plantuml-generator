package generator;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import class_diagram.ClassDiagramGenerator;

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

	@Test
	public void test2() {
//		String[] array = new String[]{"abc", "def", "ghi"};
		List<String> array = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Map<String, String> map = new HashMap<>();
		map.put("402", "ade");
		map.put("403", "age");
		map.put("404", "aaaa");
		array.addAll(map.values());
		set.add("aabb");
		set.add("dabb");
		array.add("abc");
		array.add("def");
		array.addAll(set);
		String joindText = StringUtils.join(array, ",");
		System.out.println(joindText);
		for (String a : array) {
			System.out.println(a);
		}
	}

}
