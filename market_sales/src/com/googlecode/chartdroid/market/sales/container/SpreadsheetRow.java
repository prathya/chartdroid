package com.googlecode.chartdroid.market.sales.container;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpreadsheetRow implements Comparable<SpreadsheetRow> {
	
	// Natural sort order is by order creation date.
	
	long google_order_number, merchant_order_number;
	Date order_creation_date;
	String currency_of_transaction;
	double order_amount, amount_charged;
	String financial_status, fulfillment_status;


	SimpleDateFormat sdp = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");

	
	public SpreadsheetRow(String[] row) {
		google_order_number = Long.parseLong(row[0]);
		merchant_order_number = Long.parseLong(row[1]);
		try {
			order_creation_date = sdp.parse(row[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currency_of_transaction = row[3];
		order_amount = Float.parseFloat(row[4]);
		amount_charged = Float.parseFloat(row[5]);
		financial_status = row[6];
		fulfillment_status = row[7];
	}

	
	public Date getOrderDate() {
		return order_creation_date;
	}
	
	public long getOrderNumber() {
		return merchant_order_number;
	}
	
	public double getIncome() {
		return amount_charged;
	}
	
	public String getIncomeString() {
		return "$" + amount_charged;
	}

	@Override
	public int compareTo(SpreadsheetRow another) {
		return this.order_creation_date.compareTo(another.order_creation_date);
	}
}