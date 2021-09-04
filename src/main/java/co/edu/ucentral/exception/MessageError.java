package co.edu.ucentral.exception;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MessageError {

	private int code;
	private List<Map<String, String>> listaError;
	
	
	
	public MessageError(int code, List<Map<String, String>> listaError) {
		super();
		this.code = code;
		this.listaError = listaError;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Map<String, String>> getListaError() {
		return listaError;
	}
	public void setListaError(List<Map<String, String>> listaError) {
		this.listaError = listaError;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, listaError);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageError other = (MessageError) obj;
		return code == other.code && Objects.equals(listaError, other.listaError);
	}
	@Override
	public String toString() {
		return "MessageError [code=" + code + ", listaError=" + listaError + "]";
	}
	
	
	
}
