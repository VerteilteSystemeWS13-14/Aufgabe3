package blatt3;

import java.util.HashMap;
import java.util.Map;

public class CompositeDirectory extends Directory {

	private Map<Integer, Directory> map; // Table with: Entity <=> LeafDir/CompDir
	
	protected CompositeDirectory(CompositeDirectory parent)
	{
		super(parent);
		map = new HashMap<Integer, Directory>();
	}

	@Override
	Cell lookup(int entity)
	{
		Directory child = map.get(entity); // Child can be LeafDir or CompDir
		if(child != null) // Knows where the entity is
			return child.lookup(entity);
		else if (parent != null) // Else ask parent
			return parent.lookup(entity);
		return null; // Parents do not know where the entity is
	}
	
	public void insert(int p_entity, Directory p_child)
	{
		map.put(p_entity, p_child);
		if(parent != null) {
			// (If parent knows already that this directory is in this branch, do nothing)
			// Else add/update its map entry
			parent.insert(p_entity, this);
		}
	}

}
