package generator;

import java.util.Collection;

import object.DiagramObject;

public abstract class DiagramLinesGenerator {
	public abstract Collection<?> generate(DiagramObject diagramObject);
}
