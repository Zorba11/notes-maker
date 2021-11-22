package com.zorba11.notemaker.services;

import com.zorba11.notemaker.dtos.NoteDTO;
import com.zorba11.notemaker.dtos.UserDTO;
import com.zorba11.notemaker.mappers.NoteMapper;
import com.zorba11.notemaker.mappers.UserMapper;
import com.zorba11.notemaker.models.Note;
import com.zorba11.notemaker.models.User;
import com.zorba11.notemaker.repositories.NoteRepository;
import com.zorba11.notemaker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NoteMapper noteMapper;

    public List<UserDTO> getAllUsers() {


        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user : users) {
            userDTOs.add(userMapper.convertEntityToDTO(user));
        }


        System.out.println("*****users****"+users);


        return userDTOs;
    }

    public List<User> getAllUsersWithoutDto() {

        System.out.println("*****users****");


        return userRepository.findAll();
    }

    public UserDTO createUser(UserDTO userDTO) {

        User user = userMapper.convertDtoToEntity(userDTO);

        List<Note> notes = new ArrayList<>();

        for(NoteDTO noteDTO: userDTO.getNotes()) {
            notes.add(noteMapper.convertDtoToEntity(noteDTO));
        }

        user.setNotes(notes);

        notes.forEach(note -> {
            note.setUser(user);
        });

        User userSaved= userRepository.save(user);

//        Long userId = userSaved.getId();
//
//        List<Note> userNotes = noteRepository.findAllById(userId);
//
//        userNotes.forEach(note -> {
//            note.setUser(userSaved);
//        });

        System.out.println("hi user " + userSaved);


        return userMapper.convertEntityToDTO(userSaved);
    }


    public List<NoteDTO> findAllOtherNotesOfUsers(String searchStr) {

        List<Note> notesWithStr = noteRepository.findByDetailsContaining(searchStr);

        List<User> usersWithStrInNotes =  valueGrabber(notesWithStr, n -> n.getUser());

        List<Note> allNotesOfUsersWithOutStr = new ArrayList<Note>();

        usersWithStrInNotes.forEach(user -> {
           var notesWithoutStr = noteRepository.findAllNotesOfUserWithoutStr(user, searchStr);
           allNotesOfUsersWithOutStr.addAll(notesWithoutStr);
        });

        System.out.println("**********");
        System.out.println(allNotesOfUsersWithOutStr);
        System.out.println("**********");

        List<NoteDTO> notesDTO = new ArrayList<>();

        allNotesOfUsersWithOutStr.forEach(note -> {
                NoteDTO noteDTO = noteMapper.convertEntityToDTO(note);
                notesDTO.add(noteDTO);
            });

            return notesDTO;
    }

    private static <C, T> List<T> valueGrabber(List<C> items, Function<C, T> func) {
        return items.stream().map(func).collect(Collectors.toList());
    }
}



