package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.object.Shape;


@ExportLibrary(InteropLibrary.class)
public final class SLArrayObject extends DynamicObject {

    @DynamicField
    private long length;

    private Object[] arrayElements;

    public SLArrayObject(Shape arrayShape, Object[] arrayElements) {
        super(arrayShape);
        this.setArrayElements(arrayElements, DynamicObjectLibrary.getUncached());
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
                : SLUndefined.INSTANCE;
    }

    @ExportMessage
    boolean isArrayElementModifiable(long index) {
        return this.isArrayElementReadable(index);
    }

    @ExportMessage
    boolean isArrayElementInsertable(long index) {
        return index >= this.arrayElements.length;
    }

    @ExportMessage
    void writeArrayElement(long index, Object value,
                           @CachedLibrary("this") DynamicObjectLibrary objectLibrary) {
        if (this.isArrayElementModifiable(index)) {
            this.arrayElements[(int) index] = value;
        } else {
            // in JavaScript, it's legal to write past the array size
            Object[] newArrayElements = new Object[(int) index + 1];
            for (int i = 0; i < index; i++) {
                newArrayElements[i] = i < this.arrayElements.length
                        ? this.arrayElements[i]
                        : SLUndefined.INSTANCE;
            }
            newArrayElements[(int) index] = value;
            this.setArrayElements(newArrayElements, objectLibrary);
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

    private void setArrayElements(Object[] arrayElements, DynamicObjectLibrary objectLibrary) {
        this.arrayElements = arrayElements;
        objectLibrary.putInt(this, "length", arrayElements.length);
    }
}