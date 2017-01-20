/*
 * 
 */
package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import action.TestFlightsAction;
import action.TestPlanesAction;
import action.TestRoutesAction;
import dao.TestAirlinesDao;
import dao.TestFlightDao;
import dao.TestPlaneDao;
import dao.TestRoutesDao;
import hibernate.TestConnectionHibernate;
import hibernate.TestInitHibernate;
import login.TestLoginAction;


/**
 * The Class SuiteClass.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestLoginAction.class,
	TestConnectionHibernate.class,
	TestInitHibernate.class,
	TestAirlinesDao.class,
	TestFlightDao.class,
	TestPlaneDao.class,
	TestRoutesDao.class,
	TestFlightsAction.class,
	TestPlanesAction.class,
	TestRoutesAction.class
})

public class SuiteClass {}
