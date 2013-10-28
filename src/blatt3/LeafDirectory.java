package blatt3;

public class LeafDirectory extends Directory {
	
	private Cell cell;
	private int entity;

	protected LeafDirectory(Cell p_cell, CompositeDirectory parent)
	{
		super(parent);
		cell = p_cell;
		entity = -1;
	}

	@Override
	Cell lookup(int p_entity)
	{
		if(p_entity == entity)
			return cell;
		return parent.lookup(p_entity);
	}

	public void insert(int p_entity)
	{
		entity = p_entity;
		parent.insert(p_entity, this);
	}

}
