package com.jalamor.example

import spock.lang.Specification
import spock.lang.Unroll;

class ValidateUUIDSpec extends Specification {

	@Unroll
	def 'isValid() for #uuid expects #result'() {
	
		expect: 'true is returned when UUID is valid'
		result == ValidateUUID.isValid(uuid)
		  
		where:
		uuid  									|| result
		'148g5327-b297-44bc-8ccc-46f8fd4c32e6'  || false
		'148f5327-b297-44bc-8ccc-46f8fd4c32e6'  || true
		'148f5327xb297-44bc-8ccc-46f8fd4c32e6'  || false
		'148f5327-b297-44bc-8ccc-46f8fd4c32f6'	|| true
	}
}
