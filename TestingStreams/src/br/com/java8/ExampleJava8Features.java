package br.com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleJava8Features {

	public static void main(String[] args) {
		
		List<Pojo> l = new ArrayList<>();
		
		for (int i=0; i<100000; i++)
			l.add(new Pojo(i, "nome" + i, "sobrenome " + i));
		
		/**
		 * Warning: Stream can be used only one,
		 * So if want to "reuse" in other different parts of your code, 
		 * try to encapsulate in a wrapper like "Supplier" 
		 */
		Supplier<Stream<Pojo>> supplier = () -> l.stream();
		
		System.out.println(supplier.get().count());
		
		Optional<Pojo> opt = supplier.get().findAny();
		System.out.println(opt.get().getId());
		
		// Retrieving pojo with highiest ID
		opt = supplier.get().reduce((Pojo p, Pojo p2) -> {
			return p.getId() > p2.getId() ? p : p2; 
		});
		System.out.println(opt.get().getId());
		
		
		Stream<Pojo> s = supplier.get();
		Stream<String> stringStream = supplier.get().filter(p -> (p.getId() % 2 == 0)).map(p -> p.getSobrenome());
		System.out.println(stringStream);
		
		// Converts one Stream to another type of Stream
		Stream<Pojo2> sPojo2 = s.map(p -> {
			Pojo2 pojo2 = new Pojo2();
			pojo2.setDescricao(p.getSobrenome());
			return pojo2;
		});
		
		Stream<String> s2 = s.map(p -> p.getNome());
		
		Map<Integer, List<Pojo2>> m = sPojo2.collect(Collectors.groupingBy(p2 -> p2.hashCode()));
		System.out.println(m);
		
		System.out.println(m.size());
		
	}

}
