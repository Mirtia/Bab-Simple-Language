package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Shape;
import com.oracle.truffle.sl.SLException;


@ExportLibrary(InteropLibrary.class)
public final class SLArrayObject extends DynamicObject {
    private final long length;

    final private Object[] arrayElements;

    public SLArrayObject(Shape arrayShape, Object[] arrayElements) {
        super(arrayShape);
        this.length = arrayElements.length;
        this.arrayElements = arrayElements;
    }

    @ExportMessage
    boolean hasArrayElements() {
        return true;
    }

    @ExportMessage
    long getArraySize() {
        return this.arrayElements.length;
    }

    @ExportMessage
    boolean isArrayElementReadable(long index) {
        return index >= 0 && index < this.arrayElements.length;
    }

    @ExportMessage
    Object readArrayElement(long index) {
        return this.isArrayElementReadable(index)
                ? this.arrayElements[(int) index]
                : SLNull.SINGLETON;
    }

    @ExportMessage
    boolean isArrayElementInsertable(long index) {
        return index >= this.arrayElements.length;
    }

    @ExportMessage
    boolean isArrayElementModifiable(long index) {
        return this.isArrayElementReadable(index);
    }

    @ExportMessage
    void writeArrayElement(long index, Object value,
                           @CachedLibrary("this") DynamicObjectLibrary objectLibrary)  throws InvalidArrayIndexException {
        if (this.isArrayElementModifiable(index)) {
            this.arrayElements[(int) index] = value;
        } else {
            throw InvalidArrayIndexException.create(index);
        }
    }

    @ExportMessage
    boolean hasMembers() {
        return true;
    }

    @ExportMessage
    boolean isMemberReadable(String member) {
        return "length".equals(member);
    }

    @ExportMessage
    Object readMember(String member,
                      @CachedLibrary("this") DynamicObjectLibrary objectLibrary) throws UnknownIdentifierException {
        if (member.equals("length")) {
            return objectLibrary.getOrDefault(this, "length", 0);
        }
        throw UnknownIdentifierException.create(member);
    }

    @ExportMessage
    Object getMembers(@SuppressWarnings("unused") boolean includeInternal) {
        return new SLArrayElements(new String[]{"length"});
    }

}