package topiczerotwo;

/**
 * Abstract factory to use differents types of DB.
 * 
 * @author andres.vaninetti
 *
 */
public class FactoryBuilder {

	private static final String ORACLE = "ORACLE";
	private static final String SQL = "SQL";

	public static AbstractFactory biuldFactory(String option) {
		if (option.equalsIgnoreCase(SQL)) {
			return new SQLConnectorFactory();
		} else if (option.equalsIgnoreCase(ORACLE)) {
			System.out.println("Not oracle db connection implemented");
		}
		return null;
	}

}
