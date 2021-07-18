package tech.coderonin.test.ognl;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;

import static tech.coderonin.test.ognl.OGNLUtil.*;

import java.util.*;

public class OGNLTest{

	Object[] testParams = new Object[]{ "test", new Integer("0"), Boolean.TRUE, new Short("0"), new Long(0), new Object() };

	@Test
	public void expressionTest() throws Exception{
		System.out.println( "===== START Test OGNL Expression =====");

		String expression = "test != null and test != ''";
		testExpression( expression, testParams );
		System.out.println( "===== END Test OGNL Expression =====\n");
	}

	@Test
	public void ognlUtilTest(){
		System.out.println( "===== START Test OGNL Util isNotEmpty =====" );
		for( Object obj : testParams ){
			System.out.println( "OGNL Util : " +obj.getClass().getName() + "::[" + obj + "] isNotEmpty => " + isNotEmpty(obj) );
		}
		System.out.println( "===== END Test OGNL Util isNotEmpty =====\n" );
	}

	@Test
	public void ognlUtilExpressionTest() throws Exception{
		System.out.println( "===== START Test OGNL Util isNotEmpty expression =====" );
		String expression = "@tech.coderonin.test.ognl.OGNLUtil@isNotEmpty( test )";
		testExpression( expression, testParams );
		System.out.println( "===== END Test OGNL Util isNotEmpty expression =====\n" );
	}

	@Test
	public void negativeExpressionTest() throws Exception{
		System.out.println( "===== START Test negative expression =====" );
		String expression = "test != null and test != ''";
		testExpression( expression, new Object[]{ "", null } );
		System.out.println( "===== END Test negative expression =====\n" );
	}

	@Test
	public void negativeOgnlUtilExpressionTest() throws Exception {
		System.out.println( "===== START Test negative OGNL Util isNotEmpty expression =====" );
		String expression = "@tech.coderonin.test.ognl.OGNLUtil@isNotEmpty( test )";
		testExpression( expression, new Object[]{ "", null } );
		System.out.println( "===== END Test negative OGNL Util isNotEmpty expression =====\n" );
	}

	private void testExpression( String expression, Object[] params) throws Exception{
		for( Object obj : params ){
			Map<String, Object> contextMap = new HashMap<>();
			contextMap.put( "test", obj );
			System.out.println( ((obj!=null)?obj.getClass().getName():"null") + "::[" + obj + "]" + expression + " => " + Ognl.getValue( expression, contextMap ) );
		}
	}


}
