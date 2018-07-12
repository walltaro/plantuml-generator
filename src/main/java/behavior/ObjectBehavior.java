package behavior;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * オブジェクト振る舞い抽象クラス
 * @author wataru
 *
 */
public abstract class ObjectBehavior {
	private String name;
	private List<ObjectBehavior> objectBehaviorList = new ArrayList<>();
	public final void behave(Collection<String> lines) {
		startBehave(lines);
		for (ObjectBehavior objectBehavior : objectBehaviorList) {
			objectBehavior.behave(lines);
		}
		endBehave(lines);
	}

	protected abstract void startBehave(Collection<String> lines);
	protected void endBehave(Collection<String> lines) {
		// 処理を実施する場合はオーバーライドする。
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void add(ObjectBehavior objectBehavior) {
		objectBehaviorList.add(objectBehavior);
	}
}
