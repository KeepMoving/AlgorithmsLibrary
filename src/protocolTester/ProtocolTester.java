package protocolTester;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTester 
{
	public static void main(String[] args) 
	{
		testProtocol("http://www.baidu.com");
		testProtocol("https://www.baidu.com");
	}

	private static void testProtocol(String url)
	{
		try {
			URL u = new URL(url);
			System.out.println(u.getProtocol() + " is supported");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			String protocol = url.substring(0,url.indexOf(':'));
			System.out.println(protocol + " is not supported");
		}
	}
}