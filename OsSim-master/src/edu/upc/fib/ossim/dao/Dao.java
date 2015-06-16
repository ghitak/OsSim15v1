/**
 * 
 */
package edu.upc.fib.ossim.dao;

/**
 * @author Laure
 *
 */
public interface Dao<T> {
	
	public T find(String login, String password);

}
