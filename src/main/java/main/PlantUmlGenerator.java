package main;

import java.io.File;

import generator.DiagramGenerator;
import status.Status;

public class PlantUmlGenerator {
	public static void main(String[] args) {
		checkArgs(args);

		DiagramGenerator generator = getDiagramGenerator(args[0]);
		File targetFile = getTargetFile(args[1]);

		generator.generate(targetFile);

		Status status = Status.getInstance();
		status.warning();
	}

	/**
	 * 引数チェック
	 * @param args
	 */
	private static void checkArgs(String[] args) {
		if (args.length != 2) {
			System.out.println("引数を2つ入力してください。");
			System.out.println("  引数1:生成するUML図種別");
			System.out.println("  引数2:対象ソースコード名");
			System.exit(0);
		}
	}

	/**
	 * 引数1のUML図種別論理名からダイアログ生成クラスを取得する。
	 * @param umlDialogLogicalName UML図種別論理名
	 * @return 引数に対応したダイアログ生成クラス
	 */
	private static DiagramGenerator getDiagramGenerator(String umlDialogLogicalName) {
		UmlDiagrams umlDiagram = UmlDiagrams.getUmlDiagrams(umlDialogLogicalName);
		String className = "generator." + umlDiagram.name() + "Generator";
		DiagramGenerator generator = null;
		try {
			generator = (DiagramGenerator)Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generator;
	}

	/**
	 * 引数2のファイル名からPUML化するファイルを取得する。
	 * @param fileName
	 * @return
	 */
	private static File getTargetFile(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("そんなファイルないよ！");
			System.exit(0);
		}
		return file;
	}
}

/**
 * UML図種別
 * @author wataru
 *
 */
enum UmlDiagrams {
	// クラス図
	ClassDiagram("クラス図"),
	// コンポーネント図
	ComponentDiagram("コンポーネント図"),
	// 複合構造図
	// 配置図
	// オブジェクト図
	ObjectDiagram("オブジェクト図"),
	// パッケージ図
	// プロフィール図
	// アクティビティ図
	// コミュニケーション図
	// インタラクション図
	// シーケンス図
	SequenceDiagram("シーケンス図")
	// ステートマシン図
	// タイミング図
	// ユースケース図
	;
	String logicalName;
	private UmlDiagrams(String logicalName) {
		this.logicalName = logicalName;
	}
	/**
	 * UML図論理名を基にUML図種別を取得する。
	 * 当てはまるものがなければnullを返却する。
	 * @param logicalName
	 * @return
	 */
	public static UmlDiagrams getUmlDiagrams(String logicalName) {
		for (UmlDiagrams umlDiagram : UmlDiagrams.values()) {
			if (!umlDiagram.logicalName.equals(logicalName)) continue;
			return umlDiagram;
		}
		return null;
	}
}
