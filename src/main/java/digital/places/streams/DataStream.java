package digital.places.streams;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class DataStream {
	
	public Collection<User> filterReferenced(Collection<User> inputs) {
		
		Collection<User> outputs = inputs.stream()
				.filter(t -> t.getReference() != null)
				.collect(Collectors.toList());
		return outputs;
		
	}

	public Collection<User> procFilterReferenced(Collection<User> inputs) {
		
		Collection<User> outputs = new LinkedList<>();
		for (User user:inputs) {
			if (user.getReference() != null) {
				outputs.add(user);
			}
		}
		return outputs;
		
	}
}
