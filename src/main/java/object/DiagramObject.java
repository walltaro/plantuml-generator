package object;

import java.util.Collection;

import behavior.ObjectBehavior;

public class DiagramObject {
	/**
	 * 出力PNGファイル名
	 */
	private String outputImageName;

	private ObjectBehavior objectBehavior;


	public String getOutputImageName() {
		return outputImageName;
	}

	public void setOutputImageName(String outputImageName) {
		this.outputImageName = outputImageName;
	}

	public void setObjectBehavior(ObjectBehavior objectBehavior) {
		this.objectBehavior = objectBehavior;
	}

	public void behave(Collection<String> lines) {
		objectBehavior.behave(lines);
	}

}
