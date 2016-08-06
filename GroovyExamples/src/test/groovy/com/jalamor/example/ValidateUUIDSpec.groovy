package com.jalamor.example

import spock.lang.Specification
import spock.lang.Unroll;

/**
 * Spock test class for ValidateUUID
 *
 * @author Warren Smith
 * @version 1.0
 */
class ValidateUUIDSpec extends Specification {

	@Unroll
	def 'isValid() for #uuid expects #result'() {
	
		expect: 'true is returned when UUID is valid'
		result == ValidateUUID.isValid(uuid)
		  
		where:
		uuid  									|| result
		'148f5327-b297-44bc-8ccc-46f8fd4c32f6'	|| true
		'148f5327-b297-44bc-8ccc-46f8fd4c32e6'  || true
		'123e4567-e89b-12d3-a456-426655440000'	|| true
		'148f5327-B297-44bc-8ccc-46f8fd4c32e6'  || false // on of the characters is uppercase which is invalid
		'148g5327-b297-44bc-8ccc-46f8fd4c32e6'  || false // one of the characters is g which is invalid
		'148f5327xb297-44bc-8ccc-46f8fd4c32e6'  || false // on of the dashes replaced with x is invalid
		'148f5327-b297-44bc-8ccc-46f8fd4c32e'   || false // too short
		'148f5327-b297-44bc-8ccc-46f8fd4c32e66' || false // too long
	}
}
