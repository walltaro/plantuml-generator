package main;

import java.io.File;

import diagrams.UmlDiagrams;
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


