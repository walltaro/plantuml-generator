package behavior;

import java.util.Collection;

/**
 * 属性振る舞いクラス
 * クラスタイプ振る舞いクラスが保有する。
 * @author wataru
 *
 */
public class PropertyBehavior extends ObjectBehavior {

	@Override
	protected void startBehave(Collection<String> lines) {
		lines.add(getName());
	}

}
