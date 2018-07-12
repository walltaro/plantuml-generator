package diagrams;

/**
 * アクセス修飾子
 * @author wataru
 *
 */
public enum AccessModifiers {
	Public("+"), Protected("#"), Private("-");
	/**
	 * 出力内容
	 */
	private String outputContent;
	AccessModifiers(String outputContent) {
		this.outputContent = outputContent;
	}

	public String getOutputContent() {
		return outputContent;
	}

}
