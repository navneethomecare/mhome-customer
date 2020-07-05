package com.mhomecare.customer.responsetype;

public class SingleResponseObject<E> extends BaseResponseObject<E> {

	public SingleResponseObject(E responseItem) {
		super();
		if (responseItem != null) {
			this.setResponse(responseItem);
		}
	}

	public void setResponse(E responseItem) {
		set_embedded(new EmbeddedResponse<E>());
		get_embedded().setItem(responseItem);
	}

}
