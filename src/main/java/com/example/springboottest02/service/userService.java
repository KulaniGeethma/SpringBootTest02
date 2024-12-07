package com.example.springboottest02.service;

import com.example.springboottest02.DTO.userDTO;
import com.example.springboottest02.model.userModel;
import com.example.springboottest02.repo.userRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class userService {
    @Autowired
    private userRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

//    public List<userDTO> getAllUsers() {
//        return userRepo.findAll().stream().map(user ->
//                new userDTO(
//                        user.getTotalTickets(),
//                        user.getTicketReleaseRate(),
//                        user.getCustomerRetrievalRate(),
//                        user.getMaxTicketCapacity()
//                )
//        ).collect(Collectors.toList());
//    }

//    public userDTO saveUser(userDTO userDTO) {
//        userModel user = new userModel(
//                userDTO.getTotalTickets(),
//                userDTO.getTicketReleaseRate(),
//                userDTO.getCustomerRetrievalRate(),
//                userDTO.getMaxTicketCapacity()
//        );
//        userModel savedUser = userRepo.save(user);
//        return new userDTO(
//                savedUser.getTotalTickets(),
//                savedUser.getTicketReleaseRate(),
//                savedUser.getCustomerRetrievalRate(),
//                savedUser.getMaxTicketCapacity()
//        );
//    }
    public List<userDTO> getAllUsers() {
            List<userModel>userList=userRepo.findAll();
            return userList.stream().map(userModel->modelMapper.map(userModel,userDTO.class)).collect(Collectors.toList());
    }
    public userDTO saveUser(userDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, userModel.class));
        return userDTO;
    }
    public userDTO updateUser(userDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, userModel.class));
        return userDTO;
    }

//    public userDTO updateUser(userDTO userDTO) {
//        userModel user = userRepo.findById(userDTO.getTotalTickets())
//                .orElseThrow(() -> new RuntimeException("User not found!"));
//        user.setTicketReleaseRate(userDTO.getTicketReleaseRate());
//        user.setCustomerRetrievalRate(userDTO.getCustomerRetrievalRate());
//        user.setMaxTicketCapacity(userDTO.getMaxTicketCapacity());
//        userModel updatedUser = userRepo.save(user);
//        return new userDTO(
//                updatedUser.getTotalTickets(),
//                updatedUser.getTicketReleaseRate(),
//                updatedUser.getCustomerRetrievalRate(),
//                updatedUser.getMaxTicketCapacity()
//        );
//    }
//
    public String deleteUser(userDTO userDTO) {
        userRepo.deleteById(userDTO.getTotalTickets());
        return "User deleted successfully!";
    }
}
