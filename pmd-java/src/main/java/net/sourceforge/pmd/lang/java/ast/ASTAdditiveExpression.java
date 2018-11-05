/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTAdditiveExpression.java */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Represents an addition operation on two or more values, or string concatenation.
 * This has a precedence greater than {@link ASTShiftExpression}, and lower
 * than {@link ASTMultiplicativeExpression}.
 *
 * <p>Note that the children of this node are not necessarily {@link ASTMultiplicativeExpression},
 * rather, they are expressions with an operator precedence greater or equal to MultiplicativeExpression.
 *
 * <pre>
 *
 * AdditiveExpression ::= {@linkplain ASTMultiplicativeExpression MultiplicativeExpression} ( ( "+" | "-" ) {@linkplain ASTMultiplicativeExpression MultiplicativeExpression} )+
 *
 * </pre>
 */
public class ASTAdditiveExpression extends AbstractJavaTypeNode {
    public ASTAdditiveExpression(int id) {
        super(id);
    }

    public ASTAdditiveExpression(JavaParser p, int id) {
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


    /**
     * Returns the image of the operator, i.e. "+" or "-".
     */
    public String getOperator() {
        return getImage();
    }
}
