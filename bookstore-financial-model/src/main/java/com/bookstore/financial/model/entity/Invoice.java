package com.bookstore.financial.model.entity;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.bookstore.libraries.jpa.AbstractEntity;

@Entity
public class Invoice extends AbstractEntity {

	private static final long serialVersionUID = -6856124368017177689L;

	@NotNull
	@Basic(optional = false)
	@Column(length = 8, nullable = false)
	private BigDecimal number;
	
	@NotNull
	@Basic(optional = false)
	@Column(nullable = false)
	private byte[] file;

	/**
	 * @return the number
	 */
	public BigDecimal getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	/**
	 * @return the file
	 */
	public byte[] getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(byte[] file) {
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Invoice [number=" + number + ", file=" + Arrays.toString(file) + ", id=" + id + "]";
	}
}