package noora.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noora.demo.Entity.Editor;
import noora.demo.Repository.EditorRepository;

@Service
public class EditorService {
    @Autowired EditorRepository editorRepository;

    public List<Editor> listAllEditor() {
        return editorRepository.findAll();
    }
    public void addEditor(Editor editor) {
        editorRepository.save(editor);
    }
    public void removeEditorById(Long id) {
        editorRepository.deleteById(id);
    }
    public Optional<Editor> getEditorById(Long id) {
        return editorRepository.findById(id);
    }

}
