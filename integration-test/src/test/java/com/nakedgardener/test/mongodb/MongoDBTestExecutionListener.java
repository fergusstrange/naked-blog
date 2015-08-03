package com.nakedgardener.test.mongodb;

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
                    .net(new Net(mongoPort(), localhostIsIPv6()))
                    .build()).start();
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        BlogPostCleaner blogPostCleaner = testContext.getApplicationContext().getBean(BlogPostCleaner.class);
        blogPostCleaner.cleanUpSavedEntities();
    }

    private int mongoPort() {
        String mongoPort = System.getProperty("mongo.host.port", "27018");
        return Integer.valueOf(mongoPort);
    }
}
