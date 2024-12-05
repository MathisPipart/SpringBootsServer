package it.unito.iumtweb.springboot.character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Character> insertCharacter(@RequestBody Character character) {
        Character savedCharacter = characterService.saveCharacter(character);
        return new ResponseEntity<>(savedCharacter, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        Optional<Character> character = characterService.findCharacterById(id);
        if (character.isPresent()) {
            characterService.deleteCharacterById(id);
            return new ResponseEntity<>("Character deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
       public ResponseEntity<Character> findCharacterByName(@RequestParam String name) {
           Optional<Character> character = characterService.findCharacterByName(name);
           return character.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
       }
}
