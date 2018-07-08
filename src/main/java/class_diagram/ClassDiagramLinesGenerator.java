package class_diagram;

import java.util.ArrayList;
import java.util.Collection;

import generator.DiagramLinesGenerator;
import object.DiagramObject;

public class ClassDiagramLinesGenerator extends DiagramLinesGenerator {

	@Override
	public Collection<?> generate(DiagramObject diagramObject) {
		Collection<String> lines = new ArrayList<>();
		lines.add(startUml(diagramObject));

		lines.add("package " + diagramObject.getPackageName() + " {");
		lines.add("}");

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
