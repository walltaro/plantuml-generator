package behavior;

import java.util.Collection;

import diagrams.RelationType;
import static constants.CommonConstants.SPACE;

public class RelationBehavior extends ObjectBehavior {
	/**
	 * 関係タイプ
	 */
	private RelationType relationType;
	/**
	 * 親と子 TODO 持ち方については変更するかも。
	 */
	private String parent;
	private String child;

	@Override
	protected void startBehave(Collection<String> lines) {
		lines.add(parent + SPACE + relationType.getOutputContent() + SPACE + child);
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setChild(String child) {
		this.child = child;
	}

}
