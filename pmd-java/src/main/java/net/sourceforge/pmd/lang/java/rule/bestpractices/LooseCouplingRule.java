/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.bestpractices;

import java.util.Collection;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceBodyDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.lang.java.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameter;
import net.sourceforge.pmd.lang.java.ast.ASTMarkerAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTName;
import net.sourceforge.pmd.lang.java.ast.ASTResultType;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;
import net.sourceforge.pmd.lang.java.typeresolution.TypeHelper;

public class LooseCouplingRule extends AbstractJavaRule {

    @Override
    public Object visit(ASTClassOrInterfaceType node, Object data) {
        if (methodHasOverride(node)) {
            return data;
        }
        Node parent = node.getNthParent(3);
        boolean isType = TypeHelper.isA(node, Collection.class);
        if (isType && (parent instanceof ASTFieldDeclaration || parent instanceof ASTFormalParameter
                || parent instanceof ASTResultType)) {
            addViolation(data, node, node.getImage());
        }
        return data;
    }

    private boolean methodHasOverride(Node node) {
        ASTClassOrInterfaceBodyDeclaration method = node.getFirstParentOfType(ASTClassOrInterfaceBodyDeclaration.class);
        if (method != null && method.getNumChildren() > 0 && method.getChild(0) instanceof ASTAnnotation) {
            ASTMarkerAnnotation marker = method.getFirstDescendantOfType(ASTMarkerAnnotation.class);
            if (marker != null && marker.getFirstChildOfType(ASTName.class) != null) {
                ASTName name = marker.getFirstChildOfType(ASTName.class);
                if (name.getType() == Override.class) {
                    return true;
                }
            }
        }
        return false;
    }
}
