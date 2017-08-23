package com.stackroute.datamunger;

import java.util.Scanner;

import com.stackroute.datamunger.query.parser.QueryParser;

public class DataMunger {

	public static void main(String[] args) {

		// read the query from the user
		String query;
		DataMunger dataMunger = new DataMunger();
		Scanner scan = new Scanner(System.in);
		query = scan.nextLine();
		// create an object of QueryParser class
		QueryParser queryParser = new QueryParser();
		// call parseQuery() method of queryParser
		queryParser.parseQuery(query);
		
		scan.close();
	}

}
