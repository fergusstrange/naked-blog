package com.nakedgardener.application.configuration;

import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import static de.flapdoodle.embed.mongo.MongodStarter.getDefaultInstance;
import static de.flapdoodle.embed.mongo.distribution.Version.Main.PRODUCTION;
import static de.flapdoodle.embed.process.runtime.Network.localhostIsIPv6;

public class MongoDBTestExecutionListener extends AbstractTestExecutionListener implements TestExecutionListener {

    private static MongodProcess mongodProcess;

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        if(mongodProcess == null) {
            mongodProcess = getDefaultInstance().prepare(new MongodConfigBuilder()
                    .version(PRODUCTION)
                    .net(new Net(27017, localhostIsIPv6()))
                    .build()).start();
        }
    }
}
