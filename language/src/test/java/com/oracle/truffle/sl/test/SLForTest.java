package com.oracle.truffle.sl.test;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SLForTest {

        private Context context;
        private Value forVal;

        @Before
        public void initEngine() throws Exception {
            context = Context.create();
            // @formatter:off
            context.eval("sl", "\n" +
                    "function main() {\n" +
                    "    for(j = 0;j < 10;j = j + 10)\n" +
                    "    {\n" +
                    "        j = j + 8;\n" +
                    "    }\n" +
                    "\n" +
                    "    return j;\n" +
                    "}"
            );
            // @formatter:on
            forVal = context.getBindings("sl").getMember("main");
        }

        @After
        public void dispose() {
            context.close();
        }

        @Test
        public void forComplete() throws Exception {
            Number ret = forVal.execute().as(Number.class);
            assertEquals(18, ret.intValue());
        }

}
