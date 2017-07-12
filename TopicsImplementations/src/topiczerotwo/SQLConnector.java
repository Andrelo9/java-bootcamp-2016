package topiczerotwo;

public interface SQLConnector {

	/**
	 * This method provides a DB connection, depending on the type of SQL DB
	 * used.
	 * 
	 */
	public void doConnect();

	/* Thinking about another approach to the solution, you could overload
	 the method doConnect with different numbers of parameters and create
	 different
	 connections by building the URL according to the parameters used. */
}
