package com.mhomecare.customer.responsetype;

public class BaseResponseObject<E> {

	private boolean success = true;
	private int statusCode = 200;

	private EmbeddedResponse<E> _embedded;

	public EmbeddedResponse<E> get_embedded() {
		return _embedded;
	}

	public void set_embedded(EmbeddedResponse<E> _embedded) {
		this._embedded = _embedded;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
