package behavior;

import java.util.Collection;

import diagrams.ClassType;

/**
 * クラスタイプ振る舞いクラス
 * @author wataru
 *
 */
public class ClassTypeBehavior extends ObjectBehavior {
	private ClassType classType;
	@Override
	protected void startBehave(Collection<String> lines) {
		if (getName() != null) lines.add(classType.getOutputContent() + " " + getName() + " {");
	}
	/**
	 * abstract Figure {
    #{static} const size_t ParseBufferSize = 256
    +{abstract} size_t getPointsNum()
    +{static} Figure *ParseString(const char *str)
}
	 */

	@Override
	protected void endBehave(Collection<String> lines) {
		if (getName() != null) lines.add("}");
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}



}
