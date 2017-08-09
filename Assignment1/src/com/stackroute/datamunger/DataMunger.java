package com.stackroute.datamunger;

import java.util.Scanner;

public class DataMunger {

	public static void main(String[] args) {
		// read the query from the user into queryString variable
		String query;
		DataMunger dataMunger = new DataMunger();
		Scanner scan = new Scanner(System.in);
		query = scan.nextLine();
		System.out.println(dataMunger.getGroupByFields("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		scan.close();
		// call the parseQuery method and pass the queryString variable as a parameter

	}
	

	public void parseQuery(String queryString) {
		//call the methods
		getSplitStrings(queryString);
		getFile(queryString);
		getBaseQuery(queryString);
		getConditionsPartQuery(queryString);
		getConditions(queryString);
		getLogicalOperators(queryString);
		getFields(queryString);
		getOrderByFields(queryString);
		getGroupByFields(queryString);
		getAggregateFunctions(queryString);
	}
	
	// parse the queryString into words and display
	public String[] getSplitStrings(String queryString) {
		
		String[] words = queryString.split("\\w");
		return words;
	}

	// get and display the filename
	public String getFile(String queryString) {
		
		String filename = queryString.split("from")[1].split("\\s+")[1];
		return filename;
	}
	
	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		
		String baseQuery = queryString.split("where")[0].split("group by")[0].split("order by")[0];
		return baseQuery;

	}
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
	
		String conditionsPartQuery = queryString.split("order by")[0].split("group by")[0].split("where")[1];
		return conditionsPartQuery;

	}
	
	/* parse the where conditions and display the propertyName, propertyValue and
	 conditionalOperator for each conditions*/
	public String[] getConditions(String queryString) {
	
		String conditionsPartQuery = getConditionsPartQuery(queryString);
		String[] conditions = conditionsPartQuery.trim().split("and|or");	
		return conditions;
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		String conditionsPartQuery = getConditionsPartQuery(queryString);
		
		return null;
		
	}
	
	/*get the fields from the select clause*/
	public String[] getFields(String queryString) {
		
		String[] fields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
		return fields;
		
	}
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
		
		String[] orderByFields = queryString.split("order by")[1].split("[\\s,]+");
		return orderByFields;
	}
	
	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {
		
		String[] groupByFields = queryString.split("order by")[0].split("group by")[1].split("[\\s,]+");
		return groupByFields;
	}
	
	// parse and display aggregate functions(if applicable)
	public String[] getAggregateFunctions(String queryString) {
		

		return null;
	}

	
	
	
	
}