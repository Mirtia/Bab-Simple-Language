package com.oracle.truffle.sl.nodes.array;

import com.oracle.truffle.sl.SLException;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.CachedLibrary;

@NodeChild("arrayExpr")
@NodeChild("indexExpr")
@NodeChild("rvalueExpr")
public abstract class SLArrayWriteNode extends SLExpressionNode {
    @Specialization(guards = "arrayInteropLibrary.isArrayElementWritable(array, index)", limit = "1")
    protected Object writeIntIndex(Object array, int index, Object rvalue,
                                   @CachedLibrary("array") InteropLibrary arrayInteropLibrary) {
        try {
            arrayInteropLibrary.writeArrayElement(array, index, rvalue);
        } catch (UnsupportedMessageException | InvalidArrayIndexException | UnsupportedTypeException e) {
            throw new SLException(e.getMessage(), this);
        }
        return rvalue;
    }

    @Specialization(guards = "interopLibrary.isNull(target)", limit = "1")
    protected Object indexUndefined(@SuppressWarnings("unused") Object target,
                                    Object index, @SuppressWarnings("unused") Object rvalue,
                                    @SuppressWarnings("unused") @CachedLibrary("target") InteropLibrary interopLibrary) {
        throw new SLException("Cannot set properties of undefined (setting '" + index + "')", this);
    }

    @Fallback
    protected Object writeNonArrayOrNonIntIndex(@SuppressWarnings("unused") Object array,
                                                @SuppressWarnings("unused") Object index, Object rvalue) {
        return rvalue;
    }
}