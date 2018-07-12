package diagrams;

/**
 * その他修飾子
 * @author wataru
 *
 */
public enum OtherModifiers {
	Abstract("{abstract}"), Static("{static}"), Final("{final}");
	/**
	 * 出力内容
	 */
	private String outputContent;
	OtherModifiers(String outputContent) {
		this.outputContent = outputContent;
	}

	public String getOutputContent() {
		return outputContent;
	}

}
