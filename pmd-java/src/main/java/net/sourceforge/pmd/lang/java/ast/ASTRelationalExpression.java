/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTRelationalExpression.java */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Represents a comparison on two numeric values. This has a precedence greater than {@link ASTEqualityExpression},
 * and lower than {@link ASTShiftExpression}. This has the same precedence as a {@link ASTInstanceOfExpression}.
 *
 * <p>Note that the children of this node are not necessarily {@link ASTShiftExpression},
 * rather, they are expressions with an operator precedence greater or equal to ShiftExpression.
 *
 *
 * <pre>
 *
 * RelationalExpression ::=  {@linkplain ASTShiftExpression ShiftExpression} ( ( "<" | ">" | "<=" | ">=" ) {@linkplain ASTShiftExpression ShiftExpression} )+
 *
 * </pre>
 */
public class ASTRelationalExpression extends AbstractJavaTypeNode {
    public ASTRelationalExpression(int id) {
        super(id);
    }

    public ASTRelationalExpression(JavaParser p, int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(JavaGenericSideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }
}
