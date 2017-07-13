package topiczerotwo;

/**
 * Abstract factory to use different types of DB.
 * 
 * @author andres.vaninetti
 *
 */
public class FactoryBuilder {

	public static AbstractFactory biuldFactory(DataBases option) {
		switch (option) {
		case SQL:
			return new SQLConnectorFactory();
		case ORACLE:
			System.out.println("Not oracle db connection implemented");
		}
		return null;
	}

}
