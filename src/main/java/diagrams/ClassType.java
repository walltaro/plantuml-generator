package diagrams;

public enum ClassType {
	Class("class"), Abstract("abstract"), Interface("interface");

	private ClassType(String outputContent) {
		this.outputContent = outputContent;
	}
	private String classTypeName;
	/**
	 * 出力内容
	 */
	private String outputContent;

	public String getClassTypeName() {
		return classTypeName;
	}

	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}

	public String getOutputContent() {
		return outputContent;
	}
}
