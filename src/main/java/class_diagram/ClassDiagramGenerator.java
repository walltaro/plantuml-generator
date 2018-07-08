package class_diagram;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import behavior.ClassTypeBehavior;
import behavior.ObjectBehavior;
import behavior.PackageBehavior;
import behavior.RelationBehavior;
import constants.FileConstants;
import diagrams.ClassType;
import diagrams.RelationType;
import diagrams.UmlDiagrams;
import generator.DiagramGenerator;
import object.DiagramObject;

/**
 * クラス図生成クラス
 * @author wataru
 *
 */
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
	protected Collection<?> readAndCreateLines(File targetFile) {
		DiagramObject diagramObject = readSourceByFile(targetFile);
		Collection<?> lines = createLines(diagramObject);
		return lines;
	}

	/**
	 * クラス図出力ライン生成クラスを呼び出して出力ラインを生成する。
	 * @param diagramObject
	 * @return
	 */
	private Collection<?> createLines(DiagramObject diagramObject) {
		ClassDiagramLinesGenerator linesGenerator = new ClassDiagramLinesGenerator();
		Collection<?> lines = linesGenerator.generate(diagramObject);
		return lines;
	}

	/**
	 * ダイアログオブジェクトのデータを書き換える
	 * FIXME あとで削除する。
	 * @param diagramObject
	 */
	private void example(DiagramObject diagramObject) {
		diagramObject.setOutputImageName("Sample" + FileConstants.PNG_EXTENTION);

		ClassTypeBehavior classTypeBehavior = new ClassTypeBehavior();
		classTypeBehavior.setName("Car");
		classTypeBehavior.setClassType(ClassType.Class);

		ClassTypeBehavior classTypeBehavior2 = new ClassTypeBehavior();
		classTypeBehavior2.setName("Vehicle");
		classTypeBehavior2.setClassType(ClassType.Interface);

		RelationBehavior relationBehavior = new RelationBehavior();
		relationBehavior.setParent("Vehicle");
		relationBehavior.setChild("Car");
		relationBehavior.setRelationType(RelationType.Generalization);

		PackageBehavior packageBehavior = new PackageBehavior();
		packageBehavior.setName("sample");
		packageBehavior.add(classTypeBehavior);
		packageBehavior.add(classTypeBehavior2);
		packageBehavior.add(relationBehavior);

		List<ObjectBehavior> packageBehaviorList = new ArrayList<>();
		packageBehaviorList.add(packageBehavior);
		diagramObject.setObjectBehaviorList(packageBehaviorList);
	}

	/**
	 * 対象ファイルを読み込んで、ダイアログオブジェクトを生成する。
	 * @param targetFile
	 * @return
	 */
	private DiagramObject readSourceByFile(File targetFile) {
		List<String> fileContents = null;
		try {
			// ファイルの内容を行単位で全量取得する。
			fileContents = FileUtils.readLines(targetFile,FileConstants.DEFAULT_CHAR_SET);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		DiagramObject diagramObject = new DiagramObject();
		// ファイルの内容を１行ずつ処理する。
		for (String fileContent : fileContents) {
			expound(fileContent, diagramObject);
		}
		example(diagramObject);
		return diagramObject;
	}

	/**
	 *　ファイル１行分の内容を解釈して、ダイアグラムオブジェクトに書き込む
	 * @param fileContent ファイル１行分
	 * @param diagramObject ダイアグラムオブジェクト
	 */
	private void expound(String fileContent, DiagramObject diagramObject) {
		// TODO 内容にパッケージがあればダイアグラムオブジェクトに書き込むとか。
	}

}
