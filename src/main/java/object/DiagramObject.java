package object;

import java.util.List;

import behavior.ObjectBehavior;
import diagrams.ClassType;

public class DiagramObject {
	/**
	 * 出力PNGファイル名
	 */
	private String outputImageName;


	private List<ObjectBehavior> objectBehaviorList;


	public String getOutputImageName() {
		return outputImageName;
	}

	public void setOutputImageName(String outputImageName) {
		this.outputImageName = outputImageName;
	}

	public List<ObjectBehavior> getObjectBehaviorList() {
		return objectBehaviorList;
	}

	public void setObjectBehaviorList(List<ObjectBehavior> objectBehaviorList) {
		this.objectBehaviorList = objectBehaviorList;
	}



}
