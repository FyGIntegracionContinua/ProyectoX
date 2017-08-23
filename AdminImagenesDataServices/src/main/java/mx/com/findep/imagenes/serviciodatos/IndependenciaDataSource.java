package mx.com.findep.imagenes.serviciodatos;

import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.log4j.Logger;

/**
 * Clase que permite la conexión con la base de datos P_Independencia.
 * @author jmorales
 * @version 1.0.0
 */
public final class IndependenciaDataSource {


	/**
	 * Variable para el manejo de la session.
	 */
	 private static SqlSessionFactory sqlSessionFactory = null;

	/**
	 *Variable que permite el logging de las actividades.
	 */
	 private static Logger logger = Logger.getLogger(IndependenciaDataSource.class);

	/**
	 * Constructor privado de la clase.
	 */
	private IndependenciaDataSource() {
	}
    static {
	        if (sqlSessionFactory == null) {
	            //Se carga la configuración para Ibatis junto con el XML asociado para los querys
	        	logger.info("CARGANDO XML CONFIGURACION");
	            try {
	            	Reader reader = Resources.getResourceAsReader("mx/com/findep/imagenes/serviciodatos/"
	            			+ "SqlMapConfigIndependencia.xml");
	            	logger.info("SE ASIGNO RUTA DEL XML CONFIG");
	            	sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	                reader.close();
	            } catch (Exception e) {
	                logger.error("ERROR AL CARGAR XML POR: " + e.getMessage());
	                throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
	            }
	        }
	    }


    	/**
		 * Método que Cierra La conexión a la base de datos.
		 * @param session variable de session inicializada
		 */
	    public static  void cerrarConexion(SqlSession session) throws Exception {
			try {
				if (session != null) {
					session.clearCache();
			    	session.close();
				}
			} catch (Exception excepcion) {
				 throw excepcion;
			}
		}

	    /**
	     * Método que abre la conexión de sqlSessionFactory.
	     * @return regresa una session inicializada.
	     */
	    public static SqlSession abrirSession() {
	    	logger.info("ABRIENDO SESSION EN DATASOURCE INDEPENDENCIA");
	    	return sqlSessionFactory.openSession();
	    }
}
