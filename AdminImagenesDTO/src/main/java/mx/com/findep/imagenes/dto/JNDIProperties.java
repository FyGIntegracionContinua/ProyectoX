package mx.com.findep.imagenes.dto;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public final class JNDIProperties {


	/**
	 *Variable para grabar en el log.
	 */
	private static final Logger LOGGER 	= Logger.getLogger(JNDIProperties.class);

	/**
	 * JNDI servidor de variables
	 */
	private static final String JNDI_PROPERTIES_NAME = "com/fisa/parametros";

	/**
	 * WS Solicitudes CIOF
	 */
	public static final String	RUTAHTTPIMAGENFINSOL = "mx.com.findep.finanzas.ws.adminnomina.rutaHTTPImagenFinsol";

	/**
	 * Constructor
	 */
	private JNDIProperties() {
			super();
	}

	/**
	 * @param propName propiedad
	 * @return el valor de la propiedad
	 * @throws Exception
	 */
	public static String getProperty(String propName) throws Exception {

		Properties prop = null;

		try {

			Context ctx = new InitialContext();
			prop 		= (Properties) ctx.lookup(JNDI_PROPERTIES_NAME);
			return prop.getProperty(propName);

		} catch (NamingException exc) {

			LOGGER.error("Error al obtener la variable JNDI [" + propName + "].");
			LOGGER.error(exc + exc.getMessage());
			throw new Exception(exc);
		}
	}

	/**
	 * @param valorVariable valor
	 * @return variable
	 * @throws Exception
	 */
	public static String[] obtenerValoresJNDI(String valorVariable) throws Exception {
		String valoresJNDI = getProperty( valorVariable);
		if ( valoresJNDI == null || valoresJNDI.trim().equals("") ) {
			LOGGER.error("Error al obtener la propiedad: " + valorVariable + " del contexto JNDI.");
			throw new Exception("Error al obtener la propiedad: " + valorVariable + " del contexto JNDI.");
		}
		return valoresJNDI.split(";");
	}
}

