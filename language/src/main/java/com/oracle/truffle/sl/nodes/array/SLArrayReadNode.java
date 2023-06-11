package com.oracle.truffle.sl.nodes.array;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.sl.SLException;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.runtime.SLBigNumber;
import com.oracle.truffle.sl.runtime.SLNull;

import javax.swing.plaf.TreeUI;
import java.math.BigInteger;

@NodeChild("arrayExpr")
@NodeChild("indexExpr")
public abstract class SLArrayReadNode extends SLExpressionNode {
    @Specialization(guards = "arrayInteropLibrary.isArrayElementReadable(array, index)", limit = "1")
    protected Object readLongIndex(Object array, long index,
                                   @CachedLibrary("array") InteropLibrary arrayInteropLibrary) {
        try {
            return arrayInteropLibrary.readArrayElement(array, index);
        } catch (UnsupportedMessageException | InvalidArrayIndexException e) {
            throw new SLException(e.getMessage(), this);
        }
    }

    @Specialization(guards = "interopLibrary.isNull(target)", limit = "1")
    protected Object indexUndefined(@SuppressWarnings("unused") Object target,
                                    Object index,
                                    @SuppressWarnings("unused") @CachedLibrary("target") InteropLibrary interopLibrary) {
        throw new SLException("Cannot read properties of null (reading '" + index + "')", this);
    }

    @Fallback
    protected Object readNonArrayOrNonIntIndex(@SuppressWarnings("unused") Object array,
                                               @SuppressWarnings("unused") Object index) {
        return SLNull.SINGLETON;
    }

}
