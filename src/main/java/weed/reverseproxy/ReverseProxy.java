package weed.reverseproxy;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class ReverseProxy {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String jetty_home = System.getProperty("jetty.home",".");
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
 
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(jetty_home+"/j2ep.war");
        server.setHandler(webapp);
 
        server.start();
        server.join();
	}

}
