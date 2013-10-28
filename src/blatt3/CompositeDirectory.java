package blatt3;

import java.util.HashMap;
import java.util.Map;

public class CompositeDirectory extends Directory {

	private Map<Integer, Directory> map;
	
	protected CompositeDirectory(CompositeDirectory parent)
	{
		super(parent);
		map = new HashMap<Integer, Directory>();
	}

	@Override
	Cell lookup(int entity)
	{
		Directory child = map.get(entity);
		if(child != null)
			return child.lookup(entity);
		else
			return parent.lookup(entity);
	}
	
	public void insert(int p_entity, Directory p_child)
	{
		map.put(p_entity, p_child);
		if(parent != null)
			parent.insert(p_entity, this);
	}

}
