package tech.coderonin.test.ognl;

public class OGNLUtil{

	public static boolean isNotEmpty( Object obj ){
		boolean result = obj != null;
		if( obj instanceof String ){
			result &= !"".equals( ((String)obj).trim() );
		}
		return result;
	}
}
