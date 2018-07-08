package generator;

import java.io.File;

public class ClassDiagramGenerator implements DiagramGenerator {

	@Override
	public void generate(File file) {
		System.out.println("クラス図を生成します。");
		System.out.println("対象ファイル名：" + file.getName());
		try {
			System.out.println(file.getAbsolutePath());
		} catch (Exception e) {

		}


		System.out.println("クラス図を生成しました。");
	}

}
