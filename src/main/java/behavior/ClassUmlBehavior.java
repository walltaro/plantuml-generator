package behavior;

import java.util.Collection;

public class ClassUmlBehavior extends ObjectBehavior {

	@Override
	protected void startBehave(Collection<String> lines) {
		lines.add("@startuml{" + getName() + "}");
	}

	@Override
	protected void endBehave(Collection<String> lines) {
		lines.add("@enduml");
	}

}
