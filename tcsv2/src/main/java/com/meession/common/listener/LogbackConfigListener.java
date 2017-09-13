package com.meession.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import com.meession.common.util.EnvUtils;

/**
 * @author sam
 */
public class LogbackConfigListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(LogbackConfigListener.class);

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LoggerContext context = (LoggerContext) LoggerFactory
				.getILoggerFactory();

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);

			context.reset();

			String env = EnvUtils.getEnv();
			String realPath = sce.getServletContext().getRealPath("")
					.replaceAll("\\\\", "/");
			String logbackConfigurationFile = realPath
					+ "/WEB-INF/classes/env/" + env + "/logback.xml";
			configurator.doConfigure(logbackConfigurationFile);
		} catch (JoranException e) {
			logger.error("", e);
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// do nothing
	}

}
