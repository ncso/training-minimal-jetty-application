
package com.acme.labs;

import org.eclipse.jetty.util.component.AbstractLifeCycle;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Application extends AbstractLifeCycle {
    private static final Logger LOG = Log.getLogger(Application.class);

    private int _count = 0;

    @Override
    protected void doStart() throws Exception {
        LOG.debug("doStart() at " + toString());
        super.doStart();
        int count = _count;
        while (count > 0) {
            LOG.debug(String.valueOf(count));
            Thread.sleep(1000);
            count--;
        }
        stop();
    }

    @Override
    protected void doStop() throws Exception {
        LOG.debug("doStop() at " + toString());
        super.doStop();
    }

    public void setFoo(String value) {
        LOG.debug("set foo to [" + value + "]");
    }

    public void setCount(int count) {
        _count = count;
    }
}
