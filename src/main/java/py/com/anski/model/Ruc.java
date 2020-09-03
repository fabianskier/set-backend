package py.com.anski.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author anski
 *
 */

@Entity
@Table(name = "ruc")
public class Ruc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRuc;

	@Column(name = "documento", nullable = false)
	private String documento;

	@Column(name = "denominacion", nullable = false)
	private String denominacion;

	@Column(name = "digito_verificador", nullable = false)
	private String digitoVerificador;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	public Ruc() {

	}

	public int getIdRuc() {
		return idRuc;
	}

	public void setIdRuc(int idRuc) {
		this.idRuc = idRuc;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
