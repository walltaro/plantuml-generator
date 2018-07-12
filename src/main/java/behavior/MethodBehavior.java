package behavior;

import static constants.CommonConstants.SPACE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import constants.CommonConstants;
import diagrams.AccessModifiers;
import diagrams.OtherModifiers;

/**
 * 操作振る舞いクラス
 * クラスタイプ振る舞いクラスが保有する。
 * @author wataru
 *
 */
public class MethodBehavior extends ObjectBehavior {
	/** アクセス修飾子 */
	private AccessModifiers accessModifier;
	/** その他修飾子 */
	private List<OtherModifiers> otherModifierList;
	/** 戻り値データ型 */
	private String returnDataType;
	/** 引数データ(引数名, データ型) */
	private Map<String, String> argsDataMap;

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
		outputContent.append(returnDataType + SPACE);
		// 操作名(必須)
		outputContent.append(getName());
		// 引数
		outputContent.append(outputArgs());

		lines.add(outputContent.toString());

	}

	private String outputArgs() {
		String joindArgs = "";
		if (argsDataMap != null && argsDataMap.size() != 0) {
			List<String> argList = new ArrayList<>();
			for (Entry<String, String> argsDataEntry : argsDataMap.entrySet()) {
				argList.add(argsDataEntry.getValue() + SPACE + argsDataEntry.getKey());
			}
			joindArgs = StringUtils.join(argList, CommonConstants.COMMA);
		}
		return "(" + joindArgs + ")";
	}
	public void setAccessModifier(AccessModifiers accessModifier) {
		this.accessModifier = accessModifier;
	}
	public void addOtherModifier(OtherModifiers otherModifiers) {
		if (this.otherModifierList == null) this.otherModifierList = new ArrayList<>();
		otherModifierList.add(otherModifiers);
	}

	public void setReturnDataType(String returnDataType) {
		this.returnDataType = returnDataType;
	}

	public void putArgsData(String argName, String dataType) {
		if (this.argsDataMap == null) this.argsDataMap = new LinkedHashMap<>();
		this.argsDataMap.put(argName, dataType);
	}


}


