package behavior;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import diagrams.AccessModifiers;
import diagrams.OtherModifiers;
import static constants.CommonConstants.SPACE;

/**
 * 属性振る舞いクラス
 * クラスタイプ振る舞いクラスが保有する。
 * @author wataru
 *
 */
public class PropertyBehavior extends ObjectBehavior {
	/** アクセス修飾子 */
	private AccessModifiers accessModifier;
	/** その他修飾子 */
	private List<OtherModifiers> otherModifierList;
	/** データ型 */
	private String dataType;
	/** 値 */
	private String value;

	@Override
	protected void startBehave(Collection<String> lines) {
		StringBuilder outputContent = new StringBuilder();
		// アクセス修飾子
		if (accessModifier != null) outputContent.append(accessModifier.getOutputContent());
		// その他修飾子
		if (otherModifierList != null) {
			for (OtherModifiers otherModifier : otherModifierList) {
				outputContent.append(otherModifier.getOutputContent() + SPACE);
			}
		}
		// データ型(必須)
		outputContent.append(dataType + SPACE);
		// 属性名(必須)
		outputContent.append(getName());
		// 値
		if (value != null) outputContent.append(" = " + value);

		lines.add(outputContent.toString());
	}

	public void setAccessModifier(AccessModifiers accessModifier) {
		this.accessModifier = accessModifier;
	}

	public void setOtherModifierList(List<OtherModifiers> otherModifierList) {
		this.otherModifierList = otherModifierList;
	}

	public void addOtherModifier(OtherModifiers otherModifiers) {
		if (this.otherModifierList == null) this.otherModifierList = new ArrayList<>();
		otherModifierList.add(otherModifiers);
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
