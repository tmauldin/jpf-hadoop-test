package javax.security.auth;

import java.security.*;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.kerberos.KerberosPrincipal;

public class Subject {

	public static Subject getSubject(AccessControlContext context){
		Subject sub = new Subject();
		return sub;		
	}
	
	public Set<Principal> getPrincipals() {
		Subject sub = new Subject();
		Set<Principal> principals = new HashSet<Principal>();	
		return principals;
	}
	
	public <T extends Principal> Set<Principal> getPrincipals(Class<T> c) {
		Subject sub = new Subject();
		Set<Principal> principals = sub.getPrincipals();	
		principals.add(new KerberosPrincipal(""));
		return principals;	
	}
}
