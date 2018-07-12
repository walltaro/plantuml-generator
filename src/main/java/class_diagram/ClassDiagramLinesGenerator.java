package class_diagram;

import java.util.ArrayList;
import java.util.Collection;
import generator.DiagramLinesGenerator;
import object.DiagramObject;

public class ClassDiagramLinesGenerator extends DiagramLinesGenerator {

	@Override
	public Collection<?> generate(DiagramObject diagramObject) {
		Collection<String> lines = new ArrayList<>();
		diagramObject.behave(lines);
		return lines;
	}

}
