package mx.com.findep.imagenes.dto;

import java.io.Serializable;

/**
 * @author jmorales
 * @version 1.0.0
 */
public class ImagenDTO implements Serializable {

	/**
	 *
	 */

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private String referencia;

	/**
	 * Tipo de la imagen .
	 */
	private String tipoImagen;

	/**
	 * Estatus de la imagen.
	 */
	private String estatus;

	/**
	 * Nombre de la imagen.
	 */
	private String nombreImagen;
	
	/**
	 * Fecha de alta.
	 */
	private String fechaAlta;	
	
	/**
	 * diferencia entre fecha llegada y fecha de alta.
	 */
	private String diferencia;	


	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the tipoImagen
	 */
	public String getTipoImagen() {
		return tipoImagen;
	}

	/**
	 * @param tipoImagen the tipoImagen to set
	 */
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	/**
	 * Asigna estatus a estatus.
	 * @param estatus de la imagen
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Regresa estatus.
	 * @return estatus de la imagen
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * Asigna nombre de la imagen a nombreImagen.
	 * @param nombreImagen nombre de la imagen.
	 */
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	/**
	 * Regresa nombre de la imagen.
	 * @return nombreImagen
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}

	/**
	 * @return the diferencia
	 */
	public String getDiferencia() {
		return diferencia;
	}

	/**
	 * @param diferencia the diferencia to set
	 */
	public void setDiferencia(String diferencia) {
		this.diferencia = diferencia;
	}

	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
