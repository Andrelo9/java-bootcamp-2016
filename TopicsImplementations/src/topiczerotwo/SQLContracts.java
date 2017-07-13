package topiczerotwo;

/**
 * Enum class contains JDBC connections.
 * 
 * @author andres.vaninetti
 *
 */
public enum SQLContracts {
	MYSQL("MySQL"), 
	POSTGRESQL("PostgreSQL"),
	SQLITE("SQLite");

	private final String value;

	private SQLContracts(String contract) {
		this.value = contract;
	}

	public String getContract() {
		return this.value;
	}
}
