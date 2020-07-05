package com.mhomecare.customer.responsetype;

public class EmbeddedResponse<E> {

	private E item;

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

}
