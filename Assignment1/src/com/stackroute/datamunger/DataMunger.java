package com.stackroute.datamunger;

import java.util.Scanner;

public class DataMunger {

	public static void main(String[] args) {
		// read the query from the user into queryString variable
		String query;
		DataMunger dataMunger = new DataMunger();
		Scanner scan = new Scanner(System.in);
		query = scan.nextLine();

		scan.close();
		// call the parseQuery method and pass the queryString variable as a
		// parameter

	}

	public void parseQuery(String queryString) {
		// call the methods
		/*
		 * Code review: as per the problem statement, it should print the
		 * values, but none of these methods are printing anything
		 */
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

		String[] words = queryString.split("[\\s,]+");

		for (String word : words)
			System.out.print(word + " | ");
		return words;
	}

	// get and display the filename
	public String getFile(String queryString) {

		String filename = queryString.split("from")[1].split("\\s+")[1];
		System.out.println(filename);
		return filename;
	}

	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {

		String baseQuery = queryString.split("where")[0];
		return baseQuery;

	}

	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {

		if (queryString.contains("where")) {
			String conditionsPartQuery = queryString.split("order by")[0].split("group by")[0].split("where")[1];
			System.out.println(conditionsPartQuery);
			return conditionsPartQuery;
		}
		return null;

	}

	/*
	 * parse the where conditions and display the propertyName, propertyValue
	 * and conditionalOperator for each conditions
	 */
	public String[] getConditions(String queryString) {

		String conditionsPartQuery = getConditionsPartQuery(queryString);
		if (conditionsPartQuery != null) {
			String[] conditions = conditionsPartQuery.trim().split("\\s+and\\s+|\\s+or\\s+");
			for (String condition : conditions)
				System.out.println(condition);
			return conditions;
		}
		return null;
	}

	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		String conditionsPartQuery = getConditionsPartQuery(queryString);
		String[] logicalOperators = null;

		/* code review: incomplete code */
		if (conditionsPartQuery != null) {
			return null;
		}
		return null;

	}

	/* get the fields from the select clause */
	public String[] getFields(String queryString) {

		String[] fields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
		for (String field : fields)
			System.out.println(field);
		return fields;

	}

	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {

		if (queryString.contains("order by")) {
			String[] orderByFields = queryString.split("order by")[1].trim().split("\\s");
			for (String field : orderByFields)
				System.out.println(field);
			/* if orderby is present return orderby fields */
			return orderByFields;
		}
		/* code review: why is it still returning null? */
		/* Answer:---> if order by clause is not present then it returns null */
		return null;
	}

	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {

		if (queryString.contains("group by")) {
			String[] groupByFields = queryString.split("order by")[0].split("group by")[1].trim().split("\\s");
			for (String field : groupByFields)
				System.out.println(field);
			/* if group by is present return group by fields */
			return groupByFields;
		}
		/* code review: why is it still returning null? */
		/* Answer:---> if group by clause is not present then it returns null */
		return null;
	}

	// parse and display aggregate functions(if applicable)
	/* Code Review: why is it not completed? */
	public String[] getAggregateFunctions(String queryString) {

		String selectColumnString = queryString.split("from")[0].split("select")[1].trim();

		String[] aggregateFunctions = selectColumnString.split("[\\s+(\\s+|\\s+),\\s+]+");

		for (String ag : aggregateFunctions)
			System.out.println(ag);

		return aggregateFunctions;
	}

}
