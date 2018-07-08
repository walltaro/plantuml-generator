package generator;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import constants.FileConstants;
import diagrams.UmlDiagrams;

public abstract class DiagramGenerator {
	protected UmlDiagrams umlDiagram;

	public void generate(File targetFile) {
		if (umlDiagram == null) {
			System.out.println("サブクラス生成時にumlDiagramを設定してください。");
			System.exit(0);
		}
		System.out.println(umlDiagram.getLogicalName() + "を生成します。");
		System.out.println("対象ファイル名：" + targetFile.getName());

		// PUMLファイルを生成する。
		File createdPumlFile = createPumlFile(targetFile);
		// 対象ファイルから出力コレクションを生成する。
		Collection<?> lines = createLines(targetFile);
		// PUMLファイルに出力コレクションを書き込む
		write(createdPumlFile, lines);

		System.out.println(umlDiagram.getLogicalName() + "を生成しました。");
	}

	/**
	 * <PRE>
	 * 対象ファイルを基にPUMLファイルを生成する。
	 * TODO 未実装
	 * </PRE>
	 *
	 * @param targetFile
	 * @return
	 */
	private File createPumlFile(File targetFile) {
		File createFile = new File(FilenameUtils.getBaseName(targetFile.getName()) + FileConstants.PUML_EXTENTION);
		if (createFile.exists()) {
			System.out.println("既に存在するファイルです。ファイル名：" + createFile.getName());
			return createFile;
		}
		System.out.println(createFile.getAbsolutePath());
		try {
			if (!createFile.createNewFile()) {
				System.out.println("ファイルが作成できませんでした。");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return createFile;
	}

	/**
	 * <PRE>
	 * 対象ファイルから出力コレクションを生成する。
	 * </PRE>
	 *
	 * @param targetFile
	 * @return
	 */
	protected abstract Collection<?> createLines(File targetFile);

	/**
	 * <PRE>
	 * PUMLファイルに出力コレクションを書き込む
	 * TODO 未実装
	 * </PRE>
	 *
	 * @param createdPumlFile
	 * @param lines
	 */
	private void write(File createdPumlFile, Collection<?> lines) {
		try {
			FileUtils.writeLines(createdPumlFile, FileConstants.DEFAULT_CHAR_SET, lines, FileConstants.NOT_APPEND);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
