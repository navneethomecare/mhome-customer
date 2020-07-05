package com.mhomecare.customer.responsetype;

public class PaginatedListResponseObject<E> extends ListResponseObject<E> {

	private int pageNumber = 0;
	private int pageSize = 10;
	private long totalCount = 0;

	public PaginatedListResponseObject(E responseItems, int pageNumber, long totalCount) {
		super(responseItems);
		this.pageNumber = pageNumber;
		this.totalCount = totalCount;
	}

	public PaginatedListResponseObject(E responseItems, int pageNumber, long totalCount, int pageSize) {
		super(responseItems);
		this.pageNumber = pageNumber;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}
