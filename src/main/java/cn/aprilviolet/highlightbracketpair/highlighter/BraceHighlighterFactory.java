package cn.aprilviolet.highlightbracketpair.highlighter;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;

/**
 * Factory to get the {@link AbstractBraceHighlighter} instance according to the editor.
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.07.31 星期六 14:54
 * @since V1.0.0
 */
public class BraceHighlighterFactory {
    private BraceHighlighterFactory() {
    }

    /**
     * Get the {@link AbstractBraceHighlighter} according to the editor and file type.
     *
     * @param editor editor
     * @return brace highlighter
     */
    public static AbstractBraceHighlighter getBraceHighlighterInstance(Editor editor) {
        if (editor == null) {
            return null;
        }
        Project project = editor.getProject();
        Document document = editor.getDocument();
        if (project == null) {
            return null;
        }

        PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
        if (psiFile == null) {
            return null;
        }

        return new DefaultAbstractBraceHighlighter(editor);
    }
}
