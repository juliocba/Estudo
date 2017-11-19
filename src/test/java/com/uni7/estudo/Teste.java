package com.uni7.estudo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {
	
	public static void main(String[] args) {
		List<String> a = new ArrayList<>();
		a.add("Julio");
		a.add("Will");
		a.add("MeuOVO");
		a.add("Pinto");
		a.add("MeuOVO5");
		a.add("Pinto5");
		a.add("MeuOVO2");
		a.add("Pinto1");
		a.add("MeuOVO3");
		a.add("Pinto2");
		
Collections.shuffle(a);		
		a.forEach(aa -> System.out.println(aa));
	}

}
