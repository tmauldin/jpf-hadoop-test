package javax.security.auth;

import java.security.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;

import javax.security.auth.kerberos.KerberosKey;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosTicket;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

//import mylogin.MyLoginCallbackHandler;

import org.apache.hadoop.security.*;
import org.apache.hadoop.security.UserGroupInformation.AuthenticationMethod;

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
		T instance = null;		
		try {
			LoginContext lc = new LoginContext("MyLogin");
			Constructor ctor = c.getConstructor(String.class, AuthenticationMethod.class, LoginContext.class);
		    ctor.setAccessible(true);
	 	    instance = (T)ctor.newInstance("tmauldin", AuthenticationMethod.SIMPLE, lc);
		} catch (InstantiationException x) {
		    x.printStackTrace();
	 	} catch (InvocationTargetException x) {
	 	    x.printStackTrace();
		} catch (IllegalAccessException x) {
		    x.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (LoginException e) {
			e.printStackTrace();
		} 
		
		Set<Principal> principals = new TreeSet<Principal>();
		//principals.add(new KerberosPrincipal("tmauldin@localhost"));
		principals.add(instance);
		return principals;	
	}
	
//	public Set getPrivateCredentials(Class c) {
//		Subject sub = new Subject();
//		if (c.getClass().getName() == KerberosKey.class.getName()) {	
//			Set<KerberosKey> creds = sub.getPrivateCredentials(c);
//			KerberosKey key = new KerberosKey(new KerberosPrincipal(""), new char[] { 'a' }, null);
//			creds.add(key);
//			return creds;
//		}
//		if (c.getClass().getName() == KerberosTicket.class.getName()) {	
//			Set<KerberosTicket> creds = sub.getPrivateCredentials(c);
//			KerberosTicket ticket = new KerberosTicket(new byte[] {}, new KerberosPrincipal(""), new KerberosPrincipal(""), new byte[] {}, 0, new boolean[] {}, new Date(), new Date(), new Date(), new Date(), new InetAddress[] {});
//			creds.add(ticket);
//			return creds;
//		}
//		return null;
//	}
//	
//	public Set getPrivateCredentials() {
//		return getPrivateCredentials(KerberosKey.class);
//	}
}
