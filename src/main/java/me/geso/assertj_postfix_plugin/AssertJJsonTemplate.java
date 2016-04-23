package me.geso.assertj_postfix_plugin;

import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.Template.Property;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate;
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * assertj json template
 */
public class AssertJJsonTemplate extends StringBasedPostfixTemplate {

    public AssertJJsonTemplate() {
        super("assertThatJson", "assertThatJson(expr);",
             JavaPostfixTemplatesUtils.selectorAllExpressionsWithCurrentOffset(JavaPostfixTemplatesUtils.IS_NON_VOID));
    }

    @Override
    public Template createTemplate(TemplateManager templateManager, String s) {
        Template template = super.createTemplate(templateManager, s);
        template.setValue(Property.USE_STATIC_IMPORT_IF_POSSIBLE, true);
        return template;
    }

    @Nullable
    @Override
    public String getTemplateString(@NotNull PsiElement psiElement) {
        return  "net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson($expr$)$END$";
    }

}
