package mx.com.findep.controlnegocio.imagenes;

import java.io.Serializable;
import java.util.List;

import mx.com.findep.imagenes.dto.ImagenDTO;
import mx.com.findep.imagenes.dto.JNDIProperties;
import mx.com.findep.imagenes.serviciodatos.ImagenesFinsolDAO;

import org.apache.log4j.Logger;

public class AdministracionImagenesFinsol implements Serializable {

	
	/**
	 * Id. Serializable
	 */
	private static final long serialVersionUID = 2705771024288174514L;

	/**
	 * Variable que permite logging de los procesos realizados en la operación de la clase.
	 */
	private static final Logger LOGGUER = Logger.getLogger(AdministracionImagenesFinsol.class);	
	
	/**
	 * Método que regresa la ruta de las imagenes de solicitudes finsol.
	 * @param imagen Información de la imagen que se desea obtener.
	 * @return las rutas de las imagenes en xml.
	 * @throws Exception retorna una exception en caso de error en el método.
	 */
	public String obtenerRutaImagenFinsol(ImagenDTO imagen) throws Exception {
		String rutaImagen = "";
		ImagenesFinsolDAO imagenesFinsolDAO = null;
		try {
			LOGGUER.info("OBTENIENDO RUTA DE IMAGEN");
			imagenesFinsolDAO = new ImagenesFinsolDAO();
			List<ImagenDTO> datosImagen = imagenesFinsolDAO.obtenerRutaImagenFinsol(imagen);
			
			if(datosImagen.size() > 0)
			{
				rutaImagen = "<?xml version=\"1.0\"?><respuesta><status><valor>true</valor><mensaje></mensaje></status>" + "<imagenes>";
			    for(int i=0; i<datosImagen.size(); i++) {
			    	rutaImagen += "<imagen>";			    	
			    	String rutaHttp = JNDIProperties.getProperty(JNDIProperties.RUTAHTTPIMAGENFINSOL);
			    	rutaImagen += "<ruta>" + rutaHttp + datosImagen.get(i).getNombreImagen() + "</ruta>";
			    	if("".equals(datosImagen.get(i).getEstatus().trim()))
			    	{
			    		rutaImagen += "<statusllegada>P</statusllegada>";
			    	}
			    	else{
			    		rutaImagen += "<statusllegada>E</statusllegada>";
			    	}
			    	rutaImagen += "<fechallegada>" + datosImagen.get(i).getEstatus().trim() + "</fechallegada>";
			    	rutaImagen += "<fecharegistro>" + datosImagen.get(i).getFechaAlta().trim() + "</fecharegistro>";
			    	rutaImagen += "<diferencia>" + datosImagen.get(i).getDiferencia().trim() + "</diferencia>";
			    	rutaImagen += "</imagen>";
			      }
			    rutaImagen += "</imagenes></respuesta>";
			}
			else{
				rutaImagen="<?xml version=\"1.0\"?><respuesta><status><valor>false</valor><mensaje>No se encontraron imagenes para la solicitud</mensaje></status></respuesta>";
			}
		} catch (Exception ex) {
			LOGGUER.error("Error obteniendo ruta de imagen [" + ex.getMessage() + "]");
			rutaImagen="<?xml version=\"1.0\"?><respuesta><status><valor>false</valor><mensaje>" + "Error obteniendo ruta de imagen [" + ex.getMessage() + "]" + "</mensaje></status></respuesta>";
			//throw new Exception("ERROR AL OBTENER LA IMAGEN [" + ex.getMessage() + "]");
		} finally {
			if (imagenesFinsolDAO != null) {
				imagenesFinsolDAO.commitSession();
			}
		}
		return rutaImagen;
	}		
	
}
