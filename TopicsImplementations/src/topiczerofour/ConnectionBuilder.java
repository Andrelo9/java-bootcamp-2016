package topiczerofour;

/**
 * This interface establish a contract between differents SQL implementations to
 * build the basis features to the connections.
 * 
 * @author andres.vaninetti
 *
 */
public interface ConnectionBuilder {

	public ConnectionBuilder buildDataBaseName();

	public ConnectionBuilder buildHostName();

	public ConnectionBuilder buildPort();

	public SQLConnection getSQLConnection();

}
