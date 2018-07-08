package generator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

public class ClassDiagramGenerator implements DiagramGenerator {
	private static final String PUML_EXTENTION = ".puml";

	@Override
	public void generate(File file) {
		System.out.println("クラス図を生成します。");
		System.out.println("対象ファイル名：" + file.getName());

		File createdPumlFile = createPumlFile(file);

		System.out.println("クラス図を生成しました。");
	}

	/**
	 * 対象ファイルを基にPUMLファイルを生成する。
	 * @param file
	 * @return
	 */
	private File createPumlFile(File file) {
		File createFile = new File(FilenameUtils.getBaseName(file.getName())+PUML_EXTENTION);
		if (createFile.exists()) {
			System.out.println("既に存在するファイルです。ファイル名：" + createFile.getName());
			return createFile;
		}
		System.out.println(createFile.getAbsolutePath());
		try {
			if(!createFile.createNewFile()) {
				System.out.println("ファイルが作成できませんでした。");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return createFile;
	}

}
