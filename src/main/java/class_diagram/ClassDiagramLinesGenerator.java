package class_diagram;

import java.util.ArrayList;
import java.util.Collection;

import behavior.ObjectBehavior;
import generator.DiagramLinesGenerator;
import object.DiagramObject;

public class ClassDiagramLinesGenerator extends DiagramLinesGenerator {

	@Override
	public Collection<?> generate(DiagramObject diagramObject) {
		Collection<String> lines = new ArrayList<>();
		lines.add(startUml(diagramObject));
		for (ObjectBehavior objectBehavior : diagramObject.getObjectBehaviorList()) {
			objectBehavior.behave(lines);
		}

		lines.add(endUml());
		return lines;

	}

	private String startUml(DiagramObject diagramObject) {
		return "@startuml{" + diagramObject.getOutputImageName() + "}";
	}

	private String endUml() {
		return "@enduml";
	}

}
