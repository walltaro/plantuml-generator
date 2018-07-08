package generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import diagrams.UmlDiagrams;

public class ClassDiagramGenerator extends DiagramGenerator {
	public ClassDiagramGenerator() {
		umlDiagram = UmlDiagrams.ClassDiagram;
	}
	/**
	 * <PRE>
	 * 対象ファイルから出力コレクションを生成する。
	 * TODO 未実装
	 * </PRE>
	 *
	 * @param targetFile
	 * @return
	 */
	@Override
	protected Collection<?> createLines(File targetFile) {
		Collection<String> lines = new ArrayList<>();
		lines.add("Sample作ります。");
		lines.add("ほにゃららら〜");
		feature2();
		feature3();
		return lines;
	}




	private void feature2() {
		System.out.println("Feature2 is.");
	}

	private void feature3() {
		System.out.println("feature3 is.");
	}
}
