package com.oracle.truffle.sl.nodes.array;

import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.runtime.SLArrayObject;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.object.Shape;

import java.util.List;
public final class SLArrayLiteralNode extends SLExpressionNode {
        private final Shape arrayShape;
        @Children
        private final SLExpressionNode[] arrayElementExprs;

        public SLArrayLiteralNode(Shape arrayShape, List<SLExpressionNode> arrayElementExprs) {
            this.arrayShape = arrayShape;
            this.arrayElementExprs = arrayElementExprs.toArray(new SLExpressionNode[]{});
        }

        @Override
        @ExplodeLoop
        public Object executeGeneric(VirtualFrame frame) {
            Object[] arrayElements = new Object[this.arrayElementExprs.length];
            for (int i = 0; i < this.arrayElementExprs.length; i++) {
                arrayElements[i] = this.arrayElementExprs[i].executeGeneric(frame);
            }
            return new SLArrayObject(this.arrayShape, arrayElements);
        }
}
