package fr.fms.dao;

import java.util.List;

public interface IEntityDao<E,I> {

	public E save(E e); //create
	public E findOne(I id); //read
	public void update(E e);
	public void delete(E e);
	public List<E> findAll(); // read all
	
}
