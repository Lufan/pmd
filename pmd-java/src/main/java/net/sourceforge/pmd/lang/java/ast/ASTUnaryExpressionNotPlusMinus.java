/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTUnaryExpressionNotPlusMinus.java */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Represents a boolean negation or bitwise inverse operation.
 * This has the same precedence as {@linkplain ASTUnaryExpression UnaryExpression}
 * and the like.
 *
 * <p>Note that the child of this node is not necessarily an {@link ASTUnaryExpression},
 * rather, it can be an expression with an operator precedence greater or equal to a UnaryExpression.
 *
 * <pre>
 *
 * UnaryExpressionNotPlusMinus ::=  ( "~" | "!" ) {@linkplain ASTUnaryExpression UnaryExpression}
 *
 * </pre>
 */
public class ASTUnaryExpressionNotPlusMinus extends AbstractJavaTypeNode {
    public ASTUnaryExpressionNotPlusMinus(int id) {
        super(id);
    }

    public ASTUnaryExpressionNotPlusMinus(JavaParser p, int id) {
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
     * Returns the image of this unary operator, i.e. "~" or "!".
     */
    public String getOperator() {
        return getImage();
    }


}
