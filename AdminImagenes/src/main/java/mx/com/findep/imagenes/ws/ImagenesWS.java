package mx.com.findep.imagenes.ws;

import java.rmi.RemoteException;

import javax.jws.WebParam;
import javax.jws.WebService;


import mx.com.findep.controlnegocio.imagenes.AdministracionImagenesFinsol;
import mx.com.findep.imagenes.dto.ImagenDTO;

import org.apache.log4j.Logger;

/**
 * @author gcorzo
 * @version 1.0.0
 */
@WebService(serviceName = "ImagenesWS" )
public class ImagenesWS {

	/**
	 * Variable que permite el logging de las actividades.
	 */
	private static final Logger LOGGUER = Logger.getLogger(ImagenesWS.class);

	
	/**
	 * M�todo que obtiene la ruta http de una imagen.
	 * @param imagen datos de la imagen a buscar.
	 * @return Regresa la ruta de la imagen .
	 */
	public String obtenerRutaImagenFinsol(@WebParam(name = "imagen") ImagenDTO imagen) throws RemoteException  {
		String rutaImagen;
		try {
		if (imagen != null) {
			if (!imagen.getReferencia().equals("")) {
				LOGGUER.info("OBTENIENDO LA RUTA DE LA IMAGEN [" + imagen.getReferencia() + "]");
				AdministracionImagenesFinsol imagenes = new AdministracionImagenesFinsol();
				rutaImagen = imagenes.obtenerRutaImagenFinsol(imagen);
				LOGGUER.info("RUTA DE LA IMAGEN [" + imagen.getReferencia() + "] OBTENIDA [" + rutaImagen + "]");
			} else {
				LOGGUER.error("LOS PARAMETROS DE ENTRADA NO SON VALIDOS");
				throw new RemoteException("LOS PARAMETROS DE ENTRADA NO SON VALIDOS");
			}
		} else {
			LOGGUER.error("LOS PARAMETROS DE ENTRADA NO SON VALIDOS");
			throw new RemoteException("LOS PARAMETROS DE ENTRADA NO SON VALIDOS");
		}
		} catch (Exception ex) {
			LOGGUER.error("ERROR AL OBTENER LA RUTA DE LA IMAGEN [" + imagen.getReferencia() + "] [" + ex.getMessage() + "]");
			throw new RemoteException(ex.getMessage());
		}
		return rutaImagen;
	}	
}

