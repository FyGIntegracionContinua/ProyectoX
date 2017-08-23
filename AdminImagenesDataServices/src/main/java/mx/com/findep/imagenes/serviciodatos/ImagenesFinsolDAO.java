package mx.com.findep.imagenes.serviciodatos;

import org.apache.log4j.Logger;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import mx.com.findep.imagenes.dto.ImagenDTO;


public class ImagenesFinsolDAO {

	/**
	 *Variable que permite el logging de las actividades.
	 */
	private static final Logger LOGGUER = Logger.getLogger(ImagenesFinsolDAO.class);

	/**
	 * Variable de session que permite realizar las conexiones.
	 */
	private SqlSession session;

	/**
	 * Constructor de la clase que inicializa la variable session.
	 */
	public ImagenesFinsolDAO() {
		LOGGUER.info("INICIALIZANDO SESSION ");
		this.session = IndependenciaDataSource.abrirSession();
		LOGGUER.info("SESSION INICIALIZADA");
	}

	/**
	 * Constructor de la clase que inicializa la variable de session la cual recibe como parámetro.
	 * @param session Variable inicializada
	 */
	public ImagenesFinsolDAO(SqlSession session) {
		this.session = session;
	}

	/**
	 * Realiza la confirmación de las sentencias.
	 * @throws Exception
	 */
	public  void commitSession() throws Exception {
		  this.session.commit();
		  IndependenciaDataSource.cerrarConexion(session);
	}

	/**
	 * Realiza un rollback de las sentencias.
	 * @throws Exception
	 */
	public  void rollbackSession() throws Exception {
		this.session.rollback();
		IndependenciaDataSource.cerrarConexion(session);
	}


	/**
	 * Método que obtiene las rutas de las imagenes solicitudes de Finsol.
	 * @param imagen Información de la imagen de la cual se desea conocer su ruta.
	 * @return regresa las rutas de las imagenes
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ImagenDTO> obtenerRutaImagenFinsol(ImagenDTO imagen) throws Exception {
		List<ImagenDTO> datosImagen;
		try {
			LOGGUER.info("OBTENIENDO RUTA  DE LA IMAGEN [" + imagen.getReferencia() + "] [" + imagen.getTipoImagen() + "]");
			datosImagen  = session.selectList("ImagenesFinsol.obtenerRutaImagenFinsol", imagen);
			LOGGUER.info("IMAGENES OBTENIDAS ["	+ datosImagen.size() + "]");
		} catch ( Exception ex ) {
			LOGGUER.error("OCURRIO UN ERROR AL OBTENER RUTA  DE LA IMAGEN ["
					+ imagen.getReferencia() + "] [" + imagen.getTipoImagen() + "] [" + ex.getMessage() + "]");
			throw new Exception("OCURRIO UN ERROR OBTENER RUTA  DE LA IMAGEN");
		}
		return datosImagen;
	}	


	
}
