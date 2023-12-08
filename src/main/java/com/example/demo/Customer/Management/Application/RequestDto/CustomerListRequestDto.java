package com.example.demo.Customer.Management.Application.RequestDto;

public class CustomerListRequestDto {
	
	private int limit;
	
	private int offset;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "CustomerListRequestDto [limit=" + limit + ", offset=" + offset + "]";
	}

}
