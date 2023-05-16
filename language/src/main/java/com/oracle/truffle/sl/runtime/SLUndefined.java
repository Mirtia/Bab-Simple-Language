package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;


@ExportLibrary(InteropLibrary.class)
public final class SLUndefined implements TruffleObject {
    public static final SLUndefined INSTANCE = new SLUndefined();

    private SLUndefined() {
    }

    @Override
    public String toString() {
        return "Null";
    }

    @ExportMessage
    boolean isNull() {
        return true;
    }

    @ExportMessage
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return "null";
    }
}
