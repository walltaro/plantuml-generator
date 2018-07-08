package diagrams;

/**
 * 関連タイプ
 * @author wataru
 * TODO 線の長さによってレイアウトの向き、長さが変わる。
 */
public enum RelationType {
	/** 関連 */
	Association("<--"),
	/** 集約 */
	Aggregation("o--"),
	/** コンポジション */
	Composition("*--"),
	/** コンポジション(矢印付き) */
	CompositionArrowHead("*-->"),
	/** 依存 */
	Dependency("<.."),
	/** 汎化 */
	Generalization("<|--"),
	/** 実現 */
	Realization("<|..");

	/**
	 * 出力内容
	 */
	private String outputContent;

	/**
	 * コンストラクタ
	 * @param outputContent
	 */
	private RelationType(String outputContent) {
		this.outputContent = outputContent;
	}

	public String getOutputContent() {
		return outputContent;
	}
}
