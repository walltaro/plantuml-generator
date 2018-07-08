package diagrams;


/**
 * UML図種別
 * @author wataru
 *
 */
public enum UmlDiagrams {
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
	private String logicalName;
	private UmlDiagrams(String logicalName) {
		this.logicalName = logicalName;
	}

	public String getLogicalName() {
		return this.logicalName;
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