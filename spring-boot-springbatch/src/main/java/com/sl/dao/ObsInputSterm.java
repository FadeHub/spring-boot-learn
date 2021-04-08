package com.sl.dao;

import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * @author shuliangzhao
 * @Title: ObsInputSterm
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 15:24
 */
public class ObsInputSterm extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected ObsInputSterm(InputStream in) {
        super(in);
    }
}
