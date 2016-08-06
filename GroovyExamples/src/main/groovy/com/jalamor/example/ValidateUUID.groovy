package com.jalamor.example

/**
 * <p>Class ValidateUUID validates a type 4 UUID. In its canonical form, a UUID is represented by 32 lowercase hexadecimal digits, 
 * displayed in five groups separated by hyphens, in the form 8-4-4-4-12 for a total of 36 characters (32 alphanumeric characters
 * and four hyphens).</p>
 * <p>For example:<br/><br/>
    <code>123e4567-e89b-12d3-a456-426655440000</code>
    <p/> 
 *
 * @author Warren Smith
 * @version 1.0
 */
class ValidateUUID {

	static boolean isValid(final String uuid) {
		def matcher = uuid =~ /^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/
		return matcher.matches()
	}
}
