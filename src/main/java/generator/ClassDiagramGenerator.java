package generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import constants.FileConstants;

public class ClassDiagramGenerator implements DiagramGenerator {

	@Override
	public void generate(File targetFile) {
		System.out.println("クラス図を生成します。");
		System.out.println("対象ファイル名：" + targetFile.getName());

		// PUMLファイルを生成する。
		File createdPumlFile = createPumlFile(targetFile);
		// 対象ファイルから出力コレクションを生成する。
		Collection<?> lines = createLines(targetFile);
		// PUMLファイルに出力コレクションを書き込む
		write(createdPumlFile, lines);

		System.out.println("クラス図を生成しました。");
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
	 * TODO 未実装
	 * </PRE>
	 *
	 * @param targetFile
	 * @return
	 */
	private Collection<?> createLines(File targetFile) {
		Collection<String> lines = new ArrayList<>();
		lines.add("Sample作ります。");
		lines.add("ほにゃららら〜");
		return lines;
	}

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
