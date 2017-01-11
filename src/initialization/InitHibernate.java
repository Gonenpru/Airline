package initialization;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import utils.HibernateUtils;

public class InitHibernate implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtils.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtils.start();
	}
}

