package com.mhomecare.customer.responsetype;

public class ListResponseObject<E> extends BaseResponseObject<E> {

	public ListResponseObject(E responseItems) {
		super();
		setResponse(responseItems);
	}

	public void setResponse(E responseItems) {
		set_embedded(new EmbeddedResponse<E>());
		get_embedded().setItem(responseItems);
	}

}
