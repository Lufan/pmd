/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTVariableInitializer.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTVariableInitializer extends AbstractJavaNode {
    public ASTVariableInitializer(int id) {
        super(id);
    }

    public ASTVariableInitializer(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(JavaGenericSideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }
}
