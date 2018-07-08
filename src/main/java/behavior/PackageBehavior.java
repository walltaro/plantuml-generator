package behavior;

import java.util.Collection;


public class PackageBehavior extends ObjectBehavior {
	@Override
	protected void startBehave(Collection<String> lines) {
		if (getName() != null) lines.add("package " + getName() + " {");
	}
	@Override
	protected void endBehave(Collection<String> lines) {
		if (getName() != null) lines.add("}");
	}
}
