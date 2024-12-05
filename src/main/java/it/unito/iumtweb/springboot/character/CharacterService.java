package it.unito.iumtweb.springboot.character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    public void deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
    }

    public Optional<Character> findCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    public Optional<Character> findCharacterByName(String name) {
            return characterRepository.findByName(name);
        }
}
