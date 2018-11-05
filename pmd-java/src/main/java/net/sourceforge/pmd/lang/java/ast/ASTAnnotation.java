/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTAnnotation.java */

package net.sourceforge.pmd.lang.java.ast;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.pmd.Rule;


/**
 * Represents an annotation. This node has three possible children,
 * that correspond to specific syntactic variants.
 *
 * <pre>
 *
 * Annotation ::= {@linkplain ASTNormalAnnotation NormalAnnotation}
 *              | {@linkplain ASTSingleMemberAnnotation SingleMemberAnnotation}
 *              | {@linkplain ASTMarkerAnnotation MarkerAnnotation}
 *
 * </pre>
 *
 */
public class ASTAnnotation extends AbstractJavaTypeNode {

    private static final List<String> UNUSED_RULES
            = Arrays.asList("UnusedPrivateField", "UnusedLocalVariable", "UnusedPrivateMethod", "UnusedFormalParameter");

    private static final List<String> SERIAL_RULES = Arrays.asList("BeanMembersShouldSerialize", "MissingSerialVersionUID");

    public ASTAnnotation(int id) {
        super(id);
    }

    public ASTAnnotation(JavaParser p, int id) {
        super(p, id);
    }


    /**
     * Returns the name of the annotation as it is used,
     * eg {@code java.lang.Override} or {@code Override}.
     */
    public String getAnnotationName() {
        return jjtGetChild(0).jjtGetChild(0).getImage();
    }

    // @formatter:off
    /**
     * Returns true if this annotation suppresses the given rule.
     * The suppression annotation is {@link SuppressWarnings}.
     * This method returns true if this annotation is a SuppressWarnings,
     * and if the set of suppressed warnings ({@link SuppressWarnings#value()})
     * contains at least one of those:
     * <ul>
     *     <li>"PMD" (suppresses all rules);
     *     <li>"PMD.rulename", where rulename is the name of the given rule;
     *     <li>"all" (conventional value to suppress all warnings).
     * </ul>
     *
     * <p>Additionnally, the following values suppress a specific set of rules:
     * <ul>
     *     <li>{@code "unused"}: suppresses rules like UnusedLocalVariable or UnusedPrivateField;
     *     <li>{@code "serial"}: suppresses BeanMembersShouldSerialize and MissingSerialVersionUID;
     * </ul>
     *
     * @param rule The rule for which to check for suppression
     *
     * @return True if this annotation suppresses the given rule
     */
    // @formatter:on
    public boolean suppresses(Rule rule) {

        if (jjtGetChild(0) instanceof ASTMarkerAnnotation) {
            return false;
        }

        // if (SuppressWarnings.class.equals(getType())) { // typeres is not always on
        if (isSuppressWarnings()) {
            for (ASTLiteral element : findDescendantsOfType(ASTLiteral.class)) {
                if (element.hasImageEqualTo("\"PMD\"") || element.hasImageEqualTo("\"PMD." + rule.getName() + "\"")
                        // Check for standard annotations values
                        || element.hasImageEqualTo("\"all\"")
                        || element.hasImageEqualTo("\"serial\"") && SERIAL_RULES.contains(rule.getName())
                        || element.hasImageEqualTo("\"unused\"") && UNUSED_RULES.contains(rule.getName())) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean isSuppressWarnings() {
        return "SuppressWarnings".equals(getAnnotationName()) || "java.lang.SuppressWarnings".equals(getAnnotationName());
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
